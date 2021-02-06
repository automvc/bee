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
 * 数据库操作接口,包括查,改,增,删 Suid (select,update,insert,delete),
 * 该接口比Suid接口提供更多的参数选择
 * <br>Database operation: Suid (select,update,insert,delete),
 * it supports more parameters than Suid.
 * @author Kingstar
 * Create on 2013-6-30 22:06:18
 * @since  1.0
 */
public interface SuidRich extends Suid {
	
	/**
	 * 根据实体对象entity查询数据,且可以分页
	 * <br>Select record(s) according to entity object,and can specify page information.
	 * @param entity 实体类对象,且不能为空. table's entity(do not allow null).
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value.<br>
	 * entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty field as filter condition, <br>
	 * the operator is equal sign.eg:field=value<br>
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 */
	public <T> List<T> select(T entity,int size);
	
	/**
	 * 根据实体对象entity查询数据,且可以分页
	 * <br>Select record(s) according to entity object,and can specify page information.
	 * @param entity 实体类对象,且不能为空. table's entity(do not allow null).
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value.<br>  
	 * entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty field as filter condition, <br>
	 * the operator is equal sign.eg:field=value
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  
	 * <br>start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return 可包含多个实体(多条记录)的list. list can contain more than one entity
	 */
	public <T> List<T> select(T entity,int start,int size);
	
	/**
	 * 查询实体时,只查询部分一部分字段.Just select some fields.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param selectFields 需要查询的字段,多个用逗号隔开. select fields,if more than one,separate with comma.
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 */
	public <T> List<T> select(T entity,String selectFields);
	
	/**
	 * 查询实体时,只查询部分一部分字段,且可以分页 
	 * <br>Just select some fields,and can specify page information.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param selectFields 需要查询的字段,多个用逗号隔开. select fields,if more than one,separate with comma.
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  
	 * <br>start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 * @since 1.4.3
	 */
	public <T> List<T> select(T entity,String selectFields,int start,int size);
	
	/**
	 * 查询实体,每个字段都是以字符串类型返回 
	 * <br>Select entity,every field will return the string type.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 */
	public <T> List<String[]> selectString(T entity); 
	
	/**
	 * 查询部分字段,每个字段都是以字符串类型返回 
	 * <br>Select some field, every field will return the string type. 
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param selectFields  需要查询的字段,多个用逗号隔开. Select fields,if more than one,separate with comma.
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 */
	public <T> List<String[]> selectString(T entity,String selectFields); 
	
	
	/**
	 * 不以具体实体结构返回数据,而是用字符数组的List 
	 * <br>Instead of returning data in a entity structure, it uses a character array in List.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param condition condition.若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 * @since 1.9
	 */
	public <T> List<String[]> selectString(T entity,Condition condition); 
	
	/**
	 * 根据实体对象entity查询数据,并返回Json格式结果
	 * <br>Select and return data in Json format according to entity object.
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * @return 可包含多个实体(多条记录)的list转换成的json格式的字符串. 
	 * <br>Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public <T> String selectJson(T entity);
	
	/**
	 * 查询一个实体.Select one record.  
	 * @param entity 实体类对象
	 * @return 只返回一个实体,数量不为1时返回null.return one record,if the size do not equal one, return null.
	 */
	public <T> T selectOne(T entity);
	
