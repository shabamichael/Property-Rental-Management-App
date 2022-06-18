package com.property.management.tenant.service;

import java.util.List;

import com.property.management.tenant.entity.Contact;



public interface ContactServices {
	
public void createNewContact(Contact contact);
public  void removeContact(int Id);
public void updateContact(int Id , Contact contact);
public List<Contact> readTenantById(int Id);
public List<Contact> getAllContacts();
public List<Contact> getContactByTenantId(int tenantId);




}
