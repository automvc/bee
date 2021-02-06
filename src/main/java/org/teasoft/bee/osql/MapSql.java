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

/**
 * 用Map承载SQL信息.Record SQL information with map.
 * @author Kingstar
 * @since  1.9
 */
public interface MapSql {

	/**
	 * 设置SQL用到的相关信息,Map的key由MapSqlKey提供.
	 * @param MapSqlKey
	 * @param value
	 */
	public void put(MapSqlKey MapSqlKey, String value);

	/**
	 * 设置用于SQL中where过虑的实体信息.
	 * @param fieldName
	 * @param value
	 */
	public void put(String fieldName, Object value);

}
