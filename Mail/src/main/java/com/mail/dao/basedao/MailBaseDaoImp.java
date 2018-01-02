package com.mail.dao.basedao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
public class MailBaseDaoImp<T> implements MailBaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	private Class<T>clazz;
	
	
	public MailBaseDaoImp() {
		ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz=(Class<T>)pt.getActualTypeArguments()[0];
		System.out.println(clazz);
	}

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public boolean delete(Class<T> entity, Serializable entityId) {
		// TODO Auto-generated method stub
		T temp=(T) getSession().get(entity, entityId);
		if(temp!=null){
			getSession().delete(temp);
			return true;
		}
		return false;
	}

	@Override
	public T find(Class<T> entity, Serializable entityId) {
		// TODO Auto-generated method stub
		return (T) getSession().get(entity, entityId);
	}
	
	
	@Override
	public boolean save(T entity) {
		// TODO Auto-generated method stub
		if(entity!=null){
			getSession().save(entity);
			return true;
		}
		return false;
	}
	
}
