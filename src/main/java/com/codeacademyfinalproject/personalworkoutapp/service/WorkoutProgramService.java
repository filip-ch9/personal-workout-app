package com.codeacademyfinalproject.personalworkoutapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.repository.WorkoutProgramRepository;

@Service
public class WorkoutProgramService {

	@Autowired
	private WorkoutProgramRepository workoutProgramRepository;


	public List<WorkoutProgram> getAllWorkoutPrograms() {
		List<WorkoutProgram> workoutsList = workoutProgramRepository.findAll();
		if (workoutsList.size() > 0) {
			return workoutsList;
		} else {
			return new ArrayList<WorkoutProgram>();
		}
	}
	// TODO get object 
	public List<WorkoutProgram> getByCoach(Coach coach) {
		return workoutProgramRepository.findByCoach(coach);
	}
	
	public List<WorkoutProgram> getByCoachNative(Long id) {
		 return workoutProgramRepository.findByCoachesIdNative(id);
		 
	}
	
	public WorkoutProgram updateWorkoutProgram(WorkoutProgram wp, User user, TrainingDay tDay) {
		Optional<WorkoutProgram> workouts = workoutProgramRepository.findById(wp.getId());
		
		if (workouts.isPresent()) {
			WorkoutProgram newWorkoutProgram = workouts.get();
			newWorkoutProgram.setStartDate(wp.getStartDate());
			newWorkoutProgram.setEndDate(wp.getEndDate());
			newWorkoutProgram.addUser(user);
			newWorkoutProgram.addTrainingDay(tDay);
			newWorkoutProgram.setGroup(wp.getGroup());
			
			newWorkoutProgram = workoutProgramRepository.save(newWorkoutProgram);
			return newWorkoutProgram;
		} else {
			wp = workoutProgramRepository.save(wp);
			return wp;
		}
		
	}
	
	public WorkoutProgram getWorkoutProgramById(Long id) {
		Optional<WorkoutProgram> wp = workoutProgramRepository.findById(id);
		
		if(wp.isPresent()) {
			return wp.get();
		} else {
			return null;
		}
	}
	
	public WorkoutProgram saveWorkoutProgram(WorkoutProgram wp) {
		wp = workoutProgramRepository.save(wp);
		return wp;
	}
	
	public WorkoutProgram deleteWorkoutProgram(WorkoutProgram wp) {
		workoutProgramRepository.delete(wp);
		return wp;
	}
	
	public void deleteWorkoutProgramById(Long id) {
		workoutProgramRepository.deleteById(id);
	}
	
}
