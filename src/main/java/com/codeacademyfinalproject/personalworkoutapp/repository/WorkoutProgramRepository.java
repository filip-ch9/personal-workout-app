package com.codeacademyfinalproject.personalworkoutapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;

@Repository
public interface WorkoutProgramRepository extends JpaRepository<WorkoutProgram, Long>{
	
	
	
}
