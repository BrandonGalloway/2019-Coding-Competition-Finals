package com.statefarm.core.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long policyId;
	
	String type;
	
	PolicyStatus status;
	
	String state;
	
	double annualPremium;
	
	int age;
	
	int numberOfAccidents;
	
	
	
	public Policy() {}

	
	
	
	public Policy(String[] policyData) {
		super();
		this.type = policyData[27];
		this.status = PolicyStatus.from(Integer.parseInt(policyData[33]));
		this.state = policyData[34];
		this.annualPremium = Double.parseDouble(policyData[38]);
		this.age = Integer.parseInt(policyData[39]);
		
		//Base code generated numberFormatException "4\nB"
		this.numberOfAccidents = Integer.parseInt(policyData[40]);
	}




	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyType() {
		return type;
	}

	public void setPolicyType(String type) {
		this.type = type;
	}

	public PolicyStatus getStatus() {
		return status;
	}

	public void setStatus(PolicyStatus status) {
		this.status = status;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(double annualPremium) {
		this.annualPremium = annualPremium;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfAccidents() {
		return numberOfAccidents;
	}

	public void setNumberOfAccidents(int numberOfAccidents) {
		this.numberOfAccidents = numberOfAccidents;
	}
	
	
}
