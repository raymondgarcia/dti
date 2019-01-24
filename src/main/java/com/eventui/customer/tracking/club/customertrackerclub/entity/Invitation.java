package com.eventui.customer.tracking.club.customertrackerclub.entity;

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
@Table(name = "invitation")
public class Invitation implements Serializable {

    public enum Type {
        VIP, GENERAL
    }

    public enum Status {
        VALID, ACTIVE, VOID
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;

    @JoinColumn(name = "commerce_id")
    @OneToOne
    private Commerce commerce;

    @JoinColumn(name = "sponsor_id")
    @OneToOne
    private Person sponsor;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String Status;

    @Column(name = "type")
    private String type;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "person_invitation",
            joinColumns = @JoinColumn(name = "invitation_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> persons;

    public Invitation() {
    }

    public Invitation(String numero, Commerce commerce, Person sponsor, Date date, String status, String type) {
        super();
        this.number = numero;
        this.commerce = commerce;
        this.sponsor = sponsor;
        this.date = date;
        Status = status;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
        return "Invitation [id=" + id + ", numero=" + number + ", commerce=" + commerce + ", sponsor=" + sponsor
                + ", date=" + date + ", Status=" + Status + ", type=" + type + "]";
    }

}
