package edu.uade.sam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uade.sam.model.Role;

/**
 * @author msarno
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

}
