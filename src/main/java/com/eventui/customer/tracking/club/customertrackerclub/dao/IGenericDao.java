package com.eventui.customer.tracking.club.customertrackerclub.dao;

import java.io.Serializable;
import java.util.List;


public interface IGenericDao<T extends Serializable> {
	 
	   T findOne(final int id);

	   List<T> findAll();
	 
	   void create(final T entity);
	 
	   void update(final T entity);
	 
	   void delete(final T entity);
	 
	   void deleteById(final int entityId);
           
           T loadByQuery(final String query);

	   void setClazz(Class<T> class1);
	}