	/**
	 * 使用函数查询一个统计结果.Select result with one function,Just select one function.
	 * @param entity 传入的实体对象,且不能为空
	 * @param fieldForFun 需要使用函数的字段
	 * @param functionType MAX,MIN,SUM,AVG,COUNT
	 * @return 返回使用函数查询结果.one function result.
	 */
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun);
	
	/**
	 * 使用函数查询一个统计结果,通过Condition可添加复杂过滤条件.只查询一个统计结果. 
	 * Select result with one function,Just select one function.
	 * @param entity 传入的实体对象,且不能为空
	 * @param fieldForFun 需要使用函数的字段
	 * @param functionType MAX,MIN,SUM,AVG,COUNT
	 * @param condition condition.若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * <br>condition的selectFun方法将被忽略.will ignore the condition's selectFun method.
	 * @return 返回使用函数查询结果.one function result.
	 * @since 1.9
	 */
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun, Condition condition); //selectOneFun
	
	public <T> int count(T entity);

	public <T> int count(T entity, Condition condition);
	
	/**
	 * 查询应用排序的结果,排序的字段默认按升序排列 
	 * Select result with order,order type default is:asc
	 * @param entity 传入的实体对象,且不能为空
	 * @param orderFields 排序字段列表,多个用逗号隔开
	 * @return 可包含多个有排序的实体(多条记录)的list. list which contains more than one entity.
	 */
	public <T> List<T> selectOrderBy(T entity,String orderFields);
	
	/**
	 * 查询应用排序的结果 
	 * Select result with order.
	 * @param entity 传入的实体对象,且不能为空
	 * @param orderFields 排序字段列表,多个用逗号隔开.order fields,if more than one,separate with comma.
	 * @param orderTypes 排序类型列表
	 * @return 可包含多个有排序的实体(多条记录)的list. list which contains more than one entity.
	 */
	public <T> List<T> selectOrderBy(T entity,String orderFields,OrderType[] orderTypes);
	
	/**
	 * 更新记录,且可以指定需要更新的字段.Update record, can list update fields. 
	 * @param entity 实体类对象,不能为空
	 * @param updateFields 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新),该属性不允许为空,
	 * <br>除了updateFields中声明要更新的字段,其它非空,非null的字段作为过滤条件,转成SQL的where表达式.
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 */
	public <T> int update(T entity,String updateFields);
	
	/**
	 * 根据实体对象entity更新数据,可以指定需要更新的字段.Update record according to entity.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param updateFields 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新),该属性不允许为空,且不受includeType参数的影响,默认每个字段会被转化成SQL update的set表达式
	 * @param includeType 空字符串与null是否包含设置(是否作为过滤条件)
	 * @return  成功更新的记录数.the numbers of update record(s) successfully.
	 */
	public <T> int update(T entity,String updateFields,IncludeType includeType);
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entity 与表对应的实体对象数组,且不能为空. table's entity array(do not allow null).
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 */
	public <T> int insert(T[] entity);
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entity 与表对应的实体对象,且不能为空. table's entity array(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 */
	public <T> int insert(T[] entity,int batchSize);
	
	/**
	 * 批量插入数据,且可以声明不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity 与表对应的实体对象数组,且不能为空. table's entity array(do not allow null).
	 * @param excludeFields 声明不用插入的字段列表.fields list that don't need to insert .
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 */
	public <T> int insert(T[] entity,String excludeFields);
	
	/**
	 * 批量插入数据,且可以指定不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entity 与表对应的实体对象数组,且不能为空. table's entity array(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @param excludeFields 声明不用插入的字段列表.Don't insert fields list.
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 */
	public <T> int insert(T[] entity,int batchSize,String excludeFields);
	
	
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList);
	
	/**
	 * 批量插入数据.Insert records by batch type.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,int batchSize);
	
	/**
	 * 批量插入数据,且可以声明不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @param excludeFields 声明不用插入的字段列表.fields list that don't need to insert .
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,String excludeFields);
	
	/**
	 * 批量插入数据,且可以指定不用插入的字段列表 
	 * <br>Insert record by batch type,and can point out which field(s) don't need to insert.
	 * @param entityList 与表对应的实体对象链表,且不能为空. table's entity list(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @param excludeFields 声明不用插入的字段列表.Don't insert fields list.
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 * @since  1.9
	 */
	public <T> int insert(List<T> entityList,int batchSize,String excludeFields);
	
	/**
	 * 根据实体对象entity查询数据.Select record according to entity.
	 * @param entity 实体类对象,且不能为空. table's entity(do not allow null).
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value.<br>
	 * entity corresponding to table and can not be null.<br>
	 * If the field value is not null and not empty field as filter condition, <br>
	 * the operator is equal sign.eg:field=value<br>
	 * @param includeType 空字符串与null是否包含设置
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 */
    public <T> List<T> select(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity中id更新该实体对象的数据.Update record according to entity.
	 * @param entity 与表对应的实体对象,且不能为空;entity中id字段不能为空,作为过虑条件
	 * id为null将引发ObjSQLException.
	 * @param includeType 空字符串与null是否包含设置
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 */
	public <T> int update(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity插入数据.Insert record according to entity.
	 * @param entity 与表对应的实体对象,且不能为空
	 * @param includeType 空字符串与null是否包含设置
	 * @return 成功插入的记录行数. the number of inserted record(s) successfully.
	 */
	public <T> int insert(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity删除数据.Delete record according to entity.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @return 成功删除的记录行数. the number of deleted record(s) successfully.
	 */
	public <T> int delete(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity查询并返回Json格式的数据
	 * <br>Select and return data in Json format according to entity object.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @return 可包含多个实体(多条记录)的list转换成的json格式的字符串. <br>Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public <T> String selectJson(T entity,IncludeType includeType);
	
	/**
	 * 根据id查询记录.Select record by id.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param id 实体id字段的值.value of entity's id field. 
	 * @return 返回id对应的实体.return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(T entity,Integer id);
	
	/**
	 * 根据id查询记录.Select record by id.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param id 实体id字段的值.value of entity's id field.
	 * @return 返回id对应的实体.return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(T entity,Long id);
	
	
	/**
	 * 根据id查询记录.Select record by id.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param id 实体id字段的值.value of entity's id field.
	 * @return 返回id对应的实体.return one entity which owns this id.
	 * @since  1.9
	 */
	public <T> T selectById(T entity,String id);
	
	/**
	 * 根据id查询记录.Select record by id.
	 * @param entity 实体类对象,且不能为空.table's entity(do not allow null).
	 * @param ids 实体id字段的值,多个用逗号隔开.values of entity's id field,if more than one,separate with comma.
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 * @since  1.9
	 */
	public <T> List<T> selectByIds(T entity,String ids);
	
	/**
	 * 根据id删除记录.Delete record by id.
	 * @param c 实体类类型,且不能为空
	 * @param id 实体id字段的值. value of entity's id field.
	 * @return 成功删除的记录行数. the number of deleted record(s) successfully.
	 * @since  1.4
	 */
	public int deleteById(Class c,Integer id);
	
	/**
	 * 根据id删除记录.Delete record by id.
	 * @param c 实体类类型,且不能为空
	 * @param id 实体id字段的值. value of entity's id field.
	 * @return 成功删除的记录行数. the number of deleted record(s) successfully.
	 * @since  1.4
	 */
	public int deleteById(Class c,Long id);
	
	/**
	 * 根据id删除记录.Delete record by id.
	 * @param c 实体类类型,且不能为空
	 * @param ids 实体id字段的值,多个用逗号隔开.ids values of entity's id field,if more than one,separate with comma.
	 * @return 成功删除的记录行数. the number of deleted record(s) successfully.
	 * @since  1.4
	 */
	public int deleteById(Class c,String ids);
	
	/**
	 * 根据实体对象entity查询数据.Select record according to entity.
	 * @deprecated {@link Suid#select(Object,Condition)}方法中,可以通过condition设置includeType.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null时不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @param condition entity默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition使用过的字段,默认情况不会再处理.<br>
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.<br> 
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 * @since  1.6
	 */
	@Deprecated
    public <T> List<T> select(T entity,IncludeType includeType,Condition condition);
    
	/**
	 * 根据实体对象entity查询数据,并以Json格式返回 
	 * <br>Select and return data in Json format according to entity object.
	 * @deprecated {@link SuidRich#selectJson(Object,Condition)}方法中,可以通过condition设置includeType.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @param condition entity默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition使用过的字段,默认情况不会再处理.<br>
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. <br>
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 可包含多个实体(多条记录)的list转换成的json格式的字符串.
	 * <br>Json string, it transform from list which can contain more than one entity.
	 * @since  1.6
	 */
	@Deprecated
	public <T> String selectJson(T entity,IncludeType includeType,Condition condition);
	
	/**
	 * 根据实体对象entity查询数据,并以Json格式返回 
	 * <br>Select and return data in Json format according to entity object.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param condition entity默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition使用过的字段,默认情况不会再处理.<br>
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition. <br>
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 可包含多个实体(多条记录)的list转换成的json格式的字符串.
	 * <br>Json string, it transform from list which can contain more than one entity.
	 * @since  1.9
	 */
	public <T> String selectJson(T entity,Condition condition);
	
	/**
	 * 更新记录,且可以指定作为条件的字段.Update record according to whereFields.
	 * @param entity 实体类对象,不能为空
	 * 没指定为whereFields的字段,作为set部分,默认只处理非空,非null的字段
	 * @param whereFields 作为SQL中where条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFields);
	
	/**
	 * 更新记录,且可以指定作为条件的字段和指定字段的过滤类型.Update record according to whereFields.
	 * @param entity 与表对应的实体对象,且不能为空
	 * 没指定为whereFields的字段,作为set部分.
	 * @param whereFields 作为SQL中where条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置(是否作为过滤条件)
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFields,IncludeType includeType);
	
	/**
	 * 更新记录,且可以指定作为条件的字段.Update record according to whereFields.
	 * @param entity 实体类对象,不能为空
	 * 没指定为whereFields的字段,作为set部分(默认只处理非空,非null的字段)
	 * @param whereFields 作为SQL中where条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件.
	 * <br>需要注意的是,用condition的op方法设置的条件,即使whereFields没有声明,也会转换.
	 * <br>Notice:the method op of condition also maybe converted to the where expression.
	 * @param condition 用来设置默认情况不能表达的条件.
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 * @since 1.7.2
	 */
	public <T> int updateBy(T entity,String whereFields,Condition condition);
	
	/**
	 * 此方法,相当于SuidRich接口的 updateBy(entity,"id",condition);
	 * 更新记录,且可以指定作为条件的字段.Update record according to whereFields.
	 * @param entity 实体类对象,不能为空
	 * entity中除了id字段,作为set部分(默认只处理非空,非null的字段)
	 * @param condition 用来设置默认情况不能表达的条件.
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * <br>需要注意的是,condition用op设置的条件,也有可能转换为where部分的过滤条件.
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 * @since 1.9
	 */
	public <T> int updateById(T entity,Condition condition);
	
	
	/**
	 * 更新记录,且可以指定需要更新的字段,高级条件可通过Condition参数设置.Update record, can list update fields. 
	 * @param entity 实体类对象,不能为空
	 * entity默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition中op,between等方法设置的转换到where中的字段,默认情况不会再处理.<br>
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.<br>
	 * @param updateFields 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新),该属性不允许为空,
	 * <br>默认updateFields的每个字段会被转化成SQL update的set表达式;其它非空,非null的字段作为过滤条件,转成SQL的where表达式.
	 * <br>condition中setMultiply,setAdd,set方法设置的字段不受此限制.The methods setMultiply,setAdd,set in condition are not subject to this restriction. 
	 * @param condition 
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 * @since 1.7.2
	 */
	public <T> int update(T entity,String updateFields,Condition condition);
	
	
	/**
	 * 当SQL update的set表达式通过Condition定义时,可以不用再指定set使用的字段.
	 * @param entity 实体类对象,不能为空
	 * entity默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition中op,between等方法设置的转换到where中的字段,默认情况不会再处理.<br>
	 * If the field of entity is not null or empty, it will be translate to field=value.Other can define with condition.<br>
	 * @param condition
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 成功更新的记录数.the numbers of update record(s) successfully.
	 * @since 1.8
	 */
	public <T> int update(T entity,Condition condition);

}
