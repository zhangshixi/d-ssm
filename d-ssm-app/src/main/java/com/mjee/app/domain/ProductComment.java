/**
 * f-club.cn
 * Copyright (c) 2009-2013 All Rights Reserved.
 */
package com.mjee.app.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 产品评论。
 * 
 * @author michael
 * @version $Id: ProductComment.java, v 0.1 2013-2-22 下午2:46:04 michael Exp $
 */
public class ProductComment extends PrimaryKey {

    private static final long serialVersionUID = 2695867608805427291L;

    @NotEmpty
    private String  content;
    @NotNull
    private Date    commentTime;
    @NotNull
    private String  ip;
    
    public boolean  deleted;
    
    private Product product;

    
    
}
