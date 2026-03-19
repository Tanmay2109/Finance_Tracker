package com.finance.model;

import java.time.LocalDate;

public class Expense {

    private String title;
    private double amount;
    private String category;
    private LocalDate date;

    // ✅ THIS is the constructor your controller needs
    public Expense(String title, double amount, String category, LocalDate date) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // ✅ REQUIRED for Gson
    public Expense() {}

    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }

    public void setTitle(String title) { this.title = title; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(String category) { this.category = category; }
    public void setDate(LocalDate date) { this.date = date; }
}