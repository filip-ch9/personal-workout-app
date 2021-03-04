package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
@SessionAttributes(names = {"username", "coach", "email", "biography", "users", "workoutPrograms"})
public class CoachProfileController {

	@Autowired
	private WorkoutProgramService workoutProgramService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/coach-profile")
	public String showProfilePage(Model model) {
		Coach coach = (Coach)model.getAttribute("coach");
		model.addAttribute("coach", coach);
		return "coach-profile";
	}
	@GetMapping("/dashboard")
	public String showDashboard(ModelMap model) {
		Coach coach = (Coach)model.getAttribute("coach");
		List<User> userList = userService.getUsersByCoach(coach);
		List<WorkoutProgram> workoutProgramList = workoutProgramService.getByCoach(coach);
		model.put("users", userList);
		model.put("workoutPrograms", workoutProgramList);
		return "/dashboard";
	}
	@GetMapping("/analytics")
	public String showAnalytics() {
		return "/analytics";
	}
	@GetMapping("/training")
	public String showTrainingPage(ModelMap model) {
			return "training";
		}
	
	@PostMapping("/create")
	public String showCreateTrainingPage(ModelMap model) {
		model.addAttribute("training",
				new TrainingDay());
		return "training";
	}
	
	@GetMapping(path = {"/delete", "/delete/{id}"})
	public String deleteUserbyId(@RequestParam Long id) {
		userService.deleteUserById(id);
		return "redirect:/dashboard";
	}
	
	
}
