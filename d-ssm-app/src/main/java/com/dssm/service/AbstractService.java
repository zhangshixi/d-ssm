package com.dssm.service;

import com.mcache.callback.CallbackCache;
import com.mcache.support.HashMapCache;

public abstract class AbstractService extends CallbackCache implements BaseService {

    public AbstractService() {
        super(new HashMapCache());
    }

    @Override
	public void init() {
	}
	
	@Override
	public void destroy() {
	}
	
}
