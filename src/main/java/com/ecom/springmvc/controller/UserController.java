package com.ecom.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.springmvc.model.User;
import com.ecom.springmvc.service.UserService;
import com.ecom.springmvc.validator.UserValidator;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	UserValidator userValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public String listUser(Model model) {
//		/*
//		 * model.addAttribute("user", new User());
//		 * model.addAttribute("listUser", this.userService.listUser()); return
//		 * "trial";
//		 */
//		return "sucessPage";
//
//	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid User u, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "newUser";
		}
		if (u.getId() == 0) {
			// new person, add it
			this.userService.addUser(u);
		}
		return "redirect:/users/user";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser(Model model) {
		/*
		 * model.addAttribute("user", new User());
		 * model.addAttribute("listUser", this.userService.listUser()); return
		 * "trial";
		 */
		return "newUser";

	}

}
