package com.property.management.tenant.service;

import java.util.List;

import javax.persistence.Entity;

import com.property.management.tenant.entity.Nextofkin;


public interface NextofkinService {
	public Nextofkin createNewNextOfKin(Nextofkin nextOfKin);
	public  Nextofkin getOneNextOfKin(int Id);
	public List<Nextofkin> getAllNextOfKin();
	public void removeNextOfKin(int Id);
	public List<Nextofkin> getByTenantId(int Id);
}