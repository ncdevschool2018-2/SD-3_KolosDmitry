package com.netcracker.edu.fapi.model;

public class UserModel {
    private String login;
    private String password;
    private int balance;
    private String[] subscriptions;
    private String name;
    private String surname;
    private String birthday;
    private String email;
    private boolean isAdmin;
    private boolean blocked;

    public UserModel(int id, String login, String password, int balance, String[] subscriptions, String name, String surname,
                     String birthday, String email, boolean isAdmin, boolean blocked){
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.subscriptions = subscriptions;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
        this.isAdmin = isAdmin;
        this.blocked = blocked;

    }

}
