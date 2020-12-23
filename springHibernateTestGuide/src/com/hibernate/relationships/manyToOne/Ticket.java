package com.hibernate.relationships.manyToOne;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Fill your code here
@Entity
@Table(name="ticket")
public class Ticket{
	
	//Fill your code here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Integer id;
	
	//Fill your code here
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User bookedBy;
	
	//Fill your code here
    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;
	
	//Fill your code here
	@Column(name="bookedAt")
	private Date bookedAt;
	
	public Ticket() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}
	public Ticket(User bookedBy, Event event, Date bookedAt) {
		this.bookedBy = bookedBy;
		this.event = event;
		this.bookedAt = bookedAt;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Date getBookedAt() {
		return bookedAt;
	}
	public void setBookedAt(Date bookedAt) {
		this.bookedAt = bookedAt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%-15s %-15s %-15s %s\n", id, bookedBy.getName(), event.getName(), sdf.format(bookedAt));
	}
	
}
