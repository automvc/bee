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

package org.teasoft.bee.osql.service;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.SuidRich;

/**
 * Default common abstract object rich SQLService implement class.
 * @author Kingstar
 * @since  1.0
 */
public abstract class ObjSQLRichAbstractServiceImpl extends ObjSQLAbstractServiceImpl implements ObjSQLRichService {

	public abstract SuidRich getSuidRich();

	@Override
	public <T> List<T> select(T entity, int size) {
		// Add the business logic if need.
		return getSuidRich().select(entity, size);
	}

	@Override
	public <T> List<T> select(T entity, int start, int size) {
		// Add the business logic if need.
		return getSuidRich().select(entity, start, size);
	}

	@Override
	public <T> List<T> select(T entity, int start, int size, String... selectFields) {
		// Add the business logic if need.
		return getSuidRich().select(entity, start, size, selectFields);
	}

	@Override
	public <T> List<T> select(T entity, String... selectFields) {
		// Add the business logic if need.
		return getSuidRich().select(entity, selectFields);
	}

	@Override
	public <T> int insert(T[] entity) {
		// Add the business logic if need.
		return getSuidRich().insert(entity);
	}

	@Override
	public <T> int insert(T[] entity, String excludeFieldList) {
		// Add the business logic if need.
		return getSuidRich().insert(entity, excludeFieldList);
	}

	@Override
	public <T> int insert(T[] entity, int batchSize) {
		// Add the business logic if need.
		return getSuidRich().insert(entity, batchSize);
	}

	@Override
	public <T> int insert(T[] entity, int batchSize, String excludeFieldList) {
		// Add the business logic if need.
		return getSuidRich().insert(entity, batchSize, excludeFieldList);
	}

	@Override
	public <T> int update(T entity, String... updateFieldList) {
		// Add the business logic if need.
		return getSuidRich().update(entity, updateFieldList);
	}

	@Override
	public <T> T selectOne(T entity) {
		// Add the business logic if need.
		return getSuidRich().selectOne(entity);
	}

	@Override
	public <T> T selectFirst(T entity, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().selectFirst(entity, condition);
	}

