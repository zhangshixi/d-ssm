package com.dssm.domain.website;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.dssm.domain.PrimaryKey;

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
