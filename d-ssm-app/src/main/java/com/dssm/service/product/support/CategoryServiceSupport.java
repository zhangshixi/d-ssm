package com.dssm.service.product.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssm.domain.product.Category;
import com.dssm.mapper.product.CategoryMapper;
import com.dssm.service.AbstractService;
import com.dssm.service.product.CategoryService;
import com.mtoolkit.page.Page;

@Service
public class CategoryServiceSupport extends AbstractService<Category> implements CategoryService {

	@Autowired
    private CategoryMapper categoryMapper;

	@Override
    public Integer add(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int removeById(Integer categoryId) {
        return categoryMapper.deleteById(categoryId);
    }

    @Override
    public int editSelective(Category category) {
        return categoryMapper.updateSelective(category);
    }

    @Override
    public Category findById(Integer categoryId) {
        return categoryMapper.selectById(categoryId);
    }

    @Override
    public Category findByCode(String code) {
        return categoryMapper.selectByCode(code);
    }
    
    @Override
    public List<Category> queryByPage(Page<Category> page, Category search) {
    	return categoryMapper.selectByPage(page, search);
    }
    
	@Override
	public List<Category> queryAll() {
		return queryAll(null);
	}

	@Override
	public List<Category> queryAll(Boolean display) {
		return categoryMapper.selectAll(display);
	}
	
	@Override
	public List<Category> queryAllTree(Boolean display) {
		List<Category> categoryList = queryAll(display);
		if (categoryList == null || categoryList.isEmpty()) {
			return Collections.emptyList();
		}
		
		return buildTree(categoryList);
	}
	
	private List<Category> buildTree(List<Category> categoryList) {
	    Map<Integer, Category> topMap = new HashMap<Integer, Category>();
	    
	    for (Category category : categoryList) {
	        if (category.isTopLevel()) {
	            topMap.put(category.getId(), category);
	        } else if (category.getParent().isTopLevel()) {
	            Category parentCategory = topMap.get(category.getParent().getId());
	            // TODO: 如果子分类先于父分类的话，会报NullPointerException
	            
	            List<Category> childCategoryList = parentCategory.getChildList();
	            if (childCategoryList == null) {
	                childCategoryList = new ArrayList<Category>();
	            }
	            childCategoryList.add(category);
	            parentCategory.setChildList(childCategoryList);
	        }
	    }
	    
	    List<Category> resultList = new ArrayList<Category>(topMap.size());
	    for (Category category : categoryList) {
	        if (topMap.get(category.getId()) != null) {
	            resultList.add(topMap.get(category.getId()));
	        }
	    }
	    
	    return resultList;
	}
	
}
