package domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stageEvent")
public class StageEvent extends Event {
    @Column(name = "coordinator")
	private String coordinator;
    @Column(name = "showDate")
	private Date showDate;
	@Column(name = "seatAvailable")
	private Integer seatAvailable;
	public StageEvent() {
		super();
	}
	public StageEvent(Integer id, String name, String coordinator, Date showDate, Integer seatAvailable) {
		super(id,name);
		this.coordinator = coordinator;
		this.showDate = showDate;
		this.seatAvailable = seatAvailable;
	}
	public String getCoordinator() {
		return coordinator;
	}
	public void setCoordinator(String coordinator) {
		this.coordinator = coordinator;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public Integer getSeatAvailable() {
		return seatAvailable;
	}
	public void setSeatAvailable(Integer seatAvailable) {
		this.seatAvailable = seatAvailable;
	}
}
