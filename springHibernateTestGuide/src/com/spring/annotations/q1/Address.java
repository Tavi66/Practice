package com.spring.annotations.q1;

package com.spring;

//import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class Address {
	
	private String line1 ;
	
	private String line2 ;
	
	private String city ;
	
	private String pincode ;
	
	
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


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	public void display() {
		System.out.println(this.line1);
      System.out.println(this.line2);
      System.out.println(this.city);
      System.out.println(this.pincode);
	}
}

