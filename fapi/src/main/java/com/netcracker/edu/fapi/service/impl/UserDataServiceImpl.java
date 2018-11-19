package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("$backend.server.url")
    private String backendServerUrl;

//    public List<UserModel> users = new ArrayList<>();

//    public UserDataServiceImpl() {
//        String[] subs1 = {"word", "powerpoint"};
//        String[] subs2 = {"word"};
//        users.add(new UserModel (
//                1,
//                "TheKing",
//                "1234qwer",
//                200));
//        users.add(new UserModel(
//                2,
//                "casualUser",
//                "12345",
//                20));
//    }

    @Override
    public List<UserModel> getAll() {
        return null;
    }



    @Override
    public UserModel saveUser(UserModel user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.
                postForEntity(backendServerUrl + "api/usersModels", user,
                        UserModel.class).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing-accounts/" + id);
    }
}
