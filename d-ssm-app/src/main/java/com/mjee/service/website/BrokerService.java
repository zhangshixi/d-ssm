package com.mjee.service.website;

import com.mjee.domain.website.Broker;
import com.mjee.service.BaseService;

public interface BrokerService extends BaseService {

    public int addBroker(Broker broker);

    public int removeBroker(int brokerId);

    public int editBroker(Broker broker);

    public Broker findBrokerById(int brokerId);
    
}
