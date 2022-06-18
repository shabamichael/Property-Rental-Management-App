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
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table
public class Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE , generator="contact_generator")
	@TableGenerator(name="contact_generator", 
	                table="pk_table", 
	                pkColumnName="name", 
	                valueColumnName="value",                            
	                allocationSize=100)
	private int Id;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="FK_Tenant_Id", referencedColumnName = "Id")
	private Tenant tenant;
	
	private String tel;
	private String email;
	private String Address;

}
