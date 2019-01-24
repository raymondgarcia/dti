/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.model;


import com.eventui.customer.tracking.club.customertrackerclub.entity.Person;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Status;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raymondgarcia
 */
public class InvitationDto implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("reservationNumber")
    private String reservationNumber;

    @JsonProperty("commerce")
    private CommerceDto commerce;

    @JsonProperty("sponsor")
    private PersonDto sponsor;

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("type")
    private Type type;
    
    @JsonProperty("persons")
    private List<Person> persons;

    public InvitationDto() {
    }

    public InvitationDto(String reservationNumber, CommerceDto commerce, PersonDto sponsor, Date date, Status status, Type type) {
        this.reservationNumber = reservationNumber;
        this.commerce = commerce;
        this.sponsor = sponsor;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public CommerceDto getCommerce() {
        return commerce;
    }

    public void setCommerce(CommerceDto commerce) {
        this.commerce = commerce;
    }

    public PersonDto getSponsor() {
        return sponsor;
    }

    public void setSponsor(PersonDto sponsor) {
        this.sponsor = sponsor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "ReservationDto{" + "id=" + id + ", reservationNumber=" + reservationNumber + ", commerce=" + commerce + ", sponsor=" + sponsor + ", date=" + date + ", status=" + status + ", type=" + type + '}';
    }

}
