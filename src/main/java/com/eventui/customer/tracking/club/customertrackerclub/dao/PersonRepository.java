package com.eventui.customer.tracking.club.customertrackerclub.dao;

import com.eventui.customer.tracking.club.customertrackerclub.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
