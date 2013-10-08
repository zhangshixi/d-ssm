package com.dssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtoolkit.mybatis.MybatisPageInterceptor;
import com.mtoolkit.page.Page;

public interface BaseMapper<TYPE> {
    
    public static final String PARAMETER_SEARCH = "search";
    
    public int insert(TYPE instance);
    
    public int insertSelective(TYPE instance);
    
    public int batchInsert(TYPE[] instances);
    
    
    public int deleteById(Long primaryId);
    
    public int batchDeleteByIds(Long[] primaryIds);
    
    
    public int update(TYPE instance);
    
    public int updateSelective(TYPE instance);
    
    public int batchUpdate(TYPE[] instances);
    
    
    public TYPE selectById(Long primaryId);
    
    public TYPE[] batchSelectByIds(Long[] primaryIds);
    
    public List<TYPE> selectByPage(
    		@Param(MybatisPageInterceptor.PARAMETER_PAGE) Page<TYPE> page, 
    		@Param(PARAMETER_SEARCH) TYPE search);
    
}
