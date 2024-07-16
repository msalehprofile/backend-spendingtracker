package com.spendingTracker.SpendingTracker.Interfaces;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendingTrackingRepository extends JpaRepository<SpendingTracking, Long> {

    public SpendingTracking findSpendsByUserId(long userId);



}
