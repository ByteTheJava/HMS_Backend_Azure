package com.app.hospital.schedule.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.schedule.exception.ScheduleNotFoundException;
import com.app.hospital.schedule.model.ScheduleType;
import com.app.hospital.schedule.repository.ScheduleRepository;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleServiceImpl.class);

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Object saveScheduleType(ScheduleType scheduleType) {
		LOG.info("ScheduleServiceImpl | saveScheduleType() | invoked");
		Object scheduleTypeInfo = scheduleRepository.save(scheduleType);
		LOG.info("ScheduleServiceImpl | saveScheduleType() | terminated");
		return scheduleTypeInfo;
	}

	@Override
	public Object updateScheduleType(ScheduleType scheduleType, int scheduleTypeId) throws ScheduleNotFoundException {
		Object responseScheduleTypeInfo = null;
		LOG.info("ScheduleTypeServiceImpl | updateScheduleType() | invoked");
		ScheduleType scheduleTypeInfo = scheduleRepository.findById(scheduleTypeId).orElseThrow(
				() -> new ScheduleNotFoundException("ScheduleType not found for ScheduleTypeId = " + scheduleTypeId));
		scheduleTypeInfo.setScheduleTypeValue(scheduleType.getScheduleTypeValue());
		responseScheduleTypeInfo = scheduleRepository.save(scheduleTypeInfo);
		LOG.info("ScheduleTypeServiceImpl | updateScheduleType() | terminated");
		return responseScheduleTypeInfo;
	}

	@Override
	public void deleteScheduleType(int scheduleTypeId) throws ScheduleNotFoundException {
		LOG.info("ScheduleTypeServiceImpl | deleteScheduleType() | invoked");
		scheduleRepository.findById(scheduleTypeId).orElseThrow(
				() -> new ScheduleNotFoundException("ScheduleType not found for ScheduleTypeId = " + scheduleTypeId));
		scheduleRepository.deleteById(scheduleTypeId);
		LOG.info("ScheduleTypeServiceImpl | deleteScheduleType() | terminated");
	}

	@Override
	public List<ScheduleType> fetchAllScheduleType() {
		LOG.info("ScheduleTypeServiceImpl | fetchAllScheduleType() | invoked");
		List<ScheduleType> scheduleTypes = new ArrayList<ScheduleType>();
		scheduleTypes = scheduleRepository.findAll();
		LOG.info("ScheduleTypeServiceImpl | fetchAllScheduleType() | terminated");
		return scheduleTypes;
	}

	@Override
	public Object fetchScheduleTypeById(int scheduleTypeId) throws ScheduleNotFoundException {
		LOG.info("ScheduleTypeServiceImpl | fetchScheduleTypeById() | invoked");
		Object scheduleTypeInfo = scheduleRepository.findById(scheduleTypeId).orElseThrow(
				() -> new ScheduleNotFoundException("ScheduleType not found for ScheduleTypeId = " + scheduleTypeId));
		LOG.info("ScheduleTypeServiceImpl | fetchScheduleTypeById() | terminated");
		return scheduleTypeInfo;
	}
}
