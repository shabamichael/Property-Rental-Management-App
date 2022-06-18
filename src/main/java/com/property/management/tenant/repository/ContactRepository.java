package com.property.management.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.property.management.tenant.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
