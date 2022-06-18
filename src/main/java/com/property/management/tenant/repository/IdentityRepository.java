/**
 * 
 */
package com.property.management.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.property.management.tenant.entity.Identity;

/**
 * @author Michael
 *
 */
@Repository
public interface IdentityRepository extends JpaRepository<Identity, Integer>{

}
