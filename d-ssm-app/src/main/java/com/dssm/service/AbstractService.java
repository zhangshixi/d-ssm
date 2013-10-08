package com.dssm.service;

import com.mtoolkit.cache.callback.CallbackCache;
import com.mtoolkit.cache.support.HashMapCache;

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
