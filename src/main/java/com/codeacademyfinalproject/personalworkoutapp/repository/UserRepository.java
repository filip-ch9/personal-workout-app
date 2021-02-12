package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByEmailAndPassword(String email, String password);

	public List<User> findByEmail(String email);
	
	
}
