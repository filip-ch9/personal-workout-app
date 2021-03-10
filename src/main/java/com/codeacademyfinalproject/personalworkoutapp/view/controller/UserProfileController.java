package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.service.TrainingDayService;

@Controller
@SessionAttributes(names = { "user", "workouts" })
public class UserProfileController {

	@Autowired
	private TrainingDayService trainingDayService;

	@GetMapping("/user-profile")
	public String showProfilePage(Model model) {
//		if (model.getAttribute("user") == null) {
//			model.put("errorMessage", "You are not logged in!");
//			return "redirect:/login";
//		} else {
		User user = (User) model.getAttribute("user");
//			WorkoutProgram wp = (WorkoutProgram)model.getAttribute("id");
		model.addAttribute("user", user);
//			model.put("workouts", userService.getUsersWorkoutProgram(wp.getId()));
		return "user-profile";
	}

	@GetMapping("/user-training")
	public String showTrainingPage(Model model) {
		List<TrainingDay> workouts = trainingDayService.getAllTrainingDays();
		model.addAttribute("trainingDay", workouts);
		return "user-training";
	}

	@GetMapping("/user-analytics")
	public String showAnalyticsPage(Model model) {
		return "user-analytics";
	}

}
