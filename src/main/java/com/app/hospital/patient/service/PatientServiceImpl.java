package com.app.hospital.patient.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.patient.exception.PatientNotFoundException;
import com.app.hospital.patient.model.Patient;
import com.app.hospital.patient.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	private static final Logger LOG = LoggerFactory.getLogger(PatientServiceImpl.class);

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Object savePatient(Patient patient) {
		LOG.info("PatientServiceImpl | savePatient() | invoked");
		Object patientInfo = patientRepository.save(patient);
		LOG.info("PatientServiceImpl | savePatient() | terminated");
		return patientInfo;
	}

	@Override
	public Object updatePatient(Patient patient, int patientId) throws PatientNotFoundException {
		Object responsePatientInfo = null;
		LOG.info("PatientServiceImpl | updatePatient() | invoked");
		Patient patientInfo = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found for PatientId = " + patientId));
		patientInfo.setFirstName(patient.getFirstName());
		patientInfo.setLastName(patient.getLastName());
		patientInfo.setMobileNumber(patient.getMobileNumber());
		patientInfo.setEmailId(patient.getEmailId());
		patientInfo.setGenderId(patient.getGenderId());
		patientInfo.setAgeId(patient.getAgeId());
		patientInfo.setMrId(patient.getMrId());
		patientInfo.setAppointmentTypeId(patient.getAppointmentTypeId());
		responsePatientInfo = patientRepository.save(patientInfo);
		LOG.info("PatientServiceImpl | updatePatient() | terminated");
		return responsePatientInfo;
	}

	@Override
	public void deletePatient(int patientId) throws PatientNotFoundException {
		LOG.info("PatientServiceImpl | deletePatient() | invoked");
		patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found for PatientId = " + patientId));
		patientRepository.deleteById(patientId);
		LOG.info("PatientServiceImpl | deletePatient() | terminated");
	}

	@Override
	public List<Patient> fetchAllPatient() {
		LOG.info("PatientServiceImpl | fetchAllPatient() | invoked");
		List<Patient> patients = new ArrayList<Patient>();
		patients = patientRepository.findAll();
		LOG.info("PatientServiceImpl | fetchAllPatient() | terminated");
		return patients;
	}

	@Override
	public Object fetchPatientById(int patientId) throws PatientNotFoundException {
		LOG.info("PatientServiceImpl | fetchPatientById() | invoked");
		Object patientInfo = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found for PatientId = " + patientId));
		LOG.info("PatientServiceImpl | fetchPatientById() | terminated");
		return patientInfo;
	}
}
