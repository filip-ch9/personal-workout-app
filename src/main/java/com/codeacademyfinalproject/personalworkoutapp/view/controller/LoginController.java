package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.Admin;
import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.service.AdminService;
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;

@Controller
@SessionAttributes(names = {"username", "coach", "biography", "email", "user", "workoutPrograms", "workoutProgram", "workouts"})
public class LoginController {

	@Autowired
	private CoachService coachService;
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;

	@GetMapping("/login")
	public String showLoginPage(ModelMap model) {
		return "login";
	}
	
	@PostMapping("/login")
	public String showProfilePage(ModelMap model, @RequestParam String email, @RequestParam String password) {
		List<Admin> isValidAdmin = adminService.isValidAdmin(email, password);
		List<Coach> isValidCoach = coachService.isValidCoach(email, password);
		List<User> isValidUser = userService.isValidUser(email, password);
		if (!isValidCoach.isEmpty()) {
			model.put("email", email);
			model.put("password", password);
			return "redirect:/coach-profile";
		} else if (!isValidUser.isEmpty()) {
			model.put("email", email);
			model.put("password", password);
			return "redirect:/user-profile";
		} else if (!isValidAdmin.isEmpty()) {
			model.put("email", email);
			model.put("password", password);
			return "redirect:/admin";
		} else {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
	}
}
