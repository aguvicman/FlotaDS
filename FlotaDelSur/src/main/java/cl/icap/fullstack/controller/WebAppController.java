package cl.icap.fullstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
	
	@RequestMapping("/index")
	public String getIndex() {
	    return "index";
	}

	@RequestMapping("/adminPage")
	public String getAdmin() {
	    return "adminPage";
	}

}
