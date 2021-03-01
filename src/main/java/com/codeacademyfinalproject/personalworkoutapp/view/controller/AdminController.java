package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private CoachService coachService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin")
	public String showAdminPage(Model model) {
		List<Coach> coachesList = coachService.getAllCoaches();
		List<User> userList = userService.getAllUsers();
		model.addAttribute("coach", coachesList);
		model.addAttribute("user", userList);
		return "admin";
	}
	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editCoachesById(Model model, @PathVariable("id") Optional<Long> id)  {
		if (id.isPresent()) {
			Coach coach = coachService.getCoachById(id.get());
			model.addAttribute("coach", coach);
		} else {
			model.addAttribute("coach", new Coach());
		}
		return "add-edit";
	}
	@RequestMapping(path = {"/edit-user", "/edit-user/{id}"})
	public String editUsersById(Model model, @PathVariable("id") Optional<Long> id)  {
		if (id.isPresent()) {
			User user = userService.getUserById(id.get());
			model.addAttribute("user", user);
		} else {
			model.addAttribute("user", new User());
		}
		return "add-edit-user";
	}
	
	@RequestMapping(path = {"/delete", "/delete/{id}"})
	public String deleteCoachById(Model modal, @PathVariable("id") Long id) {
		coachService.deleteCoachById(id);
		return "redirect:/admin";
	}
	
	@RequestMapping(path = {"/delete-user", "/delete-user/{id}"})
	public String deleteUserById(Model modal, @PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/admin";
	}
	
	@RequestMapping(path = "/createCoach", method = RequestMethod.POST)
	public String createOrUpdateCoach(Coach coach) {
		coachService.updateCoach(coach);
		return "redirect:/admin";
	}
	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createOrUpdateUser(User user) {
		userService.updateUser(user);
		return "redirect:/admin";
	}
}
	
