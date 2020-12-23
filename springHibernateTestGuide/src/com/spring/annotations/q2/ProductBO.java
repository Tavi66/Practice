package com.spring.annotations.q2;

package com.spring.bo;

import java.util.List;

import com.spring.domain.Product;
import org.springframework.stereotype.Component;
import com.spring.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;


//Fill your code here
@Component("productBo")
public class ProductBO {
    
    //Fill your code here
    @Autowired
    ProductDAO productDAO;
    

	public List<Product> otainProductList() {
		//Fill your code here
        return productDAO.otainProductList();
	}
	
	public List<Product> otainProductBySearchType(String type,String value) {
		//Fill your code here
        return productDAO.otainProductBySearchType(type, value);
	}
}
