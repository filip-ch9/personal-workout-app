package com.codeacademyfinalproject.personalworkoutapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.repository.CoachRepository;

@Service
public class CoachService {

	@Autowired
	private CoachRepository coachRepository;

	public List<Coach> getAllCoaches() {
		List<Coach> coachesList = coachRepository.findAll();

		if (coachesList.size() > 0) {
			return coachesList;
		} else {
			return new ArrayList<Coach>();
		}
	}

	public List<Coach> getCoach(String email) {
		return coachRepository.findByEmail(email);
	}

	public List<Coach> isValidCoach(String email, String password) {
		return coachRepository.findByEmailAndPassword(email, password);
	}

	public Coach updateCoach(Coach coach) {
		Optional<Coach> coaches = coachRepository.findById(coach.getId());

		if (coaches.isPresent()) {
			Coach newCoach = coaches.get();
			newCoach.setEmail(coach.getEmail());
			newCoach.setName(coach.getName());
			newCoach.setSurname(coach.getSurname());

			newCoach = coachRepository.save(newCoach);
			return newCoach;
		} else {
			coach = coachRepository.save(coach);
			return coach;
		}
	}

	public Coach saveCoach(Coach coach) {
		coach = coachRepository.save(coach);
		return coach;
	}

	public Coach deleteCoach(Coach coach) {
		coachRepository.delete(coach);
		return coach;
	}

}
