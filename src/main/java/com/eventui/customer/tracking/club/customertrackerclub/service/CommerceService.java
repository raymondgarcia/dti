/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.IGenericDao;
import com.eventui.customer.tracking.club.customertrackerclub.entity.Commerce;
import com.eventui.customer.tracking.club.customertrackerclub.model.CommerceDto;
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
public class CommerceService implements IGenericService<CommerceDto> {

    private IGenericDao<Commerce> dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Autowired
    public void setDao(IGenericDao<Commerce> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Commerce.class);
    }

    @Override
    @Transactional
    public CommerceDto findOne(int id) {
        return mapper.map(dao.findOne(id), CommerceDto.class);
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
        dao.create(commerce);
        return mapper.map(commerce, CommerceDto.class);
    }

    @Override
    @Transactional
    public CommerceDto update(CommerceDto entity) {
        Commerce commerce = mapper.map(entity, Commerce.class);
        dao.update(commerce);
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
    public void deleteById(int entityId) {
        dao.deleteById(entityId);
    }

}
