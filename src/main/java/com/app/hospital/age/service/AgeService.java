package com.app.hospital.age.service;

import java.util.List;

import com.app.hospital.age.exception.AgeNotFoundException;
import com.app.hospital.age.model.Age;

public interface AgeService 
{
	Object saveAge(Age age);
	Object updateAge(Age age , int ageId) throws AgeNotFoundException;
	void deleteAge(int ageId) throws AgeNotFoundException;
	List<Age> fetchAllAge();
	Object fetchAgeById(int ageId) throws AgeNotFoundException;
}
