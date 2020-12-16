import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import domain.Item;
import bo.ItemBO;
import util.HibernateUtil;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		//FILL YOUR CODE
		System.out.println("Enter item details");
		//FILL YOUR CODE
		System.out.println("Item details");
		//FILL YOUR CODE
		System.out.printf("%-10s %-15s %-15s %s\n","Id","Name","Category","Price");
		for(Item item :itemList){
			System.out.printf("%-10s %-15s %-15s %s\n",item.getId(),item.getName(),item.getCategory(),item.getPrice());
		}
		//FILL YOUR CODE
	}
}
