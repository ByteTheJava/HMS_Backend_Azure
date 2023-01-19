package com.app.hospital.slots.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.slots.exception.SlotsNotFoundException;
import com.app.hospital.slots.model.Slots;
import com.app.hospital.slots.service.SlotsService;

@RestController
public class SlotsController {
	private static final Logger LOG = LoggerFactory.getLogger(SlotsController.class);

	@Autowired
	private SlotsService slotService;

	@RequestMapping(value = "/save-slots", method = RequestMethod.POST)
	public ResponseEntity<Object> saveSlots(@Valid @RequestBody Slots slots) {
		LOG.info("SlotsController | saveSlots() | invoked");
		Object slotsInfo = null;
		try {
			slotsInfo = slotService.saveSlots(slots);
			LOG.info("SlotsController | saveSlots() | SlotsInfo = {}", slotsInfo);
		} catch (Exception ex) {
			LOG.error("SlotsController | saveSlots()| Exception = {}", ex.getMessage());
		}
		LOG.info("SlotsController | saveSlots() | terminated");
		return new ResponseEntity<Object>(slotsInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/update-slots/{slotsId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSlots(@Valid @RequestBody Slots slots, @PathVariable("slotsId") int slotsId)
			throws SlotsNotFoundException {
		LOG.info("SlotsController | updateSlots() | invoked with SlotsId = {}", slotsId);
		Object slotsInfo = null;
		try {
			if (slotsId > 0) {
				slotsInfo = slotService.updateSlots(slots, slotsId);
				LOG.info("SlotsController | updateSlots() | SlotsInfo = {}", slotsInfo);
			} else {
				throw new SlotsNotFoundException("Slots not found for SlotsId = {}" + slotsId);
			}
		} catch (SlotsNotFoundException ex) {
			LOG.error("SlotsController | updateSlots()| SlotsNotFoundException = {}", ex.getMessage());
			throw new SlotsNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("SlotsController | updateSlots()| Exception = {}" + ex.getMessage());
		}
		LOG.info("SlotsController | updateSlots() | terminated");
		return new ResponseEntity<Object>(slotsInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/delete-slots/{slotsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSlots(@PathVariable("slotsId") int slotsId) throws SlotsNotFoundException {
		LOG.info("SlotsController | deleteSlots() | invoked with SlotsId = {}", slotsId);
		try {
			if (slotsId > 0) {
				slotService.deleteSlots(slotsId);
				LOG.info("SlotsController | deleteSlots() | Deleted SlotsID = {}", slotsId);
			} else {
				throw new SlotsNotFoundException("Slots not found for SlotsId = {}" + slotsId);
			}
		} catch (SlotsNotFoundException ex) {
			LOG.error("SlotsController | deleteSlots()| SlotsNotFoundException = {}", ex.getMessage());
			throw new SlotsNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("SlotsController | deleteSlots()| Exception = {}" + ex.getMessage());
		}
		LOG.info("SlotsController | deleteSlots() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/fetch-all-slots", method = RequestMethod.GET)
	public List<Slots> fetchAllSlots() {
		LOG.info("SlotsController | fetchAllSlots() | invoked");
		List<Slots> slotsList = new ArrayList<Slots>();
		try {
			slotsList = slotService.fetchAllSlots();
			LOG.info("SlotsController | fetchAllSlots() | AllSlotsList = {}", slotsList);
		} catch (Exception ex) {
			LOG.error("SlotsController | fetchAllSlots()| Exception = {}", ex.toString());
		}
		LOG.info("SlotsController | fetchAllSlots() | terminated");
		return slotsList;
	}

	// get record by id
	@RequestMapping(value = "/fetch-slots/{slotsId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchSlotsById(@PathVariable("slotsId") int slotsId) throws SlotsNotFoundException {
		LOG.info("SlotsController | fetchSlotsById() | invoked with SlotsId = {}", slotsId);
		Object slotsInfo = null;
		try {
			if (slotsId > 0) {
				slotsInfo = slotService.fetchSlotsById(slotsId);
				LOG.info("SlotsController | fetchSlotsById() | SlotsById = {}", slotsInfo);
			} else {
				throw new SlotsNotFoundException("Slots not found for SlotsId = " + slotsId);
			}
		} catch (SlotsNotFoundException ex) {
			LOG.error("SlotsController | fetchSlotsById()| SlotsNotFoundException = {}", ex.getMessage());
			throw new SlotsNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("SlotsController | fetchSlotsById()| Exception = {}", ex.getMessage());
		}
		LOG.info("SlotsController | fetchSlotsById() | terminated");
		return new ResponseEntity<Object>(slotsInfo, HttpStatus.OK);
	}
}
