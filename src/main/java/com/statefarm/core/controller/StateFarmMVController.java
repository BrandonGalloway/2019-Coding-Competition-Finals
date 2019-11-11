package com.statefarm.core.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.statefarm.core.dao.Policy;
import com.statefarm.core.dao.PolicyRepository;
import com.statefarm.core.util.Reader;

@Controller
public class StateFarmMVController 
{
	@Autowired
	PolicyRepository policyRepository;
	
	
	
	@GetMapping("/stateStats")
	public String displayStateStatistics(Model model)
	{
	Map<String,Integer> policyAvg = new HashMap<>();
	Map<String,Integer> policyMin = new HashMap<>();
	Map<String,Integer> policyMax = new HashMap<>();
	List<Object[]> data = policyRepository.getPremiumStatisticsByState();
	for(Object[] o : data)
	{
		policyAvg.put((String)o[0],((Double) o[1]).intValue());
		policyMin.put((String)o[0],((Double) o[3]).intValue());
		policyMax.put((String)o[0],((Double) o[2]).intValue());
	}
	System.out.println(policyAvg.size());
	System.out.println(policyMin.size());
	System.out.println(policyMax.size());
	model.addAttribute("policyAvg",policyAvg);
	model.addAttribute("policyMin",policyMin);
	model.addAttribute("policyMax",policyMax);
	return "barTemplate";
	}
	
	
	@GetMapping("/ageStats")
	public String displayAgeStatistics(Model model)
	{
		Map<String,Double> ageAccidentRatio = new HashMap<>();
		List<Object[]> data = policyRepository.getAccidentRateStatsByAge();
		for(Object[] o : data)
		{
			double numAccidents = ((Integer) o[2]).intValue();
			if(numAccidents == 0)
				numAccidents = 1;
			ageAccidentRatio.put(""+(Integer)o[0],((Double) o[1]).intValue()/numAccidents);
		}
		model.addAttribute("series1",ageAccidentRatio);
		model.addAttribute("name1","Age");
		//model.addAttribute("series2",ageAccidents);
		//model.addAttribute("name2","Number of Accidents");
		model.addAttribute("subtext","Age of Policy Owner's Impact on Accidents");
		model.addAttribute("ytitle","Revenue Generated Per Accident");
		return "SingleBar";
	}
	
	@GetMapping("/PolicyStatusStats")
	public String displayPolicStatusStatistics(Model model)
	{
		Map<String,Integer> avtivePolicy = new HashMap<>();
		Map<String,Integer> userCanPolicy = new HashMap<>();
		Map<String,Integer> corpCanPolicy = new HashMap<>();
		List<Object[]> data = policyRepository.getPolicyStatusByState();
		for(Object[] o : data)
		{
			avtivePolicy.put((String)o[0],((BigInteger) o[1]).intValue());
			userCanPolicy.put((String)o[0],((BigInteger) o[2]).intValue());
			corpCanPolicy.put((String)o[0],((BigInteger) o[3]).intValue());
		}
		model.addAttribute("series1",avtivePolicy);
		model.addAttribute("name1","Active");
		model.addAttribute("series2",userCanPolicy);
		model.addAttribute("name2","Customer-Canceled");
		model.addAttribute("series3",corpCanPolicy);
		model.addAttribute("name2","Corperate-Canceled");
		model.addAttribute("subtext","Status of Policies by State");
		model.addAttribute("ytitle","Number of Policies");
		return "SingleBar";
	}
	
	
	
	@GetMapping("/")
	public String home(Model model)
	{
		return "home";
	}

	
	@GetMapping("/addPoints")
	public String dataProcessing() throws Exception
	{
		List<Policy> policies = new Reader().read();
		policyRepository.saveAll(policies);
		return "addPoints";
		
	}
	
	
}






