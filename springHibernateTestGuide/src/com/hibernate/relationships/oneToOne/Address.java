package com.hibernate.relationships.oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Fill your code here
@Entity
@Table(name="address")
public class Address{

	private static Integer idInc = 1;
	
	//Fill your code here
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;	
	
	//Fill your code here
	@Column(name="line1")
	private String line1;

	//Fill your code here
	@Column(name="line2")
	private String line2;

	//Fill your code here
	@Column(name="city")
	private String city;

	public Address(String line1, String line2, String city, Integer pincode) {
//		super();
		this.id = idInc++;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.pincode = pincode;
	}
	//Fill your code here
	@Column(name="pincode")
	private Integer pincode;

	public Address() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
}
