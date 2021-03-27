package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;
import com.codeacademyfinalproject.personalworkoutapp.service.TrainingDayService;
import com.codeacademyfinalproject.personalworkoutapp.service.UserService;
import com.codeacademyfinalproject.personalworkoutapp.service.WorkoutProgramService;

@Controller
@SessionAttributes(names = { "username", "coach", "email", "biography", "users", "workoutPrograms" })
public class CoachProfileController {

	@Autowired
	private WorkoutProgramService workoutProgramService;
	@Autowired
	private UserService userService;
	@Autowired
	private CoachService coachService;
	@Autowired
	private TrainingDayService trainingDayService;

	@GetMapping("/coach-profile")
	public String showProfilePage(Model model) {
		Coach coach1 = (Coach) model.getAttribute("coach");
		model.addAttribute("coach", coach1);
		return "coach-profile";
	}

	@GetMapping("/dashboard")
	public String showDashboard(Model model, Long id) {
		List<User> userList = userService.getByCoachNative(id);
		List<WorkoutProgram> workoutProgramList = workoutProgramService.getByCoachNative(id);
		model.addAttribute("users", userList);
		model.addAttribute("workoutPrograms", workoutProgramList);
		return "/dashboard";
	}

	@GetMapping("/analytics")
	public String showAnalytics() {
		return "/analytics";
	}

	@GetMapping("/training")
	public String showTrainingPage(Model model) {
		List<WorkoutProgram> workoutPrograms = workoutProgramService.getAllWorkoutPrograms();
		List<TrainingDay> trainingDays = trainingDayService.getAllTrainingDays();
		model.addAttribute("workoutProgram", workoutPrograms);
		model.addAttribute("trainingDay", trainingDays);
		return "training";
	}

	@RequestMapping(path = { "/edit-program", "/edit-program/{id}" })
	public String editWorkoutProgram(Model model, @PathVariable("id") Optional<Long> id) {
		if (id.isPresent()) {
			WorkoutProgram wp = workoutProgramService.getWorkoutProgramById(id.get());
			model.addAttribute("workoutProgram", wp);
		} else {
			model.addAttribute("workoutProgram", new WorkoutProgram());
		}
		return "create-edit-workout-program";
	}

	@RequestMapping(path = { "/edit-training", "/edit-training/{id}" })
	public String editTraining(Model model, @PathVariable("id") Optional<Long> id) {
		if (id.isPresent()) {
			TrainingDay training = trainingDayService.getTrainingDayById(id.get());
			model.addAttribute("trainingDay", training);
		} else {
			model.addAttribute("trainingDay", new TrainingDay());
		}
		return "add-training-day";
	}

	// TODO step1: save workoutProgram to database using its service
	// step2: get all Users from database which are specified for the given
	// program(array of strings)
	// step3: for each user set the workoutProgram property the value is the
	// returned from saved workoutProgram
	// step4: update all users using the appropriate service
	@PostMapping("/createWorkoutProgram")
	public String createWorkoutProgram(Model model, WorkoutProgram workoutProgram) {

		workoutProgramService.updateWorkoutProgram(workoutProgram);

		return "redirect:/training";
	}

	@PostMapping("/createTrainingDay")
	public String createTrainingDay(Model model, TrainingDay training) {
		trainingDayService.updateTrainingDay(training);
		return "redirect:/training";
	}

	@RequestMapping(path = { "/delete-users", "/delete-users/{id}" })
	public String deleteUserbyId(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "redirect:/dashboard";
	}

	@RequestMapping(path = { "/delete-program", "/delete-program/{id}" })
	public String deleteWorkoutProgramById(@PathVariable("id") Long id) {
		workoutProgramService.deleteWorkoutProgramById(id);
		return "redirect:/training";
	}
	
	@RequestMapping(path = { "/delete-training", "/delete-training/{id}" })
	public String deleteTrainingById(@PathVariable("id") Long id) {
		trainingDayService.deleteTrainingDayById(id);
		return "redirect:/training";
	}

}
