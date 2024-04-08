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
public class PlanCategory {

	@Id
	@GeneratedValue
	private Integer categoryId;
	private String categoryName;
	
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
