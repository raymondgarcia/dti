/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.IGenericDao;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Invitation;
import com.eventui.customer.tracking.club.customertrackerclub.model.InvitationDto;
import java.util.Collection;
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
public class InvitationService implements IGenericService<InvitationDto> {

    private IGenericDao<Invitation> dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Autowired
    public void setDao(IGenericDao<Invitation> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Invitation.class);
    }

    @Override
    @Transactional
    public InvitationDto findOne(int id) {
        return mapper.map(dao.findOne(id), InvitationDto.class);
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
        dao.create(reservation);
        return mapper.map(reservation, InvitationDto.class);
    }

    @Override
    @Transactional
    public InvitationDto update(InvitationDto entity) {
        Invitation reservation = mapper.map(entity, Invitation.class);
        dao.update(reservation);
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
    public void deleteById(int entityId) {
        dao.deleteById(entityId);
    }

}
