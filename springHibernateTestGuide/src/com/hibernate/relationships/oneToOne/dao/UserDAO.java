package com.hibernate.relationships.oneToOne.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;
import domain.User;

public class UserDAO {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
    public static void insert(User user) {
    		//Fill your code here
    	Session session = sf.openSession();
    	Transaction transaction = null;
    	
    	try {
    		transaction = session.beginTransaction();
    		session.save(user);
    		
    		transaction.commit();
    	}catch (HibernateException e) {
			System.err.println(e);
			if(transaction != null) {
				transaction.rollback();
			}
		}finally{
			session.close();
		}
	}

	public static User find(Integer id){
		//Fill your code here
    	Session session = sf.openSession();
    	Transaction transaction = null;
    	User user = null;
    	try {
    		user = (User)session.get(User.class, id);
    	}catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
    	return user;
	}
}
