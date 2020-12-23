package com.hibernate.relationships.oneToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.CascadeType;

import javax.persistence.JoinColumn;
//Fill your code here

@Entity
@Table(name="user")
public class User{
	
	//Fill your code here
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer userId;

	//Fill your code here
	@Column(name="city")
	private String name;

	//Fill your code here
	@Column(name="phoneNumber")
	private Long phoneNumber;

	//Fill your code here
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;

	//Fill your code here
	@Column(name="password")
	private String password;
	
	public User(Integer userId, String name, Long phoneNumber, Address address, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
	}
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}