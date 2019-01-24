/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;

import com.eventui.customer.tracking.club.customertrackerclub.dao.IGenericDao;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Reservation;
import com.eventui.customer.tracking.club.customertrackerclub.model.ReservationDto;
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
public class ReservationService implements IGenericService<ReservationDto> {

    private IGenericDao<Reservation> dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Autowired
    public void setDao(IGenericDao<Reservation> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Reservation.class);
    }

    @Override
    @Transactional
    public ReservationDto findOne(int id) {
        return mapper.map(dao.findOne(id), ReservationDto.class);
    }

    @Override
    @Transactional
    public Collection<ReservationDto> findAll() {
        return mapper.mapAsList(dao.findAll(), ReservationDto.class);
    }

    @Override
    @Transactional
    public ReservationDto create(ReservationDto entity) {
        Reservation reservation = mapper.map(entity, Reservation.class);
        dao.create(reservation);
        return mapper.map(reservation, ReservationDto.class);
    }

    @Override
    @Transactional
    public ReservationDto update(ReservationDto entity) {
        Reservation reservation = mapper.map(entity, Reservation.class);
        dao.update(reservation);
        return mapper.map(reservation, ReservationDto.class);
    }

    @Override
    @Transactional
    public ReservationDto delete(ReservationDto entity) {
        Reservation reservation = mapper.map(entity, Reservation.class);
        dao.delete(reservation);
        return mapper.map(reservation, ReservationDto.class);
    }

    @Override
    @Transactional
    public void deleteById(int entityId) {
        dao.deleteById(entityId);
    }

}
