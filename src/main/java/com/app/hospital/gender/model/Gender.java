package com.app.hospital.gender.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_Gender_Master")
public class Gender {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "genderId", nullable = false)
	private int genderId;

	@Column
	private String genderValue;

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGenderValue() {
		return genderValue;
	}

	public void setGenderValue(String genderValue) {
		this.genderValue = genderValue;
	}

	@Override
	public String toString() {
		return "Gender [genderId=" + genderId + ", genderValue=" + genderValue + "]";
	}
}
