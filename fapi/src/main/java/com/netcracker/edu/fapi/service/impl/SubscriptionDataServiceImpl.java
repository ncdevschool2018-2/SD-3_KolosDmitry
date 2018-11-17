package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionDataServiceImpl implements SubscriptionDataService {

    List<SubscriptionModel> subscriptions = new ArrayList<>();

    public SubscriptionDataServiceImpl(){
        subscriptions.add(new SubscriptionModel("name", 15,false, 0));
        subscriptions.add(new SubscriptionModel("word", 10,true, 0));
        subscriptions.add(new SubscriptionModel("powerpoint", 10,false, 0));
        subscriptions.add(new SubscriptionModel("viewer", 45,true, 0));
    }

    @Override
    public List<SubscriptionModel> getAll(){
        return subscriptions;
    }
}
