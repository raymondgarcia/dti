package com.eventui.customer.tracking.club.customertrackerclub.dao;

import com.eventui.customer.tracking.club.customertrackerclub.entity.Commerce;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommerceRepository extends MongoRepository<Commerce, String> {
}
