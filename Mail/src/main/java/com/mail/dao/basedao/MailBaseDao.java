package com.mail.dao.basedao;

import java.io.Serializable;

public  interface MailBaseDao<T> {
	public boolean delete(Class<T>entity,Serializable entityId);
	
	public T find(Class<T>entity,Serializable entityId);
	
	public boolean save(T entity);
	
}
