package com.finance.service;

import com.finance.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDate;

public class DataService {

    private static final String FILE_PATH = "data.json";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .setPrettyPrinting()
            .create();

    public FinanceData loadData() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            FinanceData data = gson.fromJson(reader, FinanceData.class);

            if (data == null) data = new FinanceData();

            generateMonthlyEMI(data); // 🔥 ADD THIS

            return data;
        } catch (Exception e) {
            return new FinanceData();
        }
    }

    public void generateMonthlyEMI(FinanceData data) {

        if (data.loans == null || data.expenses == null) return;

        for (Loan loan : data.loans) {

            for (int i = 0; i < loan.getMonths(); i++) {

                LocalDate emiDate = loan.getStartDate().plusMonths(i);

                boolean exists = data.expenses.stream().anyMatch(e ->
                        e.getTitle().equals("EMI - " + loan.getName()) &&
                                e.getDate().getMonth() == emiDate.getMonth()
                );

                if (!exists) {
                    data.expenses.add(
                            new Expense(
                                    "EMI - " + loan.getName(),
                                    loan.getEmi(),
                                    "Loan",
                                    emiDate
                            )
                    );
                }
            }
        }
    }



    public void saveData(FinanceData data) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(data, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}