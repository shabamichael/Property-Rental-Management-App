/**
 * 
 */
package com.property.management.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.property.management.tenant.entity.Nextofkin;

/**
 * @author Michael
 *
 */
@Repository
public interface NextofkinRepository extends JpaRepository<Nextofkin, Integer> {

}
