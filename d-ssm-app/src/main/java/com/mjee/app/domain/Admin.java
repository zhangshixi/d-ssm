package com.mjee.app.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Admin extends PrimaryKey {

	/** serial version UID */
	private static final long serialVersionUID = 5023810582244923444L;
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	@Email
	private String email;
	private String phone;

	@NotNull
	private Date   createTime;
	@NotNull
	private Date   lastLoginTime;
	@NotEmpty
	private String lastLoginIp;
	
	private Role   role;
	

	public Admin() {
	}
	
	public Admin(int id) {
		super(id);
	}
	
	// ---- getter/setter methods ------------------------------------
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
}
