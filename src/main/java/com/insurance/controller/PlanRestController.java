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

import com.insurance.entity.Plan;
import com.insurance.service.PlanService;

@RestController
public class PlanRestController {

    @Autowired
    private PlanService planService;

    @GetMapping("/categories")
    public ResponseEntity<Map<Integer, String>> planCategory() {
        Map<Integer, String> categories = planService.getPlanCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
        String responseMsg = "";
        boolean isSaved = planService.savePlan(plan);
        if (isSaved) {
            responseMsg = "Plan Saved";
        } else {
            responseMsg = "Plan Not Saved";
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
        String msg = "";
        if (updatePlan) {
            msg = "Plan Updated Successfully";
        } else {
            msg = "Plan not Updated";
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/plan/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
        boolean isDeleted = planService.deletePlanById(planId);
        String msg = "";
        if (isDeleted) {
            msg = "Plan Deleted Successfully";
        } else {
            msg = "Plan Not Deleted";
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
        boolean isStatusChange = planService.planStatusChange(planId, status);
        String msg = "";
        if (isStatusChange) {
            msg = "Status is Changed";
        } else {
            msg = "Status is not changed";
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}

