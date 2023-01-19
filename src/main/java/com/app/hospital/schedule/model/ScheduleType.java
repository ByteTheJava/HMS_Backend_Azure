package com.app.hospital.schedule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Schedule_Type_Master")
public class ScheduleType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scheduleTypeId", nullable = false)
	private int scheduleTypeId;

	@Column
	private String scheduleTypeValue;

	public int getScheduleTypeId() {
		return scheduleTypeId;
	}

	public void setScheduleTypeId(int scheduleTypeId) {
		this.scheduleTypeId = scheduleTypeId;
	}

	public String getScheduleTypeValue() {
		return scheduleTypeValue;
	}

	public void setScheduleTypeValue(String scheduleTypeValue) {
		this.scheduleTypeValue = scheduleTypeValue;
	}

	@Override
	public String toString() {
		return "ScheduleType [scheduleTypeId=" + scheduleTypeId + ", scheduleTypeValue=" + scheduleTypeValue + "]";
	}
}
