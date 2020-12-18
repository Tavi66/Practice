package learn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import learn.test.bo.DoctorBO;
import learn.test.domain.Doctor;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    Logger log = Logger.getLogger("org.hibernate");
	    	  log.setLevel(Level.OFF);
			  System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
			  
			  DoctorBO bo = new DoctorBO();
			  ArrayList<Doctor> list = bo.obtainDoctorList();
			  System.out.println("Docter List:");
			  System.out.printf("%-15s%-10s%-20s%-15s%-15s%-10s%-15s\n","Doctor Id","Doctor","Specialization","Qualification","Mobile Number","Fees","Status");
		      list.forEach(System.out::print);
			  System.out.println("Search Doctor by\n1.Doctor Id\n2.Doctor Name\n3.Specialization\n4.Status");
			  int choice = Integer.parseInt(br.readLine());
			  String search,type;
			  switch(choice)
			  {
			  case 1: //doctor id
				  type = "user_id";
				  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  list.forEach(System.out::print);
				  break;
			  case 2: //doctor name
				  type = "name";
				  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  list.forEach(System.out::print);
				  break;
			  case 3: //specialization
				  type="specialization";
				  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  list.forEach(System.out::print);
				  break;
				  default: System.out.println("Invalid search type.");
				  break;
			  }
			  
			  System.out.println("No doctor available!!!");
			  System.out.println("Do you want to continue the processes(yes/no)?");
			  System.out.println("Application closed successfully!!!");
			  
    }
}
