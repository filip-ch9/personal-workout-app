package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;

@Controller
@SessionAttributes(names = {"email", "users", "workoutPrograms"})
public class CoachProfileController {
	
	@Autowired
	private CoachService coachService;
	
	@GetMapping("/coach-profile")
	public String showProfilePage(ModelMap model) { 
		if (model.getAttribute("email") == null) {
			model.addAttribute("errorMessage", "You are not logged in");
			return "redirect:/login";
		} else {
			Coach coach = (Coach)model.getAttribute("email");
			model.put("workoutPrograms", coachService.getCoachesWorkoutPrograms(coach.getWorkoutPrograms()));
			model.put("users", coachService.getCoachesUsers(coach.getUsers()));
			return "coach-profile";
		}
		
	}
	
}
