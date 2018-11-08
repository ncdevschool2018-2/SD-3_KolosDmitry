package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserModel;

import java.util.List;

public interface BillingAccountDataService {
    List<UserModel> getAll();
    UserModel saveUser(UserModel account);
    void deleteBillingAccount(Long id);
}
