package com.wipro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView loginMethod1(){
		System.out.println("in login url with post method");
		ModelAndView model = new ModelAndView("LoginPage");
		model.addObject("title", "Login Page!!!");
		model.addObject("headerMessage", "Login Form");
		
		return model;
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginMethod(HttpServletRequest req, HttpServletResponse res){
		ModelAndView model = null;
		String name = req.getParameter("fName");
		String password = req.getParameter("password");
		if(name.length()>0 && name.equalsIgnoreCase(password)){
			model = new ModelAndView("SubmitDetails");
			model.addObject("title","Success page");
			model.addObject("headerMessage","Successful login");
			model.addObject("submitDetail","Welcome user");
			UserDTO user = new UserDTO();
			user.setfName(name);
			model.addObject("user", user);
			
		} else {
			model = new ModelAndView("LoginPage");
			model.addObject("error", "Invalid details");
		}
		return model;
	}
	
	// ..../details?id=x
	@RequestMapping("/details")
	public ModelAndView getParam(@RequestParam("id") int id){
		ModelAndView model = new ModelAndView("HomePage");
		System.out.println("Param id is: "+id);
		return model;
		
	}
	
}
