package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

@SpringBootTest
class ComphrensiveApplicationTests {
	@Autowired
	DoctorRepository docrepo;

	@Test
	void contextLoads() {
		Doctor doc=new Doctor();
		doc.setId(1L);
		doc.setName("Dipti");
		doc.setAge("33");
		doc.setGender("Female");
		doc.setPatientattended(1);
		doc.setSpecialistfields("Lungs");
		docrepo.save(doc);
		assertNotNull(docrepo.findById(2L).get());
				
	}
	@Test
	public void testReadAll() {
		List<Doctor> list=docrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	@Test
	public void deleteDoctor() {
		docrepo.deleteById(4L);
		assertThat(docrepo.existsById(4L)).isFalse();
	}

}
