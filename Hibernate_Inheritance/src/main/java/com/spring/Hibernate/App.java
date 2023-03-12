package com.spring.Hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.spring.Hibernate.Configuraiton.HibernateConfig;
import com.spring.Hibernate.model.Batsman;
import com.spring.Hibernate.model.Bowler;
import com.spring.Hibernate.model.CricketPlayer;

public class App 
{
	public static final Logger logger=Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	try(Session session=HibernateConfig.getSessionFactory().openSession()){
    		
    		CricketPlayer player=new CricketPlayer();
    		player.setPlayerName("Ravi Shashtri");
    		player.setPlayerRole("Right Hand Batter");
    		player.setPlayerAge(50);
    		
    		Batsman batter=new Batsman();
    		batter.setPlayerName("Virat");
    		batter.setPlayerAge(32);
    		batter.setPlayerRole("Right Hand Batter");
    		batter.setBattingAverage(50);
    		
    		
    		Bowler bowler=new Bowler();
    		bowler.setPlayerName("Ash");
    		bowler.setPlayerAge(37);
    		bowler.setPlayerRole("Right arm off spin");
    		bowler.setBowlingAverage(18);
    	
    		session.beginTransaction();
    		session.persist(bowler);
    		session.persist(batter);
    		session.persist(player);
    		session.getTransaction().commit();
    	}catch(Exception e) {
    		logger.error(e);
    	}
    	
    }
}
