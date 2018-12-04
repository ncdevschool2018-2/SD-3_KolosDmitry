package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.UserDataService;
import com.sun.deploy.net.URLEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("${backend.server.url}")
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
    public UserModel singInUser(String login, String password){
        RestTemplate restTemplate = new RestTemplate();
        UserModel user =  restTemplate.getForObject(backendServerUrl + "api/userModels/signIn?login="
                + login + "&password=" + password, UserModel.class);
        if(user != null) System.out.println(user.getLogin()+" "+user.getPassword());
        return user;
    }

    @Override
    public List<UserModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserModel[] UserModelResponse =
                restTemplate.
                        getForObject(backendServerUrl + "/api/userModels/", UserModel[].class);
        return UserModelResponse ==
                null ? Collections.emptyList() : Arrays.asList(UserModelResponse);
    }



    @Override
    public UserModel saveUser(UserModel user) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
//        String URL = "http://localhost:8080/api/usersModels/";
//        URL = URLEncoder.encode(URL, "UTF-8");
        return restTemplate.
                postForEntity(backendServerUrl + "api/userModels", user,
                        UserModel.class).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing-accounts/" + id);
    }

    @Override
    public UserModel subscribeUser(String id_user, String id_subscription){
        RestTemplate restTemplate = new RestTemplate();
        UserModel user =  restTemplate.getForObject(backendServerUrl + "api/userModels/join?id_user="
                + id_user + "&id_subscription=" + id_subscription, UserModel.class);
        if(user != null) System.out.println(user.getLogin()+" "+user.getPassword());
        return user;
    }
}
