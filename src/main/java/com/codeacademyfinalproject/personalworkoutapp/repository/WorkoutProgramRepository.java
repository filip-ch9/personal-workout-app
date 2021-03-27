package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.Group;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;

@Repository
public interface WorkoutProgramRepository extends JpaRepository<WorkoutProgram, Long> {

	public List<WorkoutProgram> findByGroup(Group group);
		
	public List<WorkoutProgram> findByCoach(Coach coach);
	
	public List<WorkoutProgram> findByCoach_Id(Long id);
	
	@Query(value = "SELECT * FROM personal_workout_schema.workout_program \r\n"
			+ "JOIN personal_workout_schema.coaches\r\n"
			+ "ON personal_workout_schema.workout_program.coach_id = personal_workout_schema.coaches.id", nativeQuery = true)
	public List<WorkoutProgram> findByCoachesIdNative(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM personal_workout_schema.workout_program\r\n"
			+ "WHERE personal_workout_schema.workout_program.coach_id = id", nativeQuery = true) 
	public List<WorkoutProgram> findByCoachIdNative2(@Param("id") Long id);
	
}
