package com.eventui.customer.tracking.club.customertrackerclub.dao;

import java.io.Serializable;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericHibernateDao< T extends Serializable >  extends AbstractHibernateDao< T > 
			implements IGenericDao< T > {

}
