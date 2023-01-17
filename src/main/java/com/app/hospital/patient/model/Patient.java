package com.app.hospital.patient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Patient_Master")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "patientId", nullable = false)
	private int patientId;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String mobileNumber;

	@Column
	private String emailId;

	@Column
	private int genderId;

	@Column
	private int ageId;

	// @Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "mrId", nullable = false)
	private int mrId;

	@Column
	private int appointmentTypeId;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public int getAgeId() {
		return ageId;
	}

	public void setAgeId(int ageId) {
		this.ageId = ageId;
	}

	public int getMrId() {
		return mrId;
	}

	public void setMrId(int mrId) {
		this.mrId = mrId;
	}

	public int getAppointmentTypeId() {
		return appointmentTypeId;
	}

	public void setAppointmentTypeId(int appointmentTypeId) {
		this.appointmentTypeId = appointmentTypeId;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", genderId=" + genderId + ", ageId="
				+ ageId + ", mrId=" + mrId + ", appointmentTypeId=" + appointmentTypeId + "]";
	}
}
