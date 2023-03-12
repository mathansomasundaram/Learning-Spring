package com.spring.Hibernate;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
    		player.setPlayerName("MS Dhoni");
    		player.setPlayerRole("Right Hand Batter");
    		player.setPlayerAge(55);
    		
    		Batsman batter=new Batsman();
    		batter.setPlayerName("Rohit");
    		batter.setPlayerAge(34);
    		batter.setPlayerRole("Right Hand Batter");
    		batter.setBattingAverage(39.54);
    		
    		
    		Bowler bowler=new Bowler();
    		bowler.setPlayerName("Dale Styen");
    		bowler.setPlayerAge(41);
    		bowler.setPlayerRole("Right arm fast bowler");
    		bowler.setBowlingAverage(21);
    	
    		session.beginTransaction();
    		
    		/*
    		session.persist(bowler);
    		session.persist(batter);
    		if(validatePlayer(player)) {
    			logger.info("Player Name cannot be null");
    		}else {
    			session.persist(player);
    		}
    		
    		bowler=session.get(Bowler.class, 14);
    		This Object is tracked by Hibernate
    		
    		if(bowler==null) {
    			bowler=new Bowler();
    			bowler.setPlayerName("Jadeja");
    			bowler.setPlayerRole("Left Arm Leg Break");
    			bowler.setPlayerAge(36);
    			bowler.setBowlingAverage(25);
    			
    		}
    		if(bowler.getPlayerName().equalsIgnoreCase("Ashwin")) {
    			bowler.setPlayerName("R Ashwin");
    		}
    		*/
    		
//    		Query query=session.createQuery("select distinct(playerName) from CricketPlayer order by playerName");
//    		List<String> players=query.getResultList();
    		
    		Criteria criteria=session.createCriteria(CricketPlayer.class);
    		criteria.add(Restrictions.between("playerAge", 35,40));
//    		criteria.add(Restrictions.like("playerName", "Um%"));
    		criteria.addOrder(Order.asc("playerName"));
    		List<CricketPlayer> players=criteria.list();
    		for(CricketPlayer p:players) {
    			System.out.println(p.getPlayerName());
    		}
    		session.getTransaction().commit();
    	}catch(Exception e) {
    		logger.error(e);
    	}
    	
    }
    
    private static boolean validatePlayer(CricketPlayer player) {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	Set<ConstraintViolation<CricketPlayer>> violations = validator.validate(player);
    	
    	return !violations.isEmpty();
	}

}
