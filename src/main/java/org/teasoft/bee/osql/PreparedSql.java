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
 * 支持带占位符的sql操作.sql语句是DB能识别的SQL,非面向对象的sql.Support sql string 
 * with placeholder.The sql statement is really DB's grammar,not object oriented type.
 * <p>支持的占位符有:? 或者   #{para} 或者   #{para%}, 都可以通过PreparedStatement防范SQL注入攻击.
 * <br>Support placeholder ? or #{para} or #{para%}
 * <p>若是可以,建议使用面向对象的操作方式,如:Suid和SuidRich,可以使用Bee缓存,获取更高的查询效率.
 * <br>若没有使用占位符,则传入空数组或Map即可.
 * <p>If possible, it is recommended to use object-oriented operation methods, such as Suid and SuidRich. 
 * <br>It can use Bee cache to achieve higher query efficiency.
 * @author Kingstar
 * @since  1.0<p>
 * 支持如name=#{name},name like #{name%}的map参数形式.<p>
 * @since  1.2
 */
public interface PreparedSql {

	/**
	 * 通过问号的占位语句查询数据.Select record(s) via the placeholder(?) statement.
	 * eg: select * from orders where userid=?
	 * @param sql 直接用?作为占位符的sql查询语句.
	 * @param returnType 返回entity的类型.
	 * @param preValues	按下标顺序给sql的占位符设值的Object数组.
	 * @return 返回returnType类型的实体List.
	 */
	public <T> List<T> select(String sql,T returnType,Object preValues[]);
	
	/**
	 * 通过问号的占位语句查询数据.Select record(s) via the placeholder(?) statement.
	 * eg: select * from orders where userid=?
	 * @param sql 直接用?作为占位符的sql查询语句.
	 * @param returnType 返回entity的类型.
	 * @param preValues	按下标顺序给sql的占位符设值的Object数组.
	 * @return 返回returnType类型的实体List.
	 */
	public <T> List<T> select(String sql,T returnType,Object preValues[],int start,int size);
	
	/**
	 * 通过变量的占位语句查询数据.entity和map都可以向参数传递值,map可以作为entity的补充,用于传递范围查询等复杂查询的参数
	 * <br>Select the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.<p>
	 * eg:select * from orders where userid=#{userid}
	 * eg:select * from orders where name like #{name%}
	 * @param sqlStr 使用#{para}作为占位符的sql查询语句.
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> select(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * 通过变量的占位语句查询数据.entity和map都可以向参数传递值,map可以作为entity的补充,用于传递范围查询等复杂查询的参数
	 * <br>Select the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.<p>
	 * eg:select * from orders where userid=#{userid}
	 * eg:select * from orders where name like #{name%}
	 * @param sqlStr 使用#{para}作为占位符的sql查询语句.
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).           
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> select(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	/**
	 * 通过问号的占位语句查询数据(只查询部分字段)
	 * <br>Select some column of record(s) via the placeholder(?) statement.<p>
	 * eg: select * from orders where userid=?
	 * @param sql 直接用?作为占位符的sql查询语句.
	 * @param returnType 返回entity的类型.
	 * @param preValues	按下标顺序给sql的占位符设值的Object数组.
	 * @return 返回returnType类型的实体List.
	 */
	public <T> List<T> selectSomeField(String sql,T returnType,Object preValues[]);
	
	/**
	 * 通过问号的占位语句查询数据(只查询部分字段)
	 * <br>Select some column of record(s) via the placeholder(?) statement.<p>
	 * eg: select * from orders where userid=?
	 * @param sql 直接用?作为占位符的sql查询语句.
	 * @param returnType 返回entity的类型.
	 * @param preValues	按下标顺序给sql的占位符设值的Object数组.
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).   
	 * @return 返回returnType类型的实体List.
	 */
	public <T> List<T> selectSomeField(String sql,T returnType,Object preValues[],int start,int size);
	
	/**
	 * 通过变量的占位语句查询数据(只查询部分字段).entity和map都可以向参数传递值,map可以作为entity的补充,用于传递范围查询等复杂查询的参数
	 * <br>Select some column of the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.<p>
	 * eg:select * from orders where userid=#{userid}
	 * eg:select * from orders where name like #{name%}
	 * @param sqlStr 使用#{para}作为占位符的sql查询语句.
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> selectSomeField(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * 通过变量的占位语句查询数据(只查询部分字段).entity和map都可以向参数传递值,map可以作为entity的补充,用于传递范围查询等复杂查询的参数
	 * <br>Select some column of the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.<p>
	 * eg:select * from orders where userid=#{userid}
	 * eg:select * from orders where name like #{name%}
	 * @param sqlStr 使用#{para}作为占位符的sql查询语句.
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).   
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> selectSomeField(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	/**
	 * 用函数查询结果.Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sql SQL select statement
	 * @param preValues	按下标顺序给sql的占位符设值的Object数组.
	 * @return 返回函数统计的值.如果统计的结果集为空,除了count返回0,其它都返回空字符.
	 * @throws ObjSQLException
	 */
	public String selectFun(String sql,Object preValues[]) throws ObjSQLException;
	
