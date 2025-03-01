/*
 * Copyright 2020-2025 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.api.cqrs;

import java.util.List;

import org.teasoft.bee.osql.CommOperate;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.Condition;

/**
 * @author Kingstar
 * @since  2.5.2
 */
public interface Query extends CommOperate {
	
	/**
	 * According to entity object select records from database.
	 * @param entity table's entity(do not allow null).<br>
	 * Entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty field as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> select(T entity);

	/**
	 * Select the records according to entity and condition.<br>
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * @return list which contains more than one entity.
	 * @since  1.6
	 */
	public <T> List<T> select(T entity, Condition condition);

	
	
	/**
	 * Select record(s) according to entity object,and can specify page information.
	 * @param entity table's entity(do not allow null).
	 * <br>entity corresponding to table and can not be null.
	 * <br>If the field value is not null and not empty field as filter condition, 
	 * <br>the operator is equal sign.eg:field=value<br>
	 * @param size fetch result size (>0).
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> select(T entity, int size);

	/**
	 * Select record(s) according to entity object,and can specify page information.
	 * @param entity table's entity(do not allow null).
	 * <br>entity corresponding to table and can not be null.
	 * <br>If the field value is not null and not empty field as filter condition, 
	 * <br>the operator is equal sign.eg:field=value
	 * @param start start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size fetch result size (>0).
	 * @return list can contain more than one entity
	 */
	public <T> List<T> select(T entity, int start, int size);

	/**
	 * Just select some fields.
	 * @param entity table's entity(do not allow null).
	 * @param selectFields select fields,if more than one,separate with comma in one selectField parameter or use variable parameter.
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> select(T entity, String... selectFields);

	/**
	 * Just select some fields,and can specify page information.
	 * @param entity table's entity(do not allow null).
	 * @param start start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size fetch result size (>0).
	 * @param selectFields select fields,if more than one,separate with comma in one selectField parameter or use variable parameter.
	 * @return list which contains more than one entity.
	 * @since 1.4.3
	 * @since 2.0
	 */
	public <T> List<T> select(T entity, int start, int size, String... selectFields);

	/**
	 * Select entity,every field will return the string type.
	 * @param entity table's entity(do not allow null).
	 * @return list can contain more than one record with String array struct.
	 */
	public <T> List<String[]> selectString(T entity);

	/**
	 * Select some field, every field will return the string type. 
	 * @param entity table's entity(do not allow null).
	 * @param selectFields Select fields,if more than one,separate with comma in one selectField parameter or use variable parameter.
	 * @return list can contain more than one record with String array struct.
	 */
	public <T> List<String[]> selectString(T entity, String... selectFields);

	/**
	 * Instead of returning data in a entity structure, it uses a character array in List.
	 * @param entity table's entity(do not allow null).
	 * @param condition Condition as filter the record.
	 * @return list can contain more than one record with String array struct.
	 * @since 1.9
	 */
	public <T> List<String[]> selectString(T entity, Condition condition);

	/**
	 * Select and return data in Json format according to entity object.
	 * @param entity table's entity(do not allow null).
	 * <br>entity corresponding to table and can not be null.
	 * <br>If the field value is not null and not empty field as filter condition, 
	 * <br>the operator is equal sign.eg:field=value
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public <T> String selectJson(T entity);

	/**
	 * Select one record,if the size do not equal one, return null.  
	 * @param entity table's entity(do not allow null).
	 * @return return one record,if the size do not equal one, return null.
	 */
	public <T> T selectOne(T entity);

	/**
	 * select the first record.
	 * @param entity table's entity(do not allow null).
	 * @return return the first record
	 */
	public <T> T selectFirst(T entity, Condition condition);

