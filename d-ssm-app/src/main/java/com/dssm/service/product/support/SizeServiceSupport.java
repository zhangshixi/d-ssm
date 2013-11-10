package com.dssm.service.product.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.product.Size;
import com.dssm.mapper.product.SizeMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.product.SizeService;
import com.mtoolkit.page.Page;

@Service
public class SizeServiceSupport extends AbstractService<Size> implements SizeService {

	@Autowired
    private SizeMapper sizeMapper;

	@Override
    public Integer add(Size size) {
        return sizeMapper.insert(size);
    }

    @Override
    public int removeById(Integer sizeId) {
        return sizeMapper.deleteById(sizeId);
    }

    @Override
    public int editSelective(Size size) {
        return sizeMapper.updateSelective(size);
    }

    @Override
    public Size findById(Integer sizeId) {
        return sizeMapper.selectById(sizeId);
    }

    @Override
    public Size findByCode(String code) {
        return sizeMapper.selectByCode(code);
    }
    
    @Override
    public List<Size> queryByPage(Page<Size> page, Size search) {
    	return sizeMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Size> queryAll() {
		return sizeMapper.selectAll();
	}

}
