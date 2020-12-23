package com.hibernate.relationships.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//fill your code here
@Entity
@Table(name="event")
public class Event {
    //fill your code here\
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="eventId")
    private Integer eventId;
	//fill your code here
	@Column(name="name")
	private String name;
	//fill your code here
	@Column(name="detail")
	private String detail;
	//fill your code here
	@Column(name="type")
	private String type;
	//fill your code here
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="item_event",
		joinColumns = {@JoinColumn(name="eventId")},
		inverseJoinColumns= {@JoinColumn(name="itemId")})
	private Set<Item> items = new HashSet<>();

	public Event() {
		super();
	}
	public Event(Integer eventId, String name, String detail, String type) {
		this.eventId = eventId;
		this.name = name;
		this.detail = detail;
		this.type = type;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
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
	public Set<Item> getItems() {
		return items;
	}
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void removeFromList(Item item){
		Boolean success = items.remove(item);
		System.out.println("DID REMOVE?: "+success);
//		return items;
	}
	
}
