/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.controller;


import com.eventui.customer.tracking.club.customertrackerclub.exceptions.NotFoundException;
import com.eventui.customer.tracking.club.customertrackerclub.model.InvitationDto;
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
@RequestMapping("/api/invitations")
@PreAuthorize("hasRole('ROLE_USER')")
public class InvitationController {

    @Autowired
    @Qualifier(value = "invitationService")
    IGenericService<InvitationDto> invitationServicie;
    
    @Autowired
    RegistrationReservationService registrationReservationService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<InvitationDto> listInvitations() {
        System.out.println("Enter reservation");
        return Optional.ofNullable(invitationServicie.findAll())
                .orElseThrow(() ->new NotFoundException("No found"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public InvitationDto getInvitation(@Valid @NotNull @PathVariable("id") final String id) {
        return Optional.ofNullable(invitationServicie.findOne(id))
                .orElseThrow(() ->new NotFoundException("No found"));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public InvitationDto createInvitation(@Valid @NotNull @RequestBody final InvitationDto invitationDto) {
        return invitationServicie.create(invitationDto);
    }
    
    @RequestMapping(value = "commerce/{commerceId}/sponsor/{id}", method = RequestMethod.POST)
    @ResponseBody
    public InvitationDto addInvitation(@Valid @NotNull @PathVariable("commerceId") final Integer commerceId,
            @Valid @NotNull @PathVariable("id") final Integer sponsorId) {
        return null; //registrationReservationService.addReservation(sponsorId, commerceId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public InvitationDto updateInvitation(@Valid @NotNull @PathVariable("id") final String id,
            @Valid @NotNull @RequestBody final InvitationDto invitationDto) {
        return invitationServicie.update(invitationDto);
    }
}
