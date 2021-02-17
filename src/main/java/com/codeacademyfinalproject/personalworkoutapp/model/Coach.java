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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "COACHES")
public class Coach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Version
	private Long version;
	
	private String name;
	private String surname;
	private int age;
	
	@Column(name = "coach_email", unique = true)
	private String email;
	
	private String country;
	private String gender;
	private String title;
	private String accomplishments;
	private String biography;
	private String certificate;
	
	private String username;
	private String password;
	private String confirmPassword;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "coach_group")
	private Group group;
	
	@OneToMany(mappedBy = "coach")
	private List<User> users = new ArrayList<User>();
	
	@ManyToMany(mappedBy = "coaches")
	private List<WorkoutProgram> workoutPrograms = new ArrayList<WorkoutProgram>();
	
	public Coach() {}
	
	public Coach(Long version, String name, String surname, int age, String email, String country, String gender,
			String title, String accomplishments, String biography, String certificate, String username, String password,
			String confirmPassword, Group group, List<User> users, List<WorkoutProgram> workoutPrograms) {
		super();
		this.version = version;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.country = country;
		this.gender = gender;
		this.title = title;
		this.accomplishments = accomplishments;
		this.biography = biography;
		this.certificate = certificate;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.group = group;
		this.users = users;
		this.workoutPrograms = workoutPrograms;
	}

	public void addUser(User user) {
		if (!users.contains(user)) {
			users.add(user);
		}
	}
	public void addWorkoutProgram(WorkoutProgram wProgram) {
		if (!workoutPrograms.contains(wProgram)) {
			workoutPrograms.add(wProgram);
		}
	}
	
	public boolean removeUser(User user) {
		return users.remove(user);
	} 
	
	public boolean removeWorkoutProgram(WorkoutProgram wProgram) {
		return workoutPrograms.remove(wProgram);
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getAccomplishments() {
		return accomplishments;
	}

	public void setAccomplishments(String accomplishments) {
		this.accomplishments = accomplishments;
	}

	public List<WorkoutProgram> getWorkoutPrograms() {
		return workoutPrograms;
	}

	public void setWorkoutPrograms(List<WorkoutProgram> workoutPrograms) {
		this.workoutPrograms = workoutPrograms;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Override
	public String toString() {
		return "Coach [id=" + id + ", version=" + version + ", name=" + name + ", surname=" + surname + ", age=" + age
				+ ", email=" + email + ", country=" + country + ", gender=" + gender + ", title=" + title
				+ ", accomplishments=" + accomplishments + ", biography=" + biography + ", certificate=" + certificate
				+ ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", group=" + group + ", users=" + users + ", workoutPrograms=" + workoutPrograms + "]";
	}
	
}
