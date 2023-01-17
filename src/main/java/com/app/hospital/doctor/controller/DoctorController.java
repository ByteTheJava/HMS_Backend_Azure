package com.app.hospital.doctor.controller;

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

import com.app.hospital.doctor.exception.DoctorNotFoundException;
import com.app.hospital.doctor.model.Doctor;
import com.app.hospital.doctor.service.DoctorService;

@RestController
public class DoctorController {
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/doctor", method = RequestMethod.POST)
	public ResponseEntity<Object> saveDoctor(@Valid @RequestBody Doctor doctor) {
		LOG.info("DoctorController | saveDoctor() | invoked");
		Object doctorInfo = null;
		try {
			doctorInfo = doctorService.saveDoctor(doctor);
			LOG.info("DoctorController | saveDoctor() | DoctorInfo = {}", doctorInfo);
		} catch (Exception ex) {
			LOG.error("DoctorController | saveDoctor()| Exception = {}", ex.getMessage());
		}
		LOG.info("DoctorController | saveDoctor() | terminated");
		return new ResponseEntity<Object>(doctorInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/doctor/{doctorId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateDoctor(@Valid @RequestBody Doctor doctor,
			@PathVariable("doctorId") int doctorId) throws DoctorNotFoundException {
		LOG.info("DoctorController | updateDoctor() | invoked with DoctorId = {}", doctorId);
		Object doctorInfo = null;
		try {
			if (doctorId > 0) {
				doctorInfo = doctorService.updateDoctor(doctor, doctorId);
				LOG.info("DoctorController | updateDoctor() | DoctorInfo = {}", doctorInfo);
			} else {
				throw new DoctorNotFoundException("Doctor not found for DoctorId = {}" + doctorId);
			}
		} catch (DoctorNotFoundException ex) {
			LOG.error("DoctorController | updateDoctor()| DoctorNotFoundException = {}", ex.getMessage());
			throw new DoctorNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("DoctorController | updateDoctor()| Exception = {}" + ex.getMessage());
		}
		LOG.info("DoctorController | updateDoctor() | terminated");
		return new ResponseEntity<Object>(doctorInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/doctor/{doctorId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDoctor(@PathVariable("doctorId") int doctorId) throws DoctorNotFoundException {
		LOG.info("DoctorController | deleteDoctor() | invoked with doctorId = {}", doctorId);
		try {
			if (doctorId > 0) {
				doctorService.deleteDoctor(doctorId);
				LOG.info("DoctorController | deleteDoctor() | Deleted DoctorID = {}", doctorId);
			} else {
				throw new DoctorNotFoundException("Doctor not found for  DoctorId = {}" + doctorId);
			}
		} catch (DoctorNotFoundException ex) {
			LOG.error("DoctorController | deleteDoctor()| DoctorNotFoundException = {}", ex.getMessage());
			throw new DoctorNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("DoctorController | deleteDoctor()| Exception = {}" + ex.getMessage());
		}
		LOG.info("DoctorController | deleteDoctor() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public List<Doctor> fetchAllDoctor() {
		LOG.info("DoctorController | fetchAllDoctor() | invoked");
		List<Doctor> doctorList = new ArrayList<Doctor>();
		try {
			doctorList = doctorService.fetchAllDoctor();
			LOG.info("DoctorController | fetchAllDoctor() | AllDoctorList = {}", doctorList);
		} catch (Exception ex) {
			LOG.error("DoctorController | fetchAllDoctor()| Exception = {}", ex.getMessage());
		}
		LOG.info("DoctorController | fetchAllDoctor() | terminated");
		return doctorList;
	}

	// get record by id
	@RequestMapping(value = "/doctor/{doctorId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchDoctorById(@PathVariable("doctorId") int doctorId) throws DoctorNotFoundException {
		LOG.info("DoctorController | fetchDoctorById() | invoked with DoctorId = {}", doctorId);
		Object doctorInfo = null;
		try {
			if (doctorId > 0) {
				doctorInfo = doctorService.fetchDoctorById(doctorId);
				LOG.info("DoctorController | fetchDoctorById() | DoctorInfo = {}", doctorInfo);
			} else {
				throw new DoctorNotFoundException("Doctor not found for DoctorId = " + doctorId);
			}
		} catch (DoctorNotFoundException ex) {
			LOG.error("DoctorController | fetchDoctorById()| DoctorNotFoundException = {}", ex.getMessage());
			throw new DoctorNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("DoctorController | fetchDoctorById()| Exception = {}", ex.getMessage());
		}
		LOG.info("DoctorController | fetchDoctorById() | terminated");
		return new ResponseEntity<Object>(doctorInfo, HttpStatus.OK);
	}
}
