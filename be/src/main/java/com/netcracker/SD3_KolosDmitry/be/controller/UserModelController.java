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

    @RequestMapping(method = RequestMethod.POST)
    public UserModel saveUser(@RequestBody UserModel account) {
        return userModelService.saveUserModel(account);
    }
}
