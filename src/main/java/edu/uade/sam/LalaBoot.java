package edu.uade.sam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LalaBoot {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "HolaMundo";
	}
	
	@RequestMapping("/hola")
	@ResponseBody
	String homela() {
		return "Hola Mundo";
	}
}