package com.spendingTracker.SpendingTracker.Interfaces;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.UserBudgets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserBudgetsRepository extends JpaRepository<UserBudgets, Long> {

    public UserBudgets findBudgetsByUserId(long userId);

}
