package com.app.hospital.schedule.controller;

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

import com.app.hospital.schedule.exception.ScheduleNotFoundException;
import com.app.hospital.schedule.model.ScheduleType;
import com.app.hospital.schedule.service.ScheduleService;

@RestController
public class ScheduleController {
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value = "/save-schedule-type", method = RequestMethod.POST)
	public ResponseEntity<Object> saveScheduleType(@Valid @RequestBody ScheduleType scheduleType) {
		LOG.info("ScheduleController | saveScheduleType() | invoked");
		Object scheduleTypeInfo = null;
		try {
			scheduleTypeInfo = scheduleService.saveScheduleType(scheduleType);
			LOG.info("ScheduleController | saveScheduleType() | ScheduleTypeInfo = {}", scheduleTypeInfo);
		} catch (Exception ex) {
			LOG.error("ScheduleController | saveScheduleType()| Exception = {}", ex.getMessage());
		}
		LOG.info("ScheduleController | saveScheduleType() | terminated");
		return new ResponseEntity<Object>(scheduleTypeInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/update-schedule-type/{scheduleTypeId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateScheduleType(@Valid @RequestBody ScheduleType scheduleType,
			@PathVariable("scheduleTypeId") int scheduleTypeId) throws ScheduleNotFoundException {
		LOG.info("ScheduleController | updateScheduleType() | invoked with ScheduleTypeId = {}", scheduleTypeId);
		Object scheduleTypeInfo = null;
		try {
			if (scheduleTypeId > 0) {
				scheduleTypeInfo = scheduleService.updateScheduleType(scheduleType, scheduleTypeId);
				LOG.info("ScheduleController | updateScheduleType() | ScheduleTypeInfo = {}", scheduleTypeInfo);
			} else {
				throw new ScheduleNotFoundException(
						"ScheduleType not found for ScheduleTypeId = {}" + scheduleTypeId);
			}
		} catch (ScheduleNotFoundException ex) {
			LOG.error("ScheduleController | updateScheduleType()| ScheduleNotFoundException = {}", ex.getMessage());
			throw new ScheduleNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("ScheduleController | updateScheduleType()| Exception = {}" + ex.getMessage());
		}
		LOG.info("ScheduleController | updateScheduleType() | terminated");
		return new ResponseEntity<Object>(scheduleTypeInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/delete-schedule-type/{scheduleTypeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteScheduleType(@PathVariable("scheduleTypeId") int scheduleTypeId)
			throws ScheduleNotFoundException {
		LOG.info("ScheduleController | deleteScheduleType() | invoked with ScheduleTypeId = {}", scheduleTypeId);
		try {
			if (scheduleTypeId > 0) {
				scheduleService.deleteScheduleType(scheduleTypeId);
				LOG.info("ScheduleController | deleteScheduleType() | Deleted ScheduleTypeID = {}", scheduleTypeId);
			} else {
				throw new ScheduleNotFoundException(
						"ScheduleType not found for ScheduleTypeId = {}" + scheduleTypeId);
			}
		} catch (ScheduleNotFoundException ex) {
			LOG.error("ScheduleController | deleteScheduleType()| ScheduleNotFoundException = {}", ex.getMessage());
			throw new ScheduleNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("ScheduleController | deleteScheduleType()| Exception = {}" + ex.getMessage());
		}
		LOG.info("ScheduleController | deleteScheduleType() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/fetch-all-schedule-type", method = RequestMethod.GET)
	public List<ScheduleType> fetchAllScheduleType() {
		LOG.info("ScheduleController | fetchAllScheduleType() | invoked");
		List<ScheduleType> scheduleTypeList = new ArrayList<ScheduleType>();
		try {
			scheduleTypeList = scheduleService.fetchAllScheduleType();
			LOG.info("ScheduleController | fetchAllScheduleType() | AllScheduleTypeList = {}", scheduleTypeList);
		} catch (Exception ex) {
			LOG.error("ScheduleController | fetchAllScheduleType()| Exception = {}", ex.toString());
		}
		LOG.info("ScheduleController | fetchAllScheduleType() | terminated");
		return scheduleTypeList;
	}

	// get record by id
	@RequestMapping(value = "/fetch-schedule-type/{scheduleTypeId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchScheduleTypeById(@PathVariable("scheduleTypeId") int scheduleTypeId)
			throws ScheduleNotFoundException {
		LOG.info("ScheduleController | fetchScheduleTypeById() | invoked with ScheduleTypeId = {}", scheduleTypeId);
		Object scheduleTypeInfo = null;
		try {
			if (scheduleTypeId > 0) {
				scheduleTypeInfo = scheduleService.fetchScheduleTypeById(scheduleTypeId);
				LOG.info("ScheduleController | fetchScheduleTypeById() | ScheduleTypeById = {}", scheduleTypeInfo);
			} else {
				throw new ScheduleNotFoundException(
						"ScheduleType not found for ScheduleTypeId = " + scheduleTypeId);
			}
		} catch (ScheduleNotFoundException ex) {
			LOG.error("ScheduleController | fetchScheduleTypeById()| ScheduleNotFoundException = {}", ex.getMessage());
			throw new ScheduleNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("ScheduleController | fetchScheduleTypeById()| Exception = {}", ex.getMessage());
		}
		LOG.info("ScheduleController | fetchScheduleTypeById() | terminated");
		return new ResponseEntity<Object>(scheduleTypeInfo, HttpStatus.OK);
	}
}
