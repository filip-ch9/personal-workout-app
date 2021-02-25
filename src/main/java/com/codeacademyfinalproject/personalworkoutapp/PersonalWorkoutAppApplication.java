package com.codeacademyfinalproject.personalworkoutapp;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.repository.CoachRepository;
import com.codeacademyfinalproject.personalworkoutapp.repository.UserRepository;

@SpringBootApplication
public class PersonalWorkoutAppApplication {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private CoachRepository coachRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalWorkoutAppApplication.class, args);
		
	}
	
	@PostConstruct
	public void createCoachesWithUsers() {
		for (int i = 1; i < 10; i++) {
			Coach coach = new Coach();
			coach.setName("Filip" + i);
			coach.setSurname("Filipson" + i);
			coach.setAge(29 + i);
			coach.setEmail("a@a.com" + i);
			coach.setAccomplishments("Won a fight against Chuck Norris" + i);
			coach.setBiography("World class Coach" + i);
			coach.setCertificate("World School Of Coaches" + i);
			coach.setGender("Male" + i);
			coach.setTitle("Strongest" + i);
			coach.setUsername("Batman" + i);
			coach.setPassword("one" + i);
			coach.setConfirmPassword("one" + i);
			coach.setCountry("Macedonia" + i);
			coachRepository.save(coach);
			
			List<User> users = new ArrayList<>();
			for (int j = 1; j < 5; j++) {
				User user = new User();
				user.setName("Pero"  + j);
				user.setSurname("Peroson"  + j);
				user.setAge(33 + j);
				user.setEmail("pero@pero.com"  + j);
				user.setCountry("Finland"  + j);
				user.setUsername("Perica"  + j);
				user.setGender("Male"  + j);
				user.setPassword("pero"  + j);
				user.setConfirmPassword("pero"  + j);
				userRepository.save(user);
				
			}
			
			coach.setUsers(users);
			coachRepository.save(coach);
		}
	}
//	@PostConstruct
//	public void selectUsersAndCoaches() {
//		Optional<Coach> optCoach = coachRepository.findById(1L);
//		Optional<User> optUser = userRepository.findById(1L);
//		System.out.println(optCoach);
//		if (!optCoach.isPresent() && !optUser.isPresent()) {
//			Coach coach = optCoach.get();
//			User user = optUser.get();
//			List<Coach> coach11 = coachRepository.findByUsersIdNative(user.getId(), coach.getId());
//			coach11.stream().forEach(e -> System.out.println(e));
//			List<User> user2 = userRepository.findByCoach_Id(coach.getId());
//			user2.stream().forEach(e -> System.out.println(e));
//		} else {
//			System.out.println("no such user");
//		}
//	}
}
