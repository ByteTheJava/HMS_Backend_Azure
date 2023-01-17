package com.app.hospital.call.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.call.model.CallStatus;

@Repository
public interface CallStatusRepository extends JpaRepository<CallStatus, Integer> {

}
