package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

	public List<Coach> findByEmailAndPassword(String email, String password);

	public List<Coach> findByEmail(String email);
	
	public List<Coach> findByUsersIdIn(List<User> usersId);
	
	public List<Coach> findByWorkoutProgramsIdIn(List<WorkoutProgram> workoutProgramsId);
	
}
