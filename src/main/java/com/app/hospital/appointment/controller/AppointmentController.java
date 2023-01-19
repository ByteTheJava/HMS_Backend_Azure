package com.app.hospital.appointment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.appointment.exception.AppointmentNotFoundException;
import com.app.hospital.appointment.model.Appointment;
import com.app.hospital.appointment.service.AppointmentService;

@RestController
public class AppointmentController {
	private static final Logger LOG = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping(value = "/save-appointment", method = RequestMethod.POST)
	public ResponseEntity<Object> saveAppointment(@Valid @RequestBody Appointment appointment) {
		LOG.info("AppointmentController | saveAppointment() | invoked");
		Object appointmentInfo = null;
		try {
			appointmentInfo = appointmentService.saveAppointment(appointment);
			LOG.info("AppointmentController | saveAppointment() | AppointmentInfo = {}", appointmentInfo);
		} catch (Exception ex) {
			LOG.error("AppointmentController | saveAppointment()| Exception = {}", ex.getMessage());
		}
		LOG.info("AppointmentController | saveAppointment() | terminated");
		return new ResponseEntity<Object>(appointmentInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/update-appointment/{appointmentId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAppointment(@Valid @RequestBody Appointment appointment,
			@PathVariable("appointmentId") int appointmentId) throws AppointmentNotFoundException {
		LOG.info("AppointmentController | updateAppointment() | invoked with AppointmentId = {}", appointmentId);
		Object appointmentInfo = null;
		try {
			if (appointmentId > 0) {
				appointmentInfo = appointmentService.updateAppointment(appointment, appointmentId);
				LOG.info("AppointmentController | updateAppointment() | AppointmentInfo = {}", appointmentInfo);
			} else {
				throw new AppointmentNotFoundException(
						"Appointment not found for AppointmentId = {}" + appointmentId);
			}
		} catch (AppointmentNotFoundException ex) {
			LOG.error("AppointmentController | updateAppointment()| AppointmentNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentController | updateAppointment()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AppointmentController | updateAppointment() | terminated");
		return new ResponseEntity<Object>(appointmentInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/delete-appointment/{appointmentId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAppointment(@PathVariable("appointmentId") int appointmentId)
			throws AppointmentNotFoundException {
		LOG.info("AppointmentController | deleteAppointment() | invoked with AppointmentId = {}", appointmentId);
		try {
			if (appointmentId > 0) {
				appointmentService.deleteAppointment(appointmentId);
				LOG.info("AppointmentController | deleteAppointment() | Deleted AppointmentId = {}", appointmentId);
			} else {
				throw new AppointmentNotFoundException("Appointment not found for AppointmentId = {}" + appointmentId);
			}
		} catch (AppointmentNotFoundException ex) {
			LOG.error("AppointmentController | deleteAppointment()| AppointmentNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentController | deleteAppointment()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AppointmentController | deleteAppointment() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/fetch-all-appointment", method = RequestMethod.GET)
	public List<Appointment> fetchAllAppointment() {
		LOG.info("AppointmentController | fetchAllAppointment() | invoked");
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		try {
			appointmentList = appointmentService.fetchAllAppointment();
			LOG.info("AppointmentController | fetchAllAppointment() | AllAppointmentList = {}", appointmentList);
		} catch (Exception ex) {
			LOG.error("AppointmentController | fetchAllAppointment()| Exception = {}", ex.toString());
		}
		LOG.info("AppointmentController | fetchAllAppointment() | terminated");
		return appointmentList;
	}

	// get record by id
	@RequestMapping(value = "/fetch-appointment/{appointmentId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchAppointmentById(@PathVariable("appointmentId") int appointmentId)
			throws AppointmentNotFoundException {
		LOG.info("AppointmentController | fetchAppointmentById() | invoked with AppointmentId = {}", appointmentId);
		Object appointmentInfo = null;
		try {
			if (appointmentId > 0) {
				appointmentInfo = appointmentService.fetchAppointmentById(appointmentId);
				LOG.info("AppointmentController | fetchAppointmentById() | AppointmentById = {}", appointmentInfo);
			} else {
				throw new AppointmentNotFoundException("Appointment not found AppointmentId = " + appointmentId);
			}
		} catch (AppointmentNotFoundException ex) {
			LOG.error("AppointmentController | fetchAppointmentById()| AppointmentNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentController | fetchAppointmentById()| Exception = {}", ex.getMessage());
		}
		LOG.info("AppointmentController | fetchAppointmentById() | terminated");
		return new ResponseEntity<Object>(appointmentInfo, HttpStatus.OK);
	}
}
