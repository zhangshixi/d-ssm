package com.dssm.service.product.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.product.Color;
import com.dssm.mapper.product.ColorMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.product.ColorService;
import com.mtoolkit.page.Page;

@Service
public class ColorServiceSupport extends AbstractService<Color> implements ColorService {

	@Autowired
    private ColorMapper colorMapper;

	@Override
    public Integer add(Color color) {
        return colorMapper.insert(color);
    }

    @Override
    public int removeById(Integer colorId) {
        return colorMapper.deleteById(colorId);
    }

    @Override
    public int editSelective(Color color) {
        return colorMapper.updateSelective(color);
    }

    @Override
    public Color findById(Integer colorId) {
        return colorMapper.selectById(colorId);
    }

    @Override
    public Color findByCode(String code) {
        return colorMapper.selectByCode(code);
    }
    
    @Override
    public List<Color> queryByPage(Page<Color> page, Color search) {
    	return colorMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Color> queryAll() {
		return colorMapper.selectAll();
	}

}
