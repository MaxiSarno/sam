package edu.uade.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.dao.UserAccountRepository;
import edu.uade.sam.model.UserAccount;

@RestController
public class FrontController {
	
	@Autowired
	private UserAccountRepository userRepo;

	@RequestMapping("/keep-alive")
	public String keepAlive() {
		return "i'm still alive";
	}

	@RequestMapping("/health-check")
	public String healthCheck() {
		StringBuilder sb = new StringBuilder();
		sb.append("sam backend : v0.1 \n");
		sb.append("dependencies : { \n");
		
		if(userRepo.findAll().size()>0) {
			sb.append("\tMysql : OK \n");
		} else { 
			sb.append("\tMysql : ERROR \n");
		}
		sb.append("}");
		return sb.toString();
	}
	
	@RequestMapping("/login")
	public UserAccount login() {
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		if (a instanceof UsernamePasswordAuthenticationToken) {
			UserAccount u = this.userRepo.findByUsername(a.getName());
			u.obscurePassword();
		    return u;
		}
		return null;
	}
}
