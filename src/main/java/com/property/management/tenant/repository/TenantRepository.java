package com.property.management.tenant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.property.management.tenant.entity.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer>{



}
