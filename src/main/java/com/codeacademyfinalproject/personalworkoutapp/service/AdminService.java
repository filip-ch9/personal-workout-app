package com.codeacademyfinalproject.personalworkoutapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademyfinalproject.personalworkoutapp.model.Admin;
import com.codeacademyfinalproject.personalworkoutapp.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin> isValidAdmin(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);
	}
	
}
