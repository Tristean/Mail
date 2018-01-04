package com.mail.dao.basedao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mail.domain.QueryResult;
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

	@Override
	public long getTotalRecord(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return getTotalRecord(entityClass,null,null);
	}
	@Override
	public long getTotalRecord(Class<T> entityClass, String whereHql, Object[] values) {
		// TODO Auto-generated method stub
		String whereString=(whereHql==null||"".equals(whereHql))?"":"where"+whereHql;
		String entityName=getEntityName(entityClass);
		Query query=getSession().createQuery(" from "+entityName+" "+whereString);
		whereHql(query,values);
		System.out.println(query.list().size());
		return query.list().size();
		
	}
	protected String whereHql(Query query,Object[]values){
		StringBuffer whereBuffer=new StringBuffer();
		if(values!=null&&values.length>0){
			for(int i=0;i<values.length;i++){
				query.setParameter(i+1, values[i]);
			}
		}
		return whereBuffer.toString();
	}
	protected String orderBy(LinkedHashMap<String,String>orderBy){
		StringBuffer orderBuffer=new StringBuffer();
		if(orderBy!=null&&orderBy.size()>0){
			orderBuffer.append("order by");
			for(String key:orderBy.keySet()){
				orderBuffer.append("o.").append(key).append(".").append(orderBy.get(key)).append(",");
			}
			orderBuffer.deleteCharAt(orderBuffer.length()-1);
		}
		return orderBuffer.toString();
	}
	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return getScrollData(entityClass,-1,-1,null,null,null);
	}

	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult) {
		// TODO Auto-generated method stub
		return getScrollData(entityClass,firstIndex,maxResult,null);
	}

	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass, String whereHql, Object[] values) {
		// TODO Auto-generated method stub
		return getScrollData(entityClass,-1,-1,whereHql,values,null);
	}

	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult, String whereHql,
			Object[] values) {
		// TODO Auto-generated method stub
		return getScrollData(entityClass,firstIndex,maxResult,whereHql,null);
	}

	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult,
			LinkedHashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		return getScrollData(entityClass,firstIndex,maxResult,null,null,orderBy);
	}

	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass, LinkedHashMap<String, String> orederby) {
		// TODO Auto-generated method stub
		return getScrollData(entityClass,-1,-1,null,null,orederby);
	}

	@Override
	public QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult, String whereHql,
			Object[] values, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		QueryResult<T>queryResult=new QueryResult<T>();
		String entityName=getEntityName(entityClass);
		String whereString=(whereHql==null||"".equals(whereHql))?"":"where"+whereHql;
		Query query=getSession().createQuery("select o from"+entityName+" o "+whereString+orderBy(orderby));
		whereHql(query,values);
		if(firstIndex!=-1&&maxResult!=-1)
			query.setFirstResult(firstIndex).setMaxResults(maxResult);
		queryResult.setResultList(query.list());
		queryResult.setTotalRecord(getTotalRecord(entityClass,whereHql,values));
		return queryResult;	
	}

	@Override
	public String getEntityName(Class<T> entityClass) {
		// TODO Auto-generated method stub
		String entityName=entityClass.getName();
		if(entityName!=null){
			String[]strs=entityName.split("\\.");
			entityName=strs[strs.length-1];
		}
		System.out.println("----------");
		System.out.println(entityName);
		return entityName;
	}
}
