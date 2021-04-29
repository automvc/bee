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

import java.util.List;
import java.util.Map;

/**
 * 使用Map而非具体实体的数据库操作接口,默认不处理null和空字符串(与Suid,SuidRich风格兼容)
 * <br>Database operation interface using map instead of specific entity,
 * <br>the null and empty string are not handled by default.
 * Suid (select,update,insert,delete)
 * @author Kingstar
 * @since  1.9
 */
public interface MapSuid {

	/**
	 * 使用MapSql查询数据.Use MapSql to select data.
	 * @param mapSql MapSql instance
	 * @return List<String[]>结构的多行记录.
	 * <br>the multi-line record of List<String[]> structure.
	 */
	public List<String[]> selectString(MapSql mapSql);

	/**
	 * 使用MapSql查询数据.Use MapSql to select data.
	 * @param mapSql MapSql instance
	 * @return Json格式的多行记录.multi-line record in Json format.
	 */
	public String selectJson(MapSql mapSql);

	/**
	 * 使用MapSql查询数据.Use MapSql to select data.
	 * <br>one map element as : field-name:value
	 * @param mapSql MapSql instance
	 * @return List<Map<String, Object>>结构的多行记录.
	 * <br>the multi-line record of List<Map<String, Object>> structure.
	 */
	public List<Map<String, Object>> select(MapSql mapSql);

	/**
	 * 使用MapSql查询数据.Use MapSql to select data.
	 * <br>one map element as : field-name:value
	 * @param mapSql MapSql instance
	 * @return 包装在一个Map中的一行数据.returns a row of data wrapped in a map.
	 */
	public Map<String, Object> selectOne(MapSql mapSql);

	/**
	 * 使用MapSql查询数据.Use MapSql to select data.
	 * @param mapSql MapSql instance
	 * @return 成功删除的记录数. the numbers of delete records successfully. 
	 */
	public int delete(MapSql mapSql);
	
	/**
	 * 插入并返回记录的id值.
	 * id值可由Bee自动生成分布式id.
	 * 注意:若id由DB生成,需考虑DB是否支持,且对应JDBC驱动要支持返回id.
	 * @param mapSql
	 * @return 若成功,返回插入记录的id值;若失败则返回-1.
	 */
	public long insert(MapSql mapSql);

}
