package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

        @Id
        @Column(name="id")
        private Integer id;
        @Column(name="name")
	private String name;
        @Column(name="cost")
	private Double cost;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="itemTypeId",nullable = false)
	private ItemType itemType;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public String toString() {
		return String.format("%-15s %-15s %-15s %s",getId(),getName(),getCost(),itemType.getName());
	}
}

