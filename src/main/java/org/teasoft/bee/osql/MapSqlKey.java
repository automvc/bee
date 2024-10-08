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
 * MapSql keyword for the corresponding SQL function of MapSuid.
 * @author Kingstar
 * @since  1.9
 */
public enum MapSqlKey {

	/**
	 * Declare the table to be operated on.
	 */
	Table("Table"),

	/**
	 * In the method insertAndReturnId(MapSql mapSql) of MapSuid, it is used when the primary key name is not 'id'.
	 * @since 1.11
	 */
	PrimaryKey("PrimaryKey"),

	/**
	 * Declare the select fields,if more than one,separate with comma.
	 */
	SelectColumns("SelectColumns"),

	/**
	 * It corresponds to the group by of SQL.
	 */
	GroupBy("GroupBy"),

	/**
	 * It corresponds to the having of SQL.
	 */
	Having("Having"),

	/**
	 * It corresponds to the order by of SQL.
	 */
	OrderBy("OrderBy")

	;

	String name;

	MapSqlKey(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
