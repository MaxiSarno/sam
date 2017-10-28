package edu.uade.sam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uade.sam.config.UserAccount;

/**
 * Usuariios del sistema
 * 
 * @author msarno
 *
 */
@Service
public interface UserService {
	
	List<UserAccount> findAll();
	
	void save(UserAccount u);

	UserAccount findByUsername(String username);
	
	void deleteByUsername(String username);

	void update(UserAccount u);

}
