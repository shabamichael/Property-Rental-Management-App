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
import com.property.management.tenant.entity.enums.EmploymentStatus;

import lombok.Data;

@Entity
@Table
@Data
public class EmploymentDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -952839172937326932L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private EmploymentStatus employmentstatus;
	private String companyname;
	private String address;
	private String profession;
	private String workphone;
	
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_tenant_employment", referencedColumnName = "Id")
	private Tenant tenant;

}
