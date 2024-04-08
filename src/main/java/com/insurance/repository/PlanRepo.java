package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
