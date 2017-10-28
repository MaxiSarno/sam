package edu.uade.sam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uade.sam.config.UserAccount;
import edu.uade.sam.dao.UserAccountRepository;
import edu.uade.sam.service.UserService;

/**
 * @author msarno
 *
 */
@Component
public class UserServiceImpl implements UserService {	
	
	@Autowired
	private UserAccountRepository userRepo;

	@Override
	public UserAccount findByUsername(String username) {
		return this.userRepo.findByUsername(username);
	}

	@Override
	public List<UserAccount> findAll() {
		return this.userRepo.findAll();
	}

	@Override
	public void save(UserAccount u) {
		this.userRepo.save(u);
	}

	@Override
	public void update(UserAccount u) {
		if (this.findByUsername(u.getUsername()) != null) {
			this.userRepo.save(u);
		}
	}

	@Override
	public void deleteByUsername(String username) {
		this.userRepo.delete(username);
	}

}
