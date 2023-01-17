package com.app.hospital.appointmentStatus.service;

import java.util.List;

import com.app.hospital.appointmentStatus.exception.AppointmentStatusNotFoundException;
import com.app.hospital.appointmentStatus.model.AppointmentStatus;

public interface AppointmentStatusService {
	Object saveAppointmentStatus(AppointmentStatus appointmentStatus);
	Object updateAppointmentStatus(AppointmentStatus appointmentStatus, int appointmentStatusId)
			throws AppointmentStatusNotFoundException;
	void deleteAppointmentStatus(int appointmentStatusId) throws AppointmentStatusNotFoundException;
	List<AppointmentStatus> fetchAllAppointmentStatus();
	Object fetchAppointmentStatusById(int appointmentStatusId) throws AppointmentStatusNotFoundException;
}
