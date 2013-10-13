package com.dssm.service;

import java.util.List;

import com.mtoolkit.cache.callback.CallbackCache;
import com.mtoolkit.cache.support.HashMapCache;
import com.mtoolkit.page.Page;

public abstract class AbstractService<TYPE> extends CallbackCache implements BaseService<TYPE> {

    public AbstractService() {
        super(new HashMapCache());
    }

    @Override
	public void init() {
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public Integer add(TYPE instance) {
		throw new UnsupportedOperationException("Unimplemented!");
	}
	
	@Override
	public int batchAdd(List<TYPE> instances) {
		throw new UnsupportedOperationException("Unimplemented!");
	}

	@Override
	public int removeById(Integer primaryId) {
		throw new UnsupportedOperationException("Unimplemented!");
	}

	@Override
	public int batchRemoveByIds(List<Integer> primaryIds) {
		throw new UnsupportedOperationException("Unimplemented!");
	}
	
	@Override
	public int edit(TYPE instance) {
		throw new UnsupportedOperationException("Unimplemented!");
	}
	
	@Override
	public int editSelective(TYPE instance) {
		throw new UnsupportedOperationException("Unimplemented!");
	}
	
	@Override
	public int batchEdit(List<TYPE> instances) {
		throw new UnsupportedOperationException("Unimplemented!");
	}

	@Override
	public TYPE findById(Integer primaryId) {
		throw new UnsupportedOperationException("Unimplemented!");
	}
	
	@Override
	public List<TYPE> queryAll() {
		throw new UnsupportedOperationException("Unimplemented!");
	}

	@Override
	public List<TYPE> queryByPage(Page<TYPE> page, TYPE search) {
		throw new UnsupportedOperationException("Unimplemented!");
	}
	
}
