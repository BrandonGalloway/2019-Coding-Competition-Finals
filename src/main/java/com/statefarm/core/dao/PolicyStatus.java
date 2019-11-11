package com.statefarm.core.dao;

public enum PolicyStatus {
	ACTIVE, CANCELLED_BY_POLICYHOLDER, CANCELLED_BY_COMPANY;
	
	public static PolicyStatus from(int num) {
		if(num <= 2) {
			return ACTIVE;
		} else if(num <= 6) {
			return CANCELLED_BY_POLICYHOLDER;
		} else  {
			return CANCELLED_BY_COMPANY;
		}
	}
}
