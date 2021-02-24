package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

	public List<Coach> findByEmailAndPassword(String email, String password);

	public List<Coach> findByEmail(String email);
	
	/**
	 * working with native queries
	 */
	// TODO change query method
	@Query(value = "SELECT * FROM  personal_workout_schema.coaches P INNER JOIN  personal_workout_schema.application_user  C  ON  C.coach_id = P.id", nativeQuery = true)
	public List<Coach> findByUsersIdNative(@Param("id") Long id1, @Param("id") Long id2);
	
	public List<Coach> findByWorkoutPrograms_Id(Long id);
	
}
