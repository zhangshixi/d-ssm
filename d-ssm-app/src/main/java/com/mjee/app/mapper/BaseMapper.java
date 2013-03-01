/**
 * f-club.cn
 * Copyright (c) 2009-2012 All Rights Reserved.
 */
package com.mjee.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtoolkit.mybatis.MybatisPageInterceptor;
import com.mtoolkit.page.Page;

/**
 * 
 * @author michael
 * @version $Id: Mapper.java, v 0.1 2012-8-16 下午4:53:46 michael Exp $
 */
public interface BaseMapper<TYPE> {
    
    public static final String PARAMETER_TARGET = "target";
    
    public int insert(TYPE instance);
    
    public int insertSelective(TYPE instance);
    
    public int insertBatches(TYPE[] instances);
    
    public int delete(int primaryId);
    
    public int deleteBatches(int[] primaryIds);
    
    public int update(TYPE instance);
    
    public int updateSelective(TYPE instance);
    
    public int updateBatches(TYPE[] instances);
    
    public TYPE selectById(int primaryId);
    
    public TYPE[] selectBatches(int[] primaryIds);
    
    public List<TYPE> selectByPage(
    		@Param(MybatisPageInterceptor.PARAMETER_PAGE) Page<TYPE> page, 
    		@Param(PARAMETER_TARGET) Object target);
    
}
