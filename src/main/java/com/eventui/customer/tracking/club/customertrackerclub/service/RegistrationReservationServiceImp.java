/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.enums.Status;
import com.eventui.customer.tracking.club.customertrackerclub.enums.Type;
import com.eventui.customer.tracking.club.customertrackerclub.model.CommerceDto;
import com.eventui.customer.tracking.club.customertrackerclub.model.PersonDto;
import com.eventui.customer.tracking.club.customertrackerclub.model.ReservationDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author raymondgarcia
 */
@Service
public class RegistrationReservationServiceImp implements RegistrationReservationService {
    
    @Autowired
    @Qualifier(value = "reservationService")
    IGenericService<ReservationDto> reservationService;
    
    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Transactional
    @Override
    public ReservationDto addReservation(String sponsorId, String commerceId) {
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
    public ReservationDto addReservationVip(String sponsorId, String commerceId) {
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
