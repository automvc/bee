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
 * 该接口比Suid接口提供更多的参数选择.Database operation: Suid (select,update,insert,delete),
 * it supports more parameters than Suid.
 * @author Kingstar
 * Create on 2013-6-30 22:06:18
 * @since  1.0
 */
public interface SuidRich extends Suid {
	
	/**
	 * 根据实体对象entity查询数据
	 * According to entity object select records from database.
	 * @param entity 实体类对象,且不能为空. table's entity(do not allow null).
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * entity corresponding to table and can not be null.
	 * If the field value is not null and not empty string as filter condition, 
	 * the operator is equal sign.eg:field=value
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return 返回可包含多个实体(多条记录)的list. return list can contain more than one entity
	 */
	public <T> List<T> select(T entity,int size);
	
	/**
	 * 根据实体对象entity查询数据
	 * According to entity object select records from database.
	 * @param entity 实体类对象,且不能为空. table's entity(do not allow null).
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * entity corresponding to table and can not be null.
	 * If the field value is not null and not empty string as filter condition, 
	 * the operator is equal sign.eg:field=value
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return 返回可包含多个实体(多条记录)的list. return list can contain more than one entity
	 */
	public <T> List<T> select(T entity,int start,int size);
	
	/**
	 * @param entity 实体类对象,且不能为空
	 * @param selectFields 需要查询的字段,多个用逗号隔开. select fields,if more than one,separate with comma.
	 * @return
	 */
	public <T> List<T> select(T entity,String selectFields);
	
	/**
	 * @param entity 实体类对象,且不能为空
	 * @param selectFields 需要查询的字段,多个用逗号隔开. select fields,if more than one,separate with comma.
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return
	 * @since 1.4.3
	 */
	public <T> List<T> select(T entity,String selectFields,int start,int size);
	
	/**
	 * 查询实体,每个字段都是以字符串类型返回.
	 * select entity,every field will return the string type.
	 * @param entity 实体类对象,且不能为空
	 * @return
	 */
	public <T> List<String[]> selectString(T entity); 
	
	/**
	 * 查询部分字段,每个字段都是以字符串类型返回.
	 * select some field, every field will return the string type. 
	 * @param entity 实体类对象,且不能为空
	 * @param selectFields  需要查询的字段,多个用逗号隔开. select fields,if more than one,separate with comma.
	 * @return
	 */
	public <T> List<String[]> selectString(T entity,String selectFields); 
	
	/**
	 * 根据实体对象entity查询数据,并返回Json格式结果.
	 * select Json type result by entity. 
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * @return 返回可包含多个实体(多条记录)的list转换成的json格式的字符串. return Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public <T> String selectJson(T entity);
	
	/**
	 * 查询一个实体.
	 * select one record.  
	 * @param entity 实体类对象
	 * @return 只返回一个实体,数量不为1测返回null.return one record,if the size do not equal one, return null.
	 */
	public <T> T selectOne(T entity);
	
	/**
	 * 使用函数查询结果.select result with function.
	 * @param entity 传入的实体对象,且不能为空
	 * @param fieldForFun 需要使用函数的字段
	 * @param functionType MAX,MIN,SUM,AVG,COUNT
	 * @return
	 */
	public <T> String selectWithFun(T entity,FunctionType functionType,String fieldForFun);
	
	/**
	 * 应用排序查询结果,排序的字段默认按升序排列.
	 * select result by key:order,order type default is:asc
	 * @param entity 传入的实体对象,且不能为空
	 * @param orderFieldList 排序字段列表,多个用逗号隔开
	 * @return 返回有排序的结果集
	 */
	public <T> List<T> selectOrderBy(T entity,String orderFieldList);
	
	/**
	 * 应用排序查询结果.
	 * select result by key:order.
	 * @param entity 传入的实体对象,且不能为空
	 * @param orderFieldList 排序字段列表,多个用逗号隔开
	 * @param orderTypes 排序类型列表
	 * @return 返回有排序的结果集
	 */
	public <T> List<T> selectOrderBy(T entity,String orderFieldList,OrderType[] orderTypes);
	
	/**
	 * 更新记录,且可以指定需要更新的字段.
	 * update record, can list update fields. 
	 * @param entity 实体类对象,不能为空
	 * @param updateFieldList 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新),该属性不允许为空;其它非空,非null的字段作为过滤条件
	 * @return
	 */
	public <T> int update(T entity,String updateFieldList);
	
	/**
	 * 根据实体对象entity更新数据,可以指定需要更新的字段.
	 * update record according to entity.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param updateFieldList 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新),该属性不允许为空
	 * @param includeType 空字符串与null是否包含设置(是否作为过滤条件)
	 * @return 更新的记录数
	 */
	public <T> int update(T entity,String updateFieldList,IncludeType includeType);
	
	/**
	 * 批量插入数据. insert records by batch.
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * @return
	 */
	public <T> int[] insert(T[] entity);
	
	/**
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * @param batchSize
	 * @return
	 */
	public <T> int[] insert(T[] entity,int batchSize);
	
