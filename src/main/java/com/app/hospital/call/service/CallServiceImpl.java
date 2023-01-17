package com.app.hospital.call.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.call.exception.CallStatusNotFoundException;
import com.app.hospital.call.model.CallStatus;
import com.app.hospital.call.repository.CallStatusRepository;

@Service
public class CallServiceImpl implements CallService {
	private static final Logger LOG = LoggerFactory.getLogger(CallServiceImpl.class);

	@Autowired
	private CallStatusRepository callStatusRepository;

	@Override
	public Object saveCallStatus(CallStatus callStatus) {
		LOG.info("CallServiceImpl | saveCallStatus() | invoked");
		Object callStatusInfo = callStatusRepository.save(callStatus);
		LOG.info("CallServiceImpl | saveCallStatus() | terminated");
		return callStatusInfo;
	}

	@Override
	public Object updateCallStatus(CallStatus callStatus, int callStatusId) throws CallStatusNotFoundException {
		Object responseCallStatusInfo = null;
		LOG.info("CallServiceImpl | updateCallStatus() | invoked");
		CallStatus callStatusInfo = callStatusRepository.findById(callStatusId).orElseThrow(
				() -> new CallStatusNotFoundException("CallStatus not found for CallStatusId = " + callStatusId));
		callStatusInfo.setCallStatusValue(callStatus.getCallStatusValue());
		responseCallStatusInfo = callStatusRepository.save(callStatusInfo);
		LOG.info("CallServiceImpl | updateCallStatus() | terminated");
		return responseCallStatusInfo;
	}

	@Override
	public void deleteCallStatus(int callStatusId) throws CallStatusNotFoundException {
		LOG.info("CallServiceImpl | deleteCallStatus() | invoked");
		callStatusRepository.findById(callStatusId).orElseThrow(
				() -> new CallStatusNotFoundException("CallStatus not found for CallStatusId = " + callStatusId));
		callStatusRepository.deleteById(callStatusId);
		LOG.info("CallServiceImpl | deleteCallStatus() | terminated");
	}

	@Override
	public List<CallStatus> fetchAllCallStatus() {
		LOG.info("CallServiceImpl | fetchAllCallStatus() | invoked");
		List<CallStatus> callStatusList = new ArrayList<CallStatus>();
		callStatusList = callStatusRepository.findAll();
		LOG.info("CallServiceImpl | fetchAllCallStatus() | terminated");
		return callStatusList;
	}

	@Override
	public Object fetchCallStatusById(int callStatusId) throws CallStatusNotFoundException {
		LOG.info("CallServiceImpl | fetchCallStatusById() | invoked");
		Object callStatusInfo = callStatusRepository.findById(callStatusId).orElseThrow(
				() -> new CallStatusNotFoundException("CallStatus not found for CallStatusId = " + callStatusId));
		LOG.info("CallServiceImpl | fetchCallStatusById() | terminated");
		return callStatusInfo;
	}
}
