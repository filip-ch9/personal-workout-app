package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;

@Controller
@SessionAttributes(names = { "username", "user", "email" })
public class UserRegisterController {

	@Autowired
	private UserService userService;

	@GetMapping("/user-register")
	public String getSignUpForm() {
		return "user-register";
	}

	@PostMapping("/user-register")
	public String registerUser(@RequestBody String body, @RequestParam String email, User user, ModelMap model) {
		List<User> isValidEmail = userService.getUser(email);
		if (isValidEmail.isEmpty()) {
			user = userService.saveUser(user);
			model.addAttribute("username", user.getUsername());
			model.addAttribute("user", user);
			model.addAttribute("email", email);
			return "redirect:/user-profile";
		} else {
			model.put("errorMessage", "Email is already in use");
			return "user-register";
		}
	}

}
