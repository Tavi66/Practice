package com.hibernate.relationships.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


//fill your code here
@Entity
@Table(name="item")
public class Item implements Comparable<Item>{
        //fill your code here
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemId")
	private Integer itemId;
	//fill your code here
	@Column(name="name")
	private String name;
	//fill your code here
	@Column(name="itemType")
	private String itemType;
	//fill your code here
	@Column(name="cost")
	private Double cost;
	//fill your code here
	@ManyToMany(mappedBy="items")
	private Set<Event> events = new HashSet<>();

	public Item() {
		super();
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@Override
	public boolean equals(Object obj) {
		//fill your code here
		Item tempItem2 = (Item)obj;
		
		Boolean case1 = tempItem2.getItemId().equals(this.itemId);
		Boolean case2 = tempItem2.getName().equals(this.name);
		Boolean case3 = tempItem2.getCost().equals(this.cost);
		Boolean case4 = tempItem2.getItemType().equals(this.itemType);
//		Boolean case5 = tempItem2.getEvents().equals(this.events);
		
		if(case1 && case2 && case3 && case4) 
			return true;
		return false;
	}
//	
//	@Override
//	public int compareTo(Object o) {
//		//fill your code here
//		Item tempItem = (Item) o;
//		return tempItem.getItemId().compareTo(this.itemId);
//	}
//	
	@Override
	public int compareTo(Item tempItem) {
		return tempItem.getItemId().compareTo(this.itemId);
	}
	
	@Override
	 public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime*result + itemId;
        return result;
    }

	
//	@Override
//	public String toString() {
//	// TODO Auto-generated method stub
//	return name;
//	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
}

