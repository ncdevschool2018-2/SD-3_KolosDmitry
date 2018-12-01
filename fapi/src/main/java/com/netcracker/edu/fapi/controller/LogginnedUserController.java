package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.service.LoginnedUserService;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LogginnedUserController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private LoginnedUserService loggedService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> getLogin(){
        return ResponseEntity.ok(loggedService.getLogin());
    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @RequestMapping(value = "/password", method = RequeёstMethod.GET)
    public ResponseEntity<String> getPassword(){
        return ResponseEntity.ok(loggedService.getPassword());
    }
//    @RequestMapping(value = "/password", method = RequestMethod.POST)
//
    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public ResponseEntity<Long> getBalance(){
        return ResponseEntity.ok(loggedService.getBalance());
    }
//    @RequestMapping(value = "/balance", method = RequestMethod.POST)

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ResponseEntity<Boolean> signInUser(@RequestParam String login, @RequestParam String password){
        //System.out.println(login+" "+password);
//        return ResponseEntity.ok(userDataService.singInUser(login, password));
        loggedService.setUserAccount(userDataService.singInUser(login, password));
        if(loggedService.getUserAccount() != null){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.ok(false);
        }
    }
}
