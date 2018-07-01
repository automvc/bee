package org.bee.osql.service;

import java.util.List;

import org.bee.osql.Suid;

/**
 * @author KingStar
 * @since  1.0
 */
public abstract class ObjSQLAbstractServiceImpl implements ObjSQLService {

	public abstract Suid getSuid();
	
	@Override
	public <T> int insert(T entity){
		//Add the business logic if need.
		return getSuid().insert(entity);
	}

	@Override
	public <T> List<T> select(T entity) {
		//Add the business logic if need.
		return getSuid().select(entity);
	}

	@Override
	public <T> int delete(T entity){
		//Add the business logic if need.
		return getSuid().delete(entity);
	}

	@Override
	public <T> int update(T entity){
		//Add the business logic if need.
		return getSuid().update(entity);
	}
}
