package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
public class WorkoutProgramController {


	@Autowired
	private WorkoutProgramService workoutProgramService;

	
}
