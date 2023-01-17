package com.app.hospital.gender.service;

import java.util.List;

import com.app.hospital.gender.exception.GenderNotFoundException;
import com.app.hospital.gender.model.Gender;

public interface GenderService 
{
	Object saveGender(Gender gender);
	Object updateGender(Gender gender , int genderId) throws GenderNotFoundException;
	void deleteGender(int genderId) throws GenderNotFoundException;
	List<Gender> fetchAllGender();
	Object fetchGenderById(int genderId) throws GenderNotFoundException;
}
