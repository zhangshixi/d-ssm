package com.dssm.domain.manage;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.dssm.domain.PrimaryKey;

public class Admin extends PrimaryKey {

    private static final long serialVersionUID = 5023810582244923444L;
	
	@NotEmpty
	private String 	   loginName;
	@NotEmpty
	private String 	   password;
	
	@NotEmpty
	private String 	   realName;
	@Email
	private String 	   email;
	private String 	   mobile;

	private Boolean    locked;
	private Long       createAid;
	private Date   	   createTime;
	private String 	   lastLoginIp;
	private Date   	   lastLoginTime;
	private String	   remark;
	
	private List<Role> roleList;
	
	
	/* ---- constructors ---- */
	public Admin() {
	}
	
	public Admin(Long id) {
		super(id);
	}
	
	
	/* ---- getter/setter methods ---- */
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
    public String getMobile() {
		return mobile;
	}
    
    public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
    public Boolean isLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
	
    public Long getCreateAid() {
		return createAid;
	}
    
    public void setCreateAid(Long createAid) {
		this.createAid = createAid;
	}
    
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
}
