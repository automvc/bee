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
	 * @param MapSqlKey 设置的MapSqlKey Key
	 * @param value value
	 */
	public void put(MapSqlKey MapSqlKey, String value);

	/**
	 * 设置用于SQL select,delete,update中where过虑的字段信息;也可用于SQL insert,设置插入的字段及相应值
	 * Set the field information used for where filtering in SQL select,delete, also can use in SQL insert.
	 * @param fieldName field name
	 * @param value value
	 */
	public void put(String fieldName, Object value);
	
	public void put(Map<String, ? extends Object> map);
	
	/**
	 * 用于update的Set部分
	 * @param fieldName
	 * @param value
	 */
	public void putNew(String fieldName, Object value);
	
	public void putNew(Map<String, ? extends Object> map);
	
	/**
	 * 用于Javabean与DB转换时配置信息设置
	 * @param MapSqlSetting 设置的MapSqlSetting Key
	 * @param value 设置的值
	 */
	public void put(MapSqlSetting MapSqlSetting, boolean value);
	
	/**
	 * 当用于count()时,忽略此方法
	 * @param start
	 */
	public void start(Integer start);
	/**
	 * 当用于count()时,忽略此方法
	 * @param size
	 */
	public void size(Integer size);

}
