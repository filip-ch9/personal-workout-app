package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkoutProgramController {
	
	
	@GetMapping("/create-workout")
	public String showCreateWorkoutPage() {
		return "create-workout";
	}
}
