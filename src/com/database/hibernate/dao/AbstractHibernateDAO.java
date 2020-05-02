package com.database.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import com.database.hibernate.util.HibernateUtil;

/**
 * This class is for abstract methods i.e. specific to Hibernate methods. If you
 * want any methods which are not directly from hibernate, You can define in
 * GenericHibernateDao class.
 * 
 * @author bgirdhar
 *
 * @param <T>
 */
public abstract class AbstractHibernateDAO<T extends Serializable> {

	final Class<?>[] genericTypes = GenericTypeResolver.resolveTypeArguments(this.getClass(),
			AbstractHibernateDAO.class);

	@SuppressWarnings("unchecked")
	private final Class<T> clazz = (Class<T>) genericTypes[0];

	public T findOne(long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> result = null;
		org.hibernate.Transaction transaction = beginTransaction();
		result = getCurrentSession().createQuery("from " + clazz.getName()).list();
		transaction.commit();
		return result;
	}

	public T create(T entity) {
		getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	public T update(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
	
	private org.hibernate.Transaction beginTransaction() {
		return getCurrentSession().beginTransaction();
	}
	

	protected Session getCurrentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
