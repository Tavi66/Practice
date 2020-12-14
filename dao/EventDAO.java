package dao;

import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import domain.Event;

public class EventDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;

	public void insert(Event event) {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction=session.beginTransaction();
			session.save(event);
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Event> list() {
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Event.class);
		return criteria.list();
	}

	public Event find(int id) {
		session = sessionFactory.openSession();
		Event result = (Event) session.get(Event.class,id);
		session.close();
		return result;
	}
}
