/*
 * Copyright 2016-2023 the original author.All rights reserved.
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

package org.teasoft.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.SuidRich;

/**
 * The underlying interface for Mongodb queries is not used directly by users(can use Suid,SuidRich).
 * @author AiTeaSoft
 * @since  2.0
 */
public interface MongodbBeeSql extends SuidFile, Geo {

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
	 * @see SuidRich#update(Object,java.lang.String...)
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
	 * @param includeType
	 * @return If successful, return the id value of the inserted record; if fails, return number less than 0.
	 */
	public <T> long insertAndReturnId(T entity, IncludeType includeType);

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
	 */
	public <T> List<T> select(T entity, Condition condition);

	/**
	 * Delete the records according to entity and condition.<br>
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * @return the number of deleted record(s) successfully, if fails,return integer less than 0.
	 */
	public <T> int delete(T entity, Condition condition);

	public <T> String selectJson(T entity, Condition condition);

	public <T> int update(T oldEntity, T newEntity);

	public <T> int update(T entity, Condition condition, String... setFields);

	public <T> int updateBy(T entity, Condition condition, String... whereFields);

	public <T> List<T> selectOrderBy(T entity, String orderFields, OrderType[] orderTypes);

	public <T> int insert(T entity[], int batchSize, String excludeFields);

	public <T> List<T> selectById(Class<T> entityClass, Object id);

	public int deleteById(Class c, Object id);

	public <T> int count(T entity, Condition condition);

	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun,
			Condition condition); // selectOneFun

	public <T> List<String[]> selectString(T entity, Condition condition);

	public <T> List<T> select(MongoSqlStruct struct, Class<T> entityClass);

	public <T> List<String[]> selectString(MongoSqlStruct struct, Class<T> entityClass);

	public <T> String selectJson(MongoSqlStruct struct, Class<T> entityClass);

	public <T> String selectWithFun(MongoSqlStruct struct, Class<T> entityClass);

	public <T> String count(MongoSqlStruct struct, Class<T> entityClass);
	
	public <T> boolean createTable(Class<T> entityClass, boolean isDropExistTable);
	
	
//	考虑独立出来.  其它的可以方便通过suid,suidRich;  这些不方便
	
//	//GridFS
//	public String uploadFile(String filename, InputStream fileStream);
//	public String uploadFile(String filename, InputStream fileStream,Map<String, Object> metadataMap);
//	
//	public List<GridFsFile> selectFiles(GridFsFile gridFsFile, Condition condition);
//
//	public byte[] getFileByName(String fileName);
//	public byte[] getFileById(String fileId);
//	
////	public OutputStream getOutputStreamByName(String fileName);
////	public OutputStream getOutputStreamById(String fileId);
//
//	public void renameFile(String fileId, String newName);
//	public void deleteFile(String fileId);
}
