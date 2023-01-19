package com.app.hospital.appointment_status.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.appointment_status.exception.AppointmentStatusNotFoundException;
import com.app.hospital.appointment_status.model.AppointmentStatus;
import com.app.hospital.appointment_status.repository.AppointmentStatusRepository;

@Service
public class AppointmentStatusServiceImpl implements AppointmentStatusService {
	private static final Logger LOG = LoggerFactory.getLogger(AppointmentStatusServiceImpl.class);

	@Autowired
	private AppointmentStatusRepository appointmentStatusRepository;

	@Override
	public Object saveAppointmentStatus(AppointmentStatus appointmentStatus) {
		LOG.info("AppointmentServiceImpl | saveAppointmentStatus() | invoked");
		Object appointmentStatusInfo = appointmentStatusRepository.save(appointmentStatus);
		LOG.info("AppointmentServiceImpl | saveAppointmentStatus() | terminated");
		return appointmentStatusInfo;
	}

	@Override
	public Object updateAppointmentStatus(AppointmentStatus appointmentStatus, int appointmentStatusId)
			throws AppointmentStatusNotFoundException {
		Object responseAppointmentStatusInfo = null;
		LOG.info("AppointmentServiceImpl | updateAppointmentStatus() | invoked");
		AppointmentStatus appointmentStatusInfo = appointmentStatusRepository.findById(appointmentStatusId)
				.orElseThrow(() -> new AppointmentStatusNotFoundException(
						"AppointmentStatus not found for AppointmentStatusId = " + appointmentStatusId));
		appointmentStatusInfo.setAppointmentStatusValue(appointmentStatus.getAppointmentStatusValue());
		responseAppointmentStatusInfo = appointmentStatusRepository.save(appointmentStatusInfo);
		LOG.info("AppointmentServiceImpl | updateAppointmentStatus() | terminated");
		return responseAppointmentStatusInfo;
	}

	@Override
	public void deleteAppointmentStatus(int appointmentStatusId) throws AppointmentStatusNotFoundException {
		LOG.info("AppointmentServiceImpl | deleteAppointmentStatus() | invoked");
		appointmentStatusRepository.findById(appointmentStatusId)
				.orElseThrow(() -> new AppointmentStatusNotFoundException(
						"AppointmentStatus not found for AppointmentStatusId = " + appointmentStatusId));
		appointmentStatusRepository.deleteById(appointmentStatusId);
		LOG.info("AppointmentServiceImpl | deleteAppointmentStatus() | terminated");
	}

	@Override
	public List<AppointmentStatus> fetchAllAppointmentStatus() {
		LOG.info("AppointmentServiceImpl | fetchAllAppointmentStatus() | invoked");
		List<AppointmentStatus> appointmentStatuss = new ArrayList<AppointmentStatus>();
		appointmentStatuss = appointmentStatusRepository.findAll();
		LOG.info("AppointmentServiceImpl | fetchAllAppointmentStatus() | terminated");
		return appointmentStatuss;
	}

	@Override
	public Object fetchAppointmentStatusById(int appointmentStatusId) throws AppointmentStatusNotFoundException {
		LOG.info("AppointmentServiceImpl | fetchAppointmentStatusById() | invoked");
		Object appointmentStatusInfo = appointmentStatusRepository.findById(appointmentStatusId)
				.orElseThrow(() -> new AppointmentStatusNotFoundException(
						"AppointmentStatus not found for AppointmentStatusId = " + appointmentStatusId));
		LOG.info("AppointmentServiceImpl | fetchAppointmentStatusById() | terminated");
		return appointmentStatusInfo;
	}
}
