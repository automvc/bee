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
 * @author Kingstar
 * Create on 2013-6-30 下午10:06:18
 * @since  1.0
 */
public interface SuidRich extends Suid {
	/**
	 * @param entity
	 * @param size 结果集大小 大于等于1
	 * @return
	 */
	public <T> List<T> select(T entity,int size);
	/**
	 * @param entity
	 * @param from 开始下标  大于等于0
	 * @param size 结果集大小 大于等于1
	 * @return
	 */
	public <T> List<T> select(T entity,int from,int size);
	
	/**
	 * @param entity
	 * @param selectFields 需要查询的字段  多个用逗号隔开
	 * @return
	 */
	public <T> List<T> select(T entity,String selectFields);
	
	/**
	 * 
	 * @param entity
	 * @param selectFields
	 * @param from
	 * @param size
	 * @return
	 * @since 1.4.3
	 */
	public <T> List<T> select(T entity,String selectFields,int from,int size);
	
	/**
	 * select some field, every field will return the string type 
	 * 查询部分字段,每个字段都是以字符串类型返回
	 * @param entity
	 * @return
	 */
	public <T> List<String[]> selectString(T entity); 
	
	/**
	 * select some field, every field will return the string type 
	 * 查询部分字段,每个字段都是以字符串类型返回
	 * @param entity
	 * @param selectFields  需要查询的字段  多个用逗号隔开
	 * @return
	 */
	public <T> List<String[]> selectString(T entity,String selectFields); 
	
	/**
	 * 根据实体对象entity查询数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * @return 返回json格式的字符串
	 * @since  1.1
	 */
	public <T> String selectJson(T entity);
	
	/**
	 * 只返回一个实体,数量不为1测返回null
	 * @param entity
	 * @return
	 */
	public <T> T selectOne(T entity);
	
	/**
	 * @param entity 传入的实体对象,且不能为空
	 * @param fieldForFun 需要使用函数的字段
	 * @param functionType MAX,MIN,SUM,AVG,COUNT
	 * @return
	 */
	public <T> String selectWithFun(T entity,FunctionType functionType,String fieldForFun);
	
	/**
	 * order type default is:asc
	 * 返回有排序的结果集,排序的字段默认按升序排列
	 * @param entity 传入的实体对象,且不能为空
	 * @param orderFieldList 排序字段列表,多个用逗号隔开
	 * @return
	 */
	public <T> List<T> selectOrderBy(T entity,String orderFieldList);
	public <T> List<T> selectOrderBy(T entity,String orderFieldList,OrderType[] orderTypes);
	
	/**
	 * 
	 * @param entity 不能为空
	 * @param updateFieldList 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新);其它非空,非null的字段作为过滤条件
	 * @return
	 */
	public <T> int update(T entity,String updateFieldList);
	
	/**
	 * 根据实体对象entity更新数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
	 * @param updateFieldList 需要更新的字段列表,多个字段用逗号隔开(列表中有的字段都会更新)
	 * @param includeType 空字符串与null是否包含设置(是否作为过滤条件)
	 * @return 更新的记录数
	 */
	public <T> int update(T entity,String updateFieldList,IncludeType includeType);
	
	public <T> int[] insert(T[] entity);
	public <T> int[] insert(T[] entity,int batchSize);
	
	public <T> int[] insert(T[] entity,String excludeFieldList);
	public <T> int[] insert(T[] entity,int batchSize,String excludeFieldList);
	
	/**
	 * 根据实体对象entity查询数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * id为null不作为过滤条件
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
	 * @return 返回json格式的字符串
	 * @since  1.1
	 */
	public <T> String selectJson(T entity,IncludeType includeType);
	
	/**
	 * @param entity
	 * @param id
	 * @return
	 * @since  1.4
	 */
	public <T> List<T> selectById(T entity,Integer id);
	
	/**
	 * @param entity
	 * @param id
	 * @return
	 * @since  1.4
	 */
	public <T> List<T> selectById(T entity,Long id);
	
	/**
	 * @param entity
	 * @param ids 主键id,多个用逗号隔开
	 * @return
	 * @since  1.4
	 */
	public <T> List<T> selectById(T entity,String ids);
	
	/**
	 * @param c
	 * @param id
	 * @return
	 * @since  1.4
	 */
	public int deleteById(Class c,Integer id);
	
	/**
	 * @param c
	 * @param id
	 * @return
	 * @since  1.4
	 */
	public int deleteById(Class c,Long id);
	
	/**
	 * @param c
	 * @param ids 主键id,多个用逗号隔开
	 * @return
	 * @since  1.4
	 */
	public int deleteById(Class c,String ids);

}
