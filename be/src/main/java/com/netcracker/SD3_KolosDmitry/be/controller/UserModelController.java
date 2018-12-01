package com.netcracker.SD3_KolosDmitry.be.controller;

import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;
import com.netcracker.SD3_KolosDmitry.be.service.UserModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/userModels")
public class UserModelController {

    private UserModelService userModelService;

    private UserModel loggedUser;

    @Autowired
    public UserModelController(UserModelService userModelService){
        this.userModelService = userModelService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUserModelById(@PathVariable(name = "id") Long id) {
        Optional<UserModel> userModel = userModelService.getUserModelById(id);
        if (userModel.isPresent()) {
            return ResponseEntity.ok(userModel.get());
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
}
