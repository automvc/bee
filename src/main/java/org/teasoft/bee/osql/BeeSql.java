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
 * 直接用sql语句操作数据库的接口
 * <br>在该接口中的sql字符串要是DB能识别的SQL语句
 * <br>该接口为Bee框架使用的底层接口,不建议用户直接使用
 * <br>The interface of operating database with SQL statement directly
 * <br>The SQL string in this interface is the SQL statement that DB can recognize
 * <br>BeeSql is the underlying interface used by Bee framework, and it is not recommended for users to use it directly
 * @author Kingstar
 * Create on 2013-6-30 22:05:36
 * @since  1.0
 */
public interface BeeSql {
	
	/**
	 * 根据sql查询数据,数据类型与entity类型一致
	 * <br>According to SQL query data, data type is consistent with entity type.
	 * @param sql	SQL select statement
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity corresponding to table and can not be null.
	 * @return 可包含多个实体(多条记录)的list. list can contain more than one entity.
	 */
	public <T> List<T> select(String sql,T entity );
	
	
	/**
	 * 多表查询的方法.根据sql查询数据,数据类型与entity类型一致
	 * <br>According to SQL query more table data, data type is consistent with entity type.
	 * @param sql	SQL select statement
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity corresponding to table and can not be null.
	 * @return 可包含多个实体(多条记录)的list. list can contain more than one entity.
	 * @since 1.7
	 */
	public <T> List<T> moreTableSelect(String sql,T entity );
	
	
	/**
	 * 查询部分字段.Select some field.
	 * @param sql	SQL select statement
	 * @param entity 
	 * @return entity的list,这些entity只有查询的部分字段会设值.list entity which just has some field.
	 */
	public <T> List<T> selectSomeField(String sql,T entity ); 
	
	/**
	 * 用函数查询结果.Select result with function. SQL function: max,min,avg,sum,count. 
	 * @param sql	SQL select statement
	 * @return 函数统计的值.如果统计的结果集为空,除了count返回0,其它都返回空字符.
	 */
	public String selectFun(String sql) ;


	/**
	 * 查询并将每一行结果转成String数组.Select and transform every record to string array.
	 * @param sql	SQL select statement
	 * @return List,每个元素是一行记录转换成的string数组.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql);
	
	/**
	 * 查询并将每一行结果转成Map<String,Object>.Select and transform every record to Map<String,Object>.
	 * @param sql SQL select statement
	 * @return List,每个元素是一行记录转换成的Map<String,Object>.
	 * List, every element is a Map<String,Object>(transform from record).
	 * @since 1.9
	 */
	public List<Map<String,Object>> selectMapList(String sql);
	
	/**
	 * 查询结果,并以json格式返回.Select and return json format result.
	 * @param sql	SQL select statement
	 * @return json格式结果集.json format result .
	 */
	public String selectJson(String sql);
	
	/**
	 * 操作update,insert,delete.对应Jdbc的executeUpdate方法  
	 * <br>Operate update,insert,delete. corresponding to Jdbc executeUpdate method.
	 * @param sql  SQL statement to execute
	 * @return 成功操作的记录行数. the number of affected successfully records.
	 */
	public int modify(String sql);
	
	public long insertAndReturnId(String sql);
	
	/**
	 * 提交一批命令到数据库
	 * Submits a batch of commands to the database.
	 * @param sqls 要执行的sql语句数组 Array of SQL statements to execute
	 * @return 受影响的行数  Affected rows.
	 */
	public int batch(String sqls[]);
	
	/**
	 * 提交一批命令到数据库
	 * Submits a batch of commands to the database.
	 * @param sqls 要执行的sql语句数组 Array of SQL statements to execute
	 * @param batchSize 一个批次提交的命令数目  the size of commands in a batch
	 * @return 受影响的行数  Affected rows.
	 */
	public int batch(String []sqls,int batchSize);
}
