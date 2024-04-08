package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Plan;
import com.insurance.entity.PlanCategory;

@Repository
public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer>{

	
	
}
