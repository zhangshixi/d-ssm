package com.mjee.app.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 产品评论。
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
