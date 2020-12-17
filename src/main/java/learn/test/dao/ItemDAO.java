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
	public void insert(int id,String name,String category,Float price){
		session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
		String hql = "INSERT INTO Item (id,name,category,price) VALUES ("+id+",\""+name+"\",\""+category+"\","+price+")";
		Query query =session.createQuery(hql);		
		
		transaction = session.beginTransaction();
		
		query.executeUpdate();
		
		transaction.commit();
		
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
				
		}finally {
			session.close();
		}

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
