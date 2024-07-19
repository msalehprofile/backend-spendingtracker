package com.spendingTracker.SpendingTracker.Interfaces;

import com.spendingTracker.SpendingTracker.DatabaseTables.UserBudgets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserBudgetsRepository extends JpaRepository<UserBudgets, Long> {
}
