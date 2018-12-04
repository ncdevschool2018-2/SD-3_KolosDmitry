package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserModel;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserDataService {
    List<UserModel> getAll();
    UserModel saveUser(UserModel user) throws UnsupportedEncodingException;
    void deleteBillingAccount(Long id);
    UserModel singInUser(String login, String password);
    UserModel subscribeUser(String id_user, String id_subscription);

    //String saveUser(String acc);
}
