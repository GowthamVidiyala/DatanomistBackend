package com.doc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT_DETAILS")
public class Patient 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="NAME")
	private String name;

	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAILID")
	private String emailId;
	

	@Column(name="PHONENUMBERS")
	private String phoneNumbers;

	@Column(name="AGE")
	private int age;

	@Column(name="GENDER")
	private String gender;

	@Column(name="STREET")
	private String street;

	@Column(name="AREA")
	private String area;

	@Column(name="CITY")
	private String city;

	@Column(name="STATE")
	private String state;

	@Column(name="MEDICALHISTORY")
	private String medicalHistory;
	
			
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
		
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", password=" + password + ", emailId=" + emailId
				+ ", phoneNumbers=" + phoneNumbers + ", age=" + age + ", gender=" + gender + ", street=" + street
				+ ", area=" + area + ", city=" + city + ", state=" + state + ", medicalHistory=" + medicalHistory + "]";
	}

		
}
