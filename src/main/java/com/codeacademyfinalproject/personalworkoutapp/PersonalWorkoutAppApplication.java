package com.codeacademyfinalproject.personalworkoutapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codeacademyfinalproject.personalworkoutapp.model.Admin;
import com.codeacademyfinalproject.personalworkoutapp.model.Coach;
import com.codeacademyfinalproject.personalworkoutapp.model.Group;
import com.codeacademyfinalproject.personalworkoutapp.model.TrainingDay;
import com.codeacademyfinalproject.personalworkoutapp.model.User;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutProgram;
import com.codeacademyfinalproject.personalworkoutapp.model.WorkoutType;
import com.codeacademyfinalproject.personalworkoutapp.repository.AdminRepository;
import com.codeacademyfinalproject.personalworkoutapp.repository.CoachRepository;
import com.codeacademyfinalproject.personalworkoutapp.repository.UserRepository;
import com.codeacademyfinalproject.personalworkoutapp.repository.WorkoutProgramRepository;

@SpringBootApplication
public class PersonalWorkoutAppApplication {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private CoachRepository coachRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private WorkoutProgramRepository workoutProgramRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalWorkoutAppApplication.class, args);
		
	}
	
	@PostConstruct
	public void createCoachesWithUsers() {
		Admin a = new Admin();
		a.setName("Admin");
		a.setSurname("Adminson");
		a.setAge(29);
		a.setCountry("Macedonia");
		a.setEmail("admin@admin.com");
		a.setUsername("admin");
		a.setPassword("admin");
		a.setConfirmPassword("admin");
		a.setGender("male");
		adminRepository.save(a);
		
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
	
	@PostConstruct
	public void createWorkoutProgramsWithTrainingDays() {
		for (int j = 1; j < 10; j++) {
			WorkoutProgram workoutProgram = new WorkoutProgram();
			workoutProgram.setStartDate(new Date());
			workoutProgram.setEndDate(new Date());
			workoutProgram.setNameOfWorkoutProgram("My Program" + j);
			workoutProgram.setGroup(Group.SPORTS_TEAMS);
			workoutProgram.addTrainingDay(new TrainingDay());
			
			List<TrainingDay> trainings = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				TrainingDay training = new TrainingDay();
				training.setDayOfTraining(new Date());
				training.setDuration(50 + i);
				training.setNameOfExercise("Exercise" + i);
				training.setPause(30 + i);
				training.setReps(5 + i);
				training.setSets(2 + i);
				training.setType(WorkoutType.EXPLOSIVENESS);
			}
			workoutProgram.setWorkouts(trainings);
			workoutProgramRepository.save(workoutProgram);
			
		}
		
	}

}
