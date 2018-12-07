package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.LoginnedUserService;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(userDataService.getAll());

    }

    @RequestMapping("/subscriptions")
    public ResponseEntity<List<SubscriptionModel>>  getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionDataService.getAll());
    }

//    @RequestMapping(value = "/signin", method = RequestMethod.GET)
//    public ResponseEntity<Boolean> signInUser(@RequestParam String login, @RequestParam String password){
//        System.out.println(login+" "+password);
//        return ResponseEntity.ok(userDataService.singInUser(login, password));
//        loggedUser.setUserAccount(userDataService.singInUser(login, password));
//        if(loggedUser.getUserAccount() != null){
//            return ResponseEntity.ok(true);
//        }
//        else{
//            return ResponseEntity.ok(false);
//        }
//    }
//

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserModel> saveBillingAccount(@RequestBody UserModel userModel /*todo server validation*/)
    throws UnsupportedEncodingException {
        if (userModel != null) {
            System.out.println("not null");
            return ResponseEntity.ok(userDataService.saveUser(userModel));
        }
        System.out.println("null");
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable String id) {
        userDataService.deleteBillingAccount(Long.valueOf(id));
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ResponseEntity<UserModel> subscribeUser(@RequestParam String id_subscription, @RequestBody UserModel user ){
        return ResponseEntity.ok(userDataService.subscribeUser(user, id_subscription));
    }

    @RequestMapping(value = "/refuse", method = RequestMethod.GET)
    public ResponseEntity<UserModel> unsubscribeUser(@RequestParam String id_subscription, @RequestBody UserModel user){
        return ResponseEntity.ok(userDataService.unsubscribeUser(user, id_subscription));
    }


    @RequestMapping(value = "/usersubscriptions", method = RequestMethod.GET)
    public ResponseEntity<List<SubscriptionModel>> getUserSubscriptions(@RequestParam String id_user){
        return ResponseEntity.ok(userDataService.getUserSubscriptions(id_user));
    }
}









