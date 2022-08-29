package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doc")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private String age;
	@Column(name="gender")
	private String gender;
	@Column(name="specialistfield")
	private String specialistfields;
	@Column(name="noofpatietnt")
	private Integer patientattended;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpecialistfields() {
		return specialistfields;
	}
	public void setSpecialistfields(String specialistfields) {
		this.specialistfields = specialistfields;
	}
	
	public Integer getPatientattended() {
		return patientattended;
	}
	public void setPatientattended(Integer patientattended) {
		this.patientattended = patientattended;
	}
	public Doctor(Long id, String name, String age, String gender, String specialistfields,Integer patientattended ) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialistfields = specialistfields;
		this.patientattended=patientattended;
	}
	
  public Doctor() {
	  super();
  }
}
