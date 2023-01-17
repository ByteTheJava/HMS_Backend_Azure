package com.app.hospital.slots.service;

import java.util.List;

import com.app.hospital.slots.exception.SlotsNotFoundException;
import com.app.hospital.slots.model.Slots;

public interface SlotsService 
{
	Object saveSlots(Slots slots);
	Object updateSlots(Slots slots , int slotsId) throws SlotsNotFoundException;
	void deleteSlots(int slotsId) throws SlotsNotFoundException;
	List<Slots> fetchAllSlots();
	Object fetchSlotsById(int slotsId) throws SlotsNotFoundException;
}
