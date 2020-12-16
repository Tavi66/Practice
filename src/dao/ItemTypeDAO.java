package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.ItemType;
import util.HibernateUtil;


public class ItemTypeDAO {
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;
	
	public ItemType find(int id) {
	    	session = sessionFactory.openSession();
	    	ItemType it = (ItemType) session.get(ItemType.class, id);
	    	session.close();
	    	return it;
	}
}

