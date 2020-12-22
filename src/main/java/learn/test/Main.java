import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import util.HibernateUtil;
import domain.*;
import bo.*;

public class Main 
{
	public static void main(String [] args) throws ParseException, IOException
	{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		    Logger log = Logger.getLogger("org.hibernate");
	    	  log.setLevel(Level.OFF);
			  System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
			  
			  DoctorBO bo = new DoctorBO();
			  ArrayList<Doctor> list = bo.obtainDoctorList();
			  System.out.println("Docter List:");
			  System.out.printf("%-15s%-10s%-20s%-15s%-15s%-10s%-15s\n","Doctor Id","Docter","Specialization","Qualification","Mobile Number","Fees","Status");
		      list.forEach(System.out::print);
			  
              boolean loop = true; 
              
              do {
                  System.out.println("Search Doctor by\n1.Doctor Id\n2.Doctor Name\n3.Specialization\n4.Status");
    		  //int choice = Integer.parseInt(br.readLine());
              String choice = br.readLine();
			  String search,type;
			  switch(choice)
			  {
			  case "Doctor Id": //doctor id
				  type = "doctorId";
                  System.out.println("Enter Doctor Id :");
				  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  printList(list);
				  break;
			  case "Doctor Name": //doctor name
				  type = "name";
                  System.out.println("Enter Doctor Name :");
                  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  printList(list);
				  break;
			  case "Specialization": //specialization
				  type="specialization";
                  System.out.println("Enter Specialization :");
                  search = br.readLine();
				  list = bo.searchDoctor(type, search);
				  printList(list);
				  break;
    		  case "Status": //status
				  type="status";
                  System.out.println("Enter Status :");
                  search = br.readLine();
				  list = bo.searchDoctor(type, search);
                  printList(list);
				  break;
            default: System.out.println("Invalid search type.");
				  continue;
			  }
              
              System.out.println("Do you want to continue the processes(yes/no)?");
    		  String cont = br.readLine();
              
              if(cont.toLowerCase().equals("no"))
              { loop = false; }
			  } while(loop);
			  
			  System.out.println("Application closed successfully!!!");
	}
    
    public static void printList(ArrayList<Doctor> list)
    {
        if(list.isEmpty())
        {System.out.println("No doctor available!!!");}
        else
        {
            System.out.printf("%-15s%-10s%-20s%-15s%-15s%-10s%-15s\n","Doctor Id","Docter","Specialization","Qualification","Mobile Number","Fees","Status");
            list.forEach(System.out::print);
        }
    }
    {
        
    }
}
