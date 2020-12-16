package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import domain.Item;
import util.HibernateUtil;

public class ItemDAO {
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;
	
   	 public void insert(Item item) {
 		Transaction transaction = null;
 		try {
 			session = sessionFactory.openSession();
 			transaction = session.beginTransaction();
 			session.save(item);
 			transaction.commit();
 		} catch (Exception e) {
 			if(transaction != null)
 			{
 				transaction.rollback();
 			}
 		} finally {
 			session.close();
 		}
 		}

	public void delete(Item item) {
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
				if(item==null){
					System.out.println("Item not found");
				}else{
			session.delete(item);
			transaction.commit();
			}
		} catch (Exception e) {
			if(transaction != null)
			{
				//System.out.println("ERROR");
				transaction.rollback();
			} 
		} finally {
			session.close();
		}
	}

	public Item find(int id) {
		session = sessionFactory.openSession();
		Item item = (Item) session.get(Item.class, id);
		session.close();
		return item;
	}

	@SuppressWarnings("unchecked")
	public List<Item> list(){
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Item.class);
		List<Item> list = criteria.list();
		session.close();
		return list;
	}
}

