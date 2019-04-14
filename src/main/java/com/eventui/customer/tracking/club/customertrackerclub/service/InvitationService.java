/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.InvitationRepository;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Invitation;
import com.eventui.customer.tracking.club.customertrackerclub.model.InvitationDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 *
 * @author raymondgarcia
 */
@Service
public class InvitationService implements IGenericService<InvitationDto> {

    @Autowired
    private InvitationRepository dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Override
    @Transactional
    public InvitationDto findOne(String id) {
        return mapper.map(dao.findById(id), InvitationDto.class);
    }

    @Override
    @Transactional
    public Collection<InvitationDto> findAll() {
        return mapper.mapAsList(dao.findAll(), InvitationDto.class);
    }

    @Override
    @Transactional
    public InvitationDto create(InvitationDto entity) {
        Invitation reservation = mapper.map(entity, Invitation.class);
        reservation.setId(ObjectId.get());
        dao.save(reservation);
        return mapper.map(reservation, InvitationDto.class);
    }

    @Override
    @Transactional
    public InvitationDto update(InvitationDto entity) {
        Invitation reservation = mapper.map(entity, Invitation.class);
        dao.save(reservation);
        return mapper.map(reservation, InvitationDto.class);
    }

    @Override
    @Transactional
    public InvitationDto delete(InvitationDto entity) {
        Invitation reservation = mapper.map(entity, Invitation.class);
        dao.delete(reservation);
        return mapper.map(reservation, InvitationDto.class);
    }

    @Override
    @Transactional
    public void deleteById(String entityId) {
        dao.deleteById(entityId);
    }

}
