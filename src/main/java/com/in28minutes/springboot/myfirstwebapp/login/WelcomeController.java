package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Controller
//public class LoginController {
//	
////	private Logger logger = LoggerFactory.getLogger(getClass());
//	
//	//http://localhost:8080/login?name=Ranga --- ? to indicate request param
//	
//	@RequestMapping("login")
//	//RequestParam to extract param from url
//	//Use ModelMap to allow param to be used in jsp
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//		//map a jsp var name to java param name
//		model.put("_name_", name);
//		//go into jsp file and add expression language (indicated as ${jsp var...})
//		//${_name_}
//		//and then browser will display request param
//		
//		//System.out.println("Request param is " + name); // not recommended for prod code
//		//do this instead
////		logger.debug("Request param is {}", name);
////		logger.info("I want this printed at info level");
////		logger.warn("I want this printed at warn level");
//		return "login";
//	}
//
//}

@Controller
@SessionAttributes("name")
public class WelcomeController {
	//logins require post and get
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
