package com.mjee.app.service;

import com.mjee.app.domain.Broker;

public interface BrokerService extends BaseService {

    public int addBroker(Broker broker);

    public int removeBroker(int brokerId);

    public int editBroker(Broker broker);

    public Broker findBrokerById(int brokerId);
    
}
