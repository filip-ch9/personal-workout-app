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
	
	public Optional<TrainingDay> getTrainingDayById(Long id) {
		return trainingDayRepository.findById(id);
	}

}
