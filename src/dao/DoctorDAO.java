package dao;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import domain.Doctor;
import util.HibernateUtil;

public class DoctorDAO {
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session;
	@SuppressWarnings("unchecked")
	public ArrayList<Doctor> obtainDoctorList() {
		session = sessionFactory.openSession();
		String hql = "FROM Doctor";
		Query query = session.createQuery(hql);
		ArrayList<Doctor> list = new ArrayList<>(query.list());
		session.close();
		return list;
	}


	@SuppressWarnings("unchecked")
	public ArrayList<Doctor> searchDoctor(String type,String searchValue) {
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Doctor.class);
		criteria.add(Restrictions.eq(type, searchValue));
		ArrayList<Doctor> list = new ArrayList<>(criteria.list());	
		session.close();
		return list;
		}

}

