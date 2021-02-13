package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Group;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;

@Repository
public interface WorkoutProgramRepository extends JpaRepository<WorkoutProgram, Long> {

	public List<WorkoutProgram> findByGroup(Group group);

	// complex query for nested entity graph
	public List<WorkoutProgram> findByCoaches_Email(String email);

	public List<WorkoutProgram> findByUsers_Email(String email);

	public List<WorkoutProgram> findByWorkouts_Id(Long id);

}
