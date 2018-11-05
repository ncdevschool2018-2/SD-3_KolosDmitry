package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserDataService {

    @Value("localhost:8080")
    private String backendServerUrl;

    public Iterable<UserModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserModel[] billingAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/users",
                UserModel[].class);
        return billingAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(billingAccountViewModelResponse);
    }


    public UserModel saveUser(UserModel user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/users", user, UserModel.class).getBody();
    }

}
