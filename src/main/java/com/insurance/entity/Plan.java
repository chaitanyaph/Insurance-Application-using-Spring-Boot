package com.insurance.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Plan {

	@Id
	@GeneratedValue
	private Integer planId;
	private String planName;
	
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	
	private Integer planCategoryId;
	private String activeSw;
	
	private String createBy;
	private String updateBy;
	
	@Column(updatable=false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
}
