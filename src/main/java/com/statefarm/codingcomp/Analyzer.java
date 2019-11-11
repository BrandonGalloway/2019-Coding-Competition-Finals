package com.statefarm.codingcomp;

import java.util.List;

import com.statefarm.core.dao.Policy;
import com.statefarm.core.util.Reader;

public class Analyzer {

	public static void main(String[] args) throws Exception {
		List<Policy> policies = new Reader().read();
		//TODO - find something interesting in the data
		System.out.println("SIZE:" + policies.size());
		for(Policy p : policies)
		{
			//System.out.println(p.getAge() + " " + p.getAnnualPremium());
			//System.out.println(p.getNumberOfAccidents() + " " + p.getPolicyType());
		}
	}
}
