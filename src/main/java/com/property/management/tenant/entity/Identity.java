package com.property.management.tenant.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.property.management.tenant.entity.enums.IdType;

import lombok.Data;

@Entity
@Table
@Data
public class Identity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5045771086390244911L;

	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private int Id;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_tenant_id", referencedColumnName = "Id")
	private Tenant tenant;
	
	private String  idNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="idType")
	private IdType idType ;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat
	private Date expiry;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat
	private Date acquired;
	
	private String nationality;

}
