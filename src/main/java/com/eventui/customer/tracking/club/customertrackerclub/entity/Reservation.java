package com.eventui.customer.tracking.club.customertrackerclub.entity;

import com.eventui.customer.tracking.club.customertrackerclub.enums.Type;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    public enum Status {
        VALID, ACTIVE, VOID
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reservation_number")
    private String reservationNumber;

    @OneToOne
    @JoinColumn(name = "commerce_id")
    private Commerce commerce;

    @OneToOne
    @JoinColumn(name = "sponsor_id")
    private Person sponsor;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private Status status;

    @Column(name = "type")
    private Type type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "person_reservation",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> persons;

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

    public Person getSponsor() {
        return sponsor;
    }

    public void setSponsor(Person sponsor) {
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

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
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
        return "Reservation [id=" + id + ", reservationNumber=" + reservationNumber + ", commerce=" + commerce
                + ", promotor=" + sponsor + ", date=" + date + ", status=" + status + ", type=" + type + "]";
    }

}
