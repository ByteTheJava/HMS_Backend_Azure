package com.app.hospital.slots.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.slots.exception.SlotsNotFoundException;
import com.app.hospital.slots.model.Slots;
import com.app.hospital.slots.repository.SlotsRepository;

@Service
public class SlotsServiceImpl implements SlotsService {
	private static final Logger LOG = LoggerFactory.getLogger(SlotsServiceImpl.class);

	@Autowired
	private SlotsRepository slotsRepository;

	@Override
	public Object saveSlots(Slots slots) {
		LOG.info("SlotsServiceImpl | saveSlots() | invoked");
		Object slotsInfo = slotsRepository.save(slots);
		LOG.info("SlotsServiceImpl | saveSlots() | terminated");
		return slotsInfo;
	}
	
	@Override
	public Object updateSlots(Slots slots, int slotsId) throws SlotsNotFoundException 
	{
        Object responseSlotsInfo=null;
        LOG.info("SlotsServiceImpl | updateSlots() | invoked");
		Slots slotsInfo=slotsRepository.findById(slotsId).orElseThrow(() -> new SlotsNotFoundException("Slots not found for SlotsId = " + slotsId));
		slotsInfo.setSlotsValue(slots.getSlotsValue());
		responseSlotsInfo=slotsRepository.save(slotsInfo);
		LOG.info("SlotsServiceImpl | updateSlots() | terminated");
		return responseSlotsInfo;
	}

	@Override
	public void deleteSlots(int slotsId) throws SlotsNotFoundException
	{
        LOG.info("SlotsServiceImpl | deleteSlots() | invoked");
        slotsRepository.findById(slotsId).orElseThrow(() -> new SlotsNotFoundException("Slots not found for SlotsId = " + slotsId));
        slotsRepository.deleteById(slotsId);
        LOG.info("SlotsServiceImpl | deleteSlots() | terminated");
	}

	@Override
	public List<Slots> fetchAllSlots() 
	{
        LOG.info("SlotsServiceImpl | fetchAllSlots() | invoked");
		List<Slots> slotss = new ArrayList<Slots>();
		slotss=slotsRepository.findAll();
		LOG.info("SlotsServiceImpl | fetchAllSlots() | terminated");
		return slotss;
	}

	@Override
	public Object fetchSlotsById(int slotsId) throws SlotsNotFoundException
	{
        LOG.info("SlotsServiceImpl | fetchSlotsById() | invoked");
		Object slotsInfo=slotsRepository.findById(slotsId).orElseThrow(() -> new SlotsNotFoundException("Slots not found for SlotsId = " + slotsId));
		LOG.info("SlotsServiceImpl | fetchSlotsById() | terminated");
		return slotsInfo;
	}
}
