package com.spendingTracker.SpendingTracker;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.Users;
import com.spendingTracker.SpendingTracker.Interfaces.SpendingTrackingRepository;
import com.spendingTracker.SpendingTracker.Interfaces.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpendingTrackerService {

    @Autowired
    SpendingTrackingRepository spendingTrackingRepository;

    @Autowired
    UsersRepository usersRepository;

    // CREATE
    public void addUserToDatabase(Users user) {
        usersRepository.save(user);
    }

    public void addSpendToDatabase(SpendingTracking spendingTracking){
        spendingTrackingRepository.save((spendingTracking));
    }

    // READ
    public Boolean checksEmailAlreadyExists(String email) {
        return usersRepository.existsByEmail(email);
    }

    public Users findUserByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }
}
