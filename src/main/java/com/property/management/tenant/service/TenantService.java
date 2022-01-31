package com.property.management.tenant.service;

import java.util.List;

import com.property.management.tenant.entity.Tenant;

public interface TenantService {
	
	public  void createNewTenant(Tenant tenant);
	public  void removeTenant(int Id);


	public List<Tenant> readTenantBySurname(String surname);
	public List<Tenant>readTenantByFirstName(String fName);
	public List<Tenant> readAllTenant();
	public long countTenants();
	public Tenant readOneTenant(int Id);
	
	
	

}
