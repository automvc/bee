/*
 * Copyright 2020-2025 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.api.cqrs;

import java.util.List;

import org.teasoft.bee.osql.CommOperate;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.api.Condition;

/**
 * Command type API.
 * @author Kingstar
 * @since  2.5.2
 */
public interface Command extends CommOperate {

	/**
	 * According to entity object update record(update record by id).This method just has id field to SQL where expression.
	 * table's entity(do not allow null);id is where condition,do not allow null.<br>
	 * The entity corresponding to table and can not be null. <br>
	 * The ID field of entity cannot be null and as filter condition. <br>
	 * The not null and not empty field will update to database except ID.
	 * @return the numbers of update records successfully, if fails,return integer less than 0.
	 * @see Command#update(Object,java.lang.String...)
	 */
	public <T> int update(T entity);

	/**
	 * According to entity object insert record. 
	 * @param entity table's entity(do not allow null).<br>
	 * The entity corresponding to table and can not be null. <br>
	 * The not null and not empty field will insert to database.
	 * @return the numbers of insert records successfully, if fails,return integer less than 0.
	 */
	public <T> int insert(T entity);

	/**
	 * According to entity object insert record and return id value. 
	 * <br>Just support single primary key.If primary key empty or more one, will use "id".
	 * @param entity table's entity(do not allow null).<br>
	 * The entity corresponding to table and can not be null. <br>
	 * The not null and not empty field will insert to database.
	 * @return If successful, return the id value of the inserted record; if fails, return number less than 0.
	 * @since 1.9
	 */
	public <T> long insertAndReturnId(T entity);

	/**
	 * According to entity object delete record. 
	 * @param entity table's entity(do not allow null).<br>
	 * The entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty field as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @return the numbers of delete records successfully, if fails,return integer less than 0.
	 */
	public <T> int delete(T entity);

	/**
	 * Delete the records according to entity and condition.<br>
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * @return the number of deleted record(s) successfully, if fails,return integer less than 0.
	 * @since 1.7.2
	 */
	public <T> int delete(T entity, Condition condition);

	/**
	 * Update record, can list update fields. 
	 * @param entity table's entity(do not allow null).
	 * @param updateFields update fields.
	 * <br>For the list of fields to be updated, multiple fields can separated by commas in one updateField parameter 
	 * <br>or use variable parameter (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the includeType parameter; By default, each field will be
	 * <br> converted to a set expression of SQL update.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity, String... updateFields);

	/**
	 * Update record according to entity.
	 * @param entity table's entity(do not allow null).if id's value is null can not as filter condition.
	 * @param includeType whether null string and null as a filter conditions.
	 * @param updateFields update fields.
	 * <br>For the list of fields to be updated, multiple fields can separated by commas in one updateField parameter or 
	 * <br>use variable parameter (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the includeType parameter; By default, each field will be
	 * <br> converted to a set expression of SQL update.
	 * @return  the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 2.0
	 */
	public <T> int update(T entity, IncludeType includeType, String... updateFields);

