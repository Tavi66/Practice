package com.spring.annotations.q2;
package com.spring.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Fill your code here
@Entity
@Table(name="product")
public class Product implements Serializable{
    
    	//Fill your code here
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Long id;
	
	//Fill your code here
    @Column
	private String name;	
	
	//Fill your code here
	@Column
    private String color;	
	
	//Fill your code here
	@Column
    private String material;	
	
	//Fill your code here
	@Column
    private Double price;	

	public Product(){}
	
	public Product(Long id, String name,String color, String material, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.material = material;
		this.price = price;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	public String toString() {
		return String.format("%-5s%-25s%-15s%-25s%-15s",id,name,color,material,price);
	}
	
}
