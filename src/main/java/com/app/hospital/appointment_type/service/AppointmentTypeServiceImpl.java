package com.app.hospital.appointment_type.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.appointment_type.exception.AppointmentTypeNotFoundException;
import com.app.hospital.appointment_type.model.AppointmentType;
import com.app.hospital.appointment_type.repository.AppointmentTypeRepository;

@Service
public class AppointmentTypeServiceImpl implements AppointmentTypeService {

	private static final Logger LOG = LoggerFactory.getLogger(AppointmentTypeServiceImpl.class);

	@Autowired
	private AppointmentTypeRepository appointmentTypeRepository;

	@Override
	public Object saveAppointmentType(AppointmentType appointmentType) {
		LOG.info("AppointmentTypeServiceImpl | saveAppointmentType() | invoked");
		Object appointmentTypeInfo = appointmentTypeRepository.save(appointmentType);
		LOG.info("AppointmentTypeServiceImpl | saveAppointmentType() | terminated");
		return appointmentTypeInfo;
	}

	@Override
	public Object updateAppointmentType(AppointmentType appointmentType, int appointmentTypeId)
			throws AppointmentTypeNotFoundException {
		Object responseAppointmentTypeInfo = null;
		LOG.info("AppointmentTypeServiceImpl | updateAppointmentType() | invoked");
		AppointmentType appointmentTypeInfo = appointmentTypeRepository.findById(appointmentTypeId)
				.orElseThrow(() -> new AppointmentTypeNotFoundException(
						"AppointmentType not found for AppointmentTypeId = " + appointmentTypeId));
		appointmentTypeInfo.setAppointmentTypeValue(appointmentType.getAppointmentTypeValue());
		responseAppointmentTypeInfo = appointmentTypeRepository.save(appointmentTypeInfo);
		LOG.info("AppointmentTypeServiceImpl | updateAppointmentType() | terminated");
		return responseAppointmentTypeInfo;
	}

	@Override
	public void deleteAppointmentType(int appointmentTypeId) throws AppointmentTypeNotFoundException {
		LOG.info("AppointmentTypeServiceImpl | deleteAppointmentType() | invoked");
		appointmentTypeRepository.findById(appointmentTypeId).orElseThrow(() -> new AppointmentTypeNotFoundException(
				"AppointmentType not found for AppointmentTypeId = " + appointmentTypeId));
		appointmentTypeRepository.deleteById(appointmentTypeId);
		LOG.info("AppointmentTypeServiceImpl | deleteAppointmentType() | terminated");
	}

	@Override
	public List<AppointmentType> fetchAllAppointmentType() {
		LOG.info("AppointmentTypeServiceImpl | fetchAllAppointmentType() | invoked");
		List<AppointmentType> appointmentTypes = new ArrayList<AppointmentType>();
		appointmentTypes = appointmentTypeRepository.findAll();
		LOG.info("AppointmentTypeServiceImpl | fetchAllAppointmentType() | terminated");
		return appointmentTypes;
	}

	@Override
	public Object fetchAppointmentTypeById(int appointmentTypeId) throws AppointmentTypeNotFoundException {
		LOG.info("AppointmentTypeServiceImpl | getAppointmentTypeById() | invoked");
		Object appointmentTypeInfo = appointmentTypeRepository.findById(appointmentTypeId)
				.orElseThrow(() -> new AppointmentTypeNotFoundException(
						"AppointmentType not found for AppointmentTypeId = " + appointmentTypeId));
		LOG.info("AppointmentTypeServiceImpl | fetchAppointmentTypeById() | terminated");
		return appointmentTypeInfo;
	}
}
