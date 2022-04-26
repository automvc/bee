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
import java.util.Map;

/**
 * Support sql string with placeholder.The sql statement is really DB's grammar,not object oriented type.
 * <br>Support placeholder ? or #{para} or #{para%} or #{%para} or #{%para%},
 * <br>can prevent SQL injection attacks through Preparedstatement
 * <p>If possible, it is recommended to use object-oriented operation methods, such as Suid and SuidRich. 
 * <br>It can use Bee cache to achieve higher query efficiency.
 * 
 * <br>Notice:
 * <br>PreparedSql method which no T parameter, is not associated with entity, in the case of 
 * <br> multiple dataSource, will be select the record from the default dataSource.
 * <br>from V1.11 version, can set the dataSource name.
 * 
 * @author Kingstar
 * @since  1.0<p>
 * Support map parameter forms such as name = #{name}, name like #{name%}<p>
 * @since  1.2
 */
public interface PreparedSql extends CommOperate {

	/**
	 * Select record(s) via the placeholder(?) statement.
	 * <br>eg: select * from orders where userid=?
	 * @param sql SQL select statement which direct use ? as placeholder
	 * @param returnType its type same as list element.
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @return List which element type is same as returnType.
	 */
	public <T> List<T> select(String sql,T returnType,Object preValues[]);
	
	/**
	 * Select record(s) via no placeholder(?) select statement.
	 * @param sql SQL select statement(no placeholder). 
	 * @param its type same as list element.
	 * @return List which element type is same as returnType.
	 * @since V1.11
	 */
	public <T> List<T> select(String sql,T returnType);
	
	/**
	 * Select record(s) via the placeholder(?) statement,paging generate by Bee.
	 * <br>eg: select * from orders where userid=?
	 * @param sql SQL select statement(use ? placeholder).
	 * @param its type same as list element.
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @return List which element type is same as returnType.
	 */
	public <T> List<T> select(String sql,T returnType,Object preValues[],int start,int size);
	
