package com.app.hospital.age.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Age_Master")
public class Age {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ageId", nullable = false)
	private int ageId;

	@Column
	private String ageValue;

	public int getAgeId() {
		return ageId;
	}

	public void setAgeId(int ageId) {
		this.ageId = ageId;
	}

	public String getAgeValue() {
		return ageValue;
	}

	public void setAgeValue(String ageValue) {
		this.ageValue = ageValue;
	}

	@Override
	public String toString() {
		return "Age [ageId=" + ageId + ", ageValue=" + ageValue + "]";
	}
}
