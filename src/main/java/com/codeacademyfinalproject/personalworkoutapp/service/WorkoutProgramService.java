package com.codeacademyfinalproject.personalworkoutapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademyfinalproject.personalworkoutapp.repository.WorkoutProgramRepository;

@Service
public class WorkoutProgramService {
	
	@Autowired
	private WorkoutProgramRepository workoutProgramRepository;
}
