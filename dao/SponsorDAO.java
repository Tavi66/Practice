package dao;

import java.util.List;
import org.hibernate.Session;
import domain.Sponsor;

import util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SponsorDAO {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;

	public void insert(Sponsor sponsor) {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(sponsor);
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
		}	}

	@SuppressWarnings("unchecked")
	public List<Sponsor> list() {
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Sponsor.class);
		return criteria.list();
	}
}
