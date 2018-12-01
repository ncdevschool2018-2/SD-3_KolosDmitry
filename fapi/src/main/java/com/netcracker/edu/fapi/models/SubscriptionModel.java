package com.netcracker.edu.fapi.models;

public class SubscriptionModel {
    private long idsubscription;
    private String name;
    private long cost;
    private long subscribers;

    public SubscriptionModel(){}

    public SubscriptionModel(int id, String name, int cost, int subscribers){
        this.setSubscribers(id);
        this.setName(name);
        this.setCost(cost);
        this.setSubscribers(subscribers);
    }


    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public long getSubscribers() {
        return subscribers;
    }

    public long getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(long idsubscription) {
        this.idsubscription = idsubscription;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setSubscribers(long subscribers) {
        this.subscribers = subscribers;
    }

    public void setName(String name){
        this.name = name;
    }
}
