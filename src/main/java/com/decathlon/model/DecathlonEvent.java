package com.decathlon.model;
/**
 *@author Rohit Bothe 
 */
public class DecathlonEvent {
	private String name;
	private String result;
	private Integer score;

	public DecathlonEvent(String name, String result, Integer score) {
		super();
		this.name = name;
		this.result = result;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
