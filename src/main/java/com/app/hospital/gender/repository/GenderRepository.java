package com.app.hospital.gender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hospital.gender.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>{

}
