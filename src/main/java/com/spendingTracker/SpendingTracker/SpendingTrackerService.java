package com.spendingTracker.SpendingTracker;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.UserBudgets;
import com.spendingTracker.SpendingTracker.DatabaseTables.Users;
import com.spendingTracker.SpendingTracker.Interfaces.SpendingTrackingRepository;
import com.spendingTracker.SpendingTracker.Interfaces.UserBudgetsRepository;
import com.spendingTracker.SpendingTracker.Interfaces.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class SpendingTrackerService {

    @Autowired
    SpendingTrackingRepository spendingTrackingRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserBudgetsRepository userBudgetsRepository;

    // CREATE
    public void addUserToDatabase(Users user) {
        usersRepository.save(user);
    }

    public void addSpendToDatabase(SpendingTracking spendingTracking){
        spendingTrackingRepository.save((spendingTracking));
    }

    public void addBudgetToDataBase(UserBudgets userBudgets){
        userBudgetsRepository.save((userBudgets));
    }

    // READ
    public Boolean checksEmailAlreadyExists(String email) {
        return usersRepository.existsByEmail(email);
    }

    public Users findUserByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }


    public List<SpendingTracking> findSpendsByUserId(long userId) {
        List<SpendingTracking> spends = spendingTrackingRepository.findSpendsByUserId(userId);
        return spends.stream().limit(5).toList();
    }

    public List<SpendingTracking> getSpendsForCurrentMonth(long userId) {
        return spendingTrackingRepository.getSpendsForCurrentMonth(userId);
    }

    public Double sumCurrentMonthsSpendsByUser(long userId) {
        return spendingTrackingRepository.sumCurrentMonthsSpendsByUser(userId);
    }

    public Double sumLastMonthsSpendsByUser(long userId) {
        return spendingTrackingRepository.sumLastMonthsSpendsByUser(userId);
    }

    public UserBudgets findBudgetByUserId(long userId) {
        return userBudgetsRepository.findBudgetsByUserId(userId);
    }
}
