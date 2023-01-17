package com.app.hospital.patient.controller;

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

import com.app.hospital.patient.exception.PatientNotFoundException;
import com.app.hospital.patient.model.Patient;
import com.app.hospital.patient.service.PatientService;

@RestController
public class PatientController {
	private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public ResponseEntity<Object> savePatient(@Valid @RequestBody Patient patient) {
		LOG.info("PatientController | savePatient() | invoked");
		Object patientInfo = null;
		try {
			patientInfo = patientService.savePatient(patient);
			LOG.info("PatientController | savePatient() | PatientInfo = {}",patientInfo);
		} catch (Exception ex) {
			LOG.error("PatientController | savePatient()| Exception = {}",ex.getMessage());
		}
		LOG.info("PatientController | savePatient() | terminated");
		return new ResponseEntity<Object>(patientInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePatient(@Valid @RequestBody Patient patient, @PathVariable("patientId") int patientId)
			throws PatientNotFoundException {
		LOG.info("PatientController | updatePatient() | invoked with PatientId = {}", patientId);
		Object patientInfo = null;
		try {
			if (patientId > 0) {
				patientInfo = patientService.updatePatient(patient, patientId);
				LOG.info("PatientController | updatePatient() | PatientInfo = {}", patientInfo);
			} else {
				throw new PatientNotFoundException("Patient not found for PatientId = {}" + patientId);
			}
		} catch (PatientNotFoundException ex) {
			LOG.error("PatientController | updatePatient()| PatientNotFoundException = {}", ex.getMessage());
			throw new PatientNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("PatientController | updatePatient()| Exception = {}" + ex.getMessage());
		}
		LOG.info("PatientController | updatePatient() | terminated");
		return new ResponseEntity<Object>(patientInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePatient(@PathVariable("patientId") int patientId) throws PatientNotFoundException {
		LOG.info("PatientController | deletePatient() | invoked with PatientId = {}", patientId);
		try {
			if (patientId > 0) {
				patientService.deletePatient(patientId);
				LOG.info("PatientController | deletePatient() | Deleted PatientID = {}", patientId);
			} else {
				throw new PatientNotFoundException("Patient not found for PatientId = {}" + patientId);
			}
		} catch (PatientNotFoundException ex) {
			LOG.error("PatientController | deletePatient()| PatientNotFoundException = {}", ex.getMessage());
			throw new PatientNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("PatientController | deletePatient()| Exception = {}" + ex.getMessage());
		}
		LOG.info("PatientController | deletePatient() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public List<Patient> fetchAllPatient() {
		LOG.info("PatientController | fetchAllPatient() | invoked");
		List<Patient> patientList = new ArrayList<Patient>();
		try {
			patientList = patientService.fetchAllPatient();
			LOG.info("PatientController | fetchAllPatient() | AllPatientList = {}", patientList);
		} catch (Exception ex) {
			LOG.error("PatientController | fetchAllPatient()| Exception = {}", ex.toString());
		}
		LOG.info("PatientController | fetchAllPatient() | terminated");
		return patientList;
	}

	// get record by id
	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchPatientById(@PathVariable("patientId") int patientId) throws PatientNotFoundException {
		LOG.info("PatientController | fetchPatientById() | invoked with PatientId = {}", patientId);
		Object patientInfo = null;
		try {
			if (patientId > 0) {
				patientInfo = patientService.fetchPatientById(patientId);
				LOG.info("PatientController | fetchPatientById() | PatientById = {}", patientInfo);
			} else {
				throw new PatientNotFoundException("Patient not found for PatientId = " + patientId);
			}
		} catch (PatientNotFoundException ex) {
			LOG.error("PatientController | fetchPatientById()| PatientNotFoundException = {}", ex.getMessage());
			throw new PatientNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("PatientController | fetchPatientById()| Exception = {}", ex.getMessage());
		}
		LOG.info("PatientController | fetchPatientById() | terminated");
		return new ResponseEntity<Object>(patientInfo, HttpStatus.OK);
	}
}
