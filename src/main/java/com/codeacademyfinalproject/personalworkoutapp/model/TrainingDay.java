package com.codeacademyfinalproject.personalworkoutapp.model;

import java.util.ArrayList;
import java.util.Arrays;
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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRAINING_DAYS")
public class TrainingDay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Version
	private Long version;
	
	private String nameOfExercise;
	private int duration;
	
	@Temporal(TemporalType.DATE)
	private Date dayOfTraining;
	
	private int sets;
	private int reps;
	private int pause;
	
	@NotNull(message = "Type of workout is required.")
	@Enumerated(EnumType.STRING)
	@Column(name = "workout_type", nullable = false)
	private WorkoutType type;
	
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(
			name = "TRAINING_DAY_WORKOUT_PROGRAM",
			joinColumns = {@JoinColumn(name = "TRAINING_DAY_ID")},
			inverseJoinColumns = {@JoinColumn(name = "WORKOUT_PROGRAM_ID")}
	)
	private List<WorkoutProgram> workoutPrograms = new ArrayList<>();
	
	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;
	
	public TrainingDay() {}

	public TrainingDay(Long version, String nameOfExercise, int duration, Date dayOfTraining, int sets, int reps, int pause,
			WorkoutType type, byte[] image) {
		super();
		this.version = version;
		this.nameOfExercise = nameOfExercise;
		this.duration = duration;
		this.dayOfTraining = dayOfTraining;
		this.sets = sets;
		this.reps = reps;
		this.pause = pause;
		this.type = type;
		this.image = image;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
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

	public WorkoutType getType() {
		return type;
	}

	public void setType(WorkoutType type) {
		this.type = type;
	}

	public List<WorkoutProgram> getwPrograms() {
		return workoutPrograms;
	}

	public void setwPrograms(List<WorkoutProgram> wPrograms) {
		this.workoutPrograms = wPrograms;
	}
	

	public void setPause(int pause) {
		this.pause = pause;
	}
	public int getPause() {
		return pause;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getNameOfExercise() {
		return nameOfExercise;
	}

	public void setNameOfExercise(String nameOfExercise) {
		this.nameOfExercise = nameOfExercise;
	}

	@Override
	public String toString() {
		return "TrainingDay [id=" + id + ", version=" + version + ", nameOfExercise=" + nameOfExercise + ", duration="
				+ duration + ", dayOfTraining=" + dayOfTraining + ", sets=" + sets + ", reps=" + reps + ", pause="
				+ pause + ", type=" + type + ", wPrograms=" + workoutPrograms + ", image=" + Arrays.toString(image) + "]";
	}



}
