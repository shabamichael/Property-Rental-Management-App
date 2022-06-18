/**
 * 
 */
package com.property.management.tenant.service;

import java.util.List;
import java.util.Set;

import com.property.management.tenant.entity.Identity;
import com.property.management.tenant.entity.enums.IdType;

/**
 * @author Michael
 *
 */
public interface IdentityService {
	
	public Identity createNewIdentity(String idType , Identity identity);
	public  void removeIdentity(int Id);
	public Set<Identity> readTenantIdentitiesById(int Id);
	public Set<Identity> readTenantIdentitiesByIdNo(String idNo);
	public Set<Identity> readTenantIdentitiesByNationalities(String Nationality);
	public List<Identity> getAllIdentities();
	public List<Identity> getIdentityByTenantId(int tenantId);
}
