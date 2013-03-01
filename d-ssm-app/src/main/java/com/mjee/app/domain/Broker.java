/**
 * f-club.cn
 * Copyright (c) 2009-2013 All Rights Reserved.
 */
package com.mjee.app.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 产品经纪人。
 * 
 * @author michael
 * @version $Id: ProductBroker.java, v 0.1 2013-2-22 下午2:45:08 michael Exp $
 */
public class Broker extends PrimaryKey {

    private static final long serialVersionUID = -6944337789508849950L;
    
    @NotEmpty
    @Size(max = 20)
    private String  name;
    private Boolean gender;
    private Integer age;
    @NotNull
    @Email
    private String  email;
    @NotNull
    private String  phone;
    @NotNull
    private String  address;
    
    private Boolean deleted;
    @NotNull
    private Date    addTime;
    private Admin   addAdmin;
    
    
}
