package com.dssm.service;

import java.util.List;

import com.mtoolkit.page.Page;

public interface BaseService<TYPE> {
    
    public void init();
    public void destroy();
    
    public Integer add(TYPE instance);
    public int batchAdd(List<TYPE> instances);
    
    public int removeById(Integer primaryId);
    public int batchRemoveByIds(List<Integer> primaryIds);
    
    public int edit(TYPE instance);
    public int editSelective(TYPE instance);
    public int batchEdit(List<TYPE> instances);
    
    public TYPE findById(Integer primaryId);
    
    public List<TYPE> queryAll();
    public List<TYPE> queryByPage(Page<TYPE> page, TYPE search);
    
}
