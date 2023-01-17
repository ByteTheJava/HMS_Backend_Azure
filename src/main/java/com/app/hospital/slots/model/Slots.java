package com.app.hospital.slots.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Slots_Master")
public class Slots {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "slotsId", nullable = false)
	private int slotsId;

	@Column
	private String slotsValue;

	public int getSlotsId() {
		return slotsId;
	}

	public void setSlotsId(int slotsId) {
		this.slotsId = slotsId;
	}

	public String getSlotsValue() {
		return slotsValue;
	}

	public void setSlotsValue(String slotsValue) {
		this.slotsValue = slotsValue;
	}

	@Override
	public String toString() {
		return "Slots [slotsId=" + slotsId + ", slotsValue=" + slotsValue + "]";
	}
}
