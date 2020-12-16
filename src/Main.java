import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import bo.*;
import domain.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		Logger log = Logger.getLogger("org.hibernate");
    		log.setLevel(Level.OFF);
    		System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		
    		ItemBO ibo=new ItemBO();
    		int id;
    		Item temp;
    		do {
		System.out.println("Menu");
		System.out.println("1.Add item");
		System.out.println("2.Remove item");
		System.out.println("3.Show items");
		System.out.println("4.Exit");
		
		System.out.println("Enter choice");
		int choice = Integer.parseInt(br.readLine());
		switch(choice)
		{
		case 1: 		
			System.out.println("Enter item id");
		id = Integer.parseInt(br.readLine());
		System.out.println("Enter item name");
		String name=br.readLine();
		System.out.println("Enter item cost");
		Double cost=Double.parseDouble(br.readLine());
		System.out.println("Enter item type id");
		int tid = Integer.parseInt(br.readLine());
		System.out.println("Enter item type name");
		String tname=br.readLine();
		System.out.println("Enter item type detail");
		String detail=br.readLine();
		
		ItemType it=new ItemType();
		it.setId(tid);
		it.setName(tname);
		it.setDetail(detail);
		
		temp=new Item();
		temp.setId(id);
		temp.setCost(cost);
		temp.setName(name);
		temp.setItemType(it);
		
		ibo.insertItem(temp);
		break;
		case 2:
			System.out.println("Enter item id");
			id= Integer.parseInt(br.readLine());
			temp=ibo.findItemById(id);
			if(temp==null)
			{
				System.out.println("Item not found");
			}
			ibo.deleteItem(temp);
			break;
		case 3: List<Item> list = ibo.listItems();
		if(list.isEmpty())
		{
			System.out.println("No items found");		
		} else {
			System.out.printf("%-15s %-15s %-15s %s\n","Id","Name","Cost","Type");
			list.forEach(System.out::println);
		}
			break;
		case 4: System.exit(0); return;
		default: System.out.println("Invalid choice"); break;
		}
    }while(true);

	}
}
