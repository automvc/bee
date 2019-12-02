/*
 * Copyright 2016-2020 the original author.All rights reserved.
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
 * @since  1.7
 */
public interface MoreTable {

	/**
	 * 根据实体对象entity查询数据
	 * According to entity object select records from database.
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * entity中非null且非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * entity corresponding to table and can not be null.
	 * If the field value is not null and not empty string as filter condition, 
	 * the operator is equal sign.eg:field=value
	 * @return 返回可包含多个实体(多条记录)的list. return list can contain more than one entity
	 */
	public <T> List<T> select(T entity);

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
	public <T> List<T> select(T entity, int start, int size);

	/**
	 * 根据实体对象和Condition查询数据.select the records according to entity and condition.
	 * @param entity 与表对应的实体对象,且不能为空. table's entity(do not allow null).
	 * @param condition 默认有值的字段会转成field=value的形式,其它形式可通过condition指定.condition使用过的字段,默认情况不会再处理.
	 * if the field is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * 若condition没有设置IncludeType,默认过滤NULL和空字符串(但condition中op,between,notBetween方法设置的字段,不受includeType的值影响.)
	 * @return 返回可包含多个实体(多条记录)的list. return list can contain more than one entity
	 */
	public <T> List<T> select(T entity, Condition condition);

}
