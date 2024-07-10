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
    private long amount;
    private String vendor;
    private LocalDate date;

    public SpendingTracking(){

    }

    public SpendingTracking(long id, long userId, long amount, String vendor, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.vendor = vendor;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getAmount() {
        return amount;
    }

    public String getVendor() {
        return vendor;
    }

    public LocalDate getDate() {
        return date;
    }
}
