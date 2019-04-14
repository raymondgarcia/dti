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
     public ReservationDto addReservation(String personId,String commerceId);
     public ReservationDto addReservationVip(String personId,String commerceId);
}
