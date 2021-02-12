package com.codeacademyfinalproject.personalworkoutapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.Group;
import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.repository.UserRepository;

@SpringBootApplication
public class PersonalWorkoutAppApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersonalWorkoutAppApplication.class, args);
	
	}
	
	@PostConstruct
	public void createUsersWithPrograms() {
		for (int i = 0; i <= 10; i++) {
			User u1 = new User();
			u1.setName("filip" + i);
			u1.setAge(29 + i);
			u1.setEmail("filip@f.com" + i);
			u1.setSurname("filipson" + i);
			u1.setCountry("macedonia" + i);
			u1.setGender("male" + i);
			u1.setPassword("ajde" + i);
			u1.setConfirmPassword("ajde" + i);
			u1.setUsername("nekojsi" + i);
			u1.setCoach(new Coach());
			
			List<WorkoutProgram> workouts = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				WorkoutProgram work = new WorkoutProgram();
				work.setStartDate(new Date());
				work.setEndDate(new Date());
				work.setWorkouts(new ArrayList<TrainingDay>());
				work.setGroup(Group.SPORTS_TEAMS);
				work.setCoaches(new ArrayList<Coach>());
				workouts.add(work);
			}
			u1.setWorkouts(workouts);
			userRepository.save(u1);
		}
	}

}
