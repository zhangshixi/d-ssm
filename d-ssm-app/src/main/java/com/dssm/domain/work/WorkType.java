package com.dssm.domain.work;

import com.dssm.domain.PrimaryKey;

/**
 * 工单业务类型
 */
public class WorkType extends PrimaryKey {

	private static final long serialVersionUID = -8262769790215289727L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
