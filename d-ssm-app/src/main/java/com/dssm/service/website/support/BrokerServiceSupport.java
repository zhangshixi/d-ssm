package com.dssm.service.website.support;

import com.dssm.domain.website.Broker;
import com.dssm.service.AbstractService;
import com.dssm.service.website.BrokerService;

public class BrokerServiceSupport extends AbstractService implements BrokerService {

    @Override
    public int addBroker(Broker broker) {
        return 0;
    }

    @Override
    public int removeBroker(int brokerId) {
        return 0;
    }

    @Override
    public int editBroker(Broker broker) {
        return 0;
    }

    @Override
    public Broker findBrokerById(int brokerId) {
        return null;
    }

}