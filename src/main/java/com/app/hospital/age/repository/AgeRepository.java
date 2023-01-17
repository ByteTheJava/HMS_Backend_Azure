package com.app.hospital.age.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.age.model.Age;

@Repository
public interface AgeRepository extends JpaRepository<Age, Integer> {

}
