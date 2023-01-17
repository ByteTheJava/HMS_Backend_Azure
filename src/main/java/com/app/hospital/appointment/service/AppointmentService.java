package com.app.hospital.appointment.service;

import java.util.List;

import com.app.hospital.appointment.exception.AppointmentNotFoundException;
import com.app.hospital.appointment.model.Appointment;

public interface AppointmentService 
{
	//Appointment
	Object saveAppointment(Appointment appointment);
	Object updateAppointment(Appointment appointment , int appointmentId) throws AppointmentNotFoundException;
	void deleteAppointment(int appointmentId) throws AppointmentNotFoundException;
	List<Appointment> fetchAllAppointment();
	Object fetchAppointmentById(int appointmentId) throws AppointmentNotFoundException;
}
