package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByEmailAndPassword(String email, String password);

	public List<User> findByEmail(String email);
	
	public List<User> findByCoach(Coach coach);
	
	public List<User> findByWorkoutProgram(WorkoutProgram workoutProgram);
	
	@Query(value = "SELECT * FROM personal_workout_schema.application_user\r\n"
			+ "JOIN personal_workout_schema.coaches\r\n"
			+ "ON personal_workout_schema.application_user.coach_id = personal_workout_schema.coaches.id", nativeQuery = true)
	public List<User> findByCoachIdNative(@Param("id") Long id);
}
