package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;

@Controller
@SessionAttributes(names = {"username", "users", "workoutPrograms"})
public class CoachProfileController {
	
	@Autowired
	private CoachService coachService;
	
	@GetMapping("/coach-profile")
	public String showProfilePage(ModelMap model) { 
		return "coach-profile";
	}
	
}
