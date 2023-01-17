package com.app.hospital.doctor.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.doctor.exception.DoctorNotFoundException;
import com.app.hospital.doctor.model.Doctor;
import com.app.hospital.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	private static final Logger LOG = LoggerFactory.getLogger(DoctorServiceImpl.class);

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Object saveDoctor(Doctor doctor) {
		LOG.info("DoctorServiceImpl | saveDoctor() | invoked");
		Object doctorInfo = doctorRepository.save(doctor);
		LOG.info("DoctorServiceImpl | saveDoctor() | terminated");
		return doctorInfo;
	}

	@Override
	public Object updateDoctor(Doctor doctor, int doctorId) throws DoctorNotFoundException {
		Object responseDoctorInfo = null;
		LOG.info("DoctorServiceImpl | updateDoctor() | invoked");
		Doctor doctorInfo = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor not found for  DoctorId = " + doctorId));
		doctorInfo.setFirstName(doctor.getFirstName());
		doctorInfo.setLastName(doctor.getLastName());
		doctorInfo.setMobileNumber(doctor.getMobileNumber());
		doctorInfo.setEmailId(doctor.getEmailId());
		doctorInfo.setDepartmentId(doctor.getDepartmentId());
		responseDoctorInfo = doctorRepository.save(doctorInfo);
		LOG.info("DoctorServiceImpl | updateDoctor() | terminated");
		return responseDoctorInfo;
	}

	@Override
	public void deleteDoctor(int doctorId) throws DoctorNotFoundException {
		LOG.info("DoctorServiceImpl | deleteDoctor() | invoked");
		doctorRepository.findById(doctorId)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor not found for DoctorId = " + doctorId));
		doctorRepository.deleteById(doctorId);
		LOG.info("DoctorServiceImpl | deleteDoctor() | terminated");
	}

	@Override
	public List<Doctor> fetchAllDoctor() {
		LOG.info("DoctorServiceImpl | fetchAllDoctor() | invoked");
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors = doctorRepository.findAll();
		LOG.info("DoctorServiceImpl | fetchAllDoctor() | terminated");
		return doctors;
	}

	@Override
	public Object fetchDoctorById(int doctorId) throws DoctorNotFoundException {
		LOG.info("DoctorServiceImpl | fetchDoctorById() | invoked");
		Object doctorInfo = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor not found for DoctorId = " + doctorId));
		LOG.info("DoctorServiceImpl | fetchDoctorById() | terminated");
		return doctorInfo;
	}
}
