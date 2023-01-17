package com.app.hospital.appointment.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Appointment_Master")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "appointmentId", nullable = false)
	private int appointmentId;

	@Column
	private Date appointmentDate;

	@Column
	private Time appointmentTimeTo;

	@Column
	private Time appointmentTimeFrom;

	@Column
	private int slotsId;

	@Column
	private int appointmentTypeId;

	@Column
	private int appointmentStatusId;

	@Column
	private int patientId;

	@Column
	private int doctorId;

	@Column
	private int departmentId;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Time getAppointmentTimeTo() {
		return appointmentTimeTo;
	}

	public void setAppointmentTimeTo(Time appointmentTimeTo) {
		this.appointmentTimeTo = appointmentTimeTo;
	}

	public Time getAppointmentTimeFrom() {
		return appointmentTimeFrom;
	}

	public void setAppointmentTimeFrom(Time appointmentTimeFrom) {
		this.appointmentTimeFrom = appointmentTimeFrom;
	}

	public int getSlotsId() {
		return slotsId;
	}

	public void setSlotsId(int slotsId) {
		this.slotsId = slotsId;
	}

	public int getAppointmentTypeId() {
		return appointmentTypeId;
	}

	public void setAppointmentTypeId(int appointmentTypeId) {
		this.appointmentTypeId = appointmentTypeId;
	}

	public int getAppointmentStatusId() {
		return appointmentStatusId;
	}

	public void setAppointmentStatusId(int appointmentStatusId) {
		this.appointmentStatusId = appointmentStatusId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", appointmentTimeTo=" + appointmentTimeTo + ", appointmentTimeFrom=" + appointmentTimeFrom
				+ ", slotsId=" + slotsId + ", appointmentTypeId=" + appointmentTypeId + ", appointmentStatusId="
				+ appointmentStatusId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", departmentId="
				+ departmentId + "]";
	}
}
