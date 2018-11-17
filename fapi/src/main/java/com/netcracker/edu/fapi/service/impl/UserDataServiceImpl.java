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

    @Value("${backend.server.url}")
    private String backendServerUrl;

    public List<UserModel> users = new ArrayList<>();

    public UserDataServiceImpl() {
        String[] subs1 = {"word", "powerpoint"};
        String[] subs2 = {"word"};
        users.add(new UserModel (
                "TheKing",
                "1234qwer",
                200,
                subs1,
                "Dimass",
                "Kolos",
                "15.02.1999",
                "dima@gmail.com",
                true,
                false));
        users.add(new UserModel(
                "casualUser",
                "12345",
                20,
                subs2,
                "Ivan",
                "Ivanov",
                "19.05.1998",
                "ivan@gmail.com",
                false,
                false));
    }

    @Override
    public List<UserModel> getAll() {
        return users;
    }



    public UserModel saveUser(String login, String password) {
        String[] subs = new String[0];
        users.add(new UserModel(
                login,
                password,
                0,
                 subs,
                "",
                "",
                "",
                "",
                false,
                false
        ));
        return users.get(users.size() - 1);
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing-accounts/" + id);
    }
}