	/**
	 * Select result with one function,Just select one function.
	 * @param entity table's entity(do not allow null).
	 * @param functionType MAX,MIN,SUM,AVG,COUNT
	 * @param fieldForFun field for function.
	 * @return one function result.
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 */
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun);

	/**
	 * Select result with one function,just select one function at a time.
	 * @param entity table's entity(do not allow null).
	 * @param functionType MAX,MIN,SUM,AVG,COUNT
	 * @param fieldForFun field for function.
	 * @param condition Condition as filter the record.
	 * <br>here will ignore the condition's selectFun method.
	 * @return one function result.
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 * @since 1.9
	 */
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun, Condition condition); // selectOneFun

	/**
	 * total number of statistical records.
	 * @param entity  table's entity(do not allow null).
	 * @return total number of records that satisfy the condition.
	 * @since 1.9
	 */
	public <T> int count(T entity);

	/**
	 * total number of statistical records.
	 * @param entity table's entity(do not allow null).
	 * @param condition Condition as filter the record.
	 * @return total number of records that satisfy the condition.
	 * @since 1.9
	 */
	public <T> int count(T entity, Condition condition);

	/**
	 * Select result with order,order type default is:asc
	 * @param entity table's entity(do not allow null).
	 * @param orderFields order fields,if more than one,separate with comma.
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> selectOrderBy(T entity, String orderFields);

	/**
	 * Select result with order.
	 * @param entity table's entity(do not allow null).
	 * @param orderFields order fields,if more than one,separate with comma.
	 * @param orderTypes Sort type list.
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> selectOrderBy(T entity, String orderFields, OrderType[] orderTypes);

	
//	/**
//	 * Select record according to entity.
//	 * @param entity table's entity(do not allow null).
//	 * <br>entity corresponding to table and can not be null.
//	 * <br>If the field value is not null and not empty field as filter condition, 
//	 * <br>the operator is equal sign.eg:field=value
//	 * @param includeType whether null string and null as a filter conditions.
//	 * @return list which contains more than one entity.
//	 */
//	public <T> List<T> select(T entity, IncludeType includeType);
	
//	/**
//	 * Select and return data in Json format according to entity object.
//	 * @param entity table's entity(do not allow null).
//	 * @param includeType whether null string and null as a filter conditions.
//	 * @return Json string, it transform from list which can contain more than one entity.
//	 * @since  1.1
//	 */
//	public <T> String selectJson(T entity, IncludeType includeType);
	
	/**
	 * Select and return data in Json format according to entity object.
	 * @param entity table's entity(do not allow null).
	 * @param condition Condition as filter the record.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.9
	 */
	public <T> String selectJson(T entity, Condition condition);
	
	/**
	 * Just select some fields,and return Json string.
	 * @param entity table's entity(do not allow null).
	 * @param selectFields select fields,if more than one,separate with comma in one selectField parameter or use variable parameter.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since 1.9.8
	 */
	public <T> String selectJson(T entity, String... selectFields);

	/**
	 * Just select some fields,and can specify page information.
	 * @param entity table's entity(do not allow null).
	 * @param start start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size fetch result size (>0).
	 * @param selectFields select fields,if more than one,separate with comma in one selectField parameter or use variable parameter.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since 1.9.8
	 * @since 2.0
	 */
	public <T> String selectJson(T entity, int start, int size, String... selectFields);

	/**
	 * Select record by id.
	 * @param entityClass table's entity class(do not allow null).
	 * @param id value of entity's id field. 
	 * @return return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(Class<T> entityClass, Integer id);

	/**
	 * Select record by id.
	 * @param entityClazz table's entity class(do not allow null).
	 * <br> The property value of returnType will not be parsed.
	 * @param id value of entity's id field.
	 * @return return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(Class<T> entityClazz, Long id);

	/**
	 * Select record by id.
	 * @param entityClass table's entity class(do not allow null).
	 * <br> The property value of returnType will not be parsed.
	 * @param id value of entity's id field.
	 * @return return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(Class<T> entityClass, String id);

	/**
	 * Select record by id.
	 * @param entityClass table's entity class(do not allow null).
	 * <br> The property value of returnType will not be parsed.
	 * @param ids values of entity's id field,if more than one,separate with comma.
	 * @return list which contains more than one entity.
	 * @since  1.9
	 */
	public <T> List<T> selectByIds(Class<T> entityClass, String ids);
	
	/**
	 * Check whether the entity corresponding record exist
	 * @param entity table's entity(do not allow null).
	 * @return true,if have the record;or return false.
	 * @since 1.9
	 */
	public <T> boolean exist(T entity);
	
	
	
//	/**
//	 * set dynamic parameter for dynamic table & entity name,only effective once
//	 * <br>This method is called earlier than the select, update, insert, delete methods.
//	 * @param para parameter name
//	 * @param value parameter value
//	 * @return Suid
//	 * @since  1.8
//	 */
//	public Query setDynamicParameter(String para, String value);

	/**
	 * declare begin Same Connection for some ORM operation.
	 * @since 1.9
	 */
	public void beginSameConnection();

	/**
	 * declare end Same Connection for some ORM operation.
	 * @since 1.9
	 */
	public void endSameConnection();
	
}
