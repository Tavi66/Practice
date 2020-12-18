package domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import javax.persistence.InheritanceType;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	protected Long id;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="username")
	protected String username;
	
	@Column(name="password")
	protected String password;
	
	@Column(name="age")
	protected int age;
	
	@Column(name="dob")
	protected Date dob;
	
	@Column(name="blood_group")
	protected String bloodGroup;
	
	@Column(name="contact_no")
	protected String contactNo;
	
	@Column(name="email")
	protected String email;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(Long id, String name, String username, String password, int age, Date dob, String bloodGroup,
			String contactNo, String email) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.age = age;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.contactNo = contactNo;
		this.email = email;
	}

	public User() {
		super();
	}
	
}
