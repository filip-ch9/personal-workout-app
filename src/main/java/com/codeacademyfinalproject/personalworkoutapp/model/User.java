package com.codeacademyfinalproject.personalworkoutapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "APPLICATION_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Version
	private Long version;

	private String name;
	private String surname;
	private int age;
	private String email;

	private String country;
	private String gender;

	private String username;
	private String password;
	private String confirmPassword;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_group")
	private Group group;

	@ManyToMany
	@JoinTable (
			name = "USER_COACH",
			joinColumns = {@JoinColumn(name = "USER_ID")},
			inverseJoinColumns = {@JoinColumn(name = "COACH_ID")}
	)
	private List<Coach> coaches = new ArrayList<>();

	@ManyToMany(mappedBy = "users")
	private List<WorkoutProgram> workouts = new ArrayList<>();

	public User() {
	}
	public User(Long version, String name, String surname, int age, String email, String country, String gender,
			String username, String password, String confirmPassword, Group group, List<Coach> coach,
			List<WorkoutProgram> workouts) {
		super();
		this.version = version;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.country = country;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.group = group;
		this.coaches = coach;
		this.workouts = workouts;
	}
	
	public void addCoach(Coach coach) {
		if (!coaches.contains(coach)) {
			coaches.add(coach);
		}
	}
	
	public boolean removeCoach(Coach coach) {
		return coaches.remove(coach);
	}

	public void addWorkoutProgram(WorkoutProgram wProgram) {
		if (!workouts.contains(wProgram)) {
			workouts.add(wProgram);
		}
	}

	public boolean removeWorkoutProgram(WorkoutProgram wPrgoram) {
		return workouts.remove(wPrgoram);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Coach> getCoach() {
		return coaches;
	}
	public void setCoach(List<Coach> coach) {
		this.coaches = coach;
	}
	public List<WorkoutProgram> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutProgram> workouts) {
		this.workouts = workouts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}

	
	
}
