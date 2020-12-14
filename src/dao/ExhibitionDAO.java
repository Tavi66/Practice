package dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Restrictions;
import domain.*;
import util.*;
import org.hibernate.Transaction;
//import org.hibernate.Query;

public class ExhibitionDAO {
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;
    public void insert(Exhibition exhibition) {
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(exhibition);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
    
	@SuppressWarnings("unchecked")
	public List<Exhibition> list(){
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Exhibition.class);
		List<Exhibition> list = criteria.list();
		session.close();
		return list;
	}
}
