package com.property.management.tenant.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.management.tenant.entity.Identification;
import com.property.management.tenant.entity.Identity;
import com.property.management.tenant.entity.enums.IdType;
import com.property.management.tenant.repository.IdentityRepository;

@Service
public class IdentityServiceImplementation implements IdentityService {
	
	@Autowired
	private IdentityRepository identityRepository;
	public IdentityServiceImplementation(IdentityRepository identityRepository) {
		super();
		this.identityRepository = identityRepository;
	}

	@Override
	public Identity createNewIdentity( String idType , Identity identity) {
		// TODO Auto-generated method stub
		Identification verify = new Identification();
		verify.IdentificationNumber(idType.toString(), identity.getIdNo());
				return identityRepository.save(identity);
	}

	@Override
	public void removeIdentity(int Id) {
		// TODO Auto-generated method stub
		identityRepository.deleteById(Id);
		
	}



	@Override
	public Set<Identity> readTenantIdentitiesById(int Id) {
		// TODO Auto-generated method stub
		return identityRepository.findAll()
				.stream().filter(identity -> identity.getId()==Id)
				.sorted().collect(Collectors.toSet());
	}
	
	@Override
	public Set<Identity> readTenantIdentitiesByNationalities(String nationality) {
		// TODO Auto-generated method stub
		return identityRepository.findAll()
				.stream().filter(identity -> identity.getNationality().equalsIgnoreCase(nationality))
				.sorted().collect(Collectors.toSet());
	}

	@Override
	public Set<Identity> readTenantIdentitiesByIdNo(String idNo) {
		// TODO Auto-generated method stub
		return identityRepository.findAll()
				.stream().filter(identity -> identity.getIdNo().equalsIgnoreCase(idNo))
				.sorted().collect(Collectors.toSet());

	}



	@Override
	public List<Identity> getAllIdentities() {
		// TODO Auto-generated method stub
		return identityRepository.findAll();
	}

	@Override
	public List<Identity> getIdentityByTenantId(int tenantId) {
		// TODO Auto-generated method stub
		return identityRepository.findAll()
				.stream().filter(tenant -> tenant.getTenant().getId() == tenantId)
				.sorted().collect(Collectors.toList());
	}

	

				

}

