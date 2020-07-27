package com.doc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doc.entity.Patient;

//@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{
	
	Patient findByName(String name);

	Patient findByNameAndPassword(String name, String password);

}
