package edu.uade.sam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uade.sam.model.User;

/**
 * @author msarno
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByUsername(String username);

}
