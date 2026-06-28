/*
 * Copyright 2016-2026 the original author.All rights reserved.
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

package org.teasoft.bee.osql.api;

import java.util.List;

import org.teasoft.bee.osql.CommOperate;

/**
 * More table(multi-table) Select/Update/Insert/Delete.
 * 
 * In sharding mode, the main table and sub-table need map to same dataSource.
 * <p>
 * example:
<p> 
<p> public class MoreTableExample {
<p> 	public static void main(String[] args) {
<p> 		MoreTable moreTable = BF.getMoreTable();
<p> 		Province province = new Province();
<p> 		List<Province> list1 = moreTable.select(province, 0, 10); // 查询前10条记录
<p> 		if (list1 != null) {
<p> 			for (int i = 0; i < list1.size(); i++)
<p> 				Logger.info(JacksonJsonUtil.toJson(list1.get(i)));
<p> 		}
<p> 	}
<p> }
<p> 
<p> class Province {
<p> 	private Integer id;
<p> 	private String name;
<p> 	private Integer level;
<p> 	private String remark;
<p> 	@JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.JOIN)
<p> 	private List<City> listCity;
<p> 	// @JoinTable(mainField = { "id" }, subField = { "provinceId" }, joinType = JoinType.LEFT_JOIN)
<p> 	// need use LEFT_JOIN,or would effect listCity
<p> 	// ProvinceHistory provinceHistory; // Province History
<p> 	@JoinTable(mainField = { "id" }, subField = { "fId" }, joinType = JoinType.LEFT_JOIN)
<p> 	private News news;
<p> 	// ignore getter,setter
<p> }
<p> 
<p> class City {
<p> 	private Integer id;
<p> 	private String name;
<p> 	private Integer level;
<p> 	private String remark;
<p> 	private Integer provinceId;
<p> 	@JoinTable(mainField = { "id" }, subField = { "cityId" }, joinType = JoinType.JOIN, subClass = Town.class)
<p> 	private Town town;
<p> 	// ignore getter,setter
<p> }
<p> 
<p> class Town {
<p> 	private Integer id;
<p> 	private String name;
<p> 	private Integer level;
<p> 	private String remark;
<p> 	private Integer cityId;
<p> 	@JoinTable(mainField = { "id" }, subField = { "townId" }, joinType = JoinType.JOIN)
<p> 	private List<Village> listVillage;
<p> 	// ignore getter,setter
<p> }
<p> 
<p> class Village {
<p> 	private Integer id;
<p> 	private String name;
<p> 	private Integer level;
<p> 	private String remark;
<p> 	private Integer townId;
<p> 	@JoinTable(mainField = { "id" }, subField = { "villageId" }, joinType = JoinType.JOIN)
<p> 	private Road road;
<p> 	// ignore getter,setter
<p> }
<p> 
 * 
 * @author Kingstar
 * @since  3.0.0
 */
public interface MoreTable extends CommOperate {

	/**
	 * According to entity object select records from database.
	 * @param entity table's entity(do not allow null).<br>
	 * entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty string as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @return list can contain more than one entity
	 */
	public <T> List<T> select(T entity);

	/**
	 * According to entity object select records from database.
	 * @param entity table's entity(do not allow null).<br>
	 * entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty string as filter condition, <br>
	 * the operator is equal sign. eg:field=value
	 * @param start Start index, min value is 0 or 1(eg:MySQL is 0, Oracle is 1).
	 * @param size Fetch result size (>0).
	 * @return list can contain more than one entity
	 */
	public <T> List<T> select(T entity, int start, int size);

	/**
	 * Select the records according to entity and condition.
	 * @param entity table's entity(do not allow null).
	 * @param condition If the field of entity is not null or empty, 
	 * <br>it will be translate to field=value.Other can define with condition. 
	 * @return list can contain more than one entity
	 */
	public <T> List<T> select(T entity, Condition condition);

