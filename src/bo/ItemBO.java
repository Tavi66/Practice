package bo;
import domain.Item;
import dao.ItemDAO;

import java.util.List;

public class ItemBO {
	private ItemDAO dao = new ItemDAO();
	
    	public void insertItem(Item item) {
		dao.insert(item);
	}

	public void deleteItem(Item item) {
		dao.delete(item);
	}

	public Item findItemById(int id) {
		return (Item) dao.find(id);
	}

	public List<Item> listItems() {
		return dao.list();
	}
}

