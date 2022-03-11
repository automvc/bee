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
 * 数据库操作接口,包括查,改,增,删 Suid (select,update,insert,delete),
 * 默认不处理null和空字符串
 * <br>Database operation: Suid (select,update,insert,delete),
 * the null and empty string are not handled by default.
 * @author Kingstar
 * Create on 2013-6-30 22:03:15
 * @since  1.0
 *
 */
public interface Suid  extends CommOperate{
	
	/**
	 * 根据实体对象entity查询数据
	 * <br>According to entity object select records from database.
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).<br>
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value. <br>
	 * Entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty field as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 */
	public <T> List<T> select(T entity);
	
	/**
	 * 根据实体对象entity更新数据,这个方法用于SQL的where条件的只有id属性,其它非null(且非空字符串)字段将更新到数据库(id除外)
	 * <br>According to entity object update record.This method just has id field to SQL where expression.
	 * @param entity 与表对应的实体对象,且不能为空;entity中id属性不能为空,作为过虑条件<br>
	 * entity中非null且非空字符串将更新到数据库(id除外).<br>
	 * table's entity(do not allow null);id is where condition,do not allow null.<br>
	 * The entity corresponding to table and can not be null. <br>
	 * The ID field of entity cannot be null and as filter condition. <br>
	 * The not null and not empty field will update to database except ID.
	 * @return 成功更新的记录数,若失败则返回小于0的整数.the numbers of update records successfully, if fails,return integer less than 0.
	 * @see SuidRich#update(Object,java.lang.String)
	 */
	public <T> int update(T entity);
	
	/**
	 * 根据实体对象entity插入数据.According to entity object insert record. 
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).<br>
	 * entity中非null且非空字符串将插入到数据库<br>
	 * The entity corresponding to table and can not be null. <br>
	 * The not null and not empty field will insert to database.
	 * @return 成功插入的记录数,若失败则返回小于0的整数.the numbers of insert records successfully, if fails,return integer less than 0.
	 */
	public <T> int insert(T entity);
	
	/**
	 * 根据实体对象entity插入数据,并返回主键id值.According to entity object insert record and return id value. 
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).<br>
	 * entity中非null且非空字符串将插入到数据库<br>
	 * The entity corresponding to table and can not be null. <br>
	 * The not null and not empty field will insert to database.
	 * @return 若成功,返回插入记录的id值;若失败则返回小于0的数.
	 * <br>If successful, return the id value of the inserted record; if fails, return number less than 0.
	 * @since 1.9
	 */
	public <T> long insertAndReturnId(T entity);
	
	/**
	 * 根据实体对象entity删除数据.According to entity object delete record. 
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).<br>
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value<br>
	 * The entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty field as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @return 成功删除的记录数,若失败则返回小于0的整数. the numbers of delete records successfully, if fails,return integer less than 0.
	 */
	public <T> int delete(T entity);
	
	/**
	 * 根据实体对象和Condition查询数据.Select the records according to entity and condition.<br>
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * @param condition entity默认有值的字段会转成field=value的形式,其它形式可通过condition指定.<br>
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * <br>若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 * @since  1.6
	 */
	public <T> List<T> select(T entity,Condition condition);

	/**
	 * 根据实体对象和Condition删记录.Delete the records according to entity and condition.<br>
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * @param condition entity默认有值的字段会转成field=value的形式,其它形式可通过condition指定.<br>
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * <br>若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 成功删除的记录行数,若失败则返回小于0的整数. the number of deleted record(s) successfully, if fails,return integer less than 0.
	 * @since 1.7.2
	 */
	public <T> int delete(T entity,Condition condition);
	
	/**
	 * 为动态表名、实体名参数设置值.set dynamic parameter for dynamic table & entity name
	 * <br>本方法的调用要早于select,update,insert,delete等方法.
	 * <br>This method is called earlier than the select, update, insert, delete methods.
	 * @param para parameter name
	 * @param value parameter value
	 * @return Suid
	 * @since  1.8
	 */
	public Suid setDynamicParameter(String para,String value);
	
	/**
	 * 声明开始使用同一Connection.declare begin Same Connection for some ORM operation.
	 * @since 1.9
	 */
	public void beginSameConnection();
	
	/**
	 * 声明结束使用同一Connection.declare end Same Connection for some ORM operation.
	 * @since 1.9
	 */
	public void endSameConnection();

}
