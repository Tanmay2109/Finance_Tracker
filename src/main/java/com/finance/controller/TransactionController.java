package com.finance.controller;

import com.finance.model.*;
import com.finance.service.DataService;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionController {

    @FXML private TableView<Expense> table;
    @FXML private TableColumn<Expense, String> titleCol;
    @FXML private TableColumn<Expense, Double> amountCol;
    @FXML private TableColumn<Expense, String> categoryCol;
    @FXML private TableColumn<Expense, LocalDate> dateCol;
    @FXML private TableColumn<Expense, Void> actionCol;

    // Expense / Income fields
    @FXML private TextField titleField;
    @FXML private TextField amountField;
    @FXML private TextField categoryField;

    // Loan fields
    @FXML private TextField loanNameField;
    @FXML private TextField loanAmountField;
    @FXML private TextField loanRateField;
    @FXML private TextField loanMonthsField;

    private final DataService dataService = new DataService();
    private FinanceData data;

    private final ObservableList<Expense> tableData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        data = dataService.loadData();

        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.setItems(tableData);

        addButtonsToTable();

        loadAllData();
    }

    private void loadAllData() {
        tableData.clear();

        if (data.expenses != null)
            tableData.addAll(data.expenses);

        if (data.loans != null)
            processLoanEMI();
    }

    // ================= EXPENSE =================
    @FXML
    public void addExpense() {

        if (amountField.getText().isEmpty()) return;

        Expense e = new Expense(
                titleField.getText(),
                Double.parseDouble(amountField.getText()),
                categoryField.getText(),
                LocalDate.now()
        );

        data.expenses.add(e);
        dataService.saveData(data);

        loadAllData();
        clearFields();
    }

    // ================= INCOME =================
    @FXML
    public void addIncome() {

        if (amountField.getText().isEmpty()) return;

        Income income = new Income(
                titleField.getText(),
                Double.parseDouble(amountField.getText()),
                categoryField.getText(),
                LocalDate.now()
        );

        data.income.add(income);
        dataService.saveData(data);

        clearFields();
    }

    // ================= LOAN =================
    @FXML
    public void addLoan() {

        try {

            if (loanAmountField.getText().isEmpty() ||
                    loanRateField.getText().isEmpty() ||
                    loanMonthsField.getText().isEmpty()) {
                return;
            }

            String name = loanNameField.getText();
            double principal = Double.parseDouble(loanAmountField.getText());
            double rate = Double.parseDouble(loanRateField.getText());
            int months = Integer.parseInt(loanMonthsField.getText());

            double emi = calculateEMI(principal, rate, months);

            Loan loan = new Loan(
                    name,
                    principal,
                    rate,
                    months,
                    emi,
                    LocalDate.now()
            );

            data.loans.add(loan);
            dataService.saveData(data);

            loadAllData();
            clearLoanFields();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= EMI =================
    private void processLoanEMI() {

        List<Expense> emiList = new ArrayList<>();

        for (Loan loan : data.loans) {

            for (int i = 0; i < loan.getMonths(); i++) {

                LocalDate emiDate = loan.getStartDate().plusMonths(i);

                if (emiDate.isBefore(LocalDate.now().plusMonths(1))) {

                    emiList.add(new Expense(
                            "EMI - " + loan.getName(),
                            loan.getEmi(),
                            "Loan",
                            emiDate
                    ));
                }
            }
        }

        tableData.addAll(emiList);
    }

    private double calculateEMI(double p, double r, int n) {
        double rate = r / (12 * 100);
        return (p * rate * Math.pow(1 + rate, n)) /
                (Math.pow(1 + rate, n) - 1);
    }

    // ================= EDIT / DELETE =================
    private void addButtonsToTable() {

        actionCol.setCellFactory(param -> new TableCell<>() {

            private final Button editBtn = new Button("Edit");
            private final Button deleteBtn = new Button("Delete");

            {
                editBtn.setOnAction(e -> {
                    Expense ex = getTableView().getItems().get(getIndex());
                    titleField.setText(ex.getTitle());
                    amountField.setText(String.valueOf(ex.getAmount()));
                    categoryField.setText(ex.getCategory());
                });

                deleteBtn.setOnAction(e -> {
                    Expense ex = getTableView().getItems().get(getIndex());
                    data.expenses.remove(ex);
                    tableData.remove(ex);
                    dataService.saveData(data);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) setGraphic(null);
                else setGraphic(new HBox(10, editBtn, deleteBtn));
            }
        });
    }

    // ================= HELPERS =================
    private void clearFields() {
        titleField.clear();
        amountField.clear();
        categoryField.clear();
    }

    private void clearLoanFields() {
        loanNameField.clear();
        loanAmountField.clear();
        loanRateField.clear();
        loanMonthsField.clear();
    }
}