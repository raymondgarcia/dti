package com.eventui.customer.tracking.club.customertrackerclub.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "persons")
public class Person implements Serializable{
	
	public enum Status {
		VALID, ACTIVE, VOID
	}
	
	
	@Id
	@Column(name="id")
	private ObjectId id;
		
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="email")
	private String email;
	
	@Column(name="status")
	private Status status;
		
	@Column(name="date_status")
	private Date dateStatus;


	public Person() {
		super();
	}


	public Person(final String name,final String surname,final String sex,final Date birthDate,final String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.birthDate = birthDate;
		this.email = email;
	}


	public String getId() {
		return id.toHexString();
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Date getDateStatus() {
		return dateStatus;
	}


	public void setDateStatus(Date dateStatus) {
		this.dateStatus = dateStatus;
	}

	/*public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}*/


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", sex=" + sex + ", birthDate="
				+ birthDate + ", email=" + email + ", status=" + status + ", dateStatus=" + dateStatus + "]";
	}
	
	
	

}
