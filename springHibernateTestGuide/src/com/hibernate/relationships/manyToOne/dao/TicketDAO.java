package com.hibernate.relationships.manyToOne.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import domain.Ticket;

public class TicketDAO {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@SuppressWarnings("unchecked")
	public static List<Ticket> list(){
		//Fill your code here
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		List<Ticket> ticketList = null;
		try {
			Criteria criteria = session.createCriteria(Ticket.class);
			ticketList = criteria.list();
		}catch (HibernateException e) {
			System.err.println(e);
		} finally {
			session.close();
		}
		return (List<Ticket>)ticketList;
	}
	
	public static Ticket insert(Ticket ticketIns) {
    		//Fill your code here
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(ticketIns);
			transaction.commit();
		}catch (HibernateException e) {
			System.err.println(e);
			transaction.rollback();
			return null;
		}finally {
			session.close();
		}
		return ticketIns;
	}
	
	
	public static void removeTicket(Ticket ticketIns)  {
		//Fill your code here
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(ticketIns);
			transaction.commit();
		}catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
	}
	
	public static Ticket obtainTicketById(Integer id)  {
		//Fill your code here
		Session session = sf.openSession();
//		Transaction transaction = session.beginTransaction();
		Ticket tick = null;
		try {
			tick = (Ticket)session.get(Ticket.class, id);
		}catch (HibernateException e) {
			System.err.println(e);
		}finally {
			session.close();
		}
		return tick;
	}
}
