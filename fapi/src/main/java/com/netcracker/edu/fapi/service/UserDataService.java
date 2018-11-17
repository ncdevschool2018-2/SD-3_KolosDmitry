package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserModel;

import java.util.List;

public interface UserDataService {
    List<UserModel> getAll();
    UserModel saveUser(String login, String password);
    void deleteBillingAccount(Long id);
    //String saveUser(String acc);
}
