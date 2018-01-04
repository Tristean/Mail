package com.mail.dao.basedao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.mail.domain.QueryResult;

public  interface MailBaseDao<T> {
	public boolean delete(Class<T>entity,Serializable entityId);
	
	public T find(Class<T>entity,Serializable entityId);
	
	public boolean save(T entity);
	
	public long getTotalRecord(Class<T>entityClass);
	
	public long getTotalRecord(Class<T>entityClass,String whereHql,Object[]values);
	
	public QueryResult<T> getScrollData(Class<T>entityClass);
	
	public QueryResult<T> getScrollData(Class<T>entityClass,int firstIndex,int maxResult);
	
	public QueryResult<T> getScrollData(Class<T>entityClass,String whereHql,Object[]values);
	
	public QueryResult<T> getScrollData(Class<T>entityClass,int firstIndex,int maxResult,LinkedHashMap<String,String>orderBy);
	
	public QueryResult<T> getScrollData(Class<T>entityClass,LinkedHashMap<String,String>orederby);
	
	
	public QueryResult<T> getScrollData(Class<T>entityClass,int firstIndex,int maxResult,String whereHql,Object[]values);
	
	public QueryResult<T> getScrollData(Class<T>entityClass,int firstIndex,int maxResult,String whereHql,Object[]values,LinkedHashMap<String,String>orderby);
	
	public String getEntityName(Class<T>entityClass);
	
	
}
