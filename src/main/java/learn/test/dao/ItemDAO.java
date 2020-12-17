package learn.test.dao;

import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import learn.test.util.HibernateUtil;
import learn.test.domain.Item;

public class ItemDAO {
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session;
	
	@SuppressWarnings("rawtypes")
	public Double averagePriceByCategory(String category) {
		double avg = 0.0;
		session = sessionFactory.openSession();
		String hql="SELECT AVG(price) FROM Item WHERE category=\""+category+"\"";
		Query query = session.createQuery(hql);		
		avg = (double) query.getResultList().get(0);
		return avg;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Item> list(){
		session = sessionFactory.openSession();
		String hql="FROM Item";
		Query query = session.createQuery(hql);
		List<Item> list = query.list();
		session.close();
		return list;
	}
}
