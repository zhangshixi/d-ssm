package com.dssm.domain.setting;

import java.util.List;

import com.dssm.domain.PrimaryKey;

/**
 * 物流
 * @author Michael
 */
public class Shipping extends PrimaryKey {

	private static final long serialVersionUID = -4074102985657767326L;
	
	private String 	name;
	private String 	code;
	private Boolean enable;
	private String 	template;
	private String 	description;
	
	private List<Region> regionList;

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
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Region> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}
	
}
