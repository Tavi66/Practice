package com.spring.annotations.q1;

package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class ContactDetail {
	String mobileNumber;
	String alternateMobileNumber;
	String landlineNumber;
	String email;

	@Autowired
	Address address;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAlternateMobileNumber() {
		return alternateMobileNumber;
	}
	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public void display() {
		System.out.println("Mobile : " + this.mobileNumber);
        System.out.println("Alternate Mobile : " + this.alternateMobileNumber);
        System.out.println("Landline : " + this.landlineNumber);
        System.out.println("email : " + this.email);
        this.address.display();
	}

}
