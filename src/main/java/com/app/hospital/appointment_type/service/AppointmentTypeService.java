package com.app.hospital.appointment_type.service;

import java.util.List;

import com.app.hospital.appointment_type.exception.AppointmentTypeNotFoundException;
import com.app.hospital.appointment_type.model.AppointmentType;

public interface AppointmentTypeService {
	Object saveAppointmentType(AppointmentType appointmentType);
	Object updateAppointmentType(AppointmentType appointmentType, int appointmentTypeId)
			throws AppointmentTypeNotFoundException;
	void deleteAppointmentType(int appointmentTypeId) throws AppointmentTypeNotFoundException;
	List<AppointmentType> fetchAllAppointmentType();
	Object fetchAppointmentTypeById(int appointmentTypeId) throws AppointmentTypeNotFoundException;
}
