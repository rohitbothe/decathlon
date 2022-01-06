package com.decathlon.model;

import java.util.List;
/**
 *@author Rohit Bothe 
 */
public class DecathlonAthlete {

	private String athleteName;
	private List<DecathlonEvent> events;
	private Integer athleteScore;
	private String athleteRank;

	public DecathlonAthlete(String athleteName, List<DecathlonEvent> events, Integer athleteScore, String athleteRank) {
		super();
		this.athleteName = athleteName;
		this.events = events;
		this.athleteScore = athleteScore;
		this.athleteRank = athleteRank;
	}

	public String getAthleteName() {
		return athleteName;
	}

	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}

	public List<DecathlonEvent> getEvents() {
		return events;
	}

	public void setEvents(List<DecathlonEvent> events) {
		this.events = events;
	}

	public Integer getAthleteScore() {
		return athleteScore;
	}

	public void setAthleteScore(Integer athleteScore) {
		this.athleteScore = athleteScore;
	}

	public String getAthleteRank() {
		return athleteRank;
	}

	public void setAthleteRank(String athleteRank) {
		this.athleteRank = athleteRank;
	}
}
