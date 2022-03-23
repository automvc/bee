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
 * <br>In the update method, the string updateFields parameter (if has) can indicate the fields to be updated,
 * <br> and other fields may be converted to the where part of the SQL UPDATE statement (by default)
 * <br>Filter null and empty strings, which can be explicitly set through IncludeType)
 * 
 * <br>in the updateBy method, string whereFields (if has) can indicate the field used for WHERE in SQL.
 * <br>When whereFields is specified, fields that are not in whereFields will default.
 * <br>Convert to the set part of SQL UPDATE statement (null and empty strings are filtered by default, 
 * <br>which can be explicitly set through IncludeType).
 * <br>If the value of an attribute of the same entity is used in the where part, it is meaningless to use it 
 * <br>in the update set part (because their values are the same at this time)
 * <br>However, it can be set by using the set(String fieldName, Number num) and other methods; 
 * <br>The method set,setMultiply,setAdd,setWithField of condition is processed before processing the where field, 
 * <br>so it is not affected by the specified where condition field
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
	public <T> List<String[]> selectString(T entity,String selectFields); 
	
	/**
	 * Instead of returning data in a entity structure, it uses a character array in List.
	 * @param entity table's entity(do not allow null).
	 * @param condition condition.If IncludeType is not set in condition, null and empty strings are filtered 
	 * <br>by default (but the fields set in OP, between and notbetween methods in condition are not affected 
	 * <br>by the value of IncludeType.)
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
	 * @param condition condition.若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * here will ignore the condition's selectFun method.
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
	 * @param condition condition as filter the record.
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
	 * @param orderTypes 排序类型列表
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> selectOrderBy(T entity,String orderFields,OrderType[] orderTypes);
	
	/**
	 * Update record, can list update fields. 
	 * @param entity table's entity(do not allow null).
	 * @param updateFields 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新),该属性不允许为空,
	 * <br>除了updateFields中声明要更新的字段,其它非空,非null的字段作为过滤条件,转成SQL的where表达式.
	 * <br>For the list of fields to be updated, multiple fields are separated by commas (those fields will be updated). 
	 * <br>This attribute cannot be empty. By default, each field will be converted to a set expression of SQL update.
	 * @return 成功更新的记录数,若失败则返回小于0的整数.the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity,String updateFields);
	
	/**
	 * 根据实体对象entity更新数据,可以指定需要更新的字段.Update record according to entity.
	 * @param entity 与表对应的实体对象,且不能为空.table's entity(do not allow null).
	 * id为null不作为过滤条件
	 * @param updateFields 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新),该属性不允许为空,且不受includeType参数的影响,默认每个字段会被转化成SQL update的set表达式
	 * <br>For the list of fields to be updated, multiple fields are separated by commas (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the includeType parameter. By default, each field will be
	 * <br> converted to a set expression of SQL update.
	 * @param includeType 空字符串与null是否作为过滤条件.whether null string and null as a filter conditions.
	 * @return  成功更新的记录数,若失败则返回小于0的整数.the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity,String updateFields,IncludeType includeType);
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entity 与表对应的实体对象数组,且不能为空. table's entity array(do not allow null).
	 * @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity);
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entity 与表对应的实体对象,且不能为空. table's entity array(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 *  @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity,int batchSize);
	
	/**
	 * 批量插入数据,且可以声明不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity 与表对应的实体对象数组,且不能为空. table's entity array(do not allow null).
	 * @param excludeFields 声明不用插入的字段列表.fields list that don't need to insert .
	 * @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity,String excludeFields);
	
	/**
	 * 批量插入数据,且可以指定不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity 与表对应的实体对象数组,且不能为空. table's entity array(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @param excludeFields 声明不用插入的字段列表.Don't insert fields list.
	 *  @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 */
	public <T> int insert(T[] entity,int batchSize,String excludeFields);
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList);
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,int batchSize);
	
	/**
	 * 批量插入数据,且可以声明不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @param excludeFields 声明不用插入的字段列表.fields list that don't need to insert .
	 *  @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,String excludeFields);
	
	/**
	 * 批量插入数据,且可以指定不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @param excludeFields 声明不用插入的字段列表.Don't insert fields list.
	 * @return 成功插入的记录行数;失败时返回-1. the number of inserted record(s) successfully;if fails, return -1.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,int batchSize,String excludeFields);
	
	/**
	 * Select record according to entity.
	 * @param entity table's entity(do not allow null).
	 * <br>entity corresponding to table and can not be null.
	 * <br>If the field value is not null and not empty field as filter condition, 
	 * <br>the operator is equal sign.eg:field=value
	 * @param includeType 空字符串与null是否包含设置
	 * @return list which contains more than one entity.
	 */
    public <T> List<T> select(T entity,IncludeType includeType);
	
	/**
	 * Update record according to entity by primary key.
	 * @param entity table's entity(do not allow null),The id field in entity cannot be empty as a filtering condition.
	 * @param includeType 空字符串与null是否包含设置
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int update(T entity,IncludeType includeType);
	
	/**
	 * Insert record according to entity.
	 * @param entity table's entity(do not allow null).
	 * @param includeType 空字符串与null是否包含设置
	 * @return the number of inserted record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int insert(T entity,IncludeType includeType);
	
	/**
	 * According to entity object insert record and return id value. 
	 * @param entity table's entity(do not allow null).
	 * <br>The entity corresponding to table and can not be null. 
	 * <br>The not null and not empty field will insert to database.
	 * @param includeType 空字符串与null是否包含设置
	 * @return If successful, return the id value of the inserted record; if fails, return number less than 0.
	 * @since V1.11
	 */
	public <T> long insertAndReturnId(T entity,IncludeType includeType);
	
	/**
	 * Delete record according to entity.
	 * @param entity table's entity(do not allow null).
	 * @param includeType 空字符串与null是否包含设置
	 * @return the number of deleted record(s) successfully,if fails, return integer less than 0.
	 */
	public <T> int delete(T entity,IncludeType includeType);
	
	/**
	 * Select and return data in Json format according to entity object.
	 * @param entity table's entity(do not allow null).
	 * @param includeType 空字符串与null是否包含设置
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
	 * @return 包含多个实体的部分字段的Json字符串
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
	 * @param entity 与表对应的实体对象,且不能为空,id为null不作为过滤条件.table's entity(do not allow null).if id's value is null can not as filter condition.
	 * @param includeType 空字符串与null是否包含设置
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.<br> 
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return list which contains more than one entity.
	 * @since  1.6
	 */
	@Deprecated
    public <T> List<T> select(T entity,IncludeType includeType,Condition condition);
    
	/**
	 * Select and return data in Json format according to entity object.
	 * @deprecated {@link SuidRich#selectJson(Object,Condition)}方法中,可以通过condition设置includeType.can set includeType via condition.
	 * @param entity 与表对应的实体对象,且不能为空,id为null不作为过滤条件.table's entity(do not allow null).
	 * @param includeType 空字符串与null是否包含设置
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. <br>
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.6
	 */
	@Deprecated
	public <T> String selectJson(T entity,IncludeType includeType,Condition condition);
	
	/**
	 * Select and return data in Json format according to entity object.
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. <br>
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.9
	 */
	public <T> String selectJson(T entity,Condition condition);
	
	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * 没指定为whereFields的字段,作为set部分,默认只处理非空,非null的字段
	 * @param whereFields 作为SQL中where条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFields);
	
	/**
	 * Update record according to whereFields.
	 * @param entity 与表对应的实体对象,且不能为空
	 * 没指定为whereFields的字段,作为set部分.
	 * @param whereFields 作为SQL中where条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件
	 * @param includeType whether null string and null as a filter conditions.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFields,IncludeType includeType);
	
	/**
	 * Update record according to whereFields.
	 * @param entity table's entity(do not allow null).
	 * 没指定为whereFields的字段,作为set部分(默认只处理非空,非null的字段)
	 * @param whereFields 作为SQL中where条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件.
	 * <br>Notice:the method op of condition also maybe converted to the where expression.
	 * @param condition 用来设置默认情况不能表达的条件.
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.7.2
	 */
	public <T> int updateBy(T entity,String whereFields,Condition condition);
	
	/**
	 * it is equivalent to updateBy(entity,"id",condition)
	 * @param entity table's entity(do not allow null).
	 * entity中除了id字段,作为set部分(默认只处理非空,非null的字段)
	 * @param condition 用来设置默认情况不能表达的条件.
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * <br>需要注意的是,condition用op设置的条件,也有可能转换为where部分的过滤条件.
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.9
	 */
	public <T> int updateById(T entity,Condition condition);
	
	/**
	 * Update record, can list update fields. 
	 * @param entity table's entity(do not allow null).
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.<br>
	 * @param updateFields condition中setMultiply,setAdd,set方法设置的字段不受此限制.The methods setMultiply,setAdd,set in condition are not subject to this restriction. 
	 * <br>For the list of fields to be updated, multiple fields are separated by commas (those fields will be updated). 
	 * <br>This attribute cannot be empty and is not affected by the includeType parameter. By default, each field will be
	 * <br> converted to a set expression of SQL update.
	 * @param condition 
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * 一个字段既在指定的updateFields,也用在了Condition.set(arg1,arg2)等方法设置,entity里相应的字段会按规则转化到where部分.(V1.9.8)
	 * @return the numbers of update record(s) successfully,if fails, return integer less than 0.
	 * @since 1.7.2
	 */
	public <T> int update(T entity,String updateFields,Condition condition);
	
	/**
	 * Update record,and can help with Condition.
	 * <br>When the set expression of SQL update is defined by Condition, you can no longer specify the field used by set.
	 * <br>it is equivalent to update(entity,"",condition),updateFields value is "".
	 * @param entity table's entity(do not allow null).
	 * If the field of entity is not null or empty, it will be translate to field=value in where part.Other can define with condition.<br>
	 * @param condition
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
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
