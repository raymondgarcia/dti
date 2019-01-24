/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.IGenericDao;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Person;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Reservation;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Status;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Type;
import com.eventui.customer.tracking.club.customertrackerclub.model.CommerceDto;
import com.eventui.customer.tracking.club.customertrackerclub.model.PersonDto;
import com.eventui.customer.tracking.club.customertrackerclub.model.ReservationDto;
import java.util.Date;
import java.util.UUID;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raymondgarcia
 */
@Service
public class RegistrationReservationServiceImp implements RegistrationReservationService {

    @Autowired
    private IGenericDao<Reservation> dao;
    
    @Autowired
    @Qualifier(value = "reservationService")
    IGenericService<ReservationDto> reservationService;
    
    @Autowired
    @Qualifier(value = "personService")
    IGenericService<PersonDto> personService;

    @Autowired
    private IGenericDao<Person> persoDao;
    
    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
   
    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Transactional
    @Override
    public ReservationDto addReservation(Integer sponsorId, Integer commerceId) {
        ReservationDto reservation = new ReservationDto();
        reservation.setStatus(Status.VALID);
        reservation.setType(Type.GENERAL);
        reservation.setDate(new Date());
        reservation.setSponsor(new PersonDto().id(sponsorId));
        reservation.setCommerce(new CommerceDto().id(commerceId));
        reservation.setReservationNumber(generate(reservation));
        reservation = reservationService.create(reservation);
        return reservationService.findOne(reservation.getId());
    }

    private String generate(ReservationDto reservation) {
        return UUID.randomUUID().toString();
    }

    @Override
    public ReservationDto addReservationVip(Integer sponsorId, Integer commerceId) {
        ReservationDto reservation = new ReservationDto();
        reservation.setStatus(Status.VALID);
        reservation.setType(Type.VIP);
        reservation.setDate(new Date());
        reservation.setSponsor(new PersonDto().id(sponsorId));
        reservation.setCommerce(new CommerceDto().id(commerceId));
        reservation.setReservationNumber(generate(reservation));
        reservation = reservationService.create(reservation);
        return reservationService.findOne(reservation.getId());
    }

}
