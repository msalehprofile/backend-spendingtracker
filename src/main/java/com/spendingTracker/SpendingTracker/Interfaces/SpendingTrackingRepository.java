package com.spendingTracker.SpendingTracker.Interfaces;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface SpendingTrackingRepository extends JpaRepository<SpendingTracking, Long> {

    @Query(value="SELECT * FROM spending_tracker.spending_tracker " +
            "WHERE user_id = :userId " +
            "ORDER BY date DESC", nativeQuery = true)
    public List<SpendingTracking> findSpendsByUserId(@Param("userId") long userId);

    @Query(value="SELECT * FROM spending_tracker.spending_tracker " +
            "WHERE MONTH(date) = MONTH(CURRENT_DATE()) " +
            "AND YEAR(date) = YEAR(CURRENT_DATE()) " +
            "AND user_id = :userId " +
            "ORDER BY date", nativeQuery = true)
    List<SpendingTracking> getSpendsForCurrentMonth(@Param("userId") long userId);

    @Query(value="SELECT CAST(SUM(amount) AS DECIMAL(10, 2)) FROM spending_tracker.spending_tracker " +
            "WHERE MONTH(date) = MONTH(CURRENT_DATE()) " +
            "AND YEAR(date) = YEAR(CURRENT_DATE()) " +
            "AND DAY(date) <= DAY(CURRENT_DATE()) " +
            "AND user_id = :userId", nativeQuery = true)
    Double sumCurrentMonthsSpendsByUser(@Param("userId") long userId);

    @Query(value="SELECT CAST(SUM(amount) AS DECIMAL(10, 2)) FROM spending_tracker.spending_tracker \n" +
            "            WHERE date >= DATE_FORMAT(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH), '%Y-%m-01') \n" +
            "            AND date <= LAST_DAY(DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH)) \n" +
            "            AND DAY(date) <= DAY(CURRENT_DATE())\n" +
            "            AND YEAR(date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    Double sumLastMonthsSpendsByUser(@Param("userId") long userId);

}
