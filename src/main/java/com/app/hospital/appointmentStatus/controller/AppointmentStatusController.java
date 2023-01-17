package com.app.hospital.appointmentStatus.controller;

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

import com.app.hospital.appointmentStatus.exception.AppointmentStatusNotFoundException;
import com.app.hospital.appointmentStatus.model.AppointmentStatus;
import com.app.hospital.appointmentStatus.service.AppointmentStatusService;

@RestController
public class AppointmentStatusController {
	private static final Logger LOG = LoggerFactory.getLogger(AppointmentStatusController.class);

	@Autowired
	private AppointmentStatusService appointmentStatusService;

	@RequestMapping(value = "/appointmentStatus", method = RequestMethod.POST)
	public ResponseEntity<Object> saveAppointmentStatus(@Valid @RequestBody AppointmentStatus appointmentStatus) {
		LOG.info("AppointmentStatusController | saveAppointmentStatus() | invoked");
		Object appointmentStatusInfo = null;
		try {
			appointmentStatusInfo = appointmentStatusService.saveAppointmentStatus(appointmentStatus);
			LOG.info("AppointmentStatusController | saveAppointmentStatus() | AppointmentStatusInfo = {}",
					appointmentStatusInfo);
		} catch (Exception ex) {
			LOG.error("AppointmentStatusController | saveAppointmentStatus()| Exception = {}", ex.getMessage());
		}
		LOG.info("AppointmentStatusController | saveAppointmentStatus() | terminated");
		return new ResponseEntity<Object>(appointmentStatusInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/appointmentStatus/{appointmentStatusId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAppointmentStatus(@Valid @RequestBody AppointmentStatus appointmentStatus,
			@PathVariable("appointmentStatusId") int appointmentStatusId) throws AppointmentStatusNotFoundException {
		LOG.info("AppointmentStatusController | updateAppointmentStatus() | invoked with AppointmentStatusId = {}",
				appointmentStatusId);
		Object appointmentStatusInfo = null;
		try {
			if (appointmentStatusId > 0) {
				appointmentStatusInfo = appointmentStatusService.updateAppointmentStatus(appointmentStatus,
						appointmentStatusId);
				LOG.info("AppointmentStatusController | updateAppointmentStatus() | AppointmentStatusInfo = {}",
						appointmentStatusInfo);
			} else {
				throw new AppointmentStatusNotFoundException(
						"AppointmentStatus not found for AppointmentStatusId = {}" + appointmentStatusId);
			}
		} catch (AppointmentStatusNotFoundException ex) {
			LOG.error(
					"AppointmentStatusController | updateAppointmentStatus()| AppointmentStatusNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentStatusNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentStatusController | updateAppointmentStatus()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AppointmentStatusController | updateAppointmentStatus() | terminated");
		return new ResponseEntity<Object>(appointmentStatusInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/appointmentStatus/{appointmentStatusId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAppointmentStatus(@PathVariable("appointmentStatusId") int appointmentStatusId)
			throws AppointmentStatusNotFoundException {
		LOG.info("AppointmentStatusController | deleteAppointmentStatus() | invoked with AppointmentStatusId = {}",
				appointmentStatusId);
		try {
			if (appointmentStatusId > 0) {
				appointmentStatusService.deleteAppointmentStatus(appointmentStatusId);
				LOG.info("AppointmentStatusController | deleteAppointmentStatus() | Deleted AppointmentStatusId = {}",
						appointmentStatusId);
			} else {
				throw new AppointmentStatusNotFoundException(
						"AppointmentStatus not found for AppointmentStatusId = {}" + appointmentStatusId);
			}
		} catch (AppointmentStatusNotFoundException ex) {
			LOG.error(
					"AppointmentStatusController | deleteAppointmentStatus()| AppointmentStatusNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentStatusNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentStatusController | deleteAppointmentStatus()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AppointmentStatusController | deleteAppointmentStatus() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/appointmentStatus", method = RequestMethod.GET)
	public List<AppointmentStatus> fetchAllAppointmentStatus() {
		LOG.info("AppointmentStatusController | fetchAllAppointmentStatus() | invoked");
		List<AppointmentStatus> appointmentStatusList = new ArrayList<AppointmentStatus>();
		try {
			appointmentStatusList = appointmentStatusService.fetchAllAppointmentStatus();
			LOG.info("AppointmentStatusController | fetchAllAppointmentStatus() | AllAppointmentStatusList = {}",
					appointmentStatusList);
		} catch (Exception ex) {
			LOG.error("AppointmentStatusController | fetchAllAppointmentStatus()| Exception = {}", ex.toString());
		}
		LOG.info("AppointmentStatusController | fetchAllAppointmentStatus() | terminated");
		return appointmentStatusList;
	}

	// get record by id
	@RequestMapping(value = "/appointmentStatus/{appointmentStatusId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchAppointmentStatusById(@PathVariable("appointmentStatusId") int appointmentStatusId)
			throws AppointmentStatusNotFoundException {
		LOG.info("AppointmentStatusController | fetchAppointmentStatusById() | invoked with AppointmentStatusId = {}",
				appointmentStatusId);
		Object appointmentStatusInfo = null;
		try {
			if (appointmentStatusId > 0) {
				appointmentStatusInfo = appointmentStatusService.fetchAppointmentStatusById(appointmentStatusId);
				LOG.info("AppointmentStatusController | fetchAppointmentStatusById() | AppointmentStatusById = {}",
						appointmentStatusInfo);
			} else {
				throw new AppointmentStatusNotFoundException(
						"AppointmentStatus not found for AppointmentStatusId = " + appointmentStatusId);
			}
		} catch (AppointmentStatusNotFoundException ex) {
			LOG.error(
					"AppointmentStatusController | fetchAppointmentStatusById()| AppointmentStatusNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentStatusNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentStatusController | fetchAppointmentStatusById()| Exception = {}", ex.getMessage());
		}
		LOG.info("AppointmentStatusController | fetchAppointmentStatusById() | terminated");
		return new ResponseEntity<Object>(appointmentStatusInfo, HttpStatus.OK);
	}
}
