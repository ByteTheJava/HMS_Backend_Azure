package com.app.hospital.department.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.department.exception.DepartmentNotFoundException;
import com.app.hospital.department.model.Department;
import com.app.hospital.department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private static final Logger LOG = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Object saveDepartment(Department department) {
		LOG.info("DepartmentServiceImpl | addDepartment() | invoked");
		Object DepartmentInfo = departmentRepository.save(department);
		LOG.info("DepartmentServiceImpl | addDepartment() | terminated");
		return DepartmentInfo;
	}

	@Override
	public Object updateDepartment(Department department, int departmentId) throws DepartmentNotFoundException {
		Object responseDepartmentInfo = null;
		LOG.info("DepartmentServiceImpl | updateDepartment() | invoked");
		Department departmentInfo = departmentRepository.findById(departmentId).orElseThrow(
				() -> new DepartmentNotFoundException("Department not found for DepartmentId = " + departmentId));
		departmentInfo.setDepartmentName(department.getDepartmentName());
		responseDepartmentInfo = departmentRepository.save(departmentInfo);
		LOG.info("DepartmentServiceImpl | updateDepartment() | terminated");
		return responseDepartmentInfo;
	}

	@Override
	public void deleteDepartment(int departmentId) throws DepartmentNotFoundException {
		LOG.info("DepartmentServiceImpl | deleteDepartment() | invoked");
		departmentRepository.findById(departmentId).orElseThrow(
				() -> new DepartmentNotFoundException("Department not found for DepartmentId = " + departmentId));
		departmentRepository.deleteById(departmentId);
		LOG.info("DepartmentServiceImpl | deleteDepartment() | terminated");
	}

	@Override
	public List<Department> fetchAllDepartment() {
		LOG.info("DepartmentServiceImpl | fetchAllDepartment() | invoked");
		List<Department> departmentList = new ArrayList<Department>();
		departmentList = departmentRepository.findAll();
		LOG.info("DepartmentServiceImpl | fetchAllDepartment() | terminated");
		return departmentList;
	}

	@Override
	public Object fetchDepartmentById(int departmentId) throws DepartmentNotFoundException {
		LOG.info("DepartmentServiceImpl | fetchDepartmentById() | invoked");
		Object departmentInfo = departmentRepository.findById(departmentId).orElseThrow(
				() -> new DepartmentNotFoundException("Department not found for DepartmentId = " + departmentId));
		LOG.info("DepartmentServiceImpl | fetchDepartmentById() | terminated");
		return departmentInfo;
	}
}
