/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;

import com.eventui.customer.tracking.club.customertrackerclub.dao.IGenericDao;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Person;
import com.eventui.customer.tracking.club.customertrackerclub.model.PersonDto;
import java.util.Collection;
import java.util.Date;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raymondgarcia
 */
@Service
public class PersonService implements IGenericService<PersonDto> {

    private IGenericDao<Person> dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    
    private final MapperFacade mapper = mapperFactory.getMapperFacade();

    @Autowired
    public void setDao(IGenericDao<Person> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Person.class);
    }

    @Override
    @Transactional
    public PersonDto findOne(int id) {
        return mapper.map(dao.findOne(id), PersonDto.class);
    }

    @Override
    @Transactional
    public Collection<PersonDto> findAll() {
        return mapper.mapAsList(dao.findAll(), PersonDto.class);
    }

    @Override
    @Transactional
    public PersonDto create(PersonDto entity) {
        Person person = mapper.map(entity, Person.class);
        person.setStatus(Person.Status.VALID);
        person.setDateStatus(new Date());
        dao.create(person);
        return mapper.map(person, PersonDto.class);
    }

    @Override
    @Transactional
    public PersonDto update(PersonDto entity) {
        Person person = mapper.map(entity, Person.class);
        person.setDateStatus(new Date());
        dao.update(person);
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
    public void deleteById(int entityId) {
        dao.deleteById(entityId);
    }

}
