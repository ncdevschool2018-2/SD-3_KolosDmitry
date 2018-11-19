package com.netcracker.edu.fapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private int id;
    private String login;
    private String password;
    private int balance;

    public UserModel(){}


    public UserModel(int id, String login, String password, int balance){
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setBalance(balance);


    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
