package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name = "doctor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Doctor extends User{

	@Column(name = "doctorId")
	private String doctorId;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="specialization")
	private String specialization;
	
	@Column(name="experience")
	private int experience;
	
	@Column(name="consultationFees")
	private Double consultationFees;
	
	@Column(name="status")
	private String status;
	
	@Column(name="maximumPatientPerSlot")
	private int maximumPatientPerSlot;


	public Doctor(Long id, String name, String username, String password, int age, java.util.Date dob,
			String bloodGroup, String contactNo, String email, String doctorId, String qualification,
			String specialization, int experience, Double consultationFees, String status, int maximumPatientPerSlot) {
		super(id, name, username, password, age, dob, bloodGroup, contactNo, email);
		this.doctorId = doctorId;
		this.qualification = qualification;
		this.specialization = specialization;
		this.experience = experience;
		this.consultationFees = consultationFees;
		this.status = status;
		this.maximumPatientPerSlot = maximumPatientPerSlot;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long id, String name, String username, String password, int age, java.util.Date dob,
			String bloodGroup, String contactNo, String email) {
		super(id, name, username, password, age, dob, bloodGroup, contactNo, email);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Double getConsultationFees() {
		return consultationFees;
	}

	public void setConsultationFees(Double consultationFees) {
		this.consultationFees = consultationFees;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMaximumPatientPerSlot() {
		return maximumPatientPerSlot;
	}

	public void setMaximumPatientPerSlot(int maximumPatientPerSlot) {
		this.maximumPatientPerSlot = maximumPatientPerSlot;
	}
	
	public String toString() {
		return String.format("%-15s%-10s%-20s%-15s%-15s%-10s%-15s\n",doctorId,name,specialization,qualification,contactNo,consultationFees,status);
	}

}
