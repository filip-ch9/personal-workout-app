package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.service.CoachService;

@Controller
@SessionAttributes(names = { "username", "title", "biography" })
public class CoachRegisterController {

	@Autowired
	private CoachService coachService;

	@GetMapping("/coach-register")
	public String getSignUpForm() {
		return "coach-register";
	}

	@PostMapping("/coach-register")
	public String registerCoach(@RequestBody String body, @RequestParam String email, Coach coach, ModelMap model) {
		List<Coach> isValidEmail = coachService.getCoach(email);
		if (isValidEmail.isEmpty()) {
			coach = coachService.saveCoach(coach);
			model.put("username", coach.getUsername());
			model.put("title", coach.getTitle());
			model.put("biography", coach.getBiography());
			model.put("coach", coach);
			return "redirect:/coach-profile";
		} else {
			model.put("errorMessage", "Email is already in use");
			return "coach-register";
		}
	}
}
