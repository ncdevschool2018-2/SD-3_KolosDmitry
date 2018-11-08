package com.netcracker.edu.fapi.models;

public class SubscriptionModel {
    private String name;
    private int cost;
    private boolean subscribe;
    private int subscribers;

    public SubscriptionModel(String name, int cost, boolean subscribe, int subscribers){
        this.setName(name);
        this.setCost(cost);
        this.setSubscribe(subscribe);
        this.setSubscribers(subscribers);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }
}
