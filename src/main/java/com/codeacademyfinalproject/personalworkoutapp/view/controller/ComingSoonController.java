package com.codeacademyfinalproject.personalworkoutapp.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComingSoonController {
	
	
	@GetMapping("/coming-soon")
	public String showComingSoonPage() {
		return "coming-soon";
	}
}
