/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.CommerceRepository;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Commerce;
import com.eventui.customer.tracking.club.customertrackerclub.model.CommerceDto;
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
public class CommerceService implements IGenericService<CommerceDto> {

    @Autowired
    private CommerceRepository dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Override
    @Transactional
    public CommerceDto findOne(String id) {
        return mapper.map(dao.findById(id), CommerceDto.class);
    }

    @Override
    @Transactional
    public Collection<CommerceDto> findAll() {
        return mapper.mapAsList(dao.findAll(), CommerceDto.class);
    }

    @Override
    @Transactional
    public CommerceDto create(CommerceDto entity) {
        Commerce commerce = mapper.map(entity, Commerce.class);
        commerce.setId(ObjectId.get());
        dao.save(commerce);
        return mapper.map(commerce, CommerceDto.class);
    }

    @Override
    @Transactional
    public CommerceDto update(CommerceDto entity) {
        Commerce commerce = mapper.map(entity, Commerce.class);
        dao.save(commerce);
        return mapper.map(commerce, CommerceDto.class);
    }

    @Override
    @Transactional
    public CommerceDto delete(CommerceDto entity) {
        Commerce commerce = mapper.map(entity, Commerce.class);
        dao.delete(commerce);
        return mapper.map(commerce, CommerceDto.class);
    }

    @Override
    @Transactional
    public void deleteById(String entityId) {
        dao.deleteById(entityId);
    }

}
