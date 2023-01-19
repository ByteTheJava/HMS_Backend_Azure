package com.app.hospital.appointment_status.service;

import java.util.List;

import com.app.hospital.appointment_status.exception.AppointmentStatusNotFoundException;
import com.app.hospital.appointment_status.model.AppointmentStatus;

public interface AppointmentStatusService {
	Object saveAppointmentStatus(AppointmentStatus appointmentStatus);
	Object updateAppointmentStatus(AppointmentStatus appointmentStatus, int appointmentStatusId)
			throws AppointmentStatusNotFoundException;
	void deleteAppointmentStatus(int appointmentStatusId) throws AppointmentStatusNotFoundException;
	List<AppointmentStatus> fetchAllAppointmentStatus();
	Object fetchAppointmentStatusById(int appointmentStatusId) throws AppointmentStatusNotFoundException;
}