	/**
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * @param excludeFieldList
	 * @return
	 */
	public <T> int[] insert(T[] entity,String excludeFieldList);
	
	/**
	 * 批量插入数据,可以指定不插入的字段.
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * @param batchSize 批操作数量大小.batch size.
	 * @param excludeFieldList 不插入的字段列表.don't insert fields list.
	 * @return
	 */
	public <T> int[] insert(T[] entity,int batchSize,String excludeFieldList);
	
	/**
	 * 根据实体对象entity查询数据.
	 * select record according to entity.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为时null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @return 返回的list可包含多个实体(多条记录)
	 */
    public <T> List<T> select(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity更新数据
	 * @param entity 与表对应的实体对象,且不能为空;entity中id字段不能为空,作为过虑条件
	 * id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @return 更新的记录数
	 */
	public <T> int update(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity插入数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * @param includeType 空字符串与null是否包含设置
	 * @return 成功插入的记录数
	 */
	public <T> int insert(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity删除数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @return 成功删除的记录数
	 */
	public <T> int delete(T entity,IncludeType includeType);
	
	/**
	 * 根据实体对象entity查询数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @return 返回可包含多个实体(多条记录)的list转换成的json格式的字符串. return Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public <T> String selectJson(T entity,IncludeType includeType);
	
	/**
	 * 根据id查询记录. select record by id.
	 * @param entity 实体类对象,且不能为空
	 * @param id 实体id字段的值.value of entity's id field. 
	 * @return 返回查询对象列表
	 * @since  1.4
	 */
	public <T> List<T> selectById(T entity,Integer id);
	
	/**
	 * 根据id查询记录. select record by id.
	 * @param entity 实体类对象,且不能为空
	 * @param id 实体id字段的值.value of entity's id field.
	 * @return 返回查询对象列表
	 * @since  1.4
	 */
	public <T> List<T> selectById(T entity,Long id);
	
	/**
	 * 根据id查询记录. select record by id.
	 * @param entity 实体类对象,且不能为空
	 * @param ids 实体id字段的值,多个用逗号隔开.values of entity's id field.
	 * @return 返回查询对象列表
	 * @since  1.4
	 */
	public <T> List<T> selectById(T entity,String ids);
	
	/**
	 * 根据id删记录.delete record by id.
	 * @param c 实体类类型,且不能为空
	 * @param id
	 * @return 返回成功删除记录数
	 * @since  1.4
	 */
	public int deleteById(Class c,Integer id);
	
	/**
	 * 根据id删记录.delete record by id.
	 * @param c 实体类类型,且不能为空
	 * @param id 实体id字段的值. value of entity's id field.
	 * @return 返回成功删除记录数
	 * @since  1.4
	 */
	public int deleteById(Class c,Long id);
	
	/**
	 * 根据id删记录.delete record by id.
	 * @param c 实体类类型,且不能为空
	 * @param ids 实体id字段的值,多个用逗号隔开.ids values of entity's id field.
	 * @return 返回成功删除记录数
	 * @since  1.4
	 */
	public int deleteById(Class c,String ids);
	
	
	/**
	 * 根据实体对象entity查询数据.
	 * select record according to entity.
	 * @deprecated Suid的 select(T entity,Condition condition)方法中,可以通过condition设置includeType.
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为时null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @param condition 默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition使用过的字段,默认情况不会再处理.
	 * if the field is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * @return 返回的list可包含多个实体(多条记录)
	 * @since  1.6
	 */
	@Deprecated
    public <T> List<T> select(T entity,IncludeType includeType,Condition condition);
    
	/**
	 * 根据实体对象entity查询数据,并以Json格式返回
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置
	 * @param condition 默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition使用过的字段,默认情况不会再处理.
	 * if the field is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 返回可包含多个实体(多条记录)的list转换成的json格式的字符串. return Json string, it transform from list which can contain more than one entity.
	 * @since  1.6
	 */
	public <T> String selectJson(T entity,IncludeType includeType,Condition condition);
	
	
	/**
	 * 更新记录,且可以指定作为条件的字段.
	 * update record according to whereFieldList.
	 * @param entity 实体类对象,不能为空
	 * 没指定为whereFieldList的字段,作为set部分,默认只处理非空,非null的字段
	 * @param whereFieldList 作为条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件
	 * @return
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFieldList);
	
	/**
	 * 更新记录,且可以指定作为条件的字段和指定字段的过滤类型
	 * update record according to whereFieldList.
	 * @param entity 与表对应的实体对象,且不能为空
	 * 没指定为whereFieldList的字段,作为set部分.
	 * @param whereFieldList 作为条件的字段列表,多个字段用逗号隔开(列表中有的字段都会作为条件);
	 * 指定作为条件的,都转换.id为null不作为过滤条件
	 * @param includeType 空字符串与null是否包含设置(是否作为过滤条件)
	 * @return 更新的记录数
	 * @since  1.6
	 */
	public <T> int updateBy(T entity,String whereFieldList,IncludeType includeType);

}
