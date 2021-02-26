package com.codeacademyfinalproject.personalworkoutapp.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "WORKOUT_PROGRAM")
public class WorkoutProgram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Version
	private Long version;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name = "WORKOUT_PROGRAM_ID", unique = true)
	private String workoutId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "workout_program_group")
	private Group group;
	
	@ManyToMany
	@JoinTable(
			name = "WORKOUT_PROGRAM_COACH",
			joinColumns = {@JoinColumn(name = "WORKOUT_PROGRAM_ID")},
			inverseJoinColumns = {@JoinColumn(name = "COACH_ID")}
	)
	private List<Coach> coaches = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name = "WORKOUT_PROGRAM_USER",
			joinColumns = {@JoinColumn(name = "WORKOUT_PROGRAM_ID")},
			inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
	)
	private List<User> users = new ArrayList<User>();
	
	@ManyToMany(mappedBy = "workoutPrograms")
	private List<TrainingDay> workouts = new ArrayList<>();
	
	public WorkoutProgram() {}

	public WorkoutProgram(Long version, Date startDate, Date endDate, String workoutId, Group group,
			List<Coach> coaches, List<User> users, List<TrainingDay> workouts) {
		super();
		this.version = version;
		this.startDate = startDate;
		this.endDate = endDate;
		this.workoutId = workoutId;
		this.group = group;
		this.coaches = coaches;
		this.users = users;
		this.workouts = workouts;
	}
	
	public void addTrainingDay(TrainingDay workout) {
		if (!workouts.contains(workout)) {
			workouts.add(workout);
		}
	}
	
	public boolean removeTrainingDay(TrainingDay workout) {
		return workouts.remove(workout);
	}
	
	public void addUser(User user) {
		if (!users.contains(user)) {
			users.add(user);
		}
	}
	
	public boolean removeUser(User user) {
		return users.remove(user);
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(String workoutId) {
		this.workoutId = workoutId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<TrainingDay> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<TrainingDay> workouts) {
		this.workouts = workouts;
	}

	@Override
	public String toString() {
		return "WorkoutProgram [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", workoutId="
				+ workoutId + "]";
	}


	
}
