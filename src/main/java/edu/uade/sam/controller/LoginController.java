package edu.uade.sam.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Component
public class LoginController {
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login() {
		return "All good. You DO NOT need to be authenticated to call /login";
	}
}
