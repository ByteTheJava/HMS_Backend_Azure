package com.app.hospital.call.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Call_Status")
public class CallStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "callStatusId", nullable = false)
	private int callStatusId;

	@Column
	private String callStatusValue;

	public int getCallStatusId() {
		return callStatusId;
	}

	public void setCallStatusId(int callStatusId) {
		this.callStatusId = callStatusId;
	}

	public String getCallStatusValue() {
		return callStatusValue;
	}

	public void setCallStatusValue(String callStatusValue) {
		this.callStatusValue = callStatusValue;
	}

	@Override
	public String toString() {
		return "CallStatus [callStatusId=" + callStatusId + ", callStatusValue=" + callStatusValue + "]";
	}
}
