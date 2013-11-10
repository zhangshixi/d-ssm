package com.dssm.service.depot.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.depot.Depot;
import com.dssm.mapper.depot.DepotMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.depot.DepotService;
import com.mtoolkit.page.Page;

@Service
public class DepotServiceSupport extends AbstractService<Depot> implements DepotService {

	@Autowired
    private DepotMapper depotMapper;

	@Override
    public Integer add(Depot depot) {
        return depotMapper.insert(depot);
    }

    @Override
    public int removeById(Integer depotId) {
        return depotMapper.deleteById(depotId);
    }

    @Override
    public int editSelective(Depot depot) {
        return depotMapper.updateSelective(depot);
    }

    @Override
    public Depot findById(Integer depotId) {
        return depotMapper.selectById(depotId);
    }

    @Override
    public Depot findByCode(String code) {
        return depotMapper.selectByCode(code);
    }
    
    @Override
    public List<Depot> queryByPage(Page<Depot> page, Depot search) {
    	return depotMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Depot> queryAll() {
		return depotMapper.selectAll();
	}

}
