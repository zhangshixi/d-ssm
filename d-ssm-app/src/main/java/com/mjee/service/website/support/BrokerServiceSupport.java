package com.mjee.service.website.support;

import com.mjee.domain.website.Broker;
import com.mjee.service.AbstractService;
import com.mjee.service.website.BrokerService;

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