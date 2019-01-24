package com.eventui.customer.tracking.club.customertrackerclub.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person implements Serializable{
	
	public enum Status {
		VALID, ACTIVE, VOID
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
		
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
