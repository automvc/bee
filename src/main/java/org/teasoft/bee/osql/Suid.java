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
 * the null and empty string are not handled by default.
 * @author Kingstar
 * Create on 2013-6-30 22:03:15
 * @since  1.0
 *
 */
public interface Suid extends CommOperate{
	
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
	 * According to entity object update record.This method just has id field to SQL where expression.
	 * table's entity(do not allow null);id is where condition,do not allow null.<br>
	 * The entity corresponding to table and can not be null. <br>
	 * The ID field of entity cannot be null and as filter condition. <br>
	 * The not null and not empty field will update to database except ID.
	 * @return the numbers of update records successfully, if fails,return integer less than 0.
	 * @see SuidRich#update(Object,java.lang.String)
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
	 * Select the records according to entity and condition.<br>
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * @return list which contains more than one entity.
	 * @since  1.6
	 */
	public <T> List<T> select(T entity,Condition condition);

	/**
	 * Delete the records according to entity and condition.<br>
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * @return the number of deleted record(s) successfully, if fails,return integer less than 0.
	 * @since 1.7.2
	 */
	public <T> int delete(T entity,Condition condition);
	
	/**
	 * set dynamic parameter for dynamic table & entity name
	 * <br>This method is called earlier than the select, update, insert, delete methods.
	 * @param para parameter name
	 * @param value parameter value
	 * @return Suid
	 * @since  1.8
	 */
	public Suid setDynamicParameter(String para,String value);
	
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
