package com.property.management.tenant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TenantStatus {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private Tenant tenant;
	private String status;
	private String  message;

}
