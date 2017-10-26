package edu.uade.sam.service;

import edu.uade.sam.model.User;

/**
 * @author msarno
 *
 */
public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
