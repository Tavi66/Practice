package learn.test.bo;

import learn.test.domain.Item;
import learn.test.dao.ItemDAO;
import java.util.List;

public class ItemBO {

    ItemDAO dao = new ItemDAO();
    
        public void insert(int id,String name,String category,Float price){
        	dao.insert(id,name,category,price);
	}
	
	public List<Item> list(){
		return dao.list();
	}
}
