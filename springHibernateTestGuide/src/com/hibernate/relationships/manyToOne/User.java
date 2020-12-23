package com.hibernate.relationships.manyToOne;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Fill your code here
@Entity
@Table(name="user")
public class User {
	
	//Fill your code here
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private Integer id;
	
	//Fill your code here
    @Column(name="name")
	private String name;
	
	//Fill your code here
	@Column(name="phoneNumber")
    private Long phoneNumber;
	
	//Fill your code here
	@Column(name="password")
	private String password;
	
	//Fill your code here
	@OneToMany(mappedBy="bookedBy")
	private List<Ticket> ticketsBooked = new ArrayList<>();
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Ticket> getTicketsBooked() {
		return ticketsBooked;
	}
	public void setTicketsBooked(List<Ticket> ticketsBooked) {
		this.ticketsBooked = ticketsBooked;
	}
}
