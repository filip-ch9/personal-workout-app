package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
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
			User user = (User)model.getAttribute("id");
			WorkoutProgram wp = (WorkoutProgram)model.getAttribute("id");
			model.put("email", coachService.getCoach(coach.getEmail()));
			model.put("users", coachService.getCoachesUsers(user.getId()));
			model.put("workoutPrograms", coachService.getCoachesWorkoutPrograms(wp.getId()));
			return "coach-profile";
		}
		
	}
	
}
