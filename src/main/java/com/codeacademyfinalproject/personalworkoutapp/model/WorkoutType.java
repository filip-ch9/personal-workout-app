package com.codeacademyfinalproject.personalworkoutapp.model;

public enum WorkoutType {
	POWER("Power"), 
	STRENGTH("Strength"), 
	UNLOAD("Unload"), 
	SPEED("Speed"), 
	HYPERTROPHY("Hypertrophy"), 
	STRENGTH_CAPACITY("Strength Capacity"), 
	MAX_STRENGTH("Max Strength"), 
	AEROBIC("Aerobic"), 
	ANAEROBIC("Anaerobic"),
	ENDURANCE("Endurance"), 
	FLEXIBILITY("Flexibility"), 
	YOGA("Yoga"),
	PILATES("Pilates"), 
	MOBILITY("Mobility"), 
	EXPLOSIVENESS("Explosiveness");

	private String type;
	
	WorkoutType(String type) {
		this.type = type;
	}

	public String getTypeAsString() {
		return type;
	}
}
