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

import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.CommOperate;

/**
 * Database operation interface using map instead of specific entity,
 * <br>the null and empty string are not handled by default.
 * Suid (select,update,insert,delete)
 * @author Kingstar
 * @since  1.9
 */
public interface MapSuid extends CommOperate {

	/**
	 * Use MapSql to select data.
	 * @param mapSql MapSql instance
	 * @return the multi-line record of List<String[]> structure.
	 */
	public List<String[]> selectString(MapSql mapSql);

	/**
	 * Use MapSql to select data.
	 * @param mapSql MapSql instance
	 * @return multi-line record in Json format.
	 */
	public String selectJson(MapSql mapSql);

	/**
	 * Use MapSql to select data.
	 * <br>one map element as : field-name:value
	 * @param mapSql MapSql instance
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 */
	public List<Map<String, Object>> select(MapSql mapSql);

	/**
	 * Use MapSql to select data.
	 * <br>one map element as : fieldName:value
	 * @param mapSql MapSql instance
	 * @return returns a row of data wrapped in a map.
	 */
	public Map<String, Object> selectOne(MapSql mapSql);
	
	/**
	 * Update the record and return the number of rows affected.
	 * @param mapSql MapSql instance
	 * MapSql' put method for SQL where part, putNew for update SQL 's set part.
	 * @return the numbers of update records successfully,if fails, return integer less than 0. 
	 * @since 1.9.8
	 */
	public int update(MapSql mapSql);

	/**
	 * Insert and return the id value of the record.
	 * <br>The ID value can be generated automatically by bee
	 * <br>Note: if id is generated by DB, consider whether DB supports it,
	 * <br> and the corresponding JDBC driver supports returning id.
	 * @param mapSql MapSql instance
	 * @return If successful, return the id value of the inserted record; if fails, return number less than 0.
	 */
	public long insertAndReturnId(MapSql mapSql);
	
	/**
	 * Inserts record and returns the number of the record successfully inserted.
	 * @param mapSql MapSql instance
	 * @return the numbers of insert records successfully,if fails, return integer less than 0.
	 */
	public int insert(MapSql mapSql);
	
	/**
	 * Use MapSql to delete record.
	 * @param mapSql MapSql instance
	 * @return the numbers of delete records successfully,if fails, return integer less than 0. 
	 */
	public int delete(MapSql mapSql);
	
	/**
	 * count the number of qualified record.
	 * @param mapSql MapSql instance
	 * @return the number of qualified record,if fails, return integer less than 0.
	 * @since 1.9.8
	 */
	public int count(MapSql mapSql);

}