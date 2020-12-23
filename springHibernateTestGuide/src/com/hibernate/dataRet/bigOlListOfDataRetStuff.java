package com.hibernate.dataRet;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import domain.Employee;
import domain.Item;
import domain.Project;
import util.HibernateUtil;

public class bigOlListOfDataRetStuff {

	static SessionFactory sf = HibernateUtil.getSessionFactory();

	public static ArrayList<Doctor> obtainDoctorList() {
		Session session = sf.openSession();
		Criteria crit1 = session.createCriteria(Doctor.class);
		List<Doctor> docList = crit1.list();
		session.close();
		return (ArrayList<Doctor>)docList;
	}


	public static ArrayList<Doctor> searchDoctor(String type,String searchValue) {
		Session session = sf.openSession();
		Criteria crit2 = session.createCriteria(Doctor.class);
		Criterion criterion1 = Restrictions.eq(type, searchValue);
		crit2.add(criterion1).setFetchSize(1);
		
		@SuppressWarnings("unchecked")
		List<Doctor> doctorList = crit2.list();
		return (ArrayList<Doctor>)doctorList;
	}
	
	
	
	
	
	
	
	
    @SuppressWarnings("unchecked")
	public static List<Item> listEcoFriendlyItems(){
		//FILL YOUR CODE
        Session session = sf.openSession();
        List<Item> itemList = null;
        try{
            Criteria crit1 = session.createCriteria(Item.class);
            crit1.add(Restrictions.eq("isEcoFriendly", true));
            itemList = crit1.list();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            session.close();
        }
        return itemList;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Item> listItemsByCategoryName(String name){
		//FILL YOUR CODE
        Session session = sf.openSession();
        List<Item> itemList = null;
        try{
            Query findColHqlQuery = session.createQuery("select " + name + " from Item");
            itemList = findColHqlQuery.list();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            session.close();
        }
        return itemList;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Item> listItems(){
		//FILL YOUR CODE
        Session session = sf.openSession();
        List<Item> itemList = null;
        try{
            Criteria crit2 = session.createCriteria(Item.class);
            crit2.addOrder(Order.asc("name"));
            itemList = crit2.list();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            session.close();
        }
        return itemList;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Item> filterItemCategories(Double costPerDay){
		//FILL YOUR CODE
        Session session = sf.openSession();
        List<Item> itemList = null;
        try{
            Query hqlQuery = session.createQuery("from Item where costPerDay < ?");
            hqlQuery.setDouble(0, costPerDay);
            itemList = hqlQuery.list();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            session.close();
        }
        return itemList;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Object[]> listAverageCostPerDayForCategory(){
		//FILL YOUR CODE
        Session session = sf.openSession();
        List<Object[]> itemList = null;
        try{
//            Criteria crit3 = session.createCriteria(Item.class)
//            		.createAlias("itemCategoryId", "costPerDay");
//            Projection pr = Projections.avg("costPerDay");
        	Criteria crit3 = session.createCriteria(Item.class);
        	ProjectionList pList = Projections.projectionList();
        	pList.add(Projections.groupProperty("itemCategory"));
        	pList.add(Projections.avg("costPerDay"));
            crit3.setProjection(pList);
            itemList = crit3.list();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            session.close();
        }
        return itemList;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		/* ================== Hibernate Query Language (HQL) =================== */
		
		/* SYNTAX ===== Query query = session.createQuery(SQL_STRING) */
		
		about("SELECT to read only single selected columns");
		
		Query hqlQuery1 = session.createQuery("from Project");
        List<Project> result1 = hqlQuery1.list();
        for(Project project : result1) {
        	System.out.println(project);
        }
        
        about("use SELECT to read only single selected columns");
        
        Query hqlQuery2 = session.createQuery("select name from Project");
        List<String> result2 = hqlQuery2.list();
        for(String name : result2) {
        	System.out.println(name);
        }

        about("use SELECT to read multiple selected columns");
        
        Query hqlQuery3 = session.createQuery("select name, budget from Project");
        List<Object[]> result3 = hqlQuery3.list();
        for(Object[] row : result3) {
        	System.out.println();
        	for (Object col:row) {
        		System.out.print(col);
        		System.out.print(" | ");
        	}
        }
        
        about("use ORDER BY");
        
        Query hqlQuery4 = session.createQuery("select name, budget from Project order by name");
	    List<Object[]> result4 = hqlQuery4.list();
	    for(Object[] row : result4) {
	    	System.out.println();
	    	for (Object col:row) {
	    		System.out.print(col);
	    		System.out.print(" | ");
	    	}
	    }
		
	    about("use WHERE condition");
	    
	    Query hqlQuery5 = session.createQuery("from Project where budget < 3000000");
        List<Project> result5 = hqlQuery5.list();
        for(Project project : result5) {
        	System.out.println(project);
        }
        
        about("Named Parameters");
        
        Query hqlQuery6 = session.createQuery("from Project where budget < :limit");
        hqlQuery6.setInteger("limit", 3000000);
        List<Project> result6 = hqlQuery6.list();
        for(Project project : result6) {
        	System.out.println(project);
        }
        
        about("Positional Parameters");
        
        Query hqlQuery7 = session.createQuery("from Project where budget < ? and name like ?");
        hqlQuery7.setInteger(0, 3000000);
        hqlQuery7.setString(1, "%C");
        List<Project> result7 = hqlQuery7.list();
        for(Project project : result7) {
        	System.out.println(project);
        }
                
        about("use AGGREGATE FUNCTIONS");
        
		Query hqlQuery8 = session.createQuery("select gender, sum(salary), avg(salary), min(salary), max(salary) from Employee group by gender");
	    List<Object[]> result8 = hqlQuery8.list();
	    for(Object[] row : result8) {
	    	System.out.println();
	    	for (Object col:row) {
	    		System.out.print(col);
	    		System.out.print(" | ");
	    	}
	    }

	    about("set start position and limit results returned");
	    
		Query hqlQuery9 = session.createQuery("from Employee");
		hqlQuery9.setFirstResult(25); //offset
//		hqlQuery9.setMaxResults(5);
	    List<Employee> results9 = hqlQuery9.list();
	    for(Employee employee : results9) {
	    	System.out.println(employee);
	    }

		/* ================ use Criteria to Query =============== */
	    
	    about("Query object with no restriction");
	    
	    Criteria criteria1 = session.createCriteria(Employee.class);
	    List<Employee> cResult1 = criteria1.list();
	    for(Employee employee : cResult1) {
	    	System.out.println(employee);
	    }
	    
	    about("Single Restriction");
	    
		Criteria criteria2 = session.createCriteria(Employee.class);
	    criteria2.add(Restrictions.lt("experience", Float.valueOf(5)));
//	    criteria2.add(Restrictions.like("name", "J%"));
//		criteria2.add(Restrictions.between("salary", Integer.valueOf(75000), Integer.valueOf(100000)));
		List<Employee> cResult2 = criteria2.list();
	    for(Employee employee : cResult2) {
	    	System.out.println(employee);
	    }
		
	    about("Combined Condition");
	    
	    Criteria criteria3 = session.createCriteria(Employee.class);
		Criterion experience = Restrictions.between("experience", Float.valueOf(5), Float.valueOf(15));
		Criterion salary = Restrictions.between("salary", Integer.valueOf(75000), Integer.valueOf(100000));
		LogicalExpression andExpr = Restrictions.and(experience, salary); //LogicalExpression orExpr = Restrictions.or(experience, salary);		
		criteria3.add(andExpr);//criteria.add(orExpr);

		List<Employee> cResult3 = criteria3.list();
		for(Employee employee : cResult3) {
	    	System.out.println(employee);
	    }
	    
		about("Order By in Criteria");
		
		Criteria criteria4 = session.createCriteria(Employee.class);
		criteria4.addOrder(Order.asc("salary"));
		List<Employee> cResult4 = criteria4.list();
		for(Employee employee : cResult4) {
	    	System.out.println(employee);
	    }
		
		/* ================ use Projections to use Aggregate functions =============== */
		
		about("Single Projection");
		
		Criteria criteria5 = session.createCriteria(Employee.class);
		Projection pr = Projections.rowCount(); //Projections.avg("salary")
		criteria5.setProjection(pr);
		List<Object> cResult5 = criteria4.list();
		System.out.println(cResult5.get(0));
	
		about("Multiple Projections");
		
		Criteria criteria6 = session.createCriteria(Employee.class);
	    ProjectionList more = Projections.projectionList();
	    more.add(Projections.avg("salary"));
	    more.add(Projections.min("salary"));
	    criteria6.setProjection(more);
	    
		List<Object[]> cResult6 = criteria6.list();
		for(Object[] row : cResult6) {
			for(Object col : row) {
				System.out.print(col);
				System.out.println(" | ");
			}
			System.out.println();
	    }
		
		/* =============== Native SQL Query ================ */
		/* used when database specific queries to be written (such as hints) */
		
		/* SQLQuery sqlQuery = session.createSQLQuery(SQL_STRING) */

		about("Native SQL returing entire Object");
		
	    SQLQuery sqlQuery1 = session.createSQLQuery("select * from employee where name like :startsWith");
	    sqlQuery1.addEntity(Employee.class);
	    sqlQuery1.setParameter("startsWith", "S%");
	    List<Employee> nResult1 = sqlQuery1.list();
	    for(Employee employee : nResult1) {
	    	System.out.println(employee);
	    }
	    
	    about("Native SQL returing select columns");
	    
	    SQLQuery sqlQuery2 = session.createSQLQuery("select name, experience, salary from employee where name like :startsWith");
	    sqlQuery2.setParameter("startsWith", "S%");
	    List<Object[]> nResult2 = sqlQuery2.list();
	    for(Object[] row : nResult2) {
	    	for(Object col : row) {
	    		System.out.print(col);
	    		System.out.print(" | ");
	    	}
	    	System.out.println();
	    }
	    
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			about("====== UPDATE using HQL ==========");
			
	        Query hqlQuery10 = session.createQuery("update Project set name = :newName where name = :oldName");
	        hqlQuery10.setString("newName", "Busses");
	        hqlQuery10.setString("oldName", "Fleets");	
	        
	        int result10 = hqlQuery10.executeUpdate();
	        System.out.println("Affected: "+result10);
			
			/* in HQL, INSERT INTO ... VALUES .. is not supported, instead use INSERT INTO ... SELECT ... */
			/** SAMPLE insert using HQL
				Query query = session.createQuery("insert into Stock(stock_code, stock_name)" +
	                "select stock_code, stock_name from backup_stock"); */

	        about("==== Save Object (INSERT) =====");
	        
			Project project = new Project("Engineering", Long.valueOf(500000));
			session.save(project);
			System.out.println(project);
			
			about("====== DELETE using HQL ==========");
			
	        Query hqlQuery11 = session.createQuery("delete Project where name = :projName");
	        hqlQuery11.setString("projName", "Engineering");
	        
			int result11 = hqlQuery11.executeUpdate();
			System.out.println("Affected: " + result11);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}

	}


	static void about(String s) {
		System.out.println();
		System.out.println();
		System.out.println(s);
		for(int i =0; i< s.length();i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}
