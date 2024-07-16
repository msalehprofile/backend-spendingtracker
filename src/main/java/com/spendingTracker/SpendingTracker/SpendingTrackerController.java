package com.spendingTracker.SpendingTracker;

import com.spendingTracker.SpendingTracker.DatabaseTables.SpendingTracking;
import com.spendingTracker.SpendingTracker.DatabaseTables.Users;
import com.spendingTracker.SpendingTracker.Interfaces.SpendingTrackingRepository;
import com.spendingTracker.SpendingTracker.Interfaces.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/checkuserexists/{email}")
  public ResponseEntity<Boolean> findIfEmailExists(@PathVariable String email) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.checksEmailAlreadyExists(email));
  }

  @GetMapping("/findUserByEmail/{email}")
  public  ResponseEntity<Users> findUserByEmail(@PathVariable String email) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.findUserByEmail(email));
  }

  @GetMapping("/findSpendsByUserId/{userId}")
  public  ResponseEntity<SpendingTracking> findSpendsByUserId(@PathVariable long userId) {
    return ResponseEntity.status(HttpStatus.OK).body(spendingTrackerService.findSpendsByUserId(userId));
  }



}
