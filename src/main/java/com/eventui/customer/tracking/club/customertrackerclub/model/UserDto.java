package com.eventui.customer.tracking.club.customertrackerclub.model;

import com.eventui.customer.tracking.club.customertrackerclub.entity.Person;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Roles;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Status;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class UserDto implements Serializable {
    
    @JsonProperty("id")
    private int id;

    @JsonProperty("rol")
    private Roles rol;

    @JsonProperty("person")
    private Person person;
    
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @JsonProperty("status")
    private Status status;

    public UserDto() {
        super();
    }

    public UserDto(Roles rol, Person person, String password) {
        super();
        this.rol = rol;
        this.person = person;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", rol=" + rol + ", person=" + person + ", password=" + password + ", date=" + date
                + "]";
    }

}
