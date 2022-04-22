/*
 * Copyright 2013-2018 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.teasoft.bee.osql;

import java.util.List;

/**
 * Database operation: Suid (select,update,insert,delete),
 * it supports more parameters than Suid.
 * 
 * <br>
 * <br>The SQL UPDATE statement consists of two parts: set and where. SuidRich specifies one of them 
 * <br>and tries to use the default implementation method for the other. 
 * <br>Therefore, the update method is divided into two parts:
 * <br>update and updateBy.
 * <br>In the <B>update</B> method, the string updateFields parameter (if has) can indicate the fields to be updated,
 * <br> and other fields may be converted to the where part of the SQL UPDATE statement (by default)
 * <br>Filter null and empty strings, which can be explicitly set through IncludeType)
 * 
 * <br>in the <B>updateBy</B> method, string whereFields (if has) can indicate the field used for WHERE in SQL.
 * <br>When whereFields is specified, fields that are not in whereFields will default.
 * <br>Convert to the set part of SQL UPDATE statement (null and empty strings are filtered by default, 
 * <br>which can be explicitly set through IncludeType).
 * <br>If the value of an attribute of the same entity is used in the where part, it is meaningless to use it 
 * <br>in the update set part (because their values are the same at this time)
 * <br>However, it can be set by using the set(String fieldName, Number num) and other methods; 
 * <br>The method set,setMultiply,setAdd,setWithField of condition is processed before processing the where field, 
 * <br>so it is not affected by the specified where condition field
 * 
 * <br>About the parameter <B>IncludeType</B>:
 * <br>If IncludeType is not set in condition, null and empty strings are filtered by default (but the fields set in op, between and notBetween methods in condition are not affected by the value of includeType.)
 * <br>If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.
 * 
 * <br>The fields set by the Condition of the update and updateBy methods will be parsed, which is not limited by the 
 * <br>IncludeType, nor affected by the updateFields parameter and the whereFields parameter.
 * 
 * @author Kingstar
 * Create on 2013-6-30 22:06:18
 * @since  1.0
 */
public interface SuidRich extends Suid {
	
	/**
	 * Select record(s) according to entity object,and can specify page information.
	 * @param entity table's entity(do not allow null).
	 * <br>entity corresponding to table and can not be null.
	 * <br>If the field value is not null and not empty field as filter condition, 
	 * <br>the operator is equal sign.eg:field=value<br>
	 * @param size fetch result size (>0).
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> select(T entity,int size);
	
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
	public <T> List<T> select(T entity,int start,int size);
	
	/**
	 * Just select some fields.
	 * @param entity table's entity(do not allow null).
	 * @param selectFields select fields,if more than one,separate with comma.
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> select(T entity,String selectFields);
	
	/**
	 * Just select some fields,and can specify page information.
	 * @param entity table's entity(do not allow null).
	 * @param selectFields select fields,if more than one,separate with comma.
	 * @param start start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size fetch result size (>0).
	 * @return list which contains more than one entity.
	 * @since 1.4.3
	 */
	public <T> List<T> select(T entity,String selectFields,int start,int size);
	
	/**
	 * Select entity,every field will return the string type.
	 * @param entity table's entity(do not allow null).
	 * @return list can contain more than one record with String array struct.
	 */
	public <T> List<String[]> selectString(T entity); 
	
	/**
	 * Select some field, every field will return the string type. 
	 * @param entity table's entity(do not allow null).
	 * @param selectFields Select fields,if more than one,separate with comma.
	 * @return list can contain more than one record with String array struct.
	 */
	public <T> List<String[]> selectString(T entity,String... selectFields); 
	
	/**
	 * Instead of returning data in a entity structure, it uses a character array in List.
	 * @param entity table's entity(do not allow null).
	 * @param condition Condition as filter the record.
	 * @return list can contain more than one record with String array struct.
	 * @since 1.9
	 */
	public <T> List<String[]> selectString(T entity,Condition condition); 
	
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
	 * Select one record.  
	 * @param entity table's entity(do not allow null).
	 * @return return one record,if the size do not equal one, return null.
	 */
	public <T> T selectOne(T entity);
	
