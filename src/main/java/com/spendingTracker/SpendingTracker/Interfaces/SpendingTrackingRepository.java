package com.spendingTracker.SpendingTracker.Interfaces;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpendingTrackingRepository extends JpaRepository<SpendingTracking, Long> {

    public List<SpendingTracking> findSpendsByUserId(long userId);

    @Query(value="SELECT * FROM spending_tracker.spending_tracker " +
            "WHERE MONTH(date) = MONTH(CURRENT_DATE()) " +
            "AND YEAR(date) = YEAR(CURRENT_DATE()) " +
            "AND user_id = :userId " +
            "ORDER BY date", nativeQuery = true)
    List<SpendingTracking> getSpendsForCurrentMonth(@Param("userId") long userId);


}
