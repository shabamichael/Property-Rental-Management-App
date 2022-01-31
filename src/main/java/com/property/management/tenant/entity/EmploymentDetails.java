package com.property.management.tenant.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class EmploymentDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -952839172937326932L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private Tenant tenant;
	private EmploymentStatus employmentStatus;
	private String address;
	private String profession;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_tenant_emp", referencedColumnName = "Id")
	private Tenant tenantNo;

}
