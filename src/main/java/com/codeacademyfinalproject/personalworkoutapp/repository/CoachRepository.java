package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.Group;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

	public List<Coach> findByEmailAndPassword(String email, String password);

	public List<Coach> findByEmail(String email);
	
	public List<Coach> findByWorkoutPrograms(List<WorkoutProgram> workouts);
	
	public List<Coach> findByUsers_Id(List<User> usres);
	
	public List<Coach> findByUsersAndWorkoutPrograms(List<User> users, List<WorkoutProgram> workouts);
	
	public List<Coach> findByUsersAndGroup(List<User> users, Group group);
	
}
