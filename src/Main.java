import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import bo.DoctorBO;
import domain.Doctor;

public class Main 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    Logger log = Logger.getLogger("org.hibernate");
	    	  log.setLevel(Level.OFF);
			  System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
			  
			  DoctorBO bo = new DoctorBO();
			  boolean loop = true;
			  do {
			  ArrayList<Doctor> list = bo.obtainDoctorList();
			  System.out.println("Docter List:");
			  System.out.printf("%-15s%-10s%-20s%-15s%-15s%-10s%-15s\n","Doctor Id","Doctor","Specialization","Qualification","Mobile Number","Fees","Status");
		      list.forEach(System.out::print);
			  System.out.println("Search Doctor by\n1.Doctor Id\n2.Doctor Name\n3.Specialization\n4.Status");
			  int choice = Integer.parseInt(br.readLine());
			  String search = null,type = null;
			  switch(choice)
			  {
			  case 1: //doctor id
				  type = "doctorId";
				  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  break;
			  case 2: //doctor name
				  type = "name";
				  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  break;
			  case 3: //specialization
				  type="specialization";
				  search = br.readLine();
				  break;
			  case 4: //status
				  type="status";
				  search = br.readLine();
				  break;
			  default: System.out.println("Invalid search type.");
				  return;
			  }
			  list = bo.searchDoctor(type, search);
			  if(list.isEmpty())
			  {System.out.println("No doctor available!!!");}
			  else{
				  list.forEach(System.out::print);
			  }
			  
			  System.out.println("Do you want to continue the processes(yes/no)?");
			  String cont=br.readLine().toLowerCase();
			  if(cont.equals("no"))
			  {
				  loop = false;
				  System.out.println("Application closed successfully!!!");
			  }
	    }while(loop);
    }
}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.text.ParseException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import bo.*;
//import domain.*;
//import util.HibernateUtil;
//
//public class Main {
//
//    public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
//		Logger log = Logger.getLogger("org.hibernate");
//    		log.setLevel(Level.OFF);
//    		System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
//    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    		
//    		ItemBO ibo=new ItemBO();
//    		ItemTypeBO tbo=new ItemTypeBO();
//    		
//    		int id;
//    		Item temp;
//    		do {
//		System.out.println("Menu");
//		System.out.println("1.Add item");
//		System.out.println("2.Remove item");
//		System.out.println("3.Show items");
//		System.out.println("4.Exit");
//		
//		System.out.println("Enter choice");
//		int choice = Integer.parseInt(br.readLine());
//		switch(choice)
//		{
//		case 1: 		
//			System.out.println("Enter item id");
//		id = Integer.parseInt(br.readLine());
//		System.out.println("Enter item name");
//		String name=br.readLine();
//		System.out.println("Enter item cost");
//		Double cost=Double.parseDouble(br.readLine());
//		System.out.println("Enter item type id");
//		int tid = Integer.parseInt(br.readLine());
//		ItemType it = tbo.findItemTypeById(tid);
//		if(it==null)
//		{
//		System.out.println("Enter item type name");
//		String tname=br.readLine();
//		System.out.println("Enter item type detail");
//		String detail=br.readLine();
//		it=new ItemType();
//		it.setId(tid);
//		it.setName(tname);
//		it.setDetail(detail);
//		}
//		
//		temp=new Item();
//		temp.setId(id);
//		temp.setCost(cost);
//		temp.setName(name);
//		temp.setItemType(it);
//		
//		ibo.insertItem(temp);
//		break;
//		case 2:
//			System.out.println("Enter item id");
//			id= Integer.parseInt(br.readLine());
//			ibo.deleteItem(ibo.findItemById(id));
//			break;
//		case 3: List<Item> list = ibo.listItems();
//		if(list.isEmpty())
//		{
//			System.out.println("No items found");		
//		} else {
//			System.out.printf("%-15s %-15s %-15s %s\n","Id","Name","Cost","Type");
//			list.forEach(System.out::println);
//		}
//			break;
//		case 4: HibernateUtil.getSessionFactory().close(); System.exit(0); return;
//		default: System.out.println("Invalid choice"); break;
//		}
//    }while(true);
//
//	}
//}
