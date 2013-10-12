package com.dssm.domain.website;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;

/**
 * 产品经纪人。
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
    
    /* ---- getter/setter methods ---- */
}
