package com.spring.Hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@DiscriminatorValue("bowling")
public class Bowler extends CricketPlayer{
	@Column(name="bowling_average")
	private double bowlingAverage;
	public double getBowlingAverage() {
		return bowlingAverage;
	}
	public void setBowlingAverage(double bowlingAverage) {
		this.bowlingAverage = bowlingAverage;
	}
}
