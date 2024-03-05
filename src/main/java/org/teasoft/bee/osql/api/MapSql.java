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

package org.teasoft.bee.osql.api;

import java.util.Map;

import org.teasoft.bee.osql.MapSqlKey;
import org.teasoft.bee.osql.MapSqlSetting;

/**
 * Record SQL information with map.
 * @author Kingstar
 * @since  1.9
 */
public interface MapSql {

	/**
	 * Set the relevant information used by SQL. The key of map is provided by MapSqlKey.
	 * @param mapSqlKey MapSqlKey
	 * @param value value
	 */
	public void put(MapSqlKey mapSqlKey, String value);

	/**
	 * Set the field information used for where filtering , also can use in SQL insert.
	 * @param fieldName field name
	 * @param value value
	 */
	public void put(String fieldName, Object value);
	
	/**
	 * Set the field information used for where filtering , also can use in SQL insert.
	 * @param map map instance consist by key and value.
	 */
	public void put(Map<String, ? extends Object> map);
	
	/**
	 * Set the fields and values that need to be updated for the set part of SQL update
	 * @param fieldName
	 * @param value
	 * @since 1.9.8
	 */
	public void putNew(String fieldName, Object value);
	
	/**
	 * Set the fields and values that need to be updated for the set part of SQL update
	 * @param map A map object consisting of fields and values that need to be updated
	 * @since 1.9.8
	 */
	public void putNew(Map<String, ? extends Object> map);
	
	/**
	 * Set the configuration for filtering or processing rule.
	 * @param mapSqlSetting Key of MapSqlSetting 
	 * @param value setting value
	 */
	public void put(MapSqlSetting mapSqlSetting, boolean value);
	
	/**
	 * Set the start page when paging query.
	 * It will be ignore when use count().
	 * @param start
	 * @since 1.9.8
	 */
	public void start(Integer start);
	/**
	 * During paging query, set the number of data records on one page.
	 * It will be ignore when use count().
	 * @param size
	 * @since 1.9.8
	 */
	public void size(Integer size);
	
	/**
	 * add condition for filter(use in SQL where part).
	 * @param condition instance of Condition
	 * @since 2.4.0
	 */
	public void where(Condition condition);
	
	/**
	 * add condition for update set(use in SQL update set part).
	 * @param condition instance of Condition
	 * @since 2.4.0
	 */
	public void updateSet(Condition condition);

}
