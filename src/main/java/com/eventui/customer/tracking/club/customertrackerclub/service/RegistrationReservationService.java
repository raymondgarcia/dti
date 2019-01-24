/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;

import com.eventui.customer.tracking.club.customertrackerclub.model.ReservationDto;

/**
 *
 * @author raymondgarcia
 */
public interface RegistrationReservationService {
     public ReservationDto addReservation(Integer personId,Integer commerceId);
     public ReservationDto addReservationVip(Integer personId,Integer commerceId);
}
