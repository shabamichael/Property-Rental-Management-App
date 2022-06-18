package com.property.management.tenant.controller.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.property.management.tenant.entity.Contact;
import com.property.management.tenant.entity.Tenant;
import com.property.management.tenant.service.ContactServices;

@Controller
@RequestMapping(path = ContactController.BASEURL)
public class ContactController {
	public static final String BASEURL = "/api/v1/contact";
	
	@Autowired
	private ContactServices contactServices;

	public ContactController(ContactServices contactServices) {
		super();
		this.contactServices = contactServices;
	}
	
	 @GetMapping("/{Id}")
	public  List<Contact> readTenantById(@PathVariable int Id){
		return contactServices.readTenantById(Id);
	}
	 
	 public ResponseEntity<List<Contact>> getAllContacts(){
		 return new ResponseEntity<List<Contact>>(contactServices.getAllContacts() , HttpStatus.OK);
	 }
	
	

	@DeleteMapping(value="/delete/{Id}")
	public void removeContact(@PathVariable("Id") final int Id) {
		contactServices.removeContact(Id);
	}
	
	@PutMapping(value="/update/{Id}")
	public void updateContact(@PathVariable int Id, Contact contact) {
		contactServices.updateContact(Id, contact);
	}
	
	@PostMapping(value="/create")
	public void createNewContact(@Validated @RequestBody Contact contact) {
		contactServices.createNewContact(contact);
	}
	
}
