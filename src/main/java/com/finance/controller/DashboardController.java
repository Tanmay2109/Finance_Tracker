package com.finance.controller;

import com.finance.model.*;
import com.finance.service.DataService;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;

import java.util.*;

public class DashboardController {

    @FXML private Label totalLabel;
    @FXML private Label incomeLabel;
    @FXML private Label balanceLabel;

    @FXML private PieChart pieChart;
    @FXML private BarChart<String, Number> barChart;

    private final DataService dataService = new DataService();

    public void initialize() {
        loadDashboard();
    }

    private void loadDashboard() {

        FinanceData data = dataService.loadData();

        double totalExpense = 0;
        double totalIncome = 0;

        // ✅ NORMAL EXPENSES
        if (data.expenses != null) {
            totalExpense += data.expenses.stream()
                    .mapToDouble(Expense::getAmount)
                    .sum();
        }

        // ✅ LOAN EMI (IMPORTANT FIX)
        if (data.loans != null) {
            for (Loan loan : data.loans) {
                totalExpense += loan.getEmi(); // monthly EMI added
            }
        }

        // ✅ INCOME
        if (data.income != null) {
            totalIncome = data.income.stream()
                    .mapToDouble(Income::getAmount)
                    .sum();
        }

        double balance = totalIncome - totalExpense;

        totalLabel.setText("Rs. " + totalExpense);
        incomeLabel.setText("Rs. " + totalIncome);
        balanceLabel.setText("Rs. " + balance);

        loadPieChart(data);
        loadBarChart(data);
    }

    // ================= PIE CHART =================
    private void loadPieChart(FinanceData data) {

        pieChart.getData().clear();

        Map<String, Double> categoryMap = new HashMap<>();

        if (data.expenses != null) {
            for (Expense e : data.expenses) {
                categoryMap.put(
                        e.getCategory(),
                        categoryMap.getOrDefault(e.getCategory(), 0.0) + e.getAmount()
                );
            }
        }

        // include loans
        if (data.loans != null) {
            for (Loan loan : data.loans) {
                categoryMap.put(
                        "Loan EMI",
                        categoryMap.getOrDefault("Loan EMI", 0.0) + loan.getEmi()
                );
            }
        }

        for (String key : categoryMap.keySet()) {
            pieChart.getData().add(new PieChart.Data(key, categoryMap.get(key)));
        }
    }

    // ================= BAR CHART =================
    private void loadBarChart(FinanceData data) {

        barChart.getData().clear();

        Map<String, Double> monthMap = new TreeMap<>();

        if (data.expenses != null) {
            for (Expense e : data.expenses) {
                String month = e.getDate().getMonth().toString();
                monthMap.put(month,
                        monthMap.getOrDefault(month, 0.0) + e.getAmount());
            }
        }

        // include EMI monthly
        if (data.loans != null) {
            for (Loan loan : data.loans) {
                String month = "EMI";
                monthMap.put(month,
                        monthMap.getOrDefault(month, 0.0) + loan.getEmi());
            }
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (String m : monthMap.keySet()) {
            series.getData().add(new XYChart.Data<>(m, monthMap.get(m)));
        }

        barChart.getData().add(series);
    }
}