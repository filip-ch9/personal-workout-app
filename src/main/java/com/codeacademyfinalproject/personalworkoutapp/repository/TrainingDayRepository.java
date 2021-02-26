package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;

@Repository
public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long>{
	
	public List<TrainingDay> findByWorkoutPrograms_Id(Long id);
	
}
