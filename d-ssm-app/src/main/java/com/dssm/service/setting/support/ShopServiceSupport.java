package com.dssm.service.setting.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.setting.Shop;
import com.dssm.mapper.setting.ShopMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.setting.ShopService;
import com.mtoolkit.page.Page;

@Service
public class ShopServiceSupport extends AbstractService<Shop> implements ShopService {

	@Autowired
    private ShopMapper shopMapper;

	@Override
    public Integer add(Shop shop) {
        return shopMapper.insert(shop);
    }

    @Override
    public int removeById(Integer shopId) {
        return shopMapper.deleteById(shopId);
    }

    @Override
    public int editSelective(Shop shop) {
        return shopMapper.updateSelective(shop);
    }

    @Override
    public Shop findById(Integer shopId) {
        return shopMapper.selectById(shopId);
    }

    @Override
    public Shop findByCode(String code) {
        return shopMapper.selectByCode(code);
    }
    
    @Override
    public List<Shop> queryByPage(Page<Shop> page, Shop search) {
    	return shopMapper.selectByPage(page, search);
    }
	
	@Override
	public List<Shop> queryAll() {
		return shopMapper.selectAll();
	}

}
