package com.app.hospital.appointment.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.appointment.exception.AppointmentNotFoundException;
import com.app.hospital.appointment.model.Appointment;
import com.app.hospital.appointment.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	private static final Logger LOG = LoggerFactory.getLogger(AppointmentServiceImpl.class);

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public Object saveAppointment(Appointment appointment) {
		LOG.info("AppointmentServiceImpl | saveAppointment() | invoked");
		Object appointmentInfo = appointmentRepository.save(appointment);
		LOG.info("AppointmentServiceImpl | saveAppointment() | terminated");
		return appointmentInfo;
	}

	@Override
	public Object updateAppointment(Appointment appointment, int appointmentId) throws AppointmentNotFoundException {
		Object responseAppointmentInfo = null;
		LOG.info("AppointmentServiceImpl | updateAppointment() | invoked");
		Appointment appointmentInfo = appointmentRepository.findById(appointmentId).orElseThrow(
				() -> new AppointmentNotFoundException("Appointment not found for AppointmentId = " + appointmentId));
		appointmentInfo.setAppointmentDate(appointment.getAppointmentDate());
		appointmentInfo.setAppointmentTimeTo(appointment.getAppointmentTimeTo());
		appointmentInfo.setAppointmentTimeFrom(appointment.getAppointmentTimeFrom());
		appointmentInfo.setSlotsId(appointment.getSlotsId());
		appointmentInfo.setAppointmentTypeId(appointment.getAppointmentTypeId());
		appointmentInfo.setAppointmentStatusId(appointment.getAppointmentStatusId());
		appointmentInfo.setPatientId(appointment.getPatientId());
		appointmentInfo.setDoctorId(appointment.getDoctorId());
		appointmentInfo.setDepartmentId(appointment.getDepartmentId());
		responseAppointmentInfo = appointmentRepository.save(appointmentInfo);
		LOG.info("AppointmentServiceImpl | updateAppointment() | terminated");
		return responseAppointmentInfo;
	}

	@Override
	public void deleteAppointment(int appointmentId) throws AppointmentNotFoundException {
		LOG.info("AppointmentServiceImpl | deleteAppointment() | invoked");
		appointmentRepository.findById(appointmentId).orElseThrow(
				() -> new AppointmentNotFoundException("Appointment not found for AppointmentId = " + appointmentId));
		appointmentRepository.deleteById(appointmentId);
		LOG.info("AppointmentServiceImpl | deleteAppointment() | terminated");
	}

	@Override
	public List<Appointment> fetchAllAppointment() {
		LOG.info("AppointmentServiceImpl | fetchAllAppointment() | invoked");
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointments = appointmentRepository.findAll();
		LOG.info("AppointmentServiceImpl | fetchAllAppointment() | terminated");
		return appointments;
	}

	@Override
	public Object fetchAppointmentById(int appointmentId) throws AppointmentNotFoundException {
		LOG.info("AppointmentServiceImpl | fetchAppointmentById() | invoked");
		Object appointmentInfo = appointmentRepository.findById(appointmentId).orElseThrow(
				() -> new AppointmentNotFoundException("Appointment not found for AppointmentId = " + appointmentId));
		LOG.info("AppointmentServiceImpl | fetchAppointmentById() | terminated");
		return appointmentInfo;
	}
}
