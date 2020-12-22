package dao;
import domain.Doctor;
import util.HibernateUtil;

import java.util.ArrayList;
import javax.persistence.OrderBy;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DoctorDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
    private Session session;
	@SuppressWarnings("unchecked")
	public ArrayList<Doctor> obtainDoctorList() {
		session = sessionFactory.openSession();
		//String hql = "FROM Doctor";
		//Query<Doctor> query = session.createQuery(hql);
        Criteria criteria = session.createCriteria(Doctor.class);
		ArrayList<Doctor> list = new ArrayList<>(criteria.list());
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

// package learn.test.dao;
// import learn.test.domain.Doctor;
// import learn.test.util.HibernateUtil;

// import java.util.ArrayList;
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;

// import org.hibernate.Criteria;
// import org.hibernate.criterion.Restrictions;
// import org.hibernate.query.*;

// public class DoctorDAO {
// 	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
// 	private Session session;
// 	@SuppressWarnings("unchecked")
// 	public ArrayList<Doctor> obtainDoctorList() {
// 		session = sessionFactory.openSession();
// 		String hql = "FROM Doctor";
// 		Query<Doctor> query = session.createQuery(hql);
// 		ArrayList<Doctor> list = new ArrayList<>(query.list());
// 		session.close();
// 		return list;
// 	}


// 	@SuppressWarnings("unchecked")
// 	public ArrayList<Doctor> searchDoctor(String type,String searchValue) {
// 		session = sessionFactory.openSession();
// 		Criteria criteria = session.createQuery(Doctor.class);
// 		criteria.add(Restrictions.eq(type, searchValue));
// 		ArrayList<Doctor> list = new ArrayList<>(criteria.list());	
// 		session.close();
// 		return list;
// 		}

// }

