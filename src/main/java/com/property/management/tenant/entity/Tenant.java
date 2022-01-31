package com.property.management.tenant.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;




@Entity
@Table
@Data
public class Tenant implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String tenantNo;
	private String fName;
	private String mName;
	private String surname;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Identity> identities;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contacts;
	
	private Gender gender;
	private Date DoB;
	private MaritalStatus maritalStatus;

	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmploymentDetails> employmentDetails;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <NextOfKin> nextOfKins;
	
	private String imageLocation;
	private String SignatureLocation;
	private String carRegNo;
	
	
	
	

}
