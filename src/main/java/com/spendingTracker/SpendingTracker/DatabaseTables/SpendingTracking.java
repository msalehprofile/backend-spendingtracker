package com.spendingTracker.SpendingTracker.DatabaseTables;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "spendingTracker")
public class SpendingTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private double amount;
    private String vendor;
    private String category;
    private LocalDate date;

    public SpendingTracking(){

    }

    public SpendingTracking(long id, long userId, double amount, String vendor, String category, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.vendor = vendor;
        this.category = category;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getVendor() {
        return vendor;
    }

    public LocalDate getDate() {
        return date;
    }
}
