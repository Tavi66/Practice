package learn.test.bo;

import learn.test.domain.Item;
import learn.test.dao.ItemDAO;
import java.util.List;

public class ItemBO {

    ItemDAO dao = new ItemDAO();

	public List<Item> listItems()
	{
		return dao.list();
	}
	public Double averagePriceByCategory(String category) 
	{
		return dao.averagePriceByCategory(category);
	}   
}
