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

package org.bee.osql;

/**
 * Object to SQL string for rich Suid
 * 
 * @author Kingstar
 * @since  1.0
 */
public interface ObjToSQLRich extends ObjToSQL{

	public <T> String toSelectSQL(T entity,int size);
	public <T> String toSelectSQL(T entity,int from,int size);
	public <T> String toSelectSQL(T entity,String fieldList) throws ObjSQLException;
	
	public <T> String toUpdateSQL(T entity,String updateFieldList) throws ObjSQLException;
	public <T> String toUpdateSQL(T entity,String updateFieldList,IncludeType includeType) throws ObjSQLException;
	
	public <T> String toSelectFunSQL(T entity,FunctionType functionType, String FieldForFun) throws ObjSQLException;
	
	public <T> String toSelectOrderBySQL(T entity, String orderFieldList) throws ObjSQLException;
	public <T> String toSelectOrderBySQL(T entity, String orderFieldList,OrderType[] orderTypes) throws ObjSQLException;

	public  <T> String toSelectSQL(T entity, IncludeType includeType);
	public  <T> String toDeleteSQL(T entity, IncludeType includeType);
	public  <T> String toInsertSQL(T entity, IncludeType includeType);
	public  <T> String toUpdateSQL(T entity, IncludeType includeType);
	
	public  <T> String[] toInsertSQL(T[] entity);
	public  <T> String[] toInsertSQL(T[] entity,String excludeFieldList);
	
	public  String toDeleteByIdSQL(Class c, Integer id);
	public  String toDeleteByIdSQL(Class c, Long id);
	public  String toDeleteByIdSQL(Class c, String ids);

	public  <T> String toSelectByIdSQL(T entity, Integer id);
	public  <T> String toSelectByIdSQL(T entity, Long id);
	public  <T> String toSelectByIdSQL(T entity, String ids);

	
}
