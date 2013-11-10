package com.dssm.service.depot.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.depot.TransType;
import com.dssm.mapper.depot.TransTypeMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.depot.TransTypeService;
import com.mtoolkit.page.Page;

@Service
public class TransTypeServiceSupport extends AbstractService<TransType> implements TransTypeService {

	@Autowired
    private TransTypeMapper transTypeMapper;

	@Override
    public Integer add(TransType transType) {
        return transTypeMapper.insert(transType);
    }

    @Override
    public int removeById(Integer transTypeId) {
        return transTypeMapper.deleteById(transTypeId);
    }

    @Override
    public int editSelective(TransType transType) {
        return transTypeMapper.updateSelective(transType);
    }

    @Override
    public TransType findById(Integer transTypeId) {
        return transTypeMapper.selectById(transTypeId);
    }

    @Override
    public TransType findByCode(String code) {
        return transTypeMapper.selectByCode(code);
    }
    
    @Override
    public List<TransType> queryByPage(Page<TransType> page, TransType search) {
    	return transTypeMapper.selectByPage(page, search);
    }
	
	@Override
	public List<TransType> queryAll() {
		return transTypeMapper.selectAll();
	}

}