	/**
	 * Insert records by batch type.
	 * @param entity table's entity array(do not allow null).
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity);

	/**
	 * Insert records by batch type.
	 * @param entity table's entity array(do not allow null).
	 * @param batchSize batch size.
	 *  @return the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity, int batchSize);

	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity table's entity array(do not allow null).
	 * @param excludeFields fields list that don't need to insert .
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity, String excludeFields);

	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity table's entity array(do not allow null).
	 * @param batchSize batch size.
	 * @param excludeFields Don't insert fields list.
	 *  @return the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity, int batchSize, String excludeFields);

	/**
	 * Insert records by batch type.
	 * @param entityList table's entity list(do not allow null).
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList);

	/**
	 * Insert records by batch type.
	 * @param entityList table's entity list(do not allow null).
	 * @param batchSize batch size.
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList, int batchSize);

	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList table's entity list(do not allow null).
	 * @param excludeFields fields list that don't need to insert.
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList, String excludeFields);

	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList table's entity list(do not allow null).
	 * @param batchSize batch size.
	 * @param excludeFields Don't insert fields list.
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList, int batchSize, String excludeFields);

	/**
	 * Update record according to entity by primary key.
	 * @param entity table's entity(do not allow null),The id field in entity cannot be empty as a filtering condition.
	 * @param includeType whether null string and null as a filter conditions.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity, IncludeType includeType);

	/**
	 * Insert record according to entity.
	 * @param entity table's entity(do not allow null).
	 * @param includeType whether null string and null as a filter conditions.
	 * @return the number of inserted record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int insert(T entity, IncludeType includeType);

	/**
	 * According to entity object insert record and return id value. 
	 * <br>Just support single primary key.If primary key empty or more one, will use "id".
	 * @param entity table's entity(do not allow null).
	 * <br>The entity corresponding to table and can not be null. 
	 * <br>The not null and not empty field will insert to database.
	 * @param includeType whether null string and null as a filter conditions.
	 * @return If successful, return the id value of the inserted record; if fails, return number less than 0.
	 * @since V1.11
	 */
	public <T> long insertAndReturnId(T entity, IncludeType includeType);

//	/**
//	 * Delete record according to entity.
//	 * @param entity table's entity(do not allow null).
//	 * @param includeType whether null string and null as a filter conditions.
//	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
//	 */
//	public <T> int delete(T entity, IncludeType includeType);

	/**
	 * Delete record by id.
	 * @param c table's entity class(do not allow null).
	 * @param id value of entity's id field.
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 * @since  1.4
	 */
	public int deleteById(Class<?> c, Integer id);

	/**
	 * Delete record by id.
	 * @param c table's entity class(do not allow null).
	 * @param id value of entity's id field.
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 * @since  1.4
	 */
	public int deleteById(Class<?> c, Long id);

	/**
	 * Delete record by id.
	 * @param c table's entity class(do not allow null).
	 * @param ids ids values of entity's id field,if more than one,separate with comma.
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 * @since  1.4
	 */
	public int deleteById(Class<?> c, String ids);

	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * <br>Fields that are not specified as whereFields, as part of the set(only non empty and non null fields 
	 * <br>are processed by default).
	 * @param whereFields As a field list of where part in SQL, multiple fields can separated by commas in one 
	 * <br>whereField parameter or use variable parameter (the fields in the list will be used as where filter)
	 * <br>But if id's value is null can not as filter.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since  1.6
	 */
	public <T> int updateBy(T entity, String... whereFields);

	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * <br>Fields that are not specified as whereFields, as part of the set(only non empty and non null 
	 * <br>fields are processed by default,can change the default use IncludeType parameter).
	 * @param includeType whether null string and null as a filter conditions.
	 * @param whereFields As a field list of where part in SQL, multiple fields can separated by commas in one 
	 * <br>whereField parameter or use variable parameter (the fields in the list will be used as where filter)
	 * <br>But if id's value is null can not as filter.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since  2.0
	 */
	public <T> int updateBy(T entity, IncludeType includeType, String... whereFields);

	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * <br>Fields that are not specified as whereFields, as part of the set(only non empty and non null fields 
	 * <br>are processed by default).
	 * @param condition Condition as filter the record.
	 * @param whereFields As a field list of where part in SQL, multiple fields can separated by commas in one 
	 * <br>whereField parameter or use variable parameter (the fields in the list will be used as where filter)
	 * <br>But if id's value is null can not as filter.
	 * <br>Notice:the method op of condition also maybe converted to the where expression.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 2.0
	 */
	public <T> int updateBy(T entity, Condition condition, String... whereFields);

	/**
	 * it is equivalent to updateBy(entity,"id",condition)
	 * @param entity table's entity(do not allow null).
	 * <br>In entity, except for the ID field, other fields are used as the set part (only non empty and non null 
	 * fields are processed by default)
	 * @param condition Condition as filter the record.
	 * <br>It should be noted that the condition set by OP may also be converted to the filter condition of where.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.9
	 */
	public <T> int updateById(T entity, Condition condition);

