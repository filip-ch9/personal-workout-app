package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
public class WorkoutProgramController {
	
	@Autowired
	private WorkoutProgramService workoutProgramService;
	
	@GetMapping("/training")
	public String showCreateWorkoutPage() {
		return "training";
	}
}
