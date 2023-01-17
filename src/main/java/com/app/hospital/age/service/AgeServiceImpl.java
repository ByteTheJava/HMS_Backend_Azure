package com.app.hospital.age.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.age.exception.AgeNotFoundException;
import com.app.hospital.age.model.Age;
import com.app.hospital.age.repository.AgeRepository;

@Service
public class AgeServiceImpl implements AgeService {
	private static final Logger LOG = LoggerFactory.getLogger(AgeServiceImpl.class);

	@Autowired
	private AgeRepository ageRepository;

	@Override
	public Object saveAge(Age age) {
		LOG.info("AgeServiceImpl | saveAge() | invoked");
		Object ageInfo = ageRepository.save(age);
		LOG.info("AgeServiceImpl | saveAge() | terminated");
		return ageInfo;
	}

	@Override
	public Object updateAge(Age age, int ageId) throws AgeNotFoundException {
		Object responseAgeInfo = null;
		LOG.info("AgeServiceImpl | updateAge() | invoked");
		Age ageInfo = ageRepository.findById(ageId)
				.orElseThrow(() -> new AgeNotFoundException("Age not found for AgeId = " + ageId));
		ageInfo.setAgeValue(age.getAgeValue());
		responseAgeInfo = ageRepository.save(ageInfo);
		LOG.info("AgeServiceImpl | updateAge() | terminated");
		return responseAgeInfo;
	}

	@Override
	public void deleteAge(int ageId) throws AgeNotFoundException {
		LOG.info("AgeServiceImpl | deleteAge() | invoked");
		ageRepository.findById(ageId)
				.orElseThrow(() -> new AgeNotFoundException("Age not found for AgeId = " + ageId));
		ageRepository.deleteById(ageId);
		LOG.info("AgeServiceImpl | deleteAge() | terminated");
	}

	@Override
	public List<Age> fetchAllAge() {
		LOG.info("AgeServiceImpl | fetchAllAge() | invoked");
		List<Age> ages = new ArrayList<Age>();
		ages = ageRepository.findAll();
		LOG.info("AgeServiceImpl | fetchAllAge() | terminated");
		return ages;
	}

	@Override
	public Object fetchAgeById(int ageId) throws AgeNotFoundException {
		LOG.info("AgeServiceImpl | fetchAgeById() | invoked");
		Object ageInfo = ageRepository.findById(ageId)
				.orElseThrow(() -> new AgeNotFoundException("Age not found for AgeId = " + ageId));
		LOG.info("AgeServiceImpl | fetchAgeById() | terminated");
		return ageInfo;
	}
}
