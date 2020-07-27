package com.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doc.dao.PatientRepository;
import com.doc.entity.Patient;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public Patient savePatient(Patient patient)
	{
		patient.setPassword(bcryptEncoder.encode(patient.getPassword()));
		try {
		System.out.println(patient.getPassword());
		patient= patientRepo.save(patient);
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
		return patient;		

	}

	public List<Patient> saveAllPatients(List<Patient> patients)
	{
		return patientRepo.saveAll(patients);		
	}

	public List<Patient> getPatients()
	{
		return patientRepo.findAll();		
	}

	public Patient getPatientsById(int id)
	{
		return patientRepo.findById(id).orElse(null);		
	}

	public String delete(int id)
	{
		patientRepo.deleteById(id);
		return "Removed "+id+" from Database";	
	}

	public void deleteAll()
	{
		patientRepo.deleteAll();
	}

	public Patient getPatientsByName(String name)
	{
		return patientRepo.findByName(name);		
	}
	
	public Patient getPatientsByNameAndPassword(String name,String password)
	{
		return patientRepo.findByNameAndPassword(name,password);		
	}

	public Patient updatePatient(Patient patient)
	{
		Patient existingPatient = patientRepo.findById(patient.getId()).orElse(null);
		existingPatient.setMedicalHistory(patient.getMedicalHistory());
		existingPatient.setPhoneNumbers(patient.getPhoneNumbers());
		existingPatient.setEmailId(patient.getEmailId());
		return patientRepo.save(existingPatient);
	}


}
