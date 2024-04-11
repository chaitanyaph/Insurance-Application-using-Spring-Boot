package com.insurance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.constant.AppConstant;
import com.insurance.entity.Plan;
import com.insurance.props.AppProperties;
import com.insurance.service.PlanService;

@RestController
public class PlanRestController {
	
    private PlanService planService;
    
    Map<String, String> messages;
    
    public PlanRestController(PlanService planService, AppProperties appProps) {
    	
    	this.messages = appProps.getMessages();
    	this.planService = planService;
    	System.out.println(messages);
    }

    @GetMapping("/categories")
    public ResponseEntity<Map<Integer, String>> planCategory() {
        Map<Integer, String> categories = planService.getPlanCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
        String responseMsg = AppConstant.EMPTY_STR;
        boolean isSaved = planService.savePlan(plan);
        
        if (isSaved) {
        	responseMsg = messages.get(AppConstant.PLAN_SAVE_SUCC);  
        } else {
            responseMsg = messages.get(AppConstant.PLAN_SAVE_FAIL);
        }
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> Plans() {
        List<Plan> allPlans = planService.getAllPlans();
        return new ResponseEntity<>(allPlans, HttpStatus.OK);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
        Plan planById = planService.getPlanById(planId);
        return new ResponseEntity<>(planById, HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
        boolean updatePlan = planService.updatePlan(plan);
        String msg =  AppConstant.EMPTY_STR;;
        
        if (updatePlan) {
            msg = messages.get("planUpdateSucc");
        } else {
            msg = messages.get("planUpdateFail");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/plan/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
        boolean isDeleted = planService.deletePlanById(planId);
        String msg = AppConstant.EMPTY_STR;;
       
        if (isDeleted) {
            msg = messages.get("planDeleteSucc");
        } else {
            msg = messages.get("planDeleteFail");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
        boolean isStatusChange = planService.planStatusChange(planId, status);
        String msg = AppConstant.EMPTY_STR;;
        
        if (isStatusChange) {
            msg = messages.get("planStatusChange");
        } else {
            msg = messages.get("planStatusChangeFail");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}

