package com.app.hospital.patient.service;

import java.util.List;

import com.app.hospital.patient.exception.PatientNotFoundException;
import com.app.hospital.patient.model.Patient;

public interface PatientService {
	Object savePatient(Patient patient);
	Object updatePatient(Patient patient , int patientId) throws PatientNotFoundException;
	void deletePatient(int patientId) throws PatientNotFoundException;
	List<Patient> fetchAllPatient();
	Object fetchPatientById(int patientId) throws PatientNotFoundException;
}
