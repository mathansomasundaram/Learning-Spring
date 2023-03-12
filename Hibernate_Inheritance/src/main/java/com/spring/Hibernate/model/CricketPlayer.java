package com.spring.Hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="cricket_player")
//@DiscriminatorColumn(name="PLAYER_TYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class CricketPlayer {

	@Id
	@GeneratedValue 
	@Column(name="player_id")
	private int playerId;
	@Column(name="name")
	private String playerName;
	@Column(name="age")
	private int playerAge;
	@Column(name="role")
	private String playerRole;
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerAge() {
		return playerAge;
	}
	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}
	public String getPlayerRole() {
		return playerRole;
	}
	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}
}
