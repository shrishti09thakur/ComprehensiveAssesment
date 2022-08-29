package com.example.patient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.patient.entity.Patient;
import com.example.patient.repository.PatientRepository;

@SpringBootTest
class Comphrensive1ApplicationTests {
	@Autowired
    PatientRepository patrepo;
	@Test
	void contextLoads() {
		Patient pat=new Patient();
		pat.setId(1L);
		pat.setName("Lily");
		pat.setAge("33");
		pat.setDateofvisit("2022-09-21");
		pat.setVisiteddoctor("shalin");
		pat.setPrescription("PCM");
		
		patrepo.save(pat);
		assertNotNull(patrepo.findById(2L).get());
				
	}
	@Test
	public void testReadAll() {
		List<Patient> list=patrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	@Test
	public void deletepatient() {
		patrepo.deleteById(3L);
		assertThat(patrepo.existsById(3L)).isFalse();
	}
	}


