package com.app.hospital.schedule.service;

import java.util.List;

import com.app.hospital.schedule.exception.ScheduleNotFoundException;
import com.app.hospital.schedule.model.ScheduleType;

public interface ScheduleService 
{
	Object saveScheduleType(ScheduleType scheduleType);
	Object updateScheduleType(ScheduleType scheduleType , int scheduleTypeId) throws ScheduleNotFoundException;
	void deleteScheduleType(int scheduleTypeId) throws ScheduleNotFoundException;
	List<ScheduleType> fetchAllScheduleType();
	Object fetchScheduleTypeById(int scheduleTypeId) throws ScheduleNotFoundException;
}
