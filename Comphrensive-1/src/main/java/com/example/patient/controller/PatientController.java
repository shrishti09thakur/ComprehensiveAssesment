package com.example.patient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patient.entity.Patient;
import com.example.patient.exception.ResourceNotFoundException;
import com.example.patient.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	
	// get all employees
	@GetMapping("/patient")
	public List<Patient> getAllPatient(){
		return patientRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/patient")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	// get employee by id rest api
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
		return ResponseEntity.ok(patient);
	}
	
	// update employee rest api
	
	@PutMapping("/patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails){
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		patient.setName(patientDetails.getName());
		patient.setVisiteddoctor(patientDetails.getVisiteddoctor());
		patient.setDateofvisit(patientDetails.getDateofvisit());
		patient.setPrescription(patientDetails.getPrescription());
		
		Patient updatedPAtient = patientRepository.save(patient);
		return ResponseEntity.ok(updatedPAtient);
	}
	
	// delete employee rest api
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
		
		patientRepository.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
