package com.dssm.service.product.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.product.Provider;
import com.dssm.mapper.product.ProviderMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.product.ProviderService;
import com.mtoolkit.page.Page;

@Service
public class ProviderServiceSupport extends AbstractService<Provider> implements ProviderService {

	@Autowired
    private ProviderMapper providerMapper;

	@Override
    public Integer add(Provider provider) {
        return providerMapper.insert(provider);
    }

    @Override
    public int removeById(Integer providerId) {
        return providerMapper.deleteById(providerId);
    }

    @Override
    public int editSelective(Provider provider) {
        return providerMapper.updateSelective(provider);
    }

    @Override
    public Provider findById(Integer providerId) {
        return providerMapper.selectById(providerId);
    }

    @Override
    public Provider findByCode(String code) {
        return providerMapper.selectByCode(code);
    }
    
    @Override
    public List<Provider> queryByPage(Page<Provider> page, Provider search) {
    	return providerMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Provider> queryAll() {
		return providerMapper.selectAll();
	}

}
