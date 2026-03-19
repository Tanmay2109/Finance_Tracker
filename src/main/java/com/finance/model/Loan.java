package com.finance.model;

import java.time.LocalDate;

public class Loan {

    private String name;
    private double principal;
    private double rate;
    private int months;
    private double emi;
    private LocalDate startDate;

    public Loan(String name, double principal, double rate, int months, double emi, LocalDate startDate) {
        this.name = name;
        this.principal = principal;
        this.rate = rate;
        this.months = months;
        this.emi = emi;
        this.startDate = startDate;
    }

    public Loan() {}

    public String getName() { return name; }
    public double getPrincipal() { return principal; }
    public double getRate() { return rate; }
    public int getMonths() { return months; }
    public double getEmi() { return emi; }
    public LocalDate getStartDate() { return startDate; }
}