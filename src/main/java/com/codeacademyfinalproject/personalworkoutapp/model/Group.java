package com.codeacademyfinalproject.personalworkoutapp.model;

public enum Group {
	SPORTS_TEAMS("Sports Teams"), 
	MILITARY("Military"), 
	FIREFIGHTERS("Firefighters"),
	POLICE("Police"), 
	CORPORATE_WELLNESS("Corporate Wellness");
	
	private String branch;
	
	Group(String branch) {
		this.branch = branch;
	}
	public String getBranch() {
		return branch;
	}
}
