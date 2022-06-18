package com.property.management.tenant.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.property.management.tenant.entity.Contact;
import com.property.management.tenant.repository.ContactRepository;
import com.property.management.tenant.repository.TenantRepository;

@Service
public class ContactServiceImplementation implements ContactServices  {
	
	@Autowired
	private ContactRepository contactRepository;
	public ContactServiceImplementation(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public void createNewContact(Contact contact) {
		// TODO Auto-generated method stub
		contactRepository.save(contact);
		
	}
		
	

	@Override
	public void removeContact(int Id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(Id);
		
	}

	@Override
	public void updateContact(int Id, Contact contact) {
		// TODO Auto-generated method stub
		Contact cont = contactRepository.findById(Id).get();
		cont.setAddress(contact.getAddress());
		cont.setEmail(contact.getEmail());
		cont.setTel(contact.getTel());
		contactRepository.save(cont);
		
	}

	@Override
	public List<Contact> readTenantById(int Id) {
		// TODO Auto-generated method stub	
		return contactRepository.findAll()
				.stream().filter(contact -> contact.getId()==(Id))
				.sorted().collect(Collectors.toList());
		
	}

	
	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> getContactByTenantId(int tenantId) {
		// TODO Auto-generated method stub
		return contactRepository.findAll()
				.stream().filter(tenant -> tenant.getTenant().getId() == (tenantId))
				.sorted().collect(Collectors.toList());
	}

	

}
