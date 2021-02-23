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
	private CoachRepository coachrepository;
	
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
			coach.setTitle("Najak" + i);
			coach.setUsername("Batman" + i);
			coach.setPassword("nekoj" + i);
			coach.setConfirmPassword("nekoj" + i);
			coach.setCountry("Macedonia" + i);
			
			List<User> users = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
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
				users.add(user);
				userRepository.save(user);
			}
			
			coach.setUsers(users);
			coachrepository.save(coach);
		}
	}

}
