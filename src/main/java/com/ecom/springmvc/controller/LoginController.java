package com.ecom.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.springmvc.exceptions.UserNotFoundException;
import com.ecom.springmvc.service.UserService;

@Controller
@RequestMapping("/home")
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homepage");
		return model;
	}

	@RequestMapping(value = "/loginPage")
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("loginPage");
		logger.info("-----------Login Page---------- ");
		return model;
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validateUser(@RequestParam("useremail") String useremail, @RequestParam("password") String Pwd,
			HttpSession session)throws Exception {
		boolean userExists = userService.checkLogin(useremail, Pwd, session);
		if (userExists) {
			logger.info("-----------Logged in as ---------- "+useremail);
			return "redirect:/products/product";
		} else {
			logger.info("-----------Could not Login for  ---------- "+useremail);
			throw  new UserNotFoundException(useremail);
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("cart");
		session.removeAttribute("orderMOdel");
		session.invalidate();
		logger.info("-----------Logged Out ---------- ");
		return "redirect:loginPage";

	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}	

}
