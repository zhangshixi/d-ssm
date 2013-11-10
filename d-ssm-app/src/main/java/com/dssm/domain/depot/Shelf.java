package com.dssm.domain.depot;

import java.util.Date;
import java.util.List;

import com.dssm.domain.PrimaryKey;
import com.dssm.domain.security.Admin;

public class Shelf extends PrimaryKey {
	
	private static final long serialVersionUID = -3932964038075662233L;
	
	private String name;
	private String code;
	private Date   updateTime;
	private Admin  updateAdmin;
	
	private Depot 		   depot;
	private List<Location> locationList;
	
	/* ---- getter/setter methods ---- */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Admin getUpdateAdmin() {
		return updateAdmin;
	}
	public void setUpdateAdmin(Admin updateAdmin) {
		this.updateAdmin = updateAdmin;
	}
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	public List<Location> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}
	
}