	/**
	 * 用函数查询结果.Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sqlStr SQL select statement
	 * @param map map结构的参数,通过map的key与sqlStr中变量名对应.
	 * @return 返回函数统计的值.如果统计的结果集为空,除了count返回0,其它都返回空字符.
	 * @throws ObjSQLException
	 */
	public String selectFun(String sqlStr,Map<String,Object> map) throws ObjSQLException;

	/**
	 * 查询并将每一行结果转成String数组.Select and transform every record to string array.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sql	SQL select statement
	 * @param preValues  parameter values for placeholder
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql,Object preValues[]);
	
	
	/**
	 * 查询并将每一行结果转成String数组.Select and transform every record to string array.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sql	SQL select statement
	 * @param preValues  parameter values for placeholder
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).   
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql,Object preValues[],int start,int size);
	
	/**
	 * 查询并将每一行结果转成String数组.Select and transform every record to string array.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sqlStr	SQL select statement
	 * @param map  parameter values for placeholder
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sqlStr,Map<String,Object> map);
	
	/**
	 * 查询并将每一行结果转成String数组.Select and transform every record to string array.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sqlStr	SQL select statement
	 * @param map  parameter values for placeholder
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).   
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sqlStr,Map<String,Object> map,int start,int size);
	/**
	 * 用可带问号的占位语句查询结果,并以json格式返回.Select and return json format result.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sql	SQL select statement
	 * @param preValues 占位符对应的参数数组.parameter values for placeholder
	 * @return 返回json格式结果集.json format result .
	 */
	public String selectJson(String sql,Object preValues[]);
	
	/**
	 * 用可带问号的占位语句查询结果,并以json格式返回.Select and return json format result.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sql	SQL select statement
	 * @param preValues 占位符对应的参数数组.parameter values for placeholder
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return 返回json格式结果集.json format result .
	 */
	public String selectJson(String sql,Object preValues[],int start,int size);
	
	/**
	 * 查询结果,并以json格式返回.Select and return json format result.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sqlStr	SQL select statement
	 * @param map 占位符对应的参数map.parameter values for placeholder
	 * @return 返回json格式结果集.json format result .
	 */
	public String selectJson(String sqlStr,Map<String,Object> map);
	
	/**
	 * 查询结果,并以json格式返回.Select and return json format result.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * @param sqlStr SQL select statement
	 * @param map 占位符对应的参数map.parameter values for placeholder
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return 返回json格式结果集.json format result .
	 */
	public String selectJson(String sqlStr,Map<String,Object> map,int start,int size);
	/**
	 * 用操作类型为update,insert,delete的语句更新数据库记录
	 * Modify database records with update, insert or delete statement.
	 * @deprecated 不建议使用,因为框架不知道具体是更改了什么表,会影响缓存的正确性,从而产生缓存数据不准确的危险.It is not recommended because 
	 * the framework does not know what table has been changed, which will affect the correctness of the cache and 
	 * cause the risk of inaccurate cache data.
	 * @param sql	SQL语句.SQL statement.
	 * @param preValues 占位符对应的参数数组.parameter values for placeholder
	 * @return	返回成功操作的记录行数. the number of successful records.
	 */
	@Deprecated
	public int modify(String sql,Object preValues[]);
	
	/**
	 * 用操作类型为update,insert,delete的语句更新数据库记录
	 * Modify database records with update, insert or delete statement.
	 * @deprecated 不建议使用,因为框架不知道具体是更改了什么表,会影响缓存的正确性,从而产生缓存数据不准确的危险.It is not recommended because 
	 * the framework does not know what table has been changed, which will affect the correctness of the cache and 
	 * cause the risk of inaccurate cache data.
	 * @param sql	SQL语句.SQL statement.
	 * @param map 占位符对应的参数map.parameter values for placeholder
	 * @return	返回成功操作的记录行数. the number of successful records.
	 */
	@Deprecated
	public int modify(String sql,Map<String,Object> map);
}
