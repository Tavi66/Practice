package bo;
import domain.ItemType;
import dao.ItemTypeDAO;


public class ItemTypeBO {
	private ItemTypeDAO dao = new ItemTypeDAO();
	
    public ItemType findItemTypeById(int id) {
		return dao.find(id);
	}
}