	/**
	 * Update record, can list update fields. 
	 * @param entity table's entity(do not allow null).
	 * <br>If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.
	 * @param condition Condition as filter the record.
	 * <br>A field is used not only in the specified updateFields, but also in Condition.set(arg1,arg2), 
	 *<br> and the corresponding fields in entity will be converted to the where part according to the rules (V1.9.8)
	 * @param updateFields update fields.The methods setMultiply,setAdd,set in condition are not subject to this restriction. 
	 * <br>For the list of fields to be updated, multiple fields can separated by commas in one updateField parameter or use 
	 * <br>variable parameter (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the Condition's includeType parameter. By default, each 
	 * <br>field will be converted to a set expression of SQL update.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 2.0
	 */
	public <T> int update(T entity, Condition condition, String... updateFields);

	/**
	 * Update record,and can help with Condition.
	 * <br>When the set expression of SQL update is defined by Condition, you can no longer specify the field used by set.
	 * <br>it is equivalent to update(entity,"",condition),updateFields value is "".
	 * @param entity table's entity(do not allow null).
	 * <br>If the field of entity is not null or empty, it will be translate to field=value in where part.Other can define with condition.
	 * @param condition Condition as filter the record.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.8
	 */
	public <T> int update(T entity, Condition condition);

	/**
	 * Update the entity. The non null and non empty attributes of oldEntity are taken as 
	 * <br>the filtering conditions; The non null and non empty properties of newEntity are 
	 * <br>used as the corresponding values of the properties to be updated
	 * <br>Old and new entities must be of the same type.
	 * <br>oldEntity is converted to Where part of SQL, and newEntity is converted to Set part.
	 * <br>The object-oriented Interceptor only processes the newEntity; 
	 * <br>The oldEntity as conditions is not processed in the Interceptor. 
	 * @param oldEntity Entity with old value field.
	 * @param newEntity Entity with new value field.some fields(serialVersionUID,have annotation JoinTable or Ignore, value is null) would be ignored.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T oldEntity, T newEntity);

//	/**
//	 * set dynamic parameter for dynamic table & entity name
//	 * <br>This method is called earlier than the select, update, insert, delete methods.
//	 * <br>This method has the same effect as the same name method in suid interface, 
//	 * <br>only for the convenience of chain programming
//	 * @param para parameter name
//	 * @param value parameter value
//	 * @return SuidRich
//	 * @since  1.9
//	 */
//	public SuidRich setDynamicParameter(String para, String value);

	/**
	 * save one entity(one record).
	 * <br>If it can be distinguished, it is recommended to explicitly call insert (entity) 
	 * <br>or update (entity), which is more secure and efficient.
	 * @param entity
	 * @return the numbers of effect record(s),if fails, return integer less than 0.
	 * @since 1.9.8
	 */
	public <T> int save(T entity);

	/**
	 * According to the database table generated by JavaBean, JavaBean does not need to configure 
	 * <br>too much field information. This method only considers the general situation, and is not 
	 * <br>recommended if there are detailed requirements.
	 * @param entityClass table's entityClass(do not allow null).
	 * @param isDropExistTable whether drop the exist table before create
	 * @return flag whether create successfully.
	 * @since 2.1
	 */
	public <T> boolean createTable(Class<T> entityClass, boolean isDropExistTable);

	/**
	 * create normal index 
	 * @param entityClass
	 * @param fields
	 * @param indexName
	 * @since 2.1
	 */
	public <T> void indexNormal(Class<T> entityClass, String fields, String indexName);

	/**
	 * create unique index 
	 * @param entityClass
	 * @param fields
	 * @param indexName
	 * @since 2.1
	 */
	public <T> void unique(Class<T> entityClass, String fields, String indexName);

	/**
	 * create primaryKey index 
	 * @param entityClass
	 * @param fields
	 * @param keyName
	 * @since 2.1
	 */
	public <T> void primaryKey(Class<T> entityClass, String fields, String keyName);

	/**
	 * drop index
	 * @param entityClass
	 * @param indexName
	 * @since 2.1
	 */
	public <T> void dropIndex(Class<T> entityClass, String indexName);

//	/**
//	 * set dynamic parameter for dynamic table & entity name,only effective once
//	 * <br>This method is called earlier than the select, update, insert, delete methods.
//	 * @param para parameter name
//	 * @param value parameter value
//	 * @return Suid
//	 * @since  1.8
//	 */
//	public Command setDynamicParameter(String para, String value);

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
