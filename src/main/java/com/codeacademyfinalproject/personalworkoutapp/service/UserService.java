package com.codeacademyfinalproject.personalworkoutapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getByCoachNative(Long id) {
		return userRepository.findByCoachIdNative(id);
	}
	
	public List<User> getUsersByWorkoutProgram(WorkoutProgram wp) {
		return userRepository.findByWorkoutProgram(wp);
	}

	public List<User> getUsersByCoach(Coach coach) {
		return userRepository.findByCoach(coach);
	}
	
	public User getOneUser(Long id) {
		return userRepository.getOne(id);
	}
	
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
		
	}
	
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
		Optional<User> users = userRepository.findById(user.getId());
		if (!users.isPresent()) {
		userRepository.save(user);
		return user;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public User updateUser(User user) {
		Optional<User> users = userRepository.findById(user.getId());
		
		if( users.isPresent()) {
			User newUser = users.get();
			newUser.setEmail(user.getEmail());
			newUser.setName(user.getName());
			newUser.setSurname(user.getSurname());
			newUser.setWorkoutProgram(user.getWorkoutProgram());
			
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
	
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
