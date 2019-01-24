package com.eventui.customer.tracking.club.customertrackerclub.entity;

import com.eventui.customer.tracking.club.customertrackerclub.enums.Roles;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "user")
public class User implements Serializable {

    public enum Status {
        VALID, ACTIVE, VOID
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int id;

    @Column(name = "rolId")
    private Roles rol;

    @JoinColumn(name = "personId")
    @OneToOne
    private Person person;

    @Column(name = "password")
    private String password;
    
    @Column(name = "username")
    private String username;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private Status status;

    public User() {
        super();
    }

    public User(String username, String password, Roles rol) {
        this.rol = rol;
        this.password = password;
        this.username = username;
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
        return "User{" + "id=" + id + ", rol=" + rol + ", person=" + person + ", password=" + password + ", username=" + username + ", date=" + date + ", status=" + status + '}';
    }
    
    

}
