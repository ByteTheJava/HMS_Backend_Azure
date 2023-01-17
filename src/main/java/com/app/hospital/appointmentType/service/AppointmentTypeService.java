package com.app.hospital.appointmentType.service;

import java.util.List;

import com.app.hospital.appointmentType.exception.AppointmentTypeNotFoundException;
import com.app.hospital.appointmentType.model.AppointmentType;

public interface AppointmentTypeService {
	Object saveAppointmentType(AppointmentType appointmentType);
	Object updateAppointmentType(AppointmentType appointmentType, int appointmentTypeId)
			throws AppointmentTypeNotFoundException;
	void deleteAppointmentType(int appointmentTypeId) throws AppointmentTypeNotFoundException;
	List<AppointmentType> fetchAllAppointmentType();
	Object fetchAppointmentTypeById(int appointmentTypeId) throws AppointmentTypeNotFoundException;
}
