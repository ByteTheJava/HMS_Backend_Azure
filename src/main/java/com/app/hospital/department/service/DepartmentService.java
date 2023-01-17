package com.app.hospital.department.service;

import java.util.List;

import com.app.hospital.department.exception.DepartmentNotFoundException;
import com.app.hospital.department.model.Department;

public interface DepartmentService {
	Object saveDepartment(Department department);
	Object updateDepartment(Department department, int departmentId) throws DepartmentNotFoundException;
	void deleteDepartment(int departmentId) throws DepartmentNotFoundException;
	List<Department> fetchAllDepartment();
	Object fetchDepartmentById(int departmentId) throws DepartmentNotFoundException;
}
