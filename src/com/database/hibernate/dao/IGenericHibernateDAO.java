package com.database.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * To be implements by those DAO interfaces of applications in which only default implementations are required.
 * If you want your dao has its own methods then don't implements the IGenericDao.
 * @author bgirdhar
 *
 * @param <T>
 */
public interface IGenericHibernateDAO<T extends Serializable> {

	// Start : Only Declaration of AbstractHibernateDao Methods to make them available
	// where reference of IGenericDao is used.
	
	T findOne(final long id);

	List<T> findAll();

	T create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);
	
	// Start : Generic methods of application.
	public List<T> findByQuery();
	
}
