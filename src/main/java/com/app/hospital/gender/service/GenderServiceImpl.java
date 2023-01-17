package com.app.hospital.gender.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.hospital.gender.exception.GenderNotFoundException;
import com.app.hospital.gender.model.Gender;
import com.app.hospital.gender.repository.GenderRepository;

@Repository
public class GenderServiceImpl implements GenderService {
	private static final Logger LOG = LoggerFactory.getLogger(GenderServiceImpl.class);

	@Autowired
	private GenderRepository genderRepository;

	@Override
	public Object saveGender(Gender gender) {
		LOG.info("GenderServiceImpl | saveGender() | invoked");
		Object genderInfo = genderRepository.save(gender);
		LOG.info("GenderServiceImpl | saveGender() | terminated");
		return genderInfo;
	}

	@Override
	public Object updateGender(Gender gender, int genderId) throws GenderNotFoundException {
		Object responseGenderInfo = null;
		LOG.info("GenderServiceImpl | updateGender() | invoked");
		Gender genderInfo = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender not found for GenderId = " + genderId));
		genderInfo.setGenderValue(gender.getGenderValue());
		responseGenderInfo = genderRepository.save(genderInfo);
		LOG.info("GenderServiceImpl | updateGender() | terminated");
		return responseGenderInfo;
	}

	@Override
	public void deleteGender(int genderId) throws GenderNotFoundException {
		LOG.info("GenderServiceImpl | deleteGender() | invoked");
		genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender not found for GenderId = " + genderId));
		genderRepository.deleteById(genderId);
		LOG.info("GenderServiceImpl | deleteGender() | terminated");
	}

	@Override
	public List<Gender> fetchAllGender() {
		LOG.info("GenderServiceImpl | fetchAllGender() | invoked");
		List<Gender> genders = new ArrayList<Gender>();
		genders = genderRepository.findAll();
		LOG.info("GenderServiceImpl | fetchAllGender() | terminated");
		return genders;
	}

	@Override
	public Object fetchGenderById(int genderId) throws GenderNotFoundException {
		LOG.info("GenderServiceImpl | fetchGenderById() | invoked");
		Object genderInfo = genderRepository.findById(genderId)
				.orElseThrow(() -> new GenderNotFoundException("Gender not found for GenderId = " + genderId));
		LOG.info("GenderServiceImpl | fetchGenderById() | terminated");
		return genderInfo;
	}
}
