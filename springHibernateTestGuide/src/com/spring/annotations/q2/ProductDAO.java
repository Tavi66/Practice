package com.spring.annotations.q2;

package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;



import com.spring.domain.Product;


//Fill your code here
@Component("productDao")
public class ProductDAO {
    Criteria criteria = null;
    
    @Autowired
	private SessionFactory sessionFactory;

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Product> otainProductList() {
		//Fill your code here
        Session session = sessionFactory.openSession();
        Criteria crit1 = session.createCriteria(Product.class);
        List<Product> prodList = crit1.list();
        session.close();
        return prodList;
	}
	
	public List<Product> otainProductBySearchType(String type,String value) {
		//Fill your code here
        Session session = sessionFactory.openSession();
        Criteria crit2 = session.createCriteria(Product.class);
        Criterion criterion1 = Restrictions.eq(type, value);
        crit2.add(criterion1);
        List<Product> prodList2 = crit2.list();
        session.close();
        return prodList2;
    }

}