	/**
	 * set dynamic parameter for dynamic table & entity name
	 * <br>This method is called earlier than the select methods.
	 * @param param parameter name
	 * @param value parameter value
	 * @return MoreTable
	 * @since 1.9
	 */
	public MoreTable setDynamicParameter(String param, String value);

	/**
	 * insert entity. support oneToOne/oneToMany.
	 * If the primary key of the main table is used for the foreign key of the sub table, it will be automatically filled in.
	 * The multiple tables modify is done by calling suidRich, so Interceptor use suidRich's.
	 * @param entity table's entity(do not allow null).
	 * @return returns the number of affected records in the main table; if fails, return -1.
	 * @since 2.1.8
	 */
	public <T> int insert(T entity);

	/**
	 * Update the main entity (main table) and the sub-entity (sub table) that meet the conditions.
	 * This method uses the primary key as the filtering condition to determine the entity, 
	 * so the primary key field of the entity must not be empty.
	 * When all the foreign key corresponding fields are set in the main table, the sub table will be automatically 
	 * updated in association.
	 * If not all the foreign key corresponding fields are set in the main table, the sub table will also be automatically 
	 * updated in association if all the foreign key values are set in the sub table; otherwise, it will not be updated.
	 * The multiple tables modify is done by calling suidRich, so Interceptor use suidRich's.
	 * @param entity
	 * @return returns the number of affected records in the main table.
	 * @since 2.1.8
	 */
	public <T> int update(T entity);

	/**
	 * Delete the main entity (main table) and the sub-entity (sub table) that meet the conditions.
	 * When all the foreign key corresponding fields are set in the main table, the sub table will be automatically updated 
	 * in association.
	 * If not all the foreign key corresponding fields are set in the main table, the sub table will also be automatically 
	 * updated in association if all the foreign key values are set in the sub table; otherwise, it will not be updated.
	 * The multiple tables modify is done by calling suidRich, so Interceptor use suidRich's.
	 * @param entity
	 * @return returns the number of affected records in the main table.
	 * @since 2.1.8
	 */
	public <T> int delete(T entity);

	/**
	 * Select result with one function,just select one function.
	 * eg select max users id:
	 * String maxUsersId= moreTable.selectWithFun(new Users(),BF.getCondition().selectFun(FunctionType.MAX, "users.id"));
	 * @param entity table's entity(do not allow null). 
	 * @param condition Condition instance.
	 * <br>here will ignore the condition's selectFun method.
	 * @return one function result.
	 * <br>If the result set of statistics is empty,the count return 0,the other return empty string.
	 * @since 2.4.0
	 */
	public <T> String selectWithFun(T entity, Condition condition);

	/**
	 * total number of statistical records.
	 * @param entity  table's entity(do not allow null).
	 * @return total number of records that satisfy the condition.
	 * @since 2.4.0
	 */
	public <T> int count(T entity);

	/**
	 * total number of statistical records.
	 * @param entity table's entity(do not allow null).
	 * @param condition Condition as filter the record.
	 * @return total number of records that satisfy the condition.
	 * @since 2.4.0
	 */
	public <T> int count(T entity, Condition condition);

	/**
	 * Instead of returning data in a entity structure, it uses a character array in List.
	 * @param entity table's entity(do not allow null).
	 * @param condition Condition as filter the record.
	 * @return list can contain more than one record with String array struct.
	 * @since 2.4.0
	 */
	public <T> List<String[]> selectString(T entity, Condition condition);

//	/**
//	 * Select and return data in Json format according to entity object.
//	 * @param entity table's entity(do not allow null).
//	 * @param condition Condition as filter the record.
//	 * @return Json string, it transform from list which can contain more than one entity.
//	 * @since 2.4.0
//	  can replace this method as below:
//	  List<EntityClass> list = moreTable.select(entityClass, condition);
//    then use json tool transfer the list
//	 */
//	public <T> String selectJson(T entity, Condition condition);

}
