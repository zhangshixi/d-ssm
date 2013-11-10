package com.dssm.service.product.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.product.Brand;
import com.dssm.mapper.product.BrandMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.product.BrandService;
import com.mtoolkit.page.Page;

@Service
public class BrandServiceSupport extends AbstractService<Brand> implements BrandService {

	@Autowired
    private BrandMapper brandMapper;

	@Override
    public Integer add(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public int removeById(Integer brandId) {
        return brandMapper.deleteById(brandId);
    }

    @Override
    public int editSelective(Brand brand) {
        return brandMapper.updateSelective(brand);
    }

    @Override
    public Brand findById(Integer brandId) {
        return brandMapper.selectById(brandId);
    }

    @Override
    public Brand findByCode(String code) {
        return brandMapper.selectByCode(code);
    }
    
    @Override
    public List<Brand> queryByPage(Page<Brand> page, Brand search) {
    	return brandMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Brand> queryAll() {
		return brandMapper.selectAll();
	}

}
