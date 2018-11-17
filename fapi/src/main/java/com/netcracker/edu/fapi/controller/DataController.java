package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private UserDataService UserDataService;

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(UserDataService.getAll());
    }

    @RequestMapping("/subscriptions")
    public ResponseEntity<List<SubscriptionModel>>  getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)

    public UserModel saveBillingAccount(@RequestParam String login, @RequestParam String password ) {
            return UserDataService.saveUser(login, password);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable String id) {
        UserDataService.deleteBillingAccount(Long.valueOf(id));
    }
}









