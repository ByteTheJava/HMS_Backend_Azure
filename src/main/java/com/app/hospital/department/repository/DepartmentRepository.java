package com.app.hospital.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.department.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
