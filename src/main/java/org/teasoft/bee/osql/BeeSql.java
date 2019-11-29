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
 * 直接用sql语句操作数据库的接口
 * 在该接口中的sql字符串要是DB能识别的SQL语句
 * The interface of operating database with SQL statement directly
 * The SQL string in this interface is the SQL statement that DB can recognize
 * @author Kingstar
 * Create on 2013-6-30 22:05:36
 * @since  1.0
 */
public interface BeeSql {
	
	/**
	 * 根据sql查询数据,数据类型与entity类型一致
	 * @param sql	SQL select statement
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity corresponding to table and can not be null.
	 * @return 返回的list可包含多个实体(多条记录) return list can contain more than one entity
	 */
	public <T> List<T> select(String sql,T entity );
	
	/**
	 * 查询部分字段  select some field
	 * @param sql	SQL select statement
	 * @param entity 
	 * @return
	 */
	public <T> List<T> selectSomeField(String sql,T entity );  //调用者:public <T> List<T> select(T entity, String selectField)
	
	/**
	 * 用函数查询结果.select result with function. SQL function: max,min,avg,sum,count. 
	 * @param sql	SQL select statement
	 * @return 返回函数统计的值.如果统计的结果集为空,除了count返回0,其它都返回空字符.
	 * @throws ObjSQLException
	 */
	public String selectFun(String sql) throws ObjSQLException;


	/**
	 * 查询并将每一行结果转成String数组.select and transform every record to string array.
	 * @param sql	SQL select statement
	 * @return List,每个元素是一行记录转换成的string数组.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql);    //PreparedSqlLib ObjSQLRich有调用
	
	/**
	 * 查询结果,并以json格式返回.select and return json format result.
	 * @param sql	SQL select statement
	 * @return 返回json格式结果集.json format result .
	 */
	public String selectJson(String sql);
	
	/**
	 * 操作update,insert,delete.对应Jdbc的executeUpdate方法
	 * operate update,insert,delete. corresponding to Jdbc executeUpdate method.
	 * @param sql  SQL statement to execute
	 * @return the number of successful records 返回成功操作的记录行数
	 */
	public int modify(String sql);
	
	/**
	 * 提交一批命令到数据库
	 * Submits a batch of commands to the database.
	 * @param sqls 要执行的sql语句数组 Array of SQL statements to execute
	 * @return 包含批中每个命令的一个元素的更新计数所组成的数组
	 * an array of update counts containing one element for each
     * command in the batch.  The elements of the array are ordered according
     * to the order in which commands were added to the batch.
	 */
	public int[] batch(String sqls[]);
	
	/**
	 * 提交一批命令到数据库
	 * Submits a batch of commands to the database.
	 * @param sqls 要执行的sql语句数组 Array of SQL statements to execute
	 * @param batchSize
	 * @return 包含批中每个命令的一个元素的更新计数所组成的数组
	 * an array of update counts containing one element for each
     * command in the batch.  The elements of the array are ordered according
     * to the order in which commands were added to the batch.
	 */
	public int[] batch(String []sqls,int batchSize);
}
