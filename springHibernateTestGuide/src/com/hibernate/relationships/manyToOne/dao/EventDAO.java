package com.hibernate.relationships.manyToOne.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import domain.Event;
import domain.Ticket;
import util.HibernateUtil;

public class EventDAO {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public static Event obtainEventById(Integer eventId)  {
		//Fill your code here
		Session session = sf.openSession();
//		Transaction transaction = session.beginTransaction();
		Event ev = null;
		try {
			ev = (Event)session.get(Event.class, eventId);
		}catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
		return ev;
	}
}

