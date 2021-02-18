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
	@Query(value = "SELECT * FROM personal_workout_app_schema.application_user WHERE personal_workout_app_schema.application_user.a = :id", nativeQuery = true)
	public List<Coach> findByUsersIdNative(@Param("id") Long id);
	
	public List<Coach> findByWorkoutPrograms_Id(Long id);
	
}
