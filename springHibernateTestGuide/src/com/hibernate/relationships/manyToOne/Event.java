package com.hibernate.relationships.manyToOne;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Fill your code here
@Entity
@Table(name="event")
public class Event {
	
	//Fill your code here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
	
	//Fill your code here
	@Column(name="name")
    private String name;
	
	//Fill your code here
	@Column(name="detail")
	private String detail;
	
	//Fill your code here
	@Column(name="type")
	private String type;

	//Fill your code here
	@OneToMany(mappedBy="event")
	private List<Ticket> ticketsBooked = new ArrayList<>();
	
	public Event() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Ticket> getTicketsBooked() {
		return ticketsBooked;
	}
	public void setTicketsBooked(List<Ticket> ticketsBooked) {
		this.ticketsBooked = ticketsBooked;
	}
}

