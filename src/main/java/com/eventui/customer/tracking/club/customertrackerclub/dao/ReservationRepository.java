package com.eventui.customer.tracking.club.customertrackerclub.dao;

import com.eventui.customer.tracking.club.customertrackerclub.entity.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
}
