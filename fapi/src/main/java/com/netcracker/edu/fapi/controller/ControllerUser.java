package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.model.UserModel;
import com.netcracker.edu.fapi.service.UserDataService;
import com.sun.org.apache.xml.internal.serializer.utils.Messages;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ControllerUser {

    private UserDataService userDataService;

//    @RequestMapping("/users")
//    public Iterable<> getUsers(){}
//
//    @RequestMapping("/subscriptions")
//    public Iterable<> getSubscriptions(){}
    @GetMapping("/visits")
    public ResponseEntity<Iterable<UserModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(userDataService.getAll());
}

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user /*todo server validation*/) {
        if (user != null) {
            return ResponseEntity.ok(userDataService.saveUser(user));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void Printer(){

    }
}
