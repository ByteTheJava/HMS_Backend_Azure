package com.app.hospital.appointment_type.controller;

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

import com.app.hospital.appointment_type.exception.AppointmentTypeNotFoundException;
import com.app.hospital.appointment_type.model.AppointmentType;
import com.app.hospital.appointment_type.service.AppointmentTypeService;

@RestController
public class AppointmentTypeController {
	private static final Logger LOG = LoggerFactory.getLogger(AppointmentTypeController.class);

	@Autowired
	private AppointmentTypeService appointmentTypeService;

	@RequestMapping(value = "/save-appointment-type", method = RequestMethod.POST)
	public ResponseEntity<Object> saveAppointmentType(@Valid @RequestBody AppointmentType appointmentType) {
		LOG.info("AppointmentTypeController | saveAppointmentType() | invoked");
		Object appointmentTypeInfo = null;
		try {
			appointmentTypeInfo = appointmentTypeService.saveAppointmentType(appointmentType);
			LOG.info("AppointmentTypeController | saveAppointmentType() | AppointmentTypeInfo = {}",
					appointmentTypeInfo);
		} catch (Exception ex) {
			LOG.error("AppointmentTypeController | saveAppointmentType()| Exception = {}", ex.getMessage());
		}
		LOG.info("AppointmentTypeController | saveAppointmentType() | terminated");
		return new ResponseEntity<Object>(appointmentTypeInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/update-appointment-type/{appointmentTypeId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAppointmentType(@Valid @RequestBody AppointmentType appointmentType,
			@PathVariable("appointmentTypeId") int appointmentTypeId) throws AppointmentTypeNotFoundException {
		LOG.info("AppointmentTypeController | updateAppointmentType() | invoked with AppointmentTypeId = {}",
				appointmentTypeId);
		Object appointmentTypeInfo = null;
		try {
			if (appointmentTypeId > 0) {
				appointmentTypeInfo = appointmentTypeService.updateAppointmentType(appointmentType, appointmentTypeId);
				LOG.info("AppointmentTypeController | updateAppointmentType() | AppointmentTypeInfo = {}",
						appointmentTypeInfo);
			} else {
				throw new AppointmentTypeNotFoundException(
						"AppointmentType not found for AppointmentTypeId = {}" + appointmentTypeId);
			}
		} catch (AppointmentTypeNotFoundException ex) {
			LOG.error("AppointmentTypeController | updateAppointmentType()| AppointmentTypeNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentTypeNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentTypeController | updateAppointmentType()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AppointmentTypeController | updateAppointmentType() | terminated");
		return new ResponseEntity<Object>(appointmentTypeInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/delete-appointment-type/{appointmentTypeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAppointmentType(@PathVariable("appointmentTypeId") int appointmentTypeId)
			throws AppointmentTypeNotFoundException {
		LOG.info("AppointmentTypeController | deleteAppointmentType() | invoked with AppointmentTypeId = {}",
				appointmentTypeId);
		try {
			if (appointmentTypeId > 0) {
				appointmentTypeService.deleteAppointmentType(appointmentTypeId);
				LOG.info("AppointmentTypeController | deleteAppointmentType() | Deleted AppointmentTypeID = {}",
						appointmentTypeId);
			} else {
				throw new AppointmentTypeNotFoundException(
						"AppointmentType not found for AppointmentTypeId = {}" + appointmentTypeId);
			}
		} catch (AppointmentTypeNotFoundException ex) {
			LOG.error("AppointmentTypeController | deleteAppointmentType()| AppointmentTypeNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentTypeNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentTypeController | deleteAppointmentType()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AppointmentTypeController | deleteAppointmentType() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/fetch-all-appointment-type", method = RequestMethod.GET)
	public List<AppointmentType> fetchAllAppointmentType() {
		LOG.info("AppointmentTypeController | fetchAllAppointmentType() | invoked");
		List<AppointmentType> appointmentTypeList = new ArrayList<AppointmentType>();
		try {
			appointmentTypeList = appointmentTypeService.fetchAllAppointmentType();
			LOG.info("AppointmentTypeController | fetchAllAppointmentType() | AllAppointmentTypeList = {}",
					appointmentTypeList);
		} catch (Exception ex) {
			LOG.error("AppointmentTypeController | fetchAllAppointmentType()| Exception = {}", ex.toString());
		}
		LOG.info("AppointmentTypeController | fetchAllAppointmentType() | terminated");
		return appointmentTypeList;
	}

	// get record by id
	@RequestMapping(value = "/fetch-appointment-type/{appointmentTypeId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchAppointmentTypeById(@PathVariable("appointmentTypeId") int appointmentTypeId)
			throws AppointmentTypeNotFoundException {
		LOG.info("AppointmentTypeController | fetchAppointmentTypeById() | invoked with AppointmentTypeId = {}",
				appointmentTypeId);
		Object appointmentTypeInfo = null;
		try {
			if (appointmentTypeId > 0) {
				appointmentTypeInfo = appointmentTypeService.fetchAppointmentTypeById(appointmentTypeId);
				LOG.info("AppointmentTypeController | fetchAppointmentTypeById() | AppointmentTypeById = {}",
						appointmentTypeInfo);
			} else {
				throw new AppointmentTypeNotFoundException(
						"AppointmentType not found for AppointmentTypeId = " + appointmentTypeId);
			}
		} catch (AppointmentTypeNotFoundException ex) {
			LOG.error("AppointmentTypeController | fetchAppointmentTypeById()| AppointmentTypeNotFoundException = {}",
					ex.getMessage());
			throw new AppointmentTypeNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AppointmentTypeController | fetchAppointmentTypeById()| Exception = {}", ex.getMessage());
		}
		LOG.info("AppointmentTypeController | fetchAppointmentTypeById() | terminated");
		return new ResponseEntity<Object>(appointmentTypeInfo, HttpStatus.OK);
	}
}
