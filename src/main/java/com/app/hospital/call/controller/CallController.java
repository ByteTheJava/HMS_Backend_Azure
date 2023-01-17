package com.app.hospital.call.controller;

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

import com.app.hospital.call.exception.CallStatusNotFoundException;
import com.app.hospital.call.model.CallStatus;
import com.app.hospital.call.service.CallService;

@RestController
public class CallController {
	private static final Logger LOG = LoggerFactory.getLogger(CallController.class);

	@Autowired
	private CallService callService;

	@RequestMapping(value = "/callStatus", method = RequestMethod.POST)
	public ResponseEntity<Object> saveCallStatus(@Valid @RequestBody CallStatus callStatus) {
		LOG.info("CallController | saveCallStatus() | invoked");
		Object callStatusInfo = null;
		try {
			callStatusInfo = callService.saveCallStatus(callStatus);
			LOG.info("CallController | saveCallStatus() | CallStatusInfo = {}", callStatusInfo);
		} catch (Exception ex) {
			LOG.error("CallController | saveCallStatus()| Exception = {}", ex.getMessage());
		}
		LOG.info("CallController | saveCallStatus() | terminated");
		return new ResponseEntity<Object>(callStatusInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/callStatus/{callStatusId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCallStatus(@Valid @RequestBody CallStatus callStatus,
			@PathVariable("callStatusId") int callStatusId) throws CallStatusNotFoundException {
		LOG.info("CallController | updateCallStatus() | invoked with CallStatusId = {}", callStatusId);
		Object callStatusInfo = null;
		try {
			if (callStatusId > 0) {
				callStatusInfo = callService.updateCallStatus(callStatus, callStatusId);
				LOG.info("CallController | updateCallStatus() | CallStatusInfo = {}", callStatusInfo);
			} else {
				throw new CallStatusNotFoundException("CallStatus not found for CallStatusId = {}" + callStatusId);
			}
		} catch (CallStatusNotFoundException ex) {
			LOG.error("CallController | updateCallStatus()| CallStatusIdNotFoundException = {}", ex.getMessage());
			throw new CallStatusNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("CallController | updateCallStatus()| Exception = {}" + ex.getMessage());
		}
		LOG.info("CallController | updateCallStatus() | terminated");
		return new ResponseEntity<Object>(callStatusInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/callStatus/{callStatusId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCallStatus(@PathVariable("callStatusId") int callStatusId)
			throws CallStatusNotFoundException {
		LOG.info("CallController | deleteCallStatus() | invoked with callStatusId = {}", callStatusId);
		try {
			if (callStatusId > 0) {
				callService.deleteCallStatus(callStatusId);
				LOG.info("CallController | deleteCallStatus() | Deleted callStatusId = {}", callStatusId);
			} else {
				throw new CallStatusNotFoundException("CallStatus not found for CallStatusId = {}" + callStatusId);
			}
		} catch (CallStatusNotFoundException ex) {
			LOG.error("CallController | deleteCallStatus()| CallStatusIdNotFoundException = {}", ex.getMessage());
			throw new CallStatusNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("CallController | deleteCallStatus()| Exception = {}" + ex.getMessage());
		}
		LOG.info("CallController | deleteCallStatus() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/callStatus", method = RequestMethod.GET)
	public List<CallStatus> fetchAllCallStatus() {
		LOG.info("CallController | fetchAllCallStatus() | invoked");
		List<CallStatus> callStatusList = new ArrayList<CallStatus>();
		try {
			callStatusList = callService.fetchAllCallStatus();
			LOG.info("CallController | fetchAllCallStatus() | AllCallStatusList = {}", callStatusList);
		} catch (Exception ex) {
			LOG.error("CallController | fetchAllCallStatus()| Exception = {}", ex.toString());
		}
		LOG.info("CallController | fetchAllCallStatus() | terminated");
		return callStatusList;
	}

	// get record by id
	@RequestMapping(value = "/callStatus/{callStatusId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchCallStatusById(@PathVariable("callStatusId") int callStatusId)
			throws CallStatusNotFoundException {
		LOG.info("CallController | fetchCallStatusById() | invoked with CallStatusId = {}", callStatusId);
		Object callStatusInfo = null;
		try {
			if (callStatusId > 0) {
				callStatusInfo = callService.fetchCallStatusById(callStatusId);
				LOG.info("CallController | fetchCallStatusById() | callStatusInfo = {}", callStatusInfo);
			} else {
				throw new CallStatusNotFoundException("CallStatus not found for callStatusId = " + callStatusId);
			}
		} catch (CallStatusNotFoundException ex) {
			LOG.error("CallController | fetchCallStatusById()| CallStatusIdNotFoundException = {}", ex.getMessage());
			throw new CallStatusNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("CallController | fetchCallStatusById()| Exception = {}", ex.getMessage());
		}
		LOG.info("CallController | fetchCallStatusById() | terminated");
		return new ResponseEntity<Object>(callStatusInfo, HttpStatus.OK);
	}
}
