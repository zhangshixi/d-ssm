package com.dssm.service.product.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.product.Batch;
import com.dssm.mapper.product.BatchMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.product.BatchService;
import com.mtoolkit.page.Page;

@Service
public class BatchServiceSupport extends AbstractService<Batch> implements BatchService {

	@Autowired
    private BatchMapper batchMapper;

	@Override
    public Integer add(Batch batch) {
        return batchMapper.insert(batch);
    }

    @Override
    public int removeById(Integer batchId) {
        return batchMapper.deleteById(batchId);
    }

    @Override
    public int editSelective(Batch batch) {
        return batchMapper.updateSelective(batch);
    }

    @Override
    public Batch findById(Integer batchId) {
        return batchMapper.selectById(batchId);
    }

    @Override
    public Batch findByCode(String code) {
        return batchMapper.selectByCode(code);
    }
    
    @Override
    public List<Batch> queryByPage(Page<Batch> page, Batch search) {
    	return batchMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Batch> queryAll() {
		return batchMapper.selectAll();
	}

}
