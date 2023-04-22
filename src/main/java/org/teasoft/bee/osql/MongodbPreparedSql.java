/*
 * Copyright 2020-2023 the original author.All rights reserved.
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
 * Interface support mongo shell command.
 * @author Kingstar
 * @since V2.1
 */
public interface MongodbPreparedSql extends CommOperate {

	/**
	 * Select record(s) via select statement.
	 * @param sql SQL select statement(no placeholder). 
	 * @param returnTypeClass its type same as list element.
	 * @return List which element type is same as returnTypeClass.
	 */
	public <T> List<T> select(String sql, Class<T> returnTypeClass);
	
	/**
	 * Select and return json format result.<p>
	 * <br>Notice:can not use the cache because don't relay the entity.
	 * <br>Because it is not associated with entity, in the case of multiple dataSource, 
	 * <br>will be select the record from the default dataSource.
	 * @param sqlStr SQL select statement(do not contain placeholder)
	 * @return Json format result.
	 */
	public String selectJson(String sqlStr);
	
//	public String selectFun(String sql);
	
	/**
	 * Modify database records with update, insert or delete statement.
	 * It is not recommended because the framework does not know what table has been changed, 
	 * <br>which will affect the correctness of the cache and cause the risk of inaccurate cache data.
	 * @param sql SQL statement.
	 * @return	the number of affected successfully records.
	 */
	public int modify(String sql);
	
	/**
	 * Query records and return list structure data whose element is Map<String, Object>.
	 * @param sql SQL statement(do not contain placeholder).
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 */
	public List<Map<String, Object>> selectMapList(String sql);
	
}
