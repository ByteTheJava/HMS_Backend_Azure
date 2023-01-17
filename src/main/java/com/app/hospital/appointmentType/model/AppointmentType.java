package com.app.hospital.appointmentType.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Appointment_Type")
public class AppointmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "appointmentTypeId", nullable = false)
	private int appointmentTypeId;

	@Column
	private String appointmentTypeValue;

	public int getAppointmentTypeId() {
		return appointmentTypeId;
	}

	public void setAppointmentTypeId(int appointmentTypeId) {
		this.appointmentTypeId = appointmentTypeId;
	}

	public String getAppointmentTypeValue() {
		return appointmentTypeValue;
	}

	public void setAppointmentTypeValue(String appointmentTypeValue) {
		this.appointmentTypeValue = appointmentTypeValue;
	}

	@Override
	public String toString() {
		return "AppointmentType [appointmentTypeId=" + appointmentTypeId + ", appointmentTypeValue="
				+ appointmentTypeValue + "]";
	}
}
