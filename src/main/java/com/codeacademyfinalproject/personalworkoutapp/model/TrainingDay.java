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
import javax.persistence.Version;

@Entity
@Table(name = "TRAINING_DAYS")
public class TrainingDay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Version
	private Long version;
	
	private String duration;
	private Date dayOfTraining;
	private int sets;
	private int reps;
	private long pause;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "workout_type")
	private WorkoutType type;
	
	@ManyToMany
	@JoinTable(
			name = "TRAINING_DAY_WORKOUT_PROGRAM",
			joinColumns = {@JoinColumn(name = "TRAINING_DAY_ID")},
			inverseJoinColumns = {@JoinColumn(name = "WORKOUT_PROGRAM_ID")}
	)
	private List<WorkoutProgram> wPrograms = new ArrayList<>();
	
	public TrainingDay() {}

	public TrainingDay(Long version, String duration, Date dayOfTraining, int sets, int reps, int pause,
			WorkoutType type) {
		super();
		this.version = version;
		this.duration = duration;
		this.dayOfTraining = dayOfTraining;
		this.sets = sets;
		this.reps = reps;
		this.pause = pause;
		this.type = type;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}



	public Date getDayOfTraining() {
		return dayOfTraining;
	}

	public void setDayOfTraining(Date dayOfTraining) {
		this.dayOfTraining = dayOfTraining;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public long getPause() {
		return pause;
	}

	public void setPause(int pause) {
		this.pause = pause;
	}

	public WorkoutType getType() {
		return type;
	}

	public void setType(WorkoutType type) {
		this.type = type;
	}

	public List<WorkoutProgram> getwPrograms() {
		return wPrograms;
	}

	public void setwPrograms(List<WorkoutProgram> wPrograms) {
		this.wPrograms = wPrograms;
	}

	@Override
	public String toString() {
		return "Workouts [id=" + id + ", version=" + version + ", duration=" + duration + ", dayOfWorkout="
				+ dayOfTraining + ", sets=" + sets + ", reps=" + reps + ", pause=" + pause + ", type=" + type
				+ ", wPrograms=" + wPrograms + "]";
	}


	
	
}
