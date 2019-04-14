package com.eventui.customer.tracking.club.customertrackerclub.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class Commerce implements Serializable {
    
        public enum Status {
		VALID, ACTIVE, VOID
	}
	
	@Id
	@Column(name="id")
	private ObjectId id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private Status status;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="location")
	private String location;
	
	
	@Column(name="reference")
	private String reference;
	
	
	public Commerce(String description, Status status, Date date, String location, String reference) {
		super();
		this.description = description;
		this.status = status;
		this.date = date;
		this.location = location;
		this.reference = reference;
	}
	


	public Commerce() {
		super();
	}




	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	@Override
	public String toString() {
		return "Commerce [id=" + id + ", description=" + description + ", status=" + status + ", date=" + date
				+ ", location=" + location + ", reference=" + reference + "]";
	}
	
	
	

}
