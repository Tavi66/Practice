package com.hibernate.relationships.manyToMany.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import domain.*;
import util.*;

public class EventDAO {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
    public static void insert(Event event) {
		//fill your code here
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	try {    		
    		session.save(event);
    		System.out.println("Event works");
    		tx.commit();
    		System.out.println("Commit works");
    	}catch (HibernateException e) {
    		if(tx != null) {
    			tx.rollback();
    		}
    		System.err.println(e);
    		System.out.println("Error with Insert in Event DAO");
		}finally{
			session.close();
		}
	}
	public static void update(Event event) {
		//fill your code here
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			System.out.println("UPDATE MADE IT");
			session.update(event);
			System.out.println("UPDATE SAVE WORKS");
			tx.commit();
			System.out.println("UPDATE COMMIT WORKS");
		}catch (HibernateException e) {
			System.err.println(e);
			if(tx != null) {
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	public static Event find(int id) {
		//fill your code here
		Session session = sf.openSession();
		
		Event retEvent = null;
		try {
			retEvent = (Event)session.get(Event.class, id);
			session.persist(retEvent);
		}catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
		return retEvent;
	}
}