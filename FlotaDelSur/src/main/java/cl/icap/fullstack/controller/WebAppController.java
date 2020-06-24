package cl.icap.fullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
		
	
	
	@RequestMapping("/")
	public String getHome() {
	    return "index";
	}

	
	@RequestMapping("/index")
	public String getAdmi() {
	    return "adminPage";
	}
	
	@RequestMapping("/adminPage")
	public String getAdminpage() {
	    return "adminPage";
	}


	
}
