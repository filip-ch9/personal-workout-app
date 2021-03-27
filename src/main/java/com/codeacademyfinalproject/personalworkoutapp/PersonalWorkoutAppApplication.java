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
import com.codeacademyfinalproject.personalworkoutapp.repository.TrainingDayRepository;
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
	private TrainingDayRepository trainingDayReposiroty;
	@Autowired
	private WorkoutProgramRepository workoutProgramRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersonalWorkoutAppApplication.class, args);
		
		
	}

	@PostConstruct
	public void createAdmin() {
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
		
	}

	@PostConstruct
	public void createCoachWithUsers() {
		Coach coach = new Coach();
		coach.setName("Filip");
		coach.setSurname("Filipson");
		coach.setAge(29);
		coach.setGender("Male");
		coach.setEmail("a@a.com");
		coach.setCountry("Macedonia");
		coach.setAccomplishments("Trained Chuck Noris");
		coach.setBiography("20 years expirience in helping athletes become better");
		coach.setCertificate("World School Of Athletes");
		coach.setTitle("Professional Conditional & Nutrition Advisor");
		coach.setPassword("a");
		coach.setConfirmPassword("a");
		coach.setUsername("Filip10");
		coachRepository.save(coach);
		WorkoutProgram workoutProgram = new WorkoutProgram();
		workoutProgram.setStartDate(new Date());
		workoutProgram.setEndDate(new Date());
		workoutProgram.setNameOfWorkoutProgram("My Program");
		workoutProgram.setGroup(Group.SPORTS_TEAMS);
		workoutProgramRepository.save(workoutProgram);
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setName("Pero" + i);
			user.setSurname("Peroson" + i);
			user.setAge(44 + i);
			user.setEmail("pero@pero.com" + i);
			user.setCountry("Macedonia" + i);
			user.setGender("Male");
			user.setUsername("pero1" + i);
			user.setPassword("pero" + i);
			user.setConfirmPassword("pero" + i);
			user.setCoach(coach);
			coach.addUser(user);
			workoutProgram.addUser(user);
			userRepository.save(user);
		}
		coach.setUsers(users);
		coachRepository.save(coach);

		
		List<TrainingDay> trainings = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			TrainingDay training = new TrainingDay();
			training.setDayOfTraining(new Date());
			training.setDuration(50 + i);
			training.setNameOfExercise("Exercise" + i);
			training.setPause(30 + i);
			training.setReps(5 + i);
			training.setSets(2 + i);
			training.setType(WorkoutType.EXPLOSIVENESS);
			workoutProgram.addTrainingDay(training);
			trainingDayReposiroty.save(training);

		}
		workoutProgram.setUsers(users);
		workoutProgram.setWorkouts(trainings);
		workoutProgramRepository.save(workoutProgram);
		coach.addWorkoutProgram(workoutProgram);
		coachRepository.save(coach);
	}

}
