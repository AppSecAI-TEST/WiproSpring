package com.wipro;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	ArrayList<UserDTO> user = null;
	
	@ModelAttribute
	public void addingCommonObjects(Model model){
		model.addAttribute("headerMessage","Some header message");
	}

	@RequestMapping("/") 
	public String homePage(){
		// some task
//		ModelAndView model = new ModelAndView("HomePage");
//		model.addObject("title","Home Page");
		return "HomePage";
	}
		
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginPage(){
		ModelAndView model = new ModelAndView("LoginPage");
		model.addObject("title","Login Page");
		return model;
	}
	
	
	@RequestMapping(value="/submitLoginDetails", method = RequestMethod.POST)
	public ModelAndView submitLoginPage(@ModelAttribute("user") UserDTO user){
		ModelAndView model = new ModelAndView("SubmitDetails");
		model.addObject("title","Login Details");
		if(user.getlName().equalsIgnoreCase(user.getPassword())){
			model.addObject("submitDetail", user.getfName()+" " + user.getlName()+" has successfully logged in.");
		}
		else{
			model.addObject("submitDetail","Password is not correct.");
		}
		return model;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registrationPage(){
		ModelAndView model = new ModelAndView("RegistrationPage");
		model.addObject("title","Registration Page");
		return model;
	}
	
	
	@RequestMapping(value="/registrationComplete", method = RequestMethod.POST)
	public ModelAndView registrationPage(@ModelAttribute("user") UserDTO user , BindingResult result){
		
		ModelAndView model = null;
		
		if(result.hasErrors()){
			model = new ModelAndView("RegistrationPage");
		}
		else{
			model = new ModelAndView("SubmitDetails");
			model.addObject("title","Registration Details");
			System.out.println(user);
			if(user.getfName()!="" && user.getlName()!="" && user.getPassword()!=""){
				// put here the database --> logic
				
				model.addObject("submitDetail",user.getfName()+" "+user.getlName()+" is successfully registered");
			}
			else{
				model.addObject("submitDetail",user.getfName()+" "+user.getlName()+" is not registered (some data was not filled, try again)");
			}
		}
		return model;
	}
		
}
