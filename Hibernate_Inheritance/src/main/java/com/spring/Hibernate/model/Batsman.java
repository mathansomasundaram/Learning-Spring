package com.spring.Hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Batter")
//@DiscriminatorValue("Batting")

public class Batsman extends CricketPlayer{
	
	@Column(name="batting_average")
	private double battingAverage;
	
	@Transient
	@Column(name="Century_scored")
	private int centuriesScored;
	
	public int getCenturiesScored() {
		return centuriesScored;
	}
	public void setCenturiesScored(int centuriesScored) {
		this.centuriesScored = centuriesScored;
	}
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}
	@Override
	public String toString() {
		return "Batsman [battingAverage=" + battingAverage + ", centuriesScored=" + centuriesScored + "]";
	}
	
}
