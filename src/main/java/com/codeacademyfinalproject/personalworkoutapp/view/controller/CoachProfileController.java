package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutType;
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
@SessionAttributes(names = {"username", "coach", "users", "workoutPrograms"})
public class CoachProfileController {
	
	@Autowired
	private CoachService coachService;
	@Autowired
	private WorkoutProgramService workoutProgramService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/coach-profile")
	public String showProfilePage(ModelMap model) {
		Coach coach = (Coach)model.getAttribute("coach");
		User user = (User)model.getAttribute("user");
//		model.put("users", coachService.getCoachesUsers(coach, user));
		return "coach-profile";
	}
	
	@GetMapping("/training")
	public String showTrainingPage(ModelMap model) {
			return "training";
		}
	
	@PostMapping("/create")
	public String showCreateTrainingPage(ModelMap model) {
		model.addAttribute("training",
				new TrainingDay(0L, (String) model.get("nameOfExercise"), (int) model.get("duration"), new Date(),
						(int) model.get("sets"), (int) model.get("reps"), (int) model.get("pause"),
						(WorkoutType) model.get("type"), (byte[]) model.get("image")));
		return "training";
	}
	
	@GetMapping("/delete")
	public String deleteTraining(@RequestBody WorkoutProgram wp) {
		workoutProgramService.deleteWorkoutProgram(wp);
		return "redirect:/training";
	}
	
	
}
