package com.spendingTracker.SpendingTracker.DatabaseTables;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="userbudgets")
public class UserBudgets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private double monthlyIncome;
    private double bills;
    private double eatingOut;
    private double entertainment;
    private double gifts;
    private double shopping;
    private double groceries;
    private double health;
    private double transport;

    public UserBudgets() {
    }

    public double getTransport() {
        return transport;
    }

    public UserBudgets(long id, long userId, double monthlyIncome, double bills, double eatingOut, double entertainment, double gifts, double shopping, double groceries, double health, double transport) {
        this.id = id;
        this.userId = userId;
        this.monthlyIncome = monthlyIncome;
        this.bills = bills;
        this.eatingOut = eatingOut;
        this.entertainment = entertainment;
        this.gifts = gifts;
        this.shopping = shopping;
        this.groceries = groceries;
        this.health = health;
        this.transport = transport;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getBills() {
        return bills;
    }

    public double getEatingOut() {
        return eatingOut;
    }

    public double getEntertainment() {
        return entertainment;
    }

    public double getGifts() {
        return gifts;
    }

    public double getShopping() {
        return shopping;
    }

    public double getGroceries() {
        return groceries;
    }

    public double getHealth() {
        return health;
    }
}
