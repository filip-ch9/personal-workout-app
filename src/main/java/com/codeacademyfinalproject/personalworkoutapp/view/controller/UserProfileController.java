package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
@SessionAttributes(names = {"user", "workouts"})
public class UserProfileController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private WorkoutProgramService workoutProgramService;
	
	@GetMapping("/user-profile")
	public String showProfilePage(ModelMap model) {
		if (model.getAttribute("user") == null) {
			model.put("errorMessage", "You are not logged in!");
			return "redirect:/login";
		} else {
			User user = (User)model.getAttribute("user");
			WorkoutProgram wp = (WorkoutProgram)model.getAttribute("id");
			model.put("user", userService.getUser(user.getEmail()));
			model.put("workouts", userService.getUsersWorkoutProgram(wp.getId()));
			return "user-profile";
		}
	}
	
	@GetMapping("/start-training")
	public String showTrainingPage(ModelMap model) {
		User user = (User) model.getAttribute("user");
		List<WorkoutProgram> workouts = workoutProgramService.getByUser(user.getEmail());
		model.addAttribute("workouts", workouts);
		return "training";
	}
	
}
