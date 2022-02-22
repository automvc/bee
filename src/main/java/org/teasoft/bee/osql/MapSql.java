/*
 * Copyright 2016-2021 the original author.All rights reserved.
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

import java.util.Map;

/**
 * 用Map承载SQL信息.Record SQL information with map.
 * @author Kingstar
 * @since  1.9
 */
public interface MapSql {

	/**
	 * 设置SQL用到的相关信息,Map的key由MapSqlKey提供.Set the relevant information used by SQL. The key of map is provided by MapSqlKey.
	 * @param mapSqlKey 设置的MapSqlKey Key
	 * @param value value
	 */
	public void put(MapSqlKey mapSqlKey, String value);

	/**
	 * 设置用于SQL select,delete,update中where过虑的字段信息;也可用于SQL insert,设置插入的字段及相应值
	 * Set the field information used for where filtering in SQL select,delete, also can use in SQL insert.
	 * @param fieldName field name
	 * @param value value
	 */
	public void put(String fieldName, Object value);
	
	/**
	 * 设置用于SQL select,delete,update中where过虑的字段信息;也可用于SQL insert,设置插入的字段及相应值
	 * Set the field information used for where filtering in SQL select,delete, also can use in SQL insert.
	 * @param map 字段和值组成的map对象
	 */
	public void put(Map<String, ? extends Object> map);
	
	/**
	 * 设置需要更新的字段和值,用于update的Set部分
	 * Set the fields and values that need to be updated for the set part of SQL update
	 * @param fieldName
	 * @param value
	 * @since 1.9.8
	 */
	public void putNew(String fieldName, Object value);
	
	/**
	 * 设置需要更新的字段和值,用于update SQL的Set部分
	 * Set the fields and values that need to be updated for the set part of SQL update
	 * @param map 需要更新的字段和值组成的map对象. A map object consisting of fields and values that need to be updated
	 * @since 1.9.8
	 */
	public void putNew(Map<String, ? extends Object> map);
	
	/**
	 * 设置用于过滤或处理规则的配置.Set the configuration for filtering or processing rule.
	 * @param mapSqlSetting 设置的MapSqlSetting Key
	 * @param value 设置的值
	 */
	public void put(MapSqlSetting mapSqlSetting, boolean value);
	
	/**
	 * 分页查询时,设置开始页.Set the start page when paging query.
	 * 当用于count()时,忽略此方法
	 * @param start
	 * @since 1.9.8
	 */
	public void start(Integer start);
	/**
	 * 分页查询时,设置一页的数据记录数量.During paging query, set the number of data records on one page.
	 * 当用于count()时,忽略此方法
	 * @param size
	 * @since 1.9.8
	 */
	public void size(Integer size);

}
