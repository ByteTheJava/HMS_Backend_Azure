package com.app.hospital.age.controller;

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

import com.app.hospital.age.exception.AgeNotFoundException;
import com.app.hospital.age.model.Age;
import com.app.hospital.age.service.AgeService;



@RestController
public class AgeController {
	private static final Logger LOG = LoggerFactory.getLogger(AgeController.class);

	@Autowired
	private AgeService ageService;

	// Add/create/save
	@RequestMapping(value = "/save-age", method = RequestMethod.POST)
	public ResponseEntity<Object> saveAge(@Valid @RequestBody Age age) {
		LOG.info("AgeController | saveAge() | invoked");
		Object ageInfo = null;
		try {
			ageInfo = ageService.saveAge(age);
			LOG.info("AgeController | saveAge() | AgeInfo = {}", ageInfo);
		} catch (Exception ex) {
			LOG.error("AgeController | saveAge()| Exception = {}", ex.getMessage());
		}
		LOG.info("AgeController | saveAge() | terminated");
		return new ResponseEntity<Object>(ageInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/update-age/{ageId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateAge(@Valid @RequestBody Age age, @PathVariable("ageId") int ageId)
			throws AgeNotFoundException {
		LOG.info("AgeController | updateAge() | invoked with AgeId = {}", ageId);
		Object ageInfo = null;
		try {
			if (ageId > 0) {
				ageInfo = ageService.updateAge(age, ageId);
				LOG.info("AgeController | updateAge() | AgeInfo = {}", ageInfo);
			} else {
				throw new AgeNotFoundException("Age not found for AgeId = {}" + ageId);
			}
		} catch (AgeNotFoundException ex) {
			LOG.error("AgeController | updateAge()| AgeNotFoundException = {}", ex.getMessage());
			throw new AgeNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AgeController | updateAge()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AgeController | updateAge() | terminated");
		return new ResponseEntity<Object>(ageInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/delete-age/{ageId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteAge(@PathVariable("ageId") int ageId) throws AgeNotFoundException {
		LOG.info("AgeController | deleteAge() | invoked with AgeId = {}", ageId);
		try {
			if (ageId > 0) {
				ageService.deleteAge(ageId);
				LOG.info("AgeController | deleteAge() | Deleted AgeId = {}", ageId);
			} else {
				throw new AgeNotFoundException("Age not found for AgeId = {}" + ageId);
			}
		} catch (AgeNotFoundException ex) {
			LOG.error("AgeController | deleteAge()| AgeNotFoundException = {}", ex.getMessage());
			throw new AgeNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AgeController | deleteAge()| Exception = {}" + ex.getMessage());
		}
		LOG.info("AgeController | deleteAge() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/fetch-all-age", method = RequestMethod.GET)
	public List<Age> fetchAllAge() {
		LOG.info("AgeController | fetchAllAge() | invoked");
		List<Age> ageList = new ArrayList<Age>();
		try {
			ageList = ageService.fetchAllAge();
			LOG.info("AgeController | fetchAllAge() | AllAgeList = {}", ageList);
		} catch (Exception ex) {
			LOG.error("AgeController | fetchAllAge()| Exception = {}", ex.toString());
		}
		LOG.info("AgeController | fetchAllAge() | terminated");
		return ageList;
	}

	// get record by id
	@RequestMapping(value = "/fetch-age/{ageId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchAgeById(@PathVariable("ageId") int ageId) throws AgeNotFoundException {
		LOG.info("AgeController | fetchAgeById() | invoked with AgeId = {}", ageId);
		Object ageInfo = null;
		try {
			if (ageId > 0) {
				ageInfo = ageService.fetchAgeById(ageId);
				LOG.info("AgeController | fetchAgeById() | AgeById = {}", ageInfo);
			} else {
				throw new AgeNotFoundException("Age not found for AgeId = " + ageId);
			}
		} catch (AgeNotFoundException ex) {
			LOG.error("AgeController | fetchAgeById()| AgeNotFoundException = {}", ex.getMessage());
			throw new AgeNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("AgeController | fetchAgeById()| Exception = {}", ex.getMessage());
		}
		LOG.info("AgeController | fetchAgeById() | terminated");
		return new ResponseEntity<Object>(ageInfo, HttpStatus.OK);
	}
}
