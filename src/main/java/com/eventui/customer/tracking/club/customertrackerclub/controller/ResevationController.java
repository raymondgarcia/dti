/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.controller;


import com.eventui.customer.tracking.club.customertrackerclub.exceptions.NotFoundException;
import com.eventui.customer.tracking.club.customertrackerclub.model.ReservationDto;
import com.eventui.customer.tracking.club.customertrackerclub.service.IGenericService;
import com.eventui.customer.tracking.club.customertrackerclub.service.RegistrationReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author raymondgarcia
 */
@RestController
@RequestMapping("/api/reservations")
@PreAuthorize("hasRole('ROLE_USER')")
public class ResevationController {

    @Autowired
    @Qualifier(value = "reservationService")
    IGenericService<ReservationDto> reservationService;
    
    @Autowired
    RegistrationReservationService registrationReservationService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<ReservationDto> listReservations() {
        System.out.println("Enter reservation");
        return Optional.ofNullable(reservationService.findAll())
                .orElseThrow(() ->new NotFoundException("No found"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ReservationDto gerReservation(@Valid @NotNull @PathVariable("id") final String id) {
        return Optional.ofNullable(reservationService.findOne(id))
                 .orElseThrow(() ->new NotFoundException("No found"));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ReservationDto createReservation(@Valid @NotNull @RequestBody final ReservationDto reservationDto) {
        return reservationService.create(reservationDto);
    }
    
    @RequestMapping(value = "commerce/{commerceId}/sponsor/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ReservationDto addReservation(@Valid @NotNull @PathVariable("commerceId") final String commerceId,
            @Valid @NotNull @PathVariable("id") final String sponsorId) {
        return registrationReservationService.addReservation(sponsorId, commerceId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ReservationDto updateReservation(@Valid @NotNull @PathVariable("id") final String id,
            @Valid @NotNull @RequestBody final ReservationDto reservationDto) {
        return reservationService.update(reservationDto);
    }
}
