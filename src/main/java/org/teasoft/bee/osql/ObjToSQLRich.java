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

/**
 * 对象到SQL的转换(对应SuidRich).Object to SQL string for SuidRich. 
 * 
 * @author Kingstar
 * @since  1.0
 */
public interface ObjToSQLRich extends ObjToSQL {

	public <T> String toSelectSQL(T entity,int size);
	public <T> String toSelectSQL(T entity,int start,int size);
	public <T> String toSelectSQL(T entity,String fields);
	public <T> String toSelectSQL(T entity,String selectFields,int start,int size);
	
	public <T> String toUpdateSQL(T entity,String updateFields);
	public <T> String toUpdateSQL(T entity,String updateFields,IncludeType includeType);
	
	public <T> String toSelectFunSQL(T entity,FunctionType functionType, String fieldForFun,Condition condition);
	
	public <T> String toSelectOrderBySQL(T entity, String orderFields);
	public <T> String toSelectOrderBySQL(T entity, String orderFields,OrderType[] orderTypes);

	public  <T> String toSelectSQL(T entity, IncludeType includeType);
	public  <T> String toDeleteSQL(T entity, IncludeType includeType);
	public  <T> String toInsertSQL(T entity, IncludeType includeType);
	public  <T> String toUpdateSQL(T entity, IncludeType includeType);
	
	public  <T> String[] toInsertSQL(T[] entity);
	public  <T> String[] toInsertSQL(T[] entity,String excludeFields);
	public  <T> String[] toInsertSQL(T[] entity,int batchSize,String excludeFields);
	
	public  String toDeleteByIdSQL(Class c, Integer id);
	public  String toDeleteByIdSQL(Class c, Long id);
	public  String toDeleteByIdSQL(Class c, String ids);

	public  <T> String toSelectByIdSQL(T entity, Integer id);
	public  <T> String toSelectByIdSQL(T entity, Long id);
	public  <T> String toSelectByIdSQL(T entity, String ids);
	
    /**
     * @param entity
     * @param includeType
     * @param condition
     * @return the sql string.
     * @since  1.6
     */
	public  <T> String toSelectSQL(T entity, IncludeType includeType, Condition condition);
	public <T> String toUpdateBySQL(T entity,String whereFields);
	public <T> String toUpdateBySQL(T entity,String whereFields,IncludeType includeType);
	
	/**
	 * 
	 * @param entity
	 * @param whereFields
	 * @param condition
	 * @return the sql string.
	 * @since 1.7.2
	 */
	public <T> String toUpdateBySQL(T entity, String whereFields, Condition condition);

	/**
	 * 
	 * @param entity
	 * @param updateFields
	 * @param condition
	 * @return the sql string.
	 * @since 1.7.2
	 */
	public <T> String toUpdateSQL(T entity, String updateFields, Condition condition);

	
}