	/**
	 * <br>Select the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. 
	 * <br>Map can be used as a supplement of entity to pass parameters of complex queries such as range query.
	 * <br>eg:select * from orders where userid=#{userid}
	 * <br>eg:select * from orders where name like #{name%}
	 * @param sqlStr SQL select statement(use #{para} placeholder). 
	 * @param entity The non null value in entity will be converted into the element of map as the parameter, 
	 * <br>and the field of entity will be automatically converted into the column name of the table. 
	 * <br>Entity will also act as the type of the return structure.
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlstr correspond the key of map.
	 * <br>If the key of the map element is the same as that transferred from the entity, the key of the map will be used.
	 * @return Entity List which element type is same as entity.
	 */
	public <T> List<T> select(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * Select the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. 
	 * <br>Map can be used as a supplement of entity to pass parameters of complex queries such as range query.
	 * <br>paging generate by Bee
	 * <br>eg:select * from orders where userid=#{userid}
	 * <br>eg:select * from orders where name like #{name%}
	 * @param sqlStr SQL select statement(use #{para} placeholder).
	 * @param entity The non null value in entity will be converted into the element of map as the parameter, 
	 * <br>and the field of entity will be automatically converted into the column name of the table. 
	 * <br>Entity will also act as the type of the return structure.
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlstr correspond the key of map.
	 * <br>If the key of the map element is the same as that transferred from the entity, the key of the map will be used.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).           
	 * @return Entity List which element type is same as entity.
	 */
	public <T> List<T> select(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	/**
	 * Select some column of record(s) via the placeholder(?) statement.<br>
	 * eg: select * from orders where userid=?
	 * @param sql SQL select statement(use ? placeholder).
	 * @param its type same as list element.
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @return List which element type is same as returnType.
	 */
	public <T> List<T> selectSomeField(String sql,T returnType,Object preValues[]);
	
	/**
	 * Select some column of record(s) via the placeholder(?) statement,paging generate by Bee.<p>
	 * eg: select * from orders where userid=?
	 * @param sql SQL select statement(use ? placeholder).
	 * @param its type same as list element.
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).   
	 * @return List which element type is same as returnType.
	 */
	public <T> List<T> selectSomeField(String sql,T returnType,Object preValues[],int start,int size);
	
	/**
	 * Select some column of the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.
	 * <br>eg:select * from orders where userid=#{userid}
	 * <br>eg:select * from orders where name like #{name%}
	 * @param sqlStr SQL select statement(use #{para} placeholder).
	 * @param entity The non null value in entity will be converted into the element of map as the parameter, 
	 * <br>and the field of entity will be automatically converted into the column name of the table. 
	 * <br>Entity will also act as the type of the return structure.
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlstr correspond the key of map.
	 * <br>If the key of the map element is the same as that transferred from the entity, the key of the map will be used.
	 * @return Entity List which element type is same as entity.
	 */
	public <T> List<T> selectSomeField(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * Select some column of the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.<p>
	 * paging generate by Bee
	 * <br>eg:select * from orders where userid=#{userid}
	 * <br>eg:select * from orders where name like #{name%}
	 * @param sqlStr SQL select statement(use #{para} placeholder).
	 * @param entity The non null value in entity will be converted into the element of map as the parameter, 
	 * <br>and the field of entity will be automatically converted into the column name of the table. 
	 * <br>Entity will also act as the type of the return structure.
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlstr correspond the key of map.
	 * <br>If the key of the map element is the same as that transferred from the entity, the key of the map will be used.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).   
	 * @return Entity List which element type is same as entity.
	 */
	public <T> List<T> selectSomeField(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	/**
	 * Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sql SQL select statement(use ? placeholder).
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @return The value of function statistics. 
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 */
	public String selectFun(String sql,Object preValues[]);
	
	/**
	 * Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sqlStr SQL select statement
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlStr correspond the key of map.
	 * @return The value of function statistics. 
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 */
	public String selectFun(String sqlStr, Map<String, Object> parameterMap);

	/**
	 * Select and transform every record to string array.<p>
	 * Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sql	SQL select statement(use ? placeholder).
	 * @param preValues  parameter values for placeholder
	 * @return List can contain more than one record with String array struct.
	 * <br>List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql,Object preValues[]);
	
	
	/**
	 * Select and transform every record to string array.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * <br>paging generate by Bee.
	 * @param sql  SQL select statement(use ? placeholder).
	 * @param preValues  parameter values for placeholder
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).   
	 * @return List can contain more than one record with String array struct.
	 * <br>List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql, Object preValues[], int start, int size);
	
	/**
	 * Select and transform every record to string array.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sqlStr SQL select statement
	 * @param map  parameter values for placeholder
	 * @return list can contain more than one record with String array struct.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sqlStr,Map<String,Object> map);
	
	/**
	 * Select and transform every record to string array.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * <br>paging generate by Bee.
	 * @param sqlStr SQL select statement
	 * @param map  parameter values for placeholder
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).   
	 * @return list can contain more than one record with String array struct.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sqlStr,Map<String,Object> map,int start,int size);
	/**
	 * Select and return json format result.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sql  SQL select statement(use ? placeholder).
	 * @param preValues parameter values for placeholder
	 * @return Json format result.
	 */
	public String selectJson(String sql,Object preValues[]);
	
	/**
	 * Select and return json format result.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * <br>paging generate by Bee.
	 * @param sql  SQL select statement(use ? placeholder).
	 * @param preValues parameter values for placeholder
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).
	 * @return Json format result.
	 */
	public String selectJson(String sql,Object preValues[],int start,int size);
	
	/**
	 * Select and return json format result.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sqlStr SQL select statement
	 * @param map parameter values for placeholder
	 * @return Json format result.
	 */
	public String selectJson(String sqlStr,Map<String,Object> map);
	
	/**
	 * Select and return json format result.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * <br>paging generate by Bee.
	 * @param sqlStr SQL select statement
	 * @param map parameter values for placeholder
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).
	 * @return Json format result.
	 */
	public String selectJson(String sqlStr,Map<String,Object> map,int start,int size);
	
	/**
	 * Select and return json format result.<p>
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sqlStr SQL select statement(do not contain placeholder)
	 * @return Json format result.
	 */
	public String selectJson(String sqlStr);
	
	/**
	 * Select record(s) via the sql statement.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * eg: select * from orders where userid=10001
	 * @param sql SQL select statement(do not contain placeholder)
	 * @return List can contain more than one record with String array struct.
	 * <br>List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql);
	
	/**
	 * Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sql SQL select statement(do not contain placeholder)
	 * @return The value of function statistics. 
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 */
	public String selectFun(String sql);
	
	/**
	 * Modify database records with update, insert or delete statement.
	 * @deprecated It is not recommended because 
	 * <br>the framework does not know what table has been changed, which will affect the correctness 
	 * <br>of the cache and cause the risk of inaccurate cache data.
	 * @param sql SQL select statement(use ? placeholder).
	 * @param preValues parameter values for placeholder
	 * @return	the number of affected successfully records.
	 */
	@Deprecated
	public int modify(String sql,Object preValues[]);
	
	/**
	 * Modify database records with update, insert or delete statement.
	 * @deprecated It is not recommended because 
	 * the framework does not know what table has been changed, which will affect the correctness of the cache and 
	 * cause the risk of inaccurate cache data.
	 * @param sql SQL statement.
	 * @param map parameter values for placeholder
	 * @return the number of affected successfully records.
	 */
	@Deprecated
	public int modify(String sql,Map<String,Object> map);
	
	/**
	 * Modify database records with update, insert or delete statement.
	 * @deprecated It is not recommended because the framework does not know what table has been changed, 
	 * <br>which will affect the correctness of the cache and cause the risk of inaccurate cache data.
	 * @param sql SQL statement.
	 * @return	the number of affected successfully records.
	 * @since 1.9
	 */
	@Deprecated
	public int modify(String sql);
	
	/**
	 * Query records and return list structure data whose element is Map<String, Object>.
	 * @param sql SQL statement(do not contain placeholder).
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 */
	public List<Map<String, Object>> selectMapList(String sql);
	
	/**
	 * Query records and return list structure data whose element is Map<String, Object>.
	 * @param sql SQL statement.
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 * @since V1.11
	 */
	
	/**
	 * Query records and return list structure data whose element is Map<String, Object>.
	 * @param sqlStr SQL statement.
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlStr correspond the key of map.
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 * @since V1.11
	 */
	public List<Map<String, Object>> selectMapList(String sqlStr,Map<String, Object> parameterMap);
	
	
	/**
	 * Query records and return list structure data whose element is Map<String, Object>.
	 * <br>paging generate by Bee.
	 * @param sql SQL statement.
	 * @param parameterMap
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).     
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 * @since V1.11
	 */
	public List<Map<String, Object>> selectMapList(String sql,Map<String,Object> parameterMap,int start,int size);
	
	/**
	 * Select more table record(s) via no placeholder(?) select statement.
	 * @param sql SQL select statement(no placeholder).
	 * @param its type same as list element.
	 * @return List which element type is same as returnType.
	 * @since V1.11
	 */
	public <T> List<T> moreTableSelect(String sql, T returnType);
	
	/**
	 * Select the more table record(s) via the placeholder statement of variable.
	 * <br>Both entity and map can pass values to parameters.
	 * <br>Map can be used as a supplement of entity to pass parameters of complex queries such as range query.
	 * <br>eg:select * from orders where userid=#{userid}
	 * <br>eg:select * from orders where name like #{name%}
	 * <br>Only the data of the main table is parsed as a parameter.
	 * @param sqlStr SQL select statement(use #{para} placeholder).
	 * @param entity The non null value in entity will be converted into the element of map as the parameter, 
	 * <br>and the field of entity will be automatically converted into the column name of the table. 
	 * <br>Entity will also act as the type of the return structure.
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlstr correspond the key of map.
	 * <br>If the key of the map element is the same as that transferred from the entity, the key of the map will be used.
	 * @return Entity List which element type is same as entity.
	 * @since V1.11
	 */
	public <T> List<T> moreTableSelect(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * Select the more table record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters.
	 * <br>Map can be used as a supplement of entity to pass parameters of complex queries such as range query.
	 * <br>paging generate by Bee
	 * <br>eg:select * from orders where userid=#{userid}
	 * <br>eg:select * from orders where name like #{name%}
	 * <br>Only the data of the main table is parsed as a parameter.
	 * @param sqlStr SQL select statement(use #{para} placeholder).
	 * @param entity The non null value in entity will be converted into the element of map as the parameter, 
	 * <br>and the field of entity will be automatically converted into the column name of the table. 
	 * <br>Entity will also act as the type of the return structure.
	 * @param parameterMap The parameters of map structure correspond, the variable name in sqlstr correspond the key of map.
	 * <br>If the key of the map element is the same as that transferred from the entity, the key of the map will be used.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).           
	 * @return Entity List which element type is same as entity.
	 * @since V1.11
	 */
	public <T> List<T> moreTableSelect(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	
    /**
	 * Insert records by batch type.
     * @param sql
     * @param parameterMapList every element of List is a map corresponds to one record, every field add in map struct.
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since 1.11
     */
	public int insertBatch(String sql, List<Map<String, Object>> parameterMapList);

	/**
	 * 
	 * Insert records by batch type and batchSize.
     * @param sql
     * @param parameterMapList every element of List is a map corresponds to one record, every field add in map struct.
	 * @param batchSize
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since 1.11
	 */
	public int insertBatch(String sql, List<Map<String, Object>> parameterMapList, int batchSize);

	//why has not List<Entity> ? If you know the entity structure, use object-oriented way.
//	public <T> int insertBatch(String sql, List<T> parameterMapList, int batchSize);
	
}
