/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;

import com.eventui.customer.tracking.club.customertrackerclub.dao.PersonRepository;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Person;
import com.eventui.customer.tracking.club.customertrackerclub.model.PersonDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author raymondgarcia
 */
@Service
public class PersonService implements IGenericService<PersonDto> {

    @Autowired
    private PersonRepository dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    
    private final MapperFacade mapper = mapperFactory.getMapperFacade();

    @Override
    @Transactional
    public PersonDto findOne(String id) {
        return mapper.map(dao.findById(id).get(), PersonDto.class);
    }

    @Override
    @Transactional
    public Collection<PersonDto> findAll() {
        System.out.println(dao.findAll());
        return mapper.mapAsList(dao.findAll(), PersonDto.class);
    }

    @Override
    @Transactional
    public PersonDto create(PersonDto entity) {
        Person person = mapper.map(entity, Person.class);
        person.setStatus(Person.Status.VALID);
        person.setDateStatus(new Date());
        person.setId(ObjectId.get());
        dao.save(person);
        return mapper.map(person, PersonDto.class);
    }

    @Override
    @Transactional
    public PersonDto update(PersonDto entity) {
        Person person = mapper.map(entity, Person.class);
        person.setDateStatus(new Date());
        dao.save(person);
        return mapper.map(person, PersonDto.class);
    }

    @Override
    @Transactional
    public PersonDto delete(PersonDto entity) {
        Person person = mapper.map(entity, Person.class);
        dao.delete(person);
        return mapper.map(person, PersonDto.class);
    }

    @Override
    @Transactional
    public void deleteById(String entityId) {
        dao.deleteById(entityId);
    }

}
