package com.app.hospital.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.patient.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
