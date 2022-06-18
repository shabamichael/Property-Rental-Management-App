/**
 * 
 */
package com.property.management.tenant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.management.tenant.entity.Nextofkin;
import com.property.management.tenant.entity.enums.IdType;
import com.property.management.tenant.repository.NextofkinRepository;

/**
 * @author Michael
 *
 */
@Service
public class NextofkinImplementation implements  NextofkinService{

	@Autowired
	private NextofkinRepository nextOfKinRepository;
	public NextofkinImplementation(NextofkinRepository nextOfKinRepository) {
		super();
		this.nextOfKinRepository = nextOfKinRepository;
	}

	@Override
	public Nextofkin createNewNextOfKin(Nextofkin nextOfKin) {
		// TODO Auto-generated method stub
		return  nextOfKinRepository.save(nextOfKin);
	}

	@Override
	public Nextofkin getOneNextOfKin(int Id) {
		// TODO Auto-generated method stub
		return nextOfKinRepository.getById(Id);
	}

	@Override
	public List<Nextofkin> getAllNextOfKin() {
		// TODO Auto-generated method stub
		return nextOfKinRepository.findAll();
	}

	@Override
	public void removeNextOfKin(int Id) {
		// TODO Auto-generated method stub
		nextOfKinRepository.deleteById(Id);
	}

	@Override
	public List<Nextofkin> getByTenantId(int Id) {
		// TODO Auto-generated method stub
		return nextOfKinRepository.findAll()
				.stream().filter(tenant ->tenant.getTenant().getId() == Id)
				.sorted().collect(Collectors.toList());
	}

}
