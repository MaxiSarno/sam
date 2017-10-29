package edu.uade.sam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uade.sam.model.UserAccount;

/**
 * @author msarno
 *
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

	UserAccount findByUsername(String username);

}
