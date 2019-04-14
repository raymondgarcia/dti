/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;


import com.eventui.customer.tracking.club.customertrackerclub.dao.UserRepository;
import com.eventui.customer.tracking.club.customertrackerclub.entity.User;
import com.eventui.customer.tracking.club.customertrackerclub.model.UserDto;
import java.util.Collection;
import java.util.Optional;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author raymondgarcia
 */
@Service
public class UserService implements IGenericService<UserDto> {

    @Autowired
    private UserRepository dao;

    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private MapperFacade mapper = mapperFactory.getMapperFacade();

    @Override
    @Transactional
    public UserDto findOne(String id) {
        return mapper.map(dao.findById(id), UserDto.class);
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
        user.setId(ObjectId.get());
        dao.save(user);
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

    public Optional<UserDto> findUserByEmail(String email) {
        Optional<UserDto> opt = Optional.of(mapper.map(dao.findByEmail(email), UserDto.class));;
        return opt;
    }

    public UserDto findUserByResetToken(String resetToken) {
        return mapper.map(dao.findByResetToken(resetToken), UserDto.class);
    }

    @Transactional
    public void deleteById(String entityId) {
         dao.deleteById(entityId);
    }

}
