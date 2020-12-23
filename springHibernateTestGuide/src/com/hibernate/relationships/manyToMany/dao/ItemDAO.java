package com.hibernate.relationships.manyToMany.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import domain.*;
import util.*;

public class ItemDAO {
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
    public static Item find(int id) {
    	Session session = sf.openSession();
//    	Transaction transaction = session.beginTransaction();
    	
    	Item retItem = null;
    	try {
    		retItem = (Item)session.get(Item.class, id);
    	} catch (HibernateException e) {
//			transaction.rollback();
    		
    	} finally {
			session.close();
		}
    	System.out.println("Found Item in Dao::" + retItem);
    	return retItem;
	}
}