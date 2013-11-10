package com.dssm.domain.depot;


public enum TransStatus {
	
	DAI_RU	(1),
	DAI_CHU	(2),
	YI_RU	(3),
	YI_CHU	(4),
	ZUO_FEI	(5);
	
	private Integer value;
	private TransStatus(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	public static TransStatus valueOf(Integer value) {
		for (TransStatus item : TransStatus.values()) {
			if (item.getValue().equals(value)) {
				return item;
			}
		}
		return null;
	}
	
}
