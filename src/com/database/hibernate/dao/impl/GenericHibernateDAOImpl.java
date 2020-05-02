package com.database.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.database.hibernate.dao.AbstractHibernateDAO;
import com.database.hibernate.dao.IGenericHibernateDAO;

/**
 * This class is for generic methods which needs some manuplation and then to
 * use Hibernate methods from AbstractHibernateDao class.
 * 
 * @author bgirdhar
 *
 * @param <T>
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericHibernateDAOImpl<T extends Serializable> extends AbstractHibernateDAO<T> implements IGenericHibernateDAO<T> {
 
	// AbstractHibernateDao --> For hibernate basic methods.
	// IGenericDao --> For abstract hibernate and application specific methods.
	
	@Override
	public List<T> findByQuery() {
		return null;
	}
}
