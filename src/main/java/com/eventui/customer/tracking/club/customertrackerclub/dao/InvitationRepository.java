package com.eventui.customer.tracking.club.customertrackerclub.dao;

import com.eventui.customer.tracking.club.customertrackerclub.entity.Invitation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvitationRepository extends MongoRepository<Invitation, String> {
}
