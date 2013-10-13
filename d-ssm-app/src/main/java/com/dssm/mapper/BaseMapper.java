package com.dssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtoolkit.mybatis.MybatisPageInterceptor;
import com.mtoolkit.page.Page;

public interface BaseMapper<TYPE> {
    
    public static final String PARAMETER_SEARCH = "search";
    
    public Integer insert(TYPE instance);
    public int batchInsert(TYPE[] instances);
    
    public int deleteById(Integer primaryId);
    public int batchDeleteByIds(List<Integer> primaryIds);
    
    public int update(TYPE instance);
    public int updateSelective(TYPE instance);
    public int batchUpdate(List<TYPE> instances);
    
    public TYPE selectById(Integer primaryId);
    public List<TYPE> batchSelectByIds(List<Integer> primaryIds);
    
    public List<TYPE> selectByPage(
    		@Param(MybatisPageInterceptor.PARAMETER_PAGE) Page<TYPE> page, 
    		@Param(PARAMETER_SEARCH) TYPE search);
}
