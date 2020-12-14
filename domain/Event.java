package domain;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="event")
public class Event {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="detail")
	private String detail;

	@OneToMany(mappedBy="event")
	private Set<Sponsor> sponsors;

	public Event() {
		super();
	}

	public Event(Integer id, String name,String detail){
		this.id=id;
		this.name=name;
		this.detail=detail;
		sponsors = new HashSet<>();
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
	public Set<Sponsor> getSponsors() {
		return sponsors;
	}
	public void setSponsors(Set<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}
	public void addSponsor(Sponsor s){
		this.sponsors.add(s);
	}
}
