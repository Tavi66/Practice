package com.hibernate.relationships.manyToOne.dao;


import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import antlr.debug.Event;
import util.HibernateUtil;
import domain.Ticket;
import domain.User;

public class UserDAO {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public static User obtainUserById(Integer id) {
		Session session = sf.openSession();
//		Transaction transaction = session.beginTransaction();
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
	
//	public static void insert(Event event) {
//		Session session = sf.openSession(); 
//		Transaction transaction = session.beginTransaction();
//		try {
//			session.save(event);	
//			transaction.commit();
//		}catch (HibernateException e) {
//			System.err.println(e);
//		} finally {
//			session.close();
//		}
//	}
//	
//	public static List<Event> list(){
//		Session session = sf.openSession();
//		Transaction transaction = session.beginTransaction();
//		Criteria criteria = session.createCriteria(Event.class);
//		
//		@SuppressWarnings("unchecked")
//		List<Event> evList = criteria.list();
//		
//		session.close();
//		
//		return (List<Event>)evList;
//	}
//	
//	public static Event find(int id) {
//		Session session = sf.openSession();
//		Transaction transaction = null;
//		
//		Event ev = null;
//		
//		try {
//			ev = (Event)session.get(Event.class, id);
//		}catch (HibernateException e) {
//			System.err.println(e);
//		}finally{
//			session.close();
//		}
//		return ev;
//	}
//}
