package com.dssm.service.website;

import com.dssm.domain.website.Broker;
import com.dssm.service.BaseService;

public interface BrokerService extends BaseService {

    public int addBroker(Broker broker);

    public int removeBroker(int brokerId);

    public int editBroker(Broker broker);

    public Broker findBrokerById(int brokerId);
    
}
