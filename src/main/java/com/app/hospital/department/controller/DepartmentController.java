package com.app.hospital.department.controller;

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

import com.app.hospital.department.exception.DepartmentNotFoundException;
import com.app.hospital.department.model.Department;
import com.app.hospital.department.service.DepartmentService;

@RestController
public class DepartmentController {
	private static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/department", method = RequestMethod.POST)
	public ResponseEntity<Object> saveDepartment(@Valid @RequestBody Department department) {
		LOG.info("DepartmentController | saveDepartment() | invoked");
		Object departmentInfo = null;
		try {
			departmentInfo = departmentService.saveDepartment(department);
			LOG.info("DepartmentController | saveDepartment() | AgeInfo = {}", departmentInfo);
		} catch (Exception ex) {
			LOG.error("DepartmentController | saveDepartment()| Exception = {}", ex.getMessage());
		}
		LOG.info("DepartmentController | saveDepartment() | terminated");
		return new ResponseEntity<Object>(departmentInfo, HttpStatus.OK);
	}

	// edit/update/modify
	@RequestMapping(value = "/department/{departmentId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateDepartment(@Valid @RequestBody Department department,
			@PathVariable("departmentId") int departmentId) throws DepartmentNotFoundException {
		LOG.info("DepartmentController | updateDepartment() | invoked with DepartmentId = {}", departmentId);
		Object departmentInfo = null;
		try {
			if (departmentId > 0) {
				departmentInfo = departmentService.updateDepartment(department, departmentId);
				LOG.info("DepartmentController | updateDepartment() | DepartmentInfo = {}", departmentInfo);
			} else {
				throw new DepartmentNotFoundException("Department not found for DepartmentId = {}" + departmentId);
			}
		} catch (DepartmentNotFoundException ex) {
			LOG.error("DepartmentController | updateDepartment()| DepartmentNotFoundException = {}", ex.getMessage());
			throw new DepartmentNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("DepartmentController | updateDepartment()| Exception = {}" + ex.getMessage());
		}
		LOG.info("DepartmentController | updateDepartment() | terminated");
		return new ResponseEntity<Object>(departmentInfo, HttpStatus.OK);
	}

	// delete/remove
	@RequestMapping(value = "/department/{departmentId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteDepartment(@PathVariable("departmentId") int departmentId)
			throws DepartmentNotFoundException {
		LOG.info("DepartmentController | deleteDepartment() | invoked with DepartmentId = {}", departmentId);
		try {
			if (departmentId > 0) {
				departmentService.deleteDepartment(departmentId);
				LOG.info("DepartmentController | deleteDepartment() | Deleted DepartmentId = {}", departmentId);
			} else {
				throw new DepartmentNotFoundException("Department not found for DepartmentId = {}" + departmentId);
			}
		} catch (DepartmentNotFoundException ex) {
			LOG.error("DepartmentController | deleteDepartment()| DepartmentNotFoundException = {}", ex.getMessage());
			throw new DepartmentNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("DepartmentController | deleteDepartment()| Exception = {}" + ex.getMessage());
		}
		LOG.info("DepartmentController | deleteDepartment() | terminated");
		return new ResponseEntity<Object>("Deleted Successfully", HttpStatus.OK);
	}

	// fetchList
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public List<Department> fetchAllDepartment() {
		LOG.info("DepartmentController | fetchAllDepartment() | invoked");
		List<Department> departmentList = new ArrayList<Department>();
		try {
			departmentList = departmentService.fetchAllDepartment();
			LOG.info("DepartmentController | fetchAllDepartment() | AllDepartmentList = {}", departmentList);
		} catch (Exception ex) {
			LOG.error("DepartmentController | fetchAllDepartment()| Exception = {}", ex.toString());
		}
		LOG.info("DepartmentController | fetchAllDepartment() | terminated");
		return departmentList;
	}

	// get record by id
	@RequestMapping(value = "/department/{departmentId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchDepartmentById(@PathVariable("departmentId") int departmentId)
			throws DepartmentNotFoundException {
		LOG.info("DepartmentController | fetchDepartmentById() | invoked with DepartmentId = {}", departmentId);
		Object departmentInfo = null;
		try {
			if (departmentId > 0) {
				departmentInfo = departmentService.fetchDepartmentById(departmentId);
				LOG.info("DepartmentController | fetchDepartmentById() | DepartmentInfo = {}", departmentInfo);
			} else {
				throw new DepartmentNotFoundException("Department not found for DepartmentId = " + departmentId);
			}
		} catch (DepartmentNotFoundException ex) {
			LOG.error("DepartmentController | fetchDepartmentById()| DepartmentNotFoundException = {}", ex.getMessage());
			throw new DepartmentNotFoundException(ex);
		} catch (Exception ex) {
			LOG.error("DepartmentController | fetchDepartmentById()| Exception = {}", ex.getMessage());
		}
		LOG.info("DepartmentController | fetchDepartmentById() | terminated");
		return new ResponseEntity<Object>(departmentInfo, HttpStatus.OK);
	}
}
