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
 * 支持带占位符的sql操作.sql语句是DB能识别的SQL,非面向对象的sql
 * <br>Support sql string with placeholder.The sql statement is really DB's grammar,not object oriented type.
 * <p>支持的占位符有:? 或者   #{para} 或者   #{para%}, 都可以通过PreparedStatement防范SQL注入攻击.
 * <br>Support placeholder ? or #{para} or #{para%}
 * <p>若是可以,建议使用面向对象的操作方式,如:Suid和SuidRich,可以使用Bee缓存,获取更高的查询效率.
 * <br>若没有使用占位符,则传入空数组或Map即可.
 * <p>If possible, it is recommended to use object-oriented operation methods, such as Suid and SuidRich. 
 * <br>It can use Bee cache to achieve higher query efficiency.
 * 
 * <br>注意  Notice:
 * <br>PreparedSql没有T参数的方法中,因没有与entity关联,在多数据源情况下,只会从默认数据源中获取数据.
 * <br>从V1.11开始,可以设置数据源名称.
 * <br>PreparedSql method which which no T parameter, is not associated with entity, in the case of 
 * <br> multiple Datasources, will be select the record from the default Datasource.
 * <br>from V1.11 version, can set the datasource name.
 * 
 * @author Kingstar
 * @since  1.0<p>
 * 支持如name=#{name},name like #{name%}的map参数形式.<p>
 * @since  1.2
 */
public interface PreparedSql extends CommOperate {

	/**
	 * Select record(s) via the placeholder(?) statement.
	 * <br>eg: select * from orders where userid=?
	 * @param sql SQL query statement which direct use ? as placeholder
	 * @param returnType its type same as list element.
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @return List which element type is same as returnType.
	 */
	public <T> List<T> select(String sql,T returnType,Object preValues[]);
	
	/**
	 * Select record(s) via no placeholder(?) select statement.
	 * @param sql SQL query statement(no placeholder). 
	 * @param its type same as list element.
	 * @return List which element type is same as returnType.
	 * @since V1.11
	 */
	public <T> List<T> select(String sql,T returnType);
	
	/**
	 * Select record(s) via the placeholder(?) statement,paging generate by Bee.
	 * <br>eg: select * from orders where userid=?
	 * @param sql SQL query statement(use ? placeholder).
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
	 * @param sqlStr SQL query statement(use #{para} placeholder). 
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> select(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * Select the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. 
	 * <br>Map can be used as a supplement of entity to pass parameters of complex queries such as range query.
	 * <br>paging generate by Bee
	 * <br>eg:select * from orders where userid=#{userid}
	 * <br>eg:select * from orders where name like #{name%}
	 * @param sqlStr SQL query statement(use #{para} placeholder).
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).           
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> select(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	/**
	 * 通过问号的占位语句查询数据(只查询部分字段)
	 * <br>Select some column of record(s) via the placeholder(?) statement.<p>
	 * eg: select * from orders where userid=?
	 * @param sql 直接用?作为占位符的sql查询语句.
	 * @param its type same as list element.
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @return List which element type is same as returnType.
	 */
	public <T> List<T> selectSomeField(String sql,T returnType,Object preValues[]);
	
	/**
	 * 通过问号的占位语句查询数据(只查询部分字段),其中分页语句部分由Bee生成
	 * <br>Select some column of record(s) via the placeholder(?) statement,paging generate by Bee.<p>
	 * eg: select * from orders where userid=?
	 * @param sql 直接用?作为占位符的sql查询语句.
	 * @param its type same as list element.
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).   
	 * @return List which element type is same as returnType.
	 */
	public <T> List<T> selectSomeField(String sql,T returnType,Object preValues[],int start,int size);
	