	@Override
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun) {
		// Add the business logic if need.
		return getSuidRich().selectWithFun(entity, functionType, fieldForFun);
	}

	@Override
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun,
			Condition condition) {
		// Add the business logic if need.
		return getSuidRich().selectWithFun(entity, functionType, fieldForFun, condition);
	}

	@Override
	public <T> int count(T entity) {
		// Add the business logic if need.
		return getSuidRich().count(entity);
	}

	@Override
	public <T> int count(T entity, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().count(entity, condition);
	}

	@Override
	public <T> List<T> selectOrderBy(T entity, String orderFieldList) {
		// Add the business logic if need.
		return getSuidRich().selectOrderBy(entity, orderFieldList);
	}

	@Override
	public <T> List<T> selectOrderBy(T entity, String orderFieldList, OrderType[] orderTypes) {
		// Add the business logic if need.
		return getSuidRich().selectOrderBy(entity, orderFieldList, orderTypes);
	}

	@Override
	public <T> int update(T entity, IncludeType includeType, String... updateFieldList) {
		// Add the business logic if need.
		return getSuidRich().update(entity, includeType, updateFieldList);
	}

	@Override
	public <T> List<T> select(T entity, IncludeType includeType) {
		// Add the business logic if need.
		return getSuidRich().select(entity, includeType);
	}

	@Override
	public <T> int update(T entity, IncludeType includeType) {
		// Add the business logic if need.
		return getSuidRich().update(entity, includeType);
	}

	@Override
	public <T> int insert(T entity, IncludeType includeType) {
		// Add the business logic if need.
		return getSuidRich().insert(entity, includeType);
	}

	@Override
	public <T> int delete(T entity, IncludeType includeType) {
		// Add the business logic if need.
		return getSuidRich().delete(entity, includeType);
	}

	@Override
	public <T> List<String[]> selectString(T entity) {
		// Add the business logic if need.
		return getSuidRich().selectString(entity);
	}

	@Override
	public <T> List<String[]> selectString(T entity, String... selectFields) {
		// Add the business logic if need.
		return getSuidRich().selectString(entity, selectFields);
	}

	@Override
	public <T> String selectJson(T entity) {
		// Add the business logic if need.
		return getSuidRich().selectJson(entity);
	}

	@Override
	public <T> String selectJson(T entity, IncludeType includeType) {
		// Add the business logic if need.
		return getSuidRich().selectJson(entity, includeType);
	}

	@Override
	public <T> T selectById(Class<T> entityClass, Integer id) {
		// Add the business logic if need.
		return getSuidRich().selectById(entityClass, id);
	}

	@Override
	public <T> T selectById(Class<T> entityClass, Long id) {
		// Add the business logic if need.
		return getSuidRich().selectById(entityClass, id);
	}

	@Override
	public <T> T selectById(Class<T> entityClass, String id) {
		// Add the business logic if need.
		return getSuidRich().selectById(entityClass, id);
	}

	@Override
	public <T> List<T> selectByIds(Class<T> entityClass, String ids) {
		// Add the business logic if need.
		return getSuidRich().selectByIds(entityClass, ids);
	}

	@Override
	public int deleteById(Class c, Integer id) {
		// Add the business logic if need.
		return getSuidRich().deleteById(c, id);
	}

	@Override
	public int deleteById(Class c, Long id) {
		// Add the business logic if need.
		return getSuidRich().deleteById(c, id);
	}

	@Override
	public int deleteById(Class c, String ids) {
		// Add the business logic if need.
		return getSuidRich().deleteById(c, ids);
	}

	@Override
	public <T> List<T> select(T entity, IncludeType includeType, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().select(entity, includeType, condition);
	}

	@Override
	public <T> String selectJson(T entity, IncludeType includeType, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().selectJson(entity, includeType, condition);
	}

	@Override
	public <T> String selectJson(T entity, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().selectJson(entity, condition);
	}

	@Override
	public <T> int updateBy(T entity, String... whereFields) {
		// Add the business logic if need.
		return getSuidRich().updateBy(entity, whereFields);
	}

	@Override
	public <T> int updateBy(T entity, IncludeType includeType, String... whereFields) {
		// Add the business logic if need.
		return getSuidRich().updateBy(entity, includeType, whereFields);
	}

	@Override
	public <T> int updateBy(T entity, Condition condition, String... whereFields) {
		// Add the business logic if need.
		return getSuidRich().updateBy(entity, condition, whereFields);
	}

	@Override
	public <T> int updateById(T entity, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().updateById(entity, condition);
	}

	@Override
	public <T> int update(T entity, Condition condition, String... updateFields) {
		// Add the business logic if need.
		return getSuidRich().update(entity, condition, updateFields);
	}

	@Override
	public <T> int update(T entity, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().update(entity, condition);
	}

	@Override
	public <T> int insert(List<T> entityList) {
		// Add the business logic if need.
		return getSuidRich().insert(entityList);
	}

	@Override
	public <T> int insert(List<T> entityList, int batchSize) {
		// Add the business logic if need.
		return getSuidRich().insert(entityList, batchSize);
	}

	@Override
	public <T> int insert(List<T> entityList, String excludeFields) {
		// Add the business logic if need.
		return getSuidRich().insert(entityList, excludeFields);
	}

	@Override
	public <T> int insert(List<T> entityList, int batchSize, String excludeFields) {
		// Add the business logic if need.
		return getSuidRich().insert(entityList, batchSize, excludeFields);
	}

	@Override
	public <T> List<String[]> selectString(T entity, Condition condition) {
		// Add the business logic if need.
		return getSuidRich().selectString(entity, condition);
	}

	@Override
	public SuidRich setDynamicParameter(String para, String value) {
		// Add the business logic if need.
		return getSuidRich().setDynamicParameter(para, value);
	}

	@Override
	public <T> boolean exist(T entity) {
		// Add the business logic if need.
		return getSuidRich().exist(entity);
	}

	@Override
	public <T> int update(T oldEntity, T newEntity) {
		// Add the business logic if need.
		return getSuidRich().update(oldEntity, newEntity);
	}

	@Override
	public <T> String selectJson(T entity, String... selectField) {
		// Add the business logic if need.
		return getSuidRich().selectJson(entity, selectField);
	}

	@Override
	public <T> String selectJson(T entity, int start, int size, String... selectField) {
		// Add the business logic if need.
		return getSuidRich().selectJson(entity, start, size, selectField);
	}

	@Override
	public <T> int save(T entity) {
		// Add the business logic if need.
		return getSuidRich().save(entity);
	}

	@Override
	public <T> long insertAndReturnId(T entity, IncludeType includeType) {
		// Add the business logic if need.
		return getSuidRich().insertAndReturnId(entity, includeType);
	}

	@Override
	public <T> boolean createTable(Class<T> entityClass, boolean isDropExistTable) {
		// Add the business logic if need.
		return getSuidRich().createTable(entityClass, isDropExistTable);
	}

	@Override
	public <T> void indexNormal(Class<T> entityClass, String fields, String indexName) {
		// Add the business logic if need.
		getSuidRich().indexNormal(entityClass, fields, indexName);
	}

	@Override
	public <T> void unique(Class<T> entityClass, String fields, String indexName) {
		// Add the business logic if need.
		getSuidRich().unique(entityClass, fields, indexName);
	}

	@Override
	public <T> void primaryKey(Class<T> entityClass, String fields, String keyName) {
		// Add the business logic if need.
		getSuidRich().primaryKey(entityClass, fields, keyName);
	}
	
}
