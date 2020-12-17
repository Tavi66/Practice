package learn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import learn.test.bo.ItemBO;
import learn.test.domain.Item;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "For fuck sake. Learn beans. And Hibernate, HQL" );
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    		//FILL YOUR CODE
    		System.out.println("Enter item details");
    		try {
				String[] arr = br.readLine().split(",");

    		System.out.println("Item details");
    		ItemBO bo = new ItemBO();
    		int id = Integer.parseInt(arr[0]);
    		String name = arr[1];
    		String category = arr[2];
    		float price = Float.parseFloat(arr[3]);
    		bo.insert(id, name, category, price);
    		List<Item> itemList = bo.list();
    		System.out.printf("%-10s %-15s %-15s %s\n","Id","Name","Category","Price");
    		for(Item item :itemList){
    			System.out.printf("%-10s %-15s %-15s %s\n",item.getId(),item.getName(),item.getCategory(),item.getPrice());
    		}
			} catch (IOException e) {
				e.printStackTrace();
			}    		
    		//103,Dining Set,Furnitures,599.99
    		//
    }
}
