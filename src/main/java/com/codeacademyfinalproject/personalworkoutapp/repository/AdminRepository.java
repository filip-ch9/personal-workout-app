package com.codeacademyfinalproject.personalworkoutapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeacademyfinalproject.personalworkoutapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	public List<Admin> findByEmailAndPassword(String email, String password);
	
	
}
