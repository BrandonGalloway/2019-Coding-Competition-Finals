package com.statefarm.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.statefarm.core.dao.Policy;
import com.statefarm.core.dao.PolicyRepository;
import com.statefarm.core.util.Reader;

@RestController
public class StateFarmCompRSEndpoint {
	
	@Autowired
	PolicyRepository policyRepository;
	
	@GetMapping("/addPoints")
	public void test() throws Exception
	{
		List<Policy> policies = new Reader().read();
		policyRepository.saveAll(policies);
		
	}

}
