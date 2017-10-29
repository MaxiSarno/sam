package edu.uade.sam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uade.sam.dao.UserAccountRepository;

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
}
