package com.app.hospital.appointment_status.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Appointment_Status")
public class AppointmentStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "appointmentStatusId", nullable = false)
	private int appointmentStatusId;

	@Column
	private String appointmentStatusValue;

	public int getAppointmentStatusId() {
		return appointmentStatusId;
	}

	public void setAppointmentStatusId(int appointmentStatusId) {
		this.appointmentStatusId = appointmentStatusId;
	}

	public String getAppointmentStatusValue() {
		return appointmentStatusValue;
	}

	public void setAppointmentStatusValue(String appointmentStatusValue) {
		this.appointmentStatusValue = appointmentStatusValue;
	}

	@Override
	public String toString() {
		return "AppointmentStatus [appointmentStatusId=" + appointmentStatusId + ", appointmentStatusValue="
				+ appointmentStatusValue + "]";
	}
}
