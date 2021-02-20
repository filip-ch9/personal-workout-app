package com.codeacademyfinalproject.personalworkoutapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "APPLICATION_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Version
	private Long version;

	private String name;
	private String surname;
	private int age;

	@Column(name = "user_email", unique = true)
	private String email;

	private String country;
	private String gender;

	private String username;
	private String password;
	private String confirmPassword;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_group")
	private Group group;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "user_id")
	private Coach coach;

	@ManyToMany(mappedBy = "users")
	private List<WorkoutProgram> workouts = new ArrayList<>();

	public User() {
	}

	public User(Long version, String name, String surname, int age, String email, String country, String gender,
			String username, String password, String confirmPassword, Group group, Coach coach,
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
		this.coach = coach;
		this.workouts = workouts;
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

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public List<WorkoutProgram> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<WorkoutProgram> workouts) {
		this.workouts = workouts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", version=" + version + ", name=" + name + ", surname=" + surname + ", age=" + age
				+ ", email=" + email + ", country=" + country + ", gender=" + gender + ", username=" + username
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", group=" + group + ", coach="
				+ coach + ", workouts=" + workouts + "]";
	}

}
