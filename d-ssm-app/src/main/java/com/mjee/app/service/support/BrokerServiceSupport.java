package com.mjee.app.service.support;

import com.mjee.app.domain.Broker;
import com.mjee.app.service.AbstractService;
import com.mjee.app.service.BrokerService;

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