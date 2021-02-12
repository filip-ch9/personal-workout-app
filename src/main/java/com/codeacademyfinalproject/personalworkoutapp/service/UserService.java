package com.codeacademyfinalproject.personalworkoutapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	public List<User> getUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<User> getAllUsers() {
		List<User> usersList = userRepository.findAll();
		return  usersList;
	}
	
	public List<User> isValidUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User saveUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User updateUser(User user) {
		Optional<User> users = userRepository.findById(user.getId());
		
		if( users.isPresent()) {
			User newUser = users.get();
			newUser.setEmail(user.getEmail());
			newUser.setName(user.getName());
			newUser.setSurname(user.getSurname());
			
			newUser = userRepository.save(newUser);
			return newUser;
		} else {
			return user;
		}
	}
	
	public User deleteUser(User user) {
		userRepository.delete(user);
		return user;
	}
}
