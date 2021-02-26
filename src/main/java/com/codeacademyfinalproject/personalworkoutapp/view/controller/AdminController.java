package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CoachService coachService;
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String showAdminPage(Model model) {
		List<Coach> coachesList = coachService.getAllCoaches();
		List<User> usersList = userService.getAllUsers();
		
		model.addAttribute("coach", coachesList);
		model.addAttribute("user", usersList);

		return "admin";
	}
	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editCoachesAndUsersById(Model model, @PathVariable("id") Optional<Long> id)  {
		if (id.isPresent()) {
			Coach coach = coachService.getOneCoach(id.get());
			User user = userService.getOneUser(id.get());
			model.addAttribute("coach", coach);
			model.addAttribute("user", user);
		} else {
			model.addAttribute("coach", new Coach());
			model.addAttribute("user", new User());
		}
		return "add-edit";
	}
	
	@RequestMapping(path = "/delete{id}")
	public String deleteCoachAndUserById(Model modal, @PathVariable("id") Long id) {
		coachService.deleteCoachById(id);
		userService.deleteUserById(id);
		return "redirect:/admin";
	}
	
	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createOrUpdateUser(Coach coach, User user) {
		coachService.updateCoach(coach);
		userService.updateUser(user);
		return "redirect:/admin";
	}
}
	
