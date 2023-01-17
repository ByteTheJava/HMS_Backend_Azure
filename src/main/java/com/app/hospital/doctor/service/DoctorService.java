package com.app.hospital.doctor.service;

import java.util.List;

import com.app.hospital.doctor.exception.DoctorNotFoundException;
import com.app.hospital.doctor.model.Doctor;

public interface DoctorService {
	Object saveDoctor(Doctor doctor);
	Object updateDoctor(Doctor doctor , int doctorId) throws DoctorNotFoundException;
	void deleteDoctor(int doctorId) throws DoctorNotFoundException;
	List<Doctor> fetchAllDoctor();
	Object fetchDoctorById(int doctorId) throws DoctorNotFoundException;
}
