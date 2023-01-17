package com.app.hospital.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.schedule.model.ScheduleType;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleType, Integer>{

}
