package com.netcracker.edu.fapi.models;

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

    public UserModel(String login, String password, int balance, String[] subscriptions, String name, String surname,
                     String birthday, String email, boolean isAdmin, boolean blocked){
        this.setLogin(login);
        this.setPassword(password);
        this.setBalance(balance);
        this.setSubscriptions(subscriptions);
        this.setName(name);
        this.setSurname(surname);
        this.setBirthday(birthday);
        this.setEmail(email);
        this.setAdmin(isAdmin);
        this.setBlocked(blocked);

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

    public String[] getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(String[] subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
