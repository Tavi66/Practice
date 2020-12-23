package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import org.hibernate.annotations.ForeignKey;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;

	@Column(name = "name")
	String name;

	@ManyToMany(mappedBy = "users")
	private Set<Role> roles = new HashSet<Role>();

	public User(String name) {
		super();
		this.name = name;
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

	public Set<Role> getRoles() {
		return roles;
	}

//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
//	public void addRole(Role role) {
//		this.roles.add(role);
//	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
