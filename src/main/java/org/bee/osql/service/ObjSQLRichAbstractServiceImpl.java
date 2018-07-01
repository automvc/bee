package org.bee.osql.service;

import java.util.List;

import org.bee.osql.FunctionType;
import org.bee.osql.IncludeType;
import org.bee.osql.OrderType;
import org.bee.osql.SuidRich;

/**
 * @author KingStar
 * @since  1.0
 */
public abstract class ObjSQLRichAbstractServiceImpl extends ObjSQLAbstractServiceImpl implements ObjSQLRichService{

	public abstract SuidRich getSuidRich();
	
	@Override
	public <T> List<T> select(T entity, int size){
		//Add the business logic if need.
		return getSuidRich().select(entity,size);
	}

	@Override
	public <T> List<T> select(T entity, int from, int size){
		//Add the business logic if need.
		return getSuidRich().select(entity,from,size);
	}

	@Override
	public <T> List<T> select(T entity, String selectFields){
		//Add the business logic if need.
		return getSuidRich().select(entity,selectFields);
	}
	
	@Override
	public <T> int[] insert(T[] entity){
		//Add the business logic if need.
		return getSuidRich().insert(entity);
	}
	
	@Override
	public <T> int[] insert(T[] entity,String excludeFieldList){
		//Add the business logic if need.
		return getSuidRich().insert(entity,excludeFieldList);
	}
	

	@Override
	public <T> int[] insert(T[] entity, int batchSize){
		//Add the business logic if need.
		return getSuidRich().insert(entity, batchSize);
	}
	
	@Override
	public <T> int[] insert(T[] entity, int batchSize, String excludeFieldList) {
		//Add the business logic if need.
		return getSuidRich().insert(entity,batchSize,excludeFieldList);
	}

	@Override
	public <T> int update(T entity, String updateFieldList){
		//Add the business logic if need.
		return getSuidRich().update(entity, updateFieldList);
	}

	@Override
	public <T> T selectOne(T entity) {
		//Add the business logic if need.
		return getSuidRich().selectOne(entity);
	}

	@Override
	public <T> String selectWithFun(T entity, String fieldForFun,FunctionType functionType) {
		//Add the business logic if need.
		return getSuidRich().selectWithFun(entity, fieldForFun, functionType);
	}

	@Override
	public <T> List<T> selectOrderBy(T entity, String orderFieldList) {
		//Add the business logic if need.
		return getSuidRich().selectOrderBy(entity, orderFieldList);
	}
	
	@Override
	public <T> List<T> selectOrderBy(T entity, String orderFieldList,OrderType[] orderTypes) {
		//Add the business logic if need.
		return getSuidRich().selectOrderBy(entity, orderFieldList, orderTypes);
	}

	@Override
	public <T> int update(T entity, String updateFieldList,IncludeType includeType) {
		//Add the business logic if need.
		return getSuidRich().update(entity, updateFieldList, includeType);
	}
	

	@Override
	public <T> List<T> select(T entity, IncludeType includeType) {
		//Add the business logic if need.
		return getSuidRich().select(entity, includeType);
	}

	@Override
	public <T> int update(T entity, IncludeType includeType) {
		//Add the business logic if need.
		return getSuidRich().update(entity, includeType);
	}

	@Override
	public <T> int insert(T entity, IncludeType includeType) {
		//Add the business logic if need.
		return getSuidRich().insert(entity, includeType);
	}

	@Override
	public <T> int delete(T entity, IncludeType includeType) {
		//Add the business logic if need.
		return getSuidRich().delete(entity, includeType);
	}

	@Override
	public <T> List<String[]> selectString(T entity) {
		//Add the business logic if need.
		return getSuidRich().selectString(entity);
	}

	@Override
	public <T> List<String[]> selectString(T entity, String selectFields) {
		//Add the business logic if need.
		return getSuidRich().selectString(entity, selectFields);
	}
	
}
