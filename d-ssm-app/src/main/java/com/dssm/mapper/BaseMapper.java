package com.dssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtoolkit.mybatis.MybatisPageInterceptor;
import com.mtoolkit.page.Page;

public interface BaseMapper<TYPE> {
    
    public static final String PARAMETER_SEARCH = "search";
    
    public int insert(TYPE instance);
    
    public int insertSelective(TYPE instance);
    
    public int batcheInsert(TYPE[] instances);
    
    
    public int deleteById(int primaryId);
    
    public int batchDeleteByIds(int[] primaryIds);
    
    
    public int update(TYPE instance);
    
    public int updateSelective(TYPE instance);
    
    public int batchUpdate(TYPE[] instances);
    
    
    public TYPE selectById(int primaryId);
    
    public TYPE[] batchSelectByIds(int[] primaryIds);
    
    public List<TYPE> selectByPage(
    		@Param(MybatisPageInterceptor.PARAMETER_PAGE) Page<TYPE> page, 
    		@Param(PARAMETER_SEARCH) TYPE search);
    
}
