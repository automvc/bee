/*
 * Copyright 2020-2022 the original author.All rights reserved.
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

package org.teasoft.bee.app;

import java.util.List;
import java.util.Map;

/**
 * Operate the SQLite database interface of app (Android, Harmony, etc.) environment
 * Usually, this interface is not used directly, but indirectly through Suid,SuidRich,MoreTable,MapSuid,PreparedSql.
 * @author Kingstar
 * @since 1.17
 */
public interface BeeSqlForApp {

	/**
	 * 
	 * @param sql
	 * @param entity
	 * @param selectionArgs
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> select(String sql, Class<T> entityClass, String[] selectionArgs);

	/**
	 * @param sql
	 * @param selectionArgs
	 * @return The value of function statistics. 
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 */
	public String selectFun(String sql, String[] selectionArgs);

	/**
	 * 
	 * @param sql
	 * @param bindArgs
	 * @return the number of affected successfully records.
	 */
	public int modify(String sql, Object[] bindArgs);

	/**
	 * 
	 * @param sql
	 * @param selectionArgs
	 * @return  List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql, String[] selectionArgs);

	/**
	 * Select and transform every record to Map<String,Object>.
	 * 
	 * @param sql SQL select statement
	 * @return List, every element is a Map<String,Object>(transform from record).
	 */
	public List<Map<String, Object>> selectMapList(String sql, String[] selectionArgs);
	
	/**
	 * select maplist with column name.
	 * this method just use internally.
	 * @param sql
	 * @param selectionArgs
	 * @return List, every element is a Map<String,Object>(transform from record,and the map key use ColumnName).
	 */
	public List<Map<String, String>> selectMapListWithColumnName(String sql, String[] selectionArgs);
	
	/**
	 * Select and return json format result.
	 * 
	 * @param sql SQL select statement
	 * @return json format result .
	 */
	public String selectJson(String sql, String[] selectionArgs, Class entityClass);
	
	/**
	 * 
	 * @param sql
	 * @param bindArgs
	 * @return the value of primary key.
	 */
	public long insertAndReturnId(String sql, Object[] bindArgs); 
	
	/**
	 * 
	 * @param sql
	 * @param listBindArgs
	 * @return Affected rows.
	 */
	public int batchInsert(String sql,List<Object[]> listBindArgs);    

}
