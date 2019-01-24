/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.IGenericDao;
import com.eventui.customer.tracking.club.customertrackerclub.entity.User;
import com.eventui.customer.tracking.club.customertrackerclub.model.UserDto;
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
public class UserService implements IGenericService<UserDto> {

    private IGenericDao<User> dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Autowired
    public void setDao(IGenericDao<User> daoToSet) {
        dao = daoToSet;
        dao.setClazz(User.class);
    }

    @Override
    @Transactional
    public UserDto findOne(int id) {
        return mapper.map(dao.findOne(id), UserDto.class);
    }

    @Override
    @Transactional
    public Collection<UserDto> findAll() {
        return mapper.mapAsList(dao.findAll(), UserDto.class);
    }

    @Override
    @Transactional
    public UserDto create(UserDto entity) {
        User user = mapper.map(entity, User.class);
        dao.create(user);
        return mapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public UserDto update(UserDto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public UserDto delete(UserDto entity) {
        User user = mapper.map(entity, User.class);
        dao.delete(user);
        return mapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public void deleteById(int entityId) {
         dao.deleteById(entityId);
    }

}
