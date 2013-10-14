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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Admin getAddAdmin() {
		return addAdmin;
	}
	public void setAddAdmin(Admin addAdmin) {
		this.addAdmin = addAdmin;
	}
    
}
