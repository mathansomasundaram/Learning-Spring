package com.spring.Hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Bowler")
//@DiscriminatorValue("bowling")
public class Bowler extends CricketPlayer{
	@Column(name="bowling_average")
	private double bowlingAverage;
	
	@Transient
	@Column(name="wickets_taken")
	private int wicketsTaken;
	
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	public double getBowlingAverage() {
		return bowlingAverage;
	}
	public void setBowlingAverage(double bowlingAverage) {
		this.bowlingAverage = bowlingAverage;
	}
	@Override
	public String toString() {
		return "Bowler [bowlingAverage=" + bowlingAverage + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
}
