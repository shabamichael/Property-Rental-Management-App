package com.property.management.tenant.controller.endpoint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.property.management.tenant.entity.Tenant;
import com.property.management.tenant.service.TenantService;

@Controller
@RequestMapping(path=TenantController.BASEURL)
public class TenantController {
	public static final String BASEURL= "/api/v1";
	
	@Autowired
	TenantService tenantService;
	
	
	//Return all Tenants in the repository
	@GetMapping("/tenants")
	public ResponseEntity<List<Tenant>> getAllTenants(){
		List<Tenant> tenants = tenantService.readAllTenant();
		return new  ResponseEntity<List<Tenant>>(tenants, HttpStatus.OK);
		
	}
	
	
	//Return  Tenants by surname entered 
	@GetMapping("/tenants/{surname}")
	public ResponseEntity<List<Tenant>> getTenantBySurname(@PathVariable("surname") final String surname){
		List<Tenant> tenants = tenantService.readTenantBySurname(surname);
		return new  ResponseEntity<List<Tenant>>(tenants, HttpStatus.OK);
	}

	//Return  Tenants by first name entered 
	@GetMapping("/tenants/{fName}")
	public ResponseEntity<List<Tenant>> getTenantByfirstName(@PathVariable("fName") final String fName){
		List<Tenant> tenants = tenantService.readTenantBySurname(fName);
		return new  ResponseEntity<List<Tenant>>(tenants, HttpStatus.OK);
		}
	
	//Return  Tenants by first name entered 
	@GetMapping("/tenant/{Id}")
	public ResponseEntity <Tenant> getTenantById(@PathVariable("Id") final int Id){
		Tenant tenant = tenantService.readOneTenant(Id);
		return new  ResponseEntity<Tenant>(tenant, HttpStatus.OK);
		}

	//Return  total count of Tenants 
	@GetMapping("/tenant/count")
	public ResponseEntity <Long> GetTotal(){
		long count = tenantService.countTenants();
		return new  ResponseEntity<Long>(count, HttpStatus.OK);
		}

	//Return  Tenants by first name entered 
		@DeleteMapping(value="/delete/tenant/{Id}")
		public  void deleteTenantById(@PathVariable("Id") final int Id){
			tenantService.removeTenant(Id);
			}
		
		//Create a new tenant
		@PostMapping("/save/tenant")
		public void createTenant(@RequestBody Tenant tenant) {
		tenantService.createNewTenant(tenant);
		}
	
}
