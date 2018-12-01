package com.netcracker.SD3_KolosDmitry.be.service;

import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;

import java.util.Optional;

public interface UserModelService {
    UserModel saveUserModel(UserModel user);
    Iterable<UserModel> getAllUserModel();
    Optional<UserModel> getUserModelById(long id);
    void deleteUserModel(long id);
    UserModel signInUser(String login, String password);
}
