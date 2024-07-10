package com.spendingTracker.SpendingTracker.Interfaces;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpendingTrackingRepository extends JpaRepository<SpendingTracking, Long> {

}