	/**
	 * Select result with one function,Just select one function.
	 * @param entity table's entity(do not allow null).
	 * @param functionType MAX,MIN,SUM,AVG,COUNT
	 * @param fieldForFun field for function.
	 * @return one function result.
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
	 * @since 1.9
	 */
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun, Condition condition); //selectOneFun
	
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
	public <T> List<T> selectOrderBy(T entity,String orderFields);
	
	/**
	 * Select result with order.
	 * @param entity table's entity(do not allow null).
	 * @param orderFields order fields,if more than one,separate with comma.
	 * @param orderTypes Sort type list.
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> selectOrderBy(T entity,String orderFields,OrderType[] orderTypes);
	
	/**
	 * Update record, can list update fields. 
	 * @param entity table's entity(do not allow null).
	 * @param updateFields update fields.
	 * <br>For the list of fields to be updated, multiple fields are separated by commas (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the includeType parameter; By default, each field will be
	 * <br> converted to a set expression of SQL update.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity,String updateFields);
	
	/**
	 * Update record according to entity.
	 * @param entity table's entity(do not allow null).if id's value is null can not as filter condition.
	 * @param updateFields update fields.
	 * <br>For the list of fields to be updated, multiple fields are separated by commas (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the includeType parameter; By default, each field will be
	 * <br> converted to a set expression of SQL update.
	 * @param includeType whether null string and null as a filter conditions.
	 * @return  the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity,String updateFields,IncludeType includeType);
	
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
	public <T> int insert(T[] entity,int batchSize);
	
	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity table's entity array(do not allow null).
	 * @param excludeFields fields list that don't need to insert .
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity,String excludeFields);
	
	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity table's entity array(do not allow null).
	 * @param batchSize batch size.
	 * @param excludeFields Don't insert fields list.
	 *  @return the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity,int batchSize,String excludeFields);
	
	/**
	 * Insert records by batch type.
	 * @param entityList table's entity list(do not allow null).
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList);
	
	/**
	 * Insert records by batch type.
	 * @param table's entity list(do not allow null).
	 * @param batchSize batch size.
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,int batchSize);
	
	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList table's entity list(do not allow null).
	 * @param excludeFieldsfields list that don't need to insert .
	 *  @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,String excludeFields);
	
	/**
	 * Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList table's entity list(do not allow null).
	 * @param batchSize batch size.
	 * @param excludeFields Don't insert fields list.
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,int batchSize,String excludeFields);
	
	/**
	 * Select record according to entity.
	 * @param entity table's entity(do not allow null).
	 * <br>entity corresponding to table and can not be null.
	 * <br>If the field value is not null and not empty field as filter condition, 
	 * <br>the operator is equal sign.eg:field=value
	 * @param includeType whether null string and null as a filter conditions.
	 * @return list which contains more than one entity.
	 */
    public <T> List<T> select(T entity,IncludeType includeType);
	
	/**
	 * Update record according to entity by primary key.
	 * @param entity table's entity(do not allow null),The id field in entity cannot be empty as a filtering condition.
	 * @param includeType whether null string and null as a filter conditions.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity,IncludeType includeType);
	
	/**
	 * Insert record according to entity.
	 * @param entity table's entity(do not allow null).
	 * @param includeType whether null string and null as a filter conditions.
	 * @return the number of inserted record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int insert(T entity,IncludeType includeType);
	
	/**
	 * According to entity object insert record and return id value. 
	 * @param entity table's entity(do not allow null).
	 * <br>The entity corresponding to table and can not be null. 
	 * <br>The not null and not empty field will insert to database.
	 * @param includeType whether null string and null as a filter conditions.
	 * @return If successful, return the id value of the inserted record; if fails, return number less than 0.
	 * @since V1.11
	 */
	public <T> long insertAndReturnId(T entity,IncludeType includeType);
	
	/**
	 * Delete record according to entity.
	 * @param entity table's entity(do not allow null).
	 * @param includeType whether null string and null as a filter conditions.
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int delete(T entity,IncludeType includeType);
	
	/**
	 * Select and return data in Json format according to entity object.
	 * @param entity table's entity(do not allow null).
	 * @param includeType whether null string and null as a filter conditions.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public <T> String selectJson(T entity,IncludeType includeType);
	
	/**
	 * Just select some fields,and return Json string.
	 * @param entity table's entity(do not allow null).
	 * @param selectFields select fields,if more than one,separate with comma.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since 1.9.8
	 */
	public <T> String selectJson(T entity, String selectFields);
	
	/**
	 * Just select some fields,and can specify page information.
	 * @param entity table's entity(do not allow null).
	 * @param selectFields select fields,if more than one,separate with comma.
	 * @param start start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size fetch result size (>0).
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since 1.9.8
	 */
	public <T> String selectJson(T entity, String selectFields, int start, int size);
	
	/**
	 * Select record by id.
	 * @param returnType table's entity(do not allow null).
	 * @param id value of entity's id field. 
	 * @return return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(T returnType,Integer id);
	
	/**
	 * Select record by id.
	 * @param returnType table's entity(do not allow null).
	 * <br> The property value of returnType will not be parsed.
	 * @param id value of entity's id field.
	 * @return return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(T returnType,Long id);
	
	/**
	 * Select record by id.
	 * @param returnType table's entity(do not allow null).
	 * <br> The property value of returnType will not be parsed.
	 * @param id value of entity's id field.
	 * @return return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(T returnType,String id);
	
	/**
	 * Select record by id.
	 * @param returnType table's entity(do not allow null).
	 * <br> The property value of returnType will not be parsed.
	 * @param ids values of entity's id field,if more than one,separate with comma.
	 * @return list which contains more than one entity.
	 * @since  1.9
	 */
	public <T> List<T> selectByIds(T returnType,String ids);
	
	/**
	 * Delete record by id.
	 * @param c table's entity class(do not allow null).
	 * @param id value of entity's id field.
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 * @since  1.4
	 */
	public int deleteById(Class c,Integer id);
	
	/**
	 * Delete record by id.
	 * @param c table's entity class(do not allow null).
	 * @param id value of entity's id field.
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 * @since  1.4
	 */
	public int deleteById(Class c,Long id);
	
	/**
	 * Delete record by id.
	 * @param c table's entity class(do not allow null).
	 * @param ids ids values of entity's id field,if more than one,separate with comma.
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 * @since  1.4
	 */
	public int deleteById(Class c,String ids);
	
	/**
	 * Select record according to entity.
	 * @deprecated {@link Suid#select(Object,Condition)} can set includeType via condition.
	 * @param entity table's entity(do not allow null).if id's value is null can not as filter condition.
	 * @param includeType whether null string and null as a filter conditions.
	 * @param condition Condition as filter the record.
	 * @return list which contains more than one entity.
	 * @since  1.6
	 */
	@Deprecated
    public <T> List<T> select(T entity,IncludeType includeType,Condition condition);
    
	/**
	 * Select and return data in Json format according to entity object.
	 * @deprecated {@link SuidRich#selectJson(Object,Condition)} can set includeType via condition.
	 * @param entity table's entity(do not allow null).if id's value is null can not as filter condition.
	 * @param includeType whether null string and null as a filter conditions.
	 * @param condition Condition as filter the record.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.6
	 */
	@Deprecated
	public <T> String selectJson(T entity,IncludeType includeType,Condition condition);
	
	/**
	 * Select and return data in Json format according to entity object.
	 * @param entity table's entity(do not allow null).
	 * @param condition Condition as filter the record.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.9
	 */
	public <T> String selectJson(T entity,Condition condition);
	
	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * Fields that are not specified as whereFields, as part of the set(only non empty and non null fields 
	 * <br>are processed by default).
	 * @param whereFields As a field list of where part in SQL, multiple fields are separated by commas 
	 * <br>(the fields in the list will be used as where filter)
	 * <br>But if id's value is null can not as filter.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFields);
	
	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * Fields that are not specified as whereFields, as part of the set(only non empty and non null 
	 * <br>fields are processed by default,can change the default use IncludeType parameter).
	 * @param whereFields As a field list of where part in SQL, multiple fields are separated by commas 
	 * <br>(the fields in the list will be used as where filter)
	 * <br>But if id's value is null can not as filter.
	 * @param includeType whether null string and null as a filter conditions.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFields,IncludeType includeType);
	
	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * Fields that are not specified as whereFields, as part of the set(only non empty and non null fields 
	 * <br>are processed by default).
	 * @param whereFields As a field list of where part in SQL, multiple fields are separated by commas 
	 * <br>(the fields in the list will be used as where filter)
	 * <br>But if id's value is null can not as filter.
	 * <br>Notice:the method op of condition also maybe converted to the where expression.
	 * @param condition Condition as filter the record.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.7.2
	 */
	public <T> int updateBy(T entity,String whereFields,Condition condition);
	
	/**
	 * it is equivalent to updateBy(entity,"id",condition)
	 * @param entity table's entity(do not allow null).
	 * In entity, except for the ID field, other fields are used as the set part (only non empty and non null 
	 * <br>fields are processed by default)
	 * @param condition Condition as filter the record.
	 * <br>It should be noted that the condition set by OP may also be converted to the filter condition of where.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.9
	 */
	public <T> int updateById(T entity,Condition condition);
	
	/**
	 * Update record, can list update fields. 
	 * @param entity table's entity(do not allow null).
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.<br>
	 * @param updateFields update fields.The methods setMultiply,setAdd,set in condition are not subject to this restriction. 
	 * <br>For the list of fields to be updated, multiple fields are separated by commas (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the Condition's includeType parameter. By default, each 
	 * <br>field will be converted to a set expression of SQL update.
	 * @param condition Condition as filter the record.
	 * <br>A field is used not only in the specified updateFields, but also in Condition.set(arg1,arg2), 
	 *<br> and the corresponding fields in entity will be converted to the where part according to the rules (V1.9.8)
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.7.2
	 */
	public <T> int update(T entity,String updateFields,Condition condition);
	
	/**
	 * Update record,and can help with Condition.
	 * <br>When the set expression of SQL update is defined by Condition, you can no longer specify the field used by set.
	 * <br>it is equivalent to update(entity,"",condition),updateFields value is "".
	 * @param entity table's entity(do not allow null).
	 * If the field of entity is not null or empty, it will be translate to field=value in where part.Other can define with condition.
	 * @param condition Condition as filter the record.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.8
	 */
	public <T> int update(T entity,Condition condition);
	
	/**
	 * Update the entity. The non null and non empty attributes of oldEntity are taken as 
	 * <br>the filtering conditions; The non null and non empty properties of newEntity are 
	 * <br>used as the corresponding values of the properties to be updated
	 * Old and new entities must be of the same type.
	 * oldEntity is converted to Where part of SQL, and newEntity is converted to Set part.
	 * @param oldEntity Entity with old value field.
	 * @param newEntity Entity with new value field.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T oldEntity,T newEntity);
	
	/**
	 * set dynamic parameter for dynamic table & entity name
	 * <br>This method is called earlier than the select, update, insert, delete methods.
	 * <br>This method has the same effect as the same name method in suid interface, 
	 * <br>only for the convenience of chain programming
	 * @param para parameter name
	 * @param value parameter value
	 * @return SuidRich
	 * @since  1.9
	 */
	public SuidRich setDynamicParameter(String para, String value);
	
	/**
	 * Check whether the entity corresponding record exist
	 * @param entity table's entity(do not allow null).
	 * @return true,if have the record;or return false.
	 * @since 1.9
	 */
	public <T> boolean exist(T entity);
	
	/**
	 * save one entity(one record).
	 * If it can be distinguished, it is recommended to explicitly call insert (entity) 
	 * <br>or update (entity), which is more secure and efficient.
	 * @param entity
	 * @return the numbers of effect record(s),if fails, return integer less than 0.
	 * @since 1.9.8
	 */
	public <T> int save(T entity);
}
