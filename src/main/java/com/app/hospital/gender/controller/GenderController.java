package com.app.hospital.gender.controller;

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

import com.app.hospital.gender.exception.GenderNotFoundException;
import com.app.hospital.gender.model.Gender;
import com.app.hospital.gender.service.GenderService;

@RestController
public class GenderController {
	private static final Logger LOG = LoggerFactory.getLogger(GenderController.class);

	@Autowired
	private GenderService genderService;

	@RequestMapping(value = "/save-gender", method = RequestMethod.POST)
	public ResponseEntity<Object> saveGender(@Valid @RequestBody Gender gender) {
		LOG.info("GenderController | saveGender() | invoked");
		Object genderInfo = null;
		try {
			genderInfo = genderService.saveGender(gender);
			LOG.info("GenderController | saveGender() | GenderInfo = {}", genderInfo);
		} catch (Exception ex) {
			LOG.error("GenderController | saveGender()| Exception = {}", ex.getMessage());
		}
		LOG.info("GenderController | saveGender() | terminated");
		return new ResponseEntity<Object>(genderInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/update-gender/{genderId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateGender(@Valid @RequestBody Gender gender, @PathVariable("genderId") int genderId)
			throws GenderNotFoundException {
		LOG.info("GenderController | updateGender() | invoked with GenderId = {}", genderId);
		Object genderInfo = null;
		try {
			if (genderId > 0) {
				genderInfo = genderService.updateGender(gender, genderId);
				LOG.info("GenderController | updateGender() | GenderInfo = {}", genderInfo);
			} else {
				throw new GenderNotFoundException("Gender not found for GenderId = {}" + genderId);
			}
		} catch (GenderNotFoundException ex) {
			LOG.error("GenderController | updateGender()| GenderNotFoundException = {}", ex.getMessage());
			throw new GenderNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("GenderController | updateGender()| Exception = {}" + ex.getMessage());
		}
		LOG.info("GenderController | updateGender() | terminated");
		return new ResponseEntity<Object>(genderInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/delete-gender/{genderId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteGender(@PathVariable("genderId") int genderId) throws GenderNotFoundException {
		LOG.info("GenderController | deleteGender() | invoked with GenderId = {}", genderId);
		try {
			if (genderId > 0) {
				genderService.deleteGender(genderId);
				LOG.info("GenderController | deleteGender() | Deleted GenderID = {}", genderId);
			} else {
				throw new GenderNotFoundException("Gender not found for GenderId = {}" + genderId);
			}
		} catch (GenderNotFoundException ex) {
			LOG.error("GenderController | deleteGender()| GenderNotFoundException = {}", ex.getMessage());
			throw new GenderNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("GenderController | deleteGender()| Exception = {}" + ex.getMessage());
		}
		LOG.info("GenderController | deleteGender() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/fetch-all-gender", method = RequestMethod.GET)
	public List<Gender> fetchAllGender() {
		LOG.info("GenderController | fetchAllGender() | invoked");
		List<Gender> genderList = new ArrayList<Gender>();
		try {
			genderList = genderService.fetchAllGender();
			LOG.info("GenderController | fetchAllGender() | AllGenderList = {}", genderList);
		} catch (Exception ex) {
			LOG.error("GenderController | fetchAllGender()| Exception = {}", ex.toString());
		}
		LOG.info("GenderController | fetchAllGender() | terminated");
		return genderList;
	}

	// get record by id
	@RequestMapping(value = "/fetch-gender/{genderId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchGenderById(@PathVariable("genderId") int genderId) throws GenderNotFoundException {
		LOG.info("GenderController | fetchGenderById() | invoked with GenderId = {}", genderId);
		Object genderInfo = null;
		try {
			if (genderId > 0) {
				genderInfo = genderService.fetchGenderById(genderId);
				LOG.info("GenderController | fetchGenderById() | GenderInfo = {}", genderInfo);
			} else {
				throw new GenderNotFoundException("Gender not found for GenderId = " + genderId);
			}
		} catch (GenderNotFoundException ex) {
			LOG.error("GenderController | fetchGenderById()| GenderNotFoundException = {}", ex.getMessage());
			throw new GenderNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("GenderController | fetchGenderById()| Exception = {}", ex.getMessage());
		}
		LOG.info("GenderController | fetchGenderById() | terminated");
		return new ResponseEntity<Object>(genderInfo, HttpStatus.OK);
	}
}
