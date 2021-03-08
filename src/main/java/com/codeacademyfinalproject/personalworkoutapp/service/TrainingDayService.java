package com.codeacademyfinalproject.personalworkoutapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.repository.TrainingDayRepository;

@Service
@Transactional
public class TrainingDayService {
	
	@Autowired
	private TrainingDayRepository trainingDayRepository;
	
	public void saveTrainingDay(TrainingDay tDay) {
		trainingDayRepository.save(tDay);
	}
	
	public List<TrainingDay> getAllTrainingDays() {
		return trainingDayRepository.findAll();
	}
	
	public TrainingDay getTrainingDayById(Long id) {
		Optional<TrainingDay> training = trainingDayRepository.findById(id);
		
		if (training.isPresent()) {
			return training.get();
		} else {
			return null;
		}
	}
	
	public TrainingDay updateTrainingDay(TrainingDay training) {
		Optional<TrainingDay> trainingDays = trainingDayRepository.findById(training.getId());
		
		if(trainingDays.isPresent()) {
			TrainingDay newTraining = trainingDays.get();
			newTraining.setNameOfExercise(training.getNameOfExercise());
			newTraining.setDuration(training.getDuration());
			newTraining.setDayOfTraining(training.getDayOfTraining());
			newTraining.setSets(training.getSets());
			newTraining.setReps(training.getReps());
			newTraining.setPause(training.getPause());
			newTraining.setImage(training.getImage());
			newTraining.setType(training.getType());
			
			newTraining = trainingDayRepository.save(newTraining);
			return newTraining;
		} else {
			training = trainingDayRepository.save(training);
			return training;
		}
	}
	
	public void deleteTrainingDayById(Long id) {
		trainingDayRepository.deleteById(id);
	}

}
