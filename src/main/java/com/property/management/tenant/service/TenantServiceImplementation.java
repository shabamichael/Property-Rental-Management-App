package com.property.management.tenant.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.property.management.tenant.entity.Tenant;
import com.property.management.tenant.repository.TenantRepository;

@Service
public class TenantServiceImplementation implements TenantService{
	private final static Logger LOGGER = LoggerFactory.getLogger(TenantServiceImplementation.class);
	
	
	private TenantRepository tenantRepository;

	//Creates a new Tenant
	@Override
	public void createNewTenant(Tenant tenant) {
				// TODO Auto-generated method stub
		tenantRepository.save(tenant);
		LOGGER.info(String.format("Added a new tenant %s  %s at %s")
				, tenant.getFName(), tenant.getSurname(), LocalDateTime.now()) ;
	}
	
	//Delete a new Tenant By Id
	@Override
	public void removeTenant(int Id) {
		// TODO Auto-generated method stub
		Tenant tenant = new Tenant();
		tenantRepository.deleteById(Id);
		LOGGER.info(String.format("Deleted  tenant %s  %s at %s")
				, tenant.getFName(), tenant.getSurname(), LocalDateTime.now()) ;
	}


	// Get or Read tenant by Id
	@Override
	public Tenant readOneTenant(int Id) {
		// TODO Auto-generated method stub
		// check to see if the customer is present on the database
		if (!tenantRepository.existsById(Id)) {
			throw new IllegalStateException(String.format("Tenant with Id:- %s does not exist.", Id));
		} else {
			return tenantRepository.findById(Id).orElseThrow();
		}
	}
	
	
	@Override
	public List<Tenant> readAllTenant() {
		// TODO Auto-generated method stub
		return tenantRepository.findAll();
	}

	@Override
	public long countTenants() {
		// TODO Auto-generated method stub
		return tenantRepository.count();
	}


	@Override
	public List<Tenant> readTenantBySurname(String surname) {
		// TODO Auto-generated method stub
		return tenantRepository.findAll()
				.stream().filter(name -> name.getSurname().equalsIgnoreCase(surname))
				.sorted().collect(Collectors.toList());
	}

	@Override
	public List<Tenant> readTenantByFirstName(String fName) {
		// TODO Auto-generated method stub
		return tenantRepository.findAll()
				.stream().filter(name -> name.getFName().equalsIgnoreCase(fName))
				.sorted().collect(Collectors.toList());
		
	}



			
}

