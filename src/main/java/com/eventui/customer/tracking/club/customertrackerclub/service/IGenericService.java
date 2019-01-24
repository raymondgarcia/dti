/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventui.customer.tracking.club.customertrackerclub.service;

import java.io.Serializable;
import java.util.Collection;
/**
 *
 * @author raymondgarcia
 * @param <T>
 */
public interface IGenericService<T extends Serializable> {
    T findOne(final int id);

    Collection<T> findAll();

    T create(final T entity);

    T update(final T entity);

    T delete(final T entity);

    void deleteById(final int entityId);

}
