package com.netcracker.SD3_KolosDmitry.be.controller;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;
import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;
import com.netcracker.SD3_KolosDmitry.be.service.SubscriptionModelService;
import com.netcracker.SD3_KolosDmitry.be.service.UserModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userModels")
public class UserModelController {

    private UserModelService userModelService;

    private SubscriptionModelService subscriptionModelService;

    private UserModel loggedUser;

    @Autowired
    public UserModelController(UserModelService userModelService, SubscriptionModelService subscriptionModelService){
        this.userModelService = userModelService;
        this.subscriptionModelService = subscriptionModelService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUserModelById(@PathVariable(name = "id") Long id) {
        UserModel userModel = userModelService.getUserModelById(id);
        if (userModel != null) {
            return ResponseEntity.ok(userModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public UserModel signInUser(@RequestParam String login, @RequestParam String password){
        return userModelService.signInUser(login, password);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserModel> getAllUsers() {
        return userModelService.getAllUserModel();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserModel saveUser(@RequestBody UserModel account) {
        return userModelService.saveUserModel(account);
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public UserModel subscribeUser(@RequestParam String id_subscription, @RequestBody UserModel user){
//        long idUser = Long.parseLong(id_user);
        long idSubscription = Long.parseLong(id_subscription);
        System.out.println(idSubscription);
//        UserModel user = userModelService.getUserModelById(idUser);
        SubscriptionModel subsbcription = subscriptionModelService.getSubscriptionById(idSubscription);
        List<SubscriptionModel> subscriptions = user.getSubscriptions();
        System.out.println(user.getLogin());
        System.out.println(subscriptions);
        subscriptions.add(subsbcription);
        user.setSubscriptions(subscriptions);
        userModelService.saveUserModel(user);
        return user;
    }

    @RequestMapping(value = "/refuse", method = RequestMethod.POST)
    public UserModel unsunscribeUser(@RequestParam long id_subscription, @RequestBody UserModel user){
//        UserModel user = userModelService.getUserModelById(id_user);
        SubscriptionModel subscription = subscriptionModelService.getSubscriptionById(id_subscription);
        List<SubscriptionModel> subscriptions = user.getSubscriptions();
        subscriptions.remove(subscription);
        user.setSubscriptions(subscriptions);
        userModelService.saveUserModel(user);
        return user;
    }

    @RequestMapping(value = "/user_subscriptions", method = RequestMethod.GET)
    public List<SubscriptionModel> getUserSubscriptions(@RequestParam String id_user){
        long idUser = Long.parseLong(id_user);
        UserModel user = userModelService.getUserModelById(idUser);
        return userModelService.getUserSubscriptions(user);
    }
}
