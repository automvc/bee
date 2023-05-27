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

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * The interface of operating database with SQL statement directly.
 * <br>The SQL string in this interface is the SQL statement that DB can recognize.
 * <br>BeeSql is the underlying interface used by Bee framework, and it is not 
 * <br>recommended for users to use it directly.
 * @author Kingstar
 * Create on 2013-6-30 22:05:36
 * @since  1.0
 */
public interface BeeSql {
	
	/**
	 * According to SQL query data, data type is consistent with entity type.
	 * @param sql	SQL select statement
	 * @param entityClass The entity class corresponding to table and can not be null. (update in v2.0)
	 * @return List can contain more than one entity.
	 */
	public <T> List<T> select(String sql, Class<T> entityClass);
	
	/**
	 * Select some field.
	 * @param sql	SQL select statement
	 * @param entityClass The entity class corresponding to table and can not be null. (update in v2.0)
	 * @return List entity which just has some field.
	 */
	public <T> List<T> selectSomeField(String sql, Class<T> entityClass);
	
	/**
	 * Select result with function. SQL function: max,min,avg,sum,count. 
	 * @param sql	SQL select statement
	 * @return The value of function statistics. 
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 * 
	 */
	public String selectFun(String sql) ;


	/**
	 * Select and transform every record to string array.
	 * @param sql	SQL select statement
	 * @return List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql);
	
	/**
	 * Select and return json format result.
	 * @param sql	SQL select statement
	 * @return json format result .
	 */
	public String selectJson(String sql);
	
	/**
	 * Operate update,insert,delete. corresponding to Jdbc executeUpdate method.
	 * @param sql  SQL statement to execute
	 * @return the number of affected successfully records.
	 */
	public int modify(String sql);
	
	/**
	 * insert and return the value of primary key.
	 * @param sql SQL statement to execute
	 * @return the value of primary key.
	 */
	public long insertAndReturnId(String sql);
	
	/**
	 * Submits a batch of commands to the database.
	 * @param sqls Array of SQL statements to execute
	 * @return Affected rows.
	 */
	public int batch(String sqls[]);
	
	/**
	 * Submits a batch of commands to the database.
	 * @param sqls Array of SQL statements to execute
	 * @param batchSize the size of commands in a batch
	 * @return Affected rows.
	 */
	public int batch(String []sqls,int batchSize);
	
	/**
	 * According to SQL query more table data, data type is consistent with entity type.
	 * @param sql  SQL select statement
	 * @param entity The entity corresponding to table and can not be null.
	 * @return List can contain more than one entity.
	 * @since 1.7
	 */
	public <T> List<T> moreTableSelect(String sql,T entity );
	
	/**
	 * Select and transform every record to Map<String,Object>.
	 * @param sql SQL select statement
	 * @return List, every element is a Map<String,Object>(transform from record).
	 * @since 1.9
	 */
	public List<Map<String,Object>> selectMapList(String sql);
	
	/**
	 * select ResultSet.After using the returned ResultSet results, call HoneyContext.clearConnForSelectRs() to close the connection.
	 * @param sql SQL select statement
	 * @return ResultSet
	 */
	public ResultSet selectRs(String sql);
}
