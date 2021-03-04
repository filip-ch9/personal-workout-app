package com.codeacademyfinalproject.personalworkoutapp.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "WORKOUT_PROGRAM")
public class WorkoutProgram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Version
	private Long version;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	

	private String nameOfWorkoutProgram;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "workout_program_group")
	private Group group;
	
	@ManyToOne
	@JoinColumn(name = "coach_id", referencedColumnName = "id")
	private Coach coach;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "workoutProgram")
	private List<User> users = new ArrayList<User>();
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "workoutProgram")
	private List<TrainingDay> workouts = new ArrayList<TrainingDay>();
	
	public WorkoutProgram() {}

	public WorkoutProgram(Long version, Date startDate, Date endDate, String workoutId, Group group,
			Coach coach, List<User> users, List<TrainingDay> workouts) {
		super();
		this.version = version;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nameOfWorkoutProgram = workoutId;
		this.group = group;
		this.coach = coach;
		this.users = users;
		this.workouts = workouts;
	}
	
	public void addTrainingDay(TrainingDay training) {
		addTrainingDay(training, true);
	}
	
	void addTrainingDay(TrainingDay training, boolean set) {
		if(training != null) {
			if(getWorkouts().contains(training)) {
				getWorkouts().set(getWorkouts().indexOf(training), training);
			} else {
				getWorkouts().add(training);
			} if (set) {
				training.setWorkoutProgram(this, false);
			}
		}
	}
	
	public void removeTrainingDay(TrainingDay training) {
		getWorkouts().remove(training);
		training.setWorkoutProgram(null);
	}
	
	public void addUser(User user) {
		addUser(user, true);
	}
	
	void addUser(User user, boolean set) {
		if (user != null) {
			if(getUsers().contains(user)) {
				getUsers().set(getUsers().indexOf(user), user);
			} else {
				getUsers().add(user);
			} if (set) {
				user.setWorkoutProgram(this, false);
			}
		}
	}
	
	public void removeUser(User user) {
		getUsers().remove(user);
		user.setWorkoutProgram(null);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getNameOfWorkoutProgram() {
		return nameOfWorkoutProgram;
	}

	public void setNameOfWorkoutProgram(String nameOfWorkoutProgram) {
		this.nameOfWorkoutProgram = nameOfWorkoutProgram;
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
		setCoach(coach, true);
	}
	
	void setCoach(Coach coach, boolean add) {
		this.coach = coach;
		if (coach != null && add) {
			coach.addWorkoutProgram(this, false);
		}
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
				+ nameOfWorkoutProgram + "]";
	}

	public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof WorkoutProgram))
            return false;
 
        final WorkoutProgram wp = (WorkoutProgram)object;
 
        if (id != null && wp.getId() != null) {
            return id.equals(wp.getId());
        }
        return false;
    }
	
}
