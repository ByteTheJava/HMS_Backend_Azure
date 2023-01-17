package com.app.hospital.slots.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.slots.model.Slots;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Integer> {

}
