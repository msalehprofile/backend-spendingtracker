package com.spendingTracker.SpendingTracker;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.UserBudgets;
import com.spendingTracker.SpendingTracker.DatabaseTables.Users;
import com.spendingTracker.SpendingTracker.Interfaces.SpendingTrackingRepository;
import com.spendingTracker.SpendingTracker.Interfaces.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SpendingTrackerController {

  @Autowired
  SpendingTrackerService spendingTrackerService;

  @PostMapping("createuser")
  public Users addUserToDataBase(@RequestBody Users user) {
    spendingTrackerService.addUserToDatabase(user);
    return user;
  }

  @PostMapping("/addspend")
  public SpendingTracking addSpendToDatabase(@RequestBody SpendingTracking spendingTracking) {
    spendingTrackerService.addSpendToDatabase(spendingTracking);
    return spendingTracking;
  }

  @PostMapping("/createbudget")
  public ResponseEntity<UserBudgets> addSpendToDatabase(@RequestBody UserBudgets userBudgets) {
    try {
      spendingTrackerService.addBudgetToDataBase(userBudgets);
      return new ResponseEntity<>(userBudgets, HttpStatus.OK);
    } catch (Exception e) {
      // Log the exception and return a proper error response
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/checkuserexists/{email}")
  public ResponseEntity<Boolean> findIfEmailExists(@PathVariable String email) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.checksEmailAlreadyExists(email));
  }

  @GetMapping("/findUserByEmail/{email}")
  public  ResponseEntity<Users> findUserByEmail(@PathVariable String email) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.findUserByEmail(email));
  }

  @GetMapping("/findSpendsByUserId/{userId}")
  public  ResponseEntity<List<SpendingTracking>> findSpendsByUserId(@PathVariable long userId) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.findSpendsByUserId(userId));
  }

  @GetMapping("/findSpendsForCurrentMonth/{userId}")
  public  ResponseEntity<List<SpendingTracking>> getSpendsForCurrentMonth(@PathVariable long userId) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.getSpendsForCurrentMonth(userId));
  }

  @GetMapping("/calculateCurrentMonthSpends/{userId}")
  public  ResponseEntity<Double> sumCurrentMonthsSpendsByUser(@PathVariable long userId) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.sumCurrentMonthsSpendsByUser(userId));
  }

  @GetMapping("/calculateLastMonthSpends/{userId}")
  public  ResponseEntity<Double> sumLastMonthsSpendsByUser(@PathVariable long userId) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.sumLastMonthsSpendsByUser(userId));
  };


  @GetMapping("/findBudgetsByUserId/{userId}")
    public ResponseEntity<UserBudgets> findBudgetsByUserId(@PathVariable long userId) {
      return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.findBudgetByUserId(userId));
    }


}
