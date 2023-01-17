package com.app.hospital.appointmentStatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.appointmentStatus.model.AppointmentStatus;

@Repository
public interface AppointmentStatusRepository extends JpaRepository<AppointmentStatus, Integer> {

}
