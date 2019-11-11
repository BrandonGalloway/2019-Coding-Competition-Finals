package com.statefarm.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PolicyRepository extends CrudRepository<Policy,Long>{
	
	@Query(value = "SELECT STATE,AVG(ANNUAL_PREMIUM),Max(ANNUAL_PREMIUM),MIN(ANNUAL_PREMIUM) FROM POLICY GROUP BY STATE", nativeQuery = true)
	List<Object[]> getPremiumStatisticsByState();
	
	
	@Query(value = "select STATE,sum(case when Status <= 2 then 1 else 0 end) as active,\r\n" + 
			"       sum(case when Status > 2 and Status <= 6 then 1 else 0 end) as holder,\r\n" + 
			"       sum(case when Status > 6 then 1 else 0 end) as company\r\n" + 
			"from POLICY GROUP BY STATE", nativeQuery = true)
	List<Object[]> getPolicyStatusByState();
	
	
	
	@Query(value = "select AGE,AVG(ANNUAL_PREMIUM),AVG(NUMBER_OF_ACCIDENTS) from POLICY GROUP BY AGE ORDER BY AGE", nativeQuery = true)
	List<Object[]> getAccidentRateStatsByAge();
	
	
	

}