	/**
	 * 通过变量的占位语句查询数据(只查询部分字段).entity和map都可以向参数传递值,map可以作为entity的补充,用于传递范围查询等复杂查询的参数
	 * <br>Select some column of the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.<p>
	 * eg:select * from orders where userid=#{userid}
	 * eg:select * from orders where name like #{name%}
	 * @param sqlStr SQL query statement(use #{para} placeholder).
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> selectSomeField(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * 通过变量的占位语句查询数据(只查询部分字段).entity和map都可以向参数传递值,map可以作为entity的补充,用于传递范围查询等复杂查询的参数,其中分页语句部分由Bee生成
	 * <br>Select some column of the record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters. <br>
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.<p>
	 * paging generate by Bee<p>
	 * eg:select * from orders where userid=#{userid}
	 * eg:select * from orders where name like #{name%}
	 * @param sqlStr SQL query statement(use #{para} placeholder).
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).   
	 * @return 返回与entity类型一样的实体List.
	 */
	public <T> List<T> selectSomeField(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	/**
	 * 用函数查询结果.Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * <br>因没有与entity关联,在多数据源情况下,只会从默认数据源中获取数据.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sql SQL select statement
	 * @param preValues An object array that values set for the SQL placeholders in index order.
	 * @return 返回函数统计的值.如果统计的结果集为空,除了count返回0,其它都返回空字符.
	 */
	public String selectFun(String sql,Object preValues[]);
	
	/**
	 * 用函数查询结果.Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * <br>因没有与entity关联,在多数据源情况下,只会从默认数据源中获取数据.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sqlStr SQL select statement
	 * @param map map结构的参数,通过map的key与sqlStr中变量名对应.
	 * @return 返回函数统计的值.如果统计的结果集为空,除了count返回0,其它都返回空字符.
	 */
	public String selectFun(String sqlStr, Map<String, Object> map);

	/**
	 * 查询并将每一行结果转成String数组.Select and transform every record to string array.<p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * <br>因没有与entity关联,在多数据源情况下,只会从默认数据源中获取数据.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sql	SQL select statement
	 * @param preValues  parameter values for placeholder
	 * @return List can contain more than one record with String array struct.
	 * <br>List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql,Object preValues[]);
	
	
	/**
	 * Select and transform every record to string array.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * <br>paging generate by Bee.
	 * @param sql  SQL select statement
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
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sqlStr SQL select statement
	 * @param map  parameter values for placeholder
	 * @return list can contain more than one record with String array struct.
	 * List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sqlStr,Map<String,Object> map);
	
	/**
	 * Select and transform every record to string array.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
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
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sql  SQL select statement
	 * @param preValues parameter values for placeholder
	 * @return Json format result.
	 */
	public String selectJson(String sql,Object preValues[]);
	
	/**
	 * Select and return json format result.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * <br>paging generate by Bee.
	 * @param sql  SQL select statement
	 * @param preValues parameter values for placeholder
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).
	 * @return Json format result.
	 */
	public String selectJson(String sql,Object preValues[],int start,int size);
	
	/**
	 * Select and return json format result.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sqlStr SQL select statement
	 * @param map parameter values for placeholder
	 * @return Json format result.
	 */
	public String selectJson(String sqlStr,Map<String,Object> map);
	
	/**
	 * Select and return json format result.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
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
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sqlStr SQL select statement(no placeholder)
	 * @return Json format result.
	 */
	public String selectJson(String sqlStr);
	
	/**
	 * Select record(s) via the sql statement.
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * eg: select * from orders where userid=10001
	 * @param sql SQL select statement(no placeholder)
	 * @return List can contain more than one record with String array struct.
	 * <br>List, every element is string array(transform from record).
	 */
	public List<String[]> select(String sql);
	
	/**
	 * 用函数查询结果.Select result with function. SQL function: max,min,avg,sum,count. <p>
	 * 注意:因没有与entity关联,没有应用上缓存. Notice:can not use the cache because don't relay the entity.
	 * <br>因没有与entity关联,在多数据源情况下,只会从默认数据源中获取数据.
	 * <br>Because it is not associated with entity, in the case of multiple Datasources, 
	 * <br>will be select the record from the default Datasource.
	 * @param sql SQL select statement
	 * @return 返回函数统计的值.如果统计的结果集为空,除了count返回0,其它都返回空字符.
	 */
	public String selectFun(String sql);
	
	/**
	 * Modify database records with update, insert or delete statement.
	 * @deprecated It is not recommended because 
	 * <br>the framework does not know what table has been changed, which will affect the correctness 
	 * <br>of the cache and cause the risk of inaccurate cache data.
	 * @param sql SQL statement.
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
	 * @param sql SQL statement.
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 */
	public List<Map<String, Object>> selectMapList(String sql);
	
	/**
	 * Query records and return list structure data whose element is Map<String, Object>.
	 * @param sql SQL statement.
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 * @since V1.11
	 */
	public List<Map<String, Object>> selectMapList(String sql,Map<String, Object> map);
	
	
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
	 * @param sql SQL query statement(no placeholder).
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
	 * entity只解析主表的数据作为参数.
	 * @param sqlStr SQL query statement(use #{para} placeholder).
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @return 返回与entity类型一样的实体List.
	 * @since V1.11
	 */
	public <T> List<T> moreTableSelect(String sqlStr,T entity,Map<String,Object> parameterMap);
	
	/**
	 * Select the more table record(s) via the placeholder statement of variable.Both entity and map can pass values to parameters.
	 * Map can be used as a supplement of entity to pass parameters of complex queries such as range query.
	 * paging generate by Bee
	 * eg:select * from orders where userid=#{userid}
	 * eg:select * from orders where name like #{name%}
	 * 只解析主表的数据作为参数.
	 * @param sqlStr SQL query statement(use #{para} placeholder).
	 * @param entity entity中非null的值,会转换成map的元素作为参数,entity的字段会自动转成表的列名;entity也将作用返回结构的类型.
	 * @param parameterMap map结构的参数,通过map的key与sqlStr中变量名对应.
	 *            若map有元素的key与从entity转来的一样,会使用map的.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size Fetch result size (>0).           
	 * @return Entity List which element type is same as entity.
	 * @since V1.11
	 */
	public <T> List<T> moreTableSelect(String sqlStr,T entity,Map<String,Object> parameterMap,int start,int size);
	
	
    /**
	 * Insert records by batch type.
     * @param sql
     * @param parameterMapList 一行记录为List的一个元素.每个字段的值放在Map里.
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since 1.11
     */
	public int insertBatch(String sql, List<Map<String, Object>> parameterMapList);

	/**
	 * 
	 * Insert records by batch type.
     * @param sql
     * @param parameterMapList
	 * @param batchSize
	 * @return the number of inserted record(s) successfully;if fails, return -1.
	 * @since 1.11
	 */
	public int insertBatch(String sql, List<Map<String, Object>> parameterMapList, int batchSize);

	//为什么没有List<Entity> ? 假如知道实体结构的,就用面向对象.
//	public <T> int insert(String sql, List<T> parameterMapList, int batchSize);
	
}
