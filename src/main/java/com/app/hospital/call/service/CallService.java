package com.app.hospital.call.service;

import java.util.List;

import com.app.hospital.call.exception.CallStatusNotFoundException;
import com.app.hospital.call.model.CallStatus;

public interface CallService 
{
	Object saveCallStatus(CallStatus callStatus);
	Object updateCallStatus(CallStatus callStatus , int callStatusId) throws CallStatusNotFoundException;
	void deleteCallStatus(int callStatusId) throws CallStatusNotFoundException;
	List<CallStatus> fetchAllCallStatus();
	Object fetchCallStatusById(int callStatusId) throws CallStatusNotFoundException;
}
