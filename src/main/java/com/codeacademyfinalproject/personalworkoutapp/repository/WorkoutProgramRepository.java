package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Group;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;

@Repository
public interface WorkoutProgramRepository extends JpaRepository<WorkoutProgram, Long> {
	
	List<WorkoutProgram> findByGroup(Group group);
	
}
