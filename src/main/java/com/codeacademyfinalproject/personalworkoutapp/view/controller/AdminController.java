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
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;

@Controller
public class AdminController {
	
	@Autowired
	private CoachService coachService;
	
	@GetMapping("/admin")
	public String showAdminPage(Model model) {
		List<Coach> coachesList = coachService.getAllCoaches();
		
		model.addAttribute("coach", coachesList);

		return "admin";
	}
	
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editCoachesAndUsersById(Model model, @PathVariable("id") Optional<Long> id)  {
		if (id.isPresent()) {
			Coach coach = coachService.getCoachById(id.get());
			model.addAttribute("coach", coach);
		} else {
			model.addAttribute("coach", new Coach());
		}
		return "add-edit";
	}
	
	@RequestMapping(path = "/delete{id}")
	public String deleteCoachAndUserById(Model modal, @PathVariable("id") Long id) {
		coachService.deleteCoachById(id);
		return "redirect:/admin";
	}
	
	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createOrUpdateUser(Coach coach) {
		coachService.updateCoach(coach);
		return "redirect:/admin";
	}
}
	
