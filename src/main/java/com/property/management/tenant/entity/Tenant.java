package com.property.management.tenant.entity;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.property.management.tenant.entity.enums.Gender;
import com.property.management.tenant.entity.enums.MaritalStatus;
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
public class Tenant implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private int Id;
	
	@GeneratedValue(generator = "unique_id" ,strategy = GenerationType.AUTO)
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String unique_id = UUID.randomUUID().toString();
	private String tenantNo;
	private String firstname;
	private String othername;
	private String surname;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Identity> identity;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Nextofkin> nextofkin;
	
	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contact;

	@Enumerated(EnumType.STRING)
	@Column(name="Gender")
	private Gender gender;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="marital_status")
	private MaritalStatus marital_status;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat
	private Date DoB ;
	
	

	@JsonManagedReference
	@OneToMany(mappedBy ="tenant", fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmploymentDetails> employmentdetails;
	
	
	
	@Lob
	private Byte [] identificationScan;
	
	@Lob
	private Byte [] Signature;
	private String carRegNo;
	
	
	
	

}
