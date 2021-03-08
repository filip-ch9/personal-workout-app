package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
@SessionAttributes(names = {"user", "workouts"})
public class UserProfileController {
	

	@Autowired
	private WorkoutProgramService workoutProgramService;
	
	@GetMapping("/user-profile")
	public String showProfilePage(Model model) {
//		if (model.getAttribute("user") == null) {
//			model.put("errorMessage", "You are not logged in!");
//			return "redirect:/login";
//		} else {
			User user = (User)model.getAttribute("user");
//			WorkoutProgram wp = (WorkoutProgram)model.getAttribute("id");
			model.addAttribute("user", user);
//			model.put("workouts", userService.getUsersWorkoutProgram(wp.getId()));
			return "user-profile";
		}
	
	
	@GetMapping("/user-training")
	public String showTrainingPage(Model model) {
		List<WorkoutProgram> workouts = workoutProgramService.getAllWorkoutPrograms();
		model.addAttribute("workouts", workouts);
		return "user-training";
	}
	
}
