package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="exhibition")
public class Exhibition extends Event {
    @Column(name="numberOfStalls")
	private Integer numberOfStalls;
	@Column(name = "occupied")
	private Integer occupied;
	public Exhibition() {
		super();
	}
	public Exhibition(Integer id, String name, Integer numberOfStalls, Integer occupied) {
		super(id,name);
		this.numberOfStalls = numberOfStalls;
		this.occupied = occupied;
	}
	public Integer getNumberOfStalls() {
		return numberOfStalls;
	}
	public void setNumberOfStalls(Integer numberOfStalls) {
		this.numberOfStalls = numberOfStalls;
	}
	public Integer getOccupied() {
		return occupied;
	}
	public void setOccupied(Integer occupied) {
		this.occupied = occupied;
	}
}
