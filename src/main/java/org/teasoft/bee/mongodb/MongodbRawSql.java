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

package org.teasoft.bee.mongodb;

import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.CommOperate;

/**
 * Interface support Mongo Shell Query Language(Shell command).
 * @author Kingstar
 * @since V2.1
 */
public interface MongodbRawSql extends CommOperate {

	/**
	 * Select record(s) via find command.
	 * @param sql find command. 
	 * @param returnTypeClass its type same as list element.
	 * @return List which element type is same as returnTypeClass.
	 */
	public <T> List<T> select(String sql, Class<T> returnTypeClass);
	
	/**
	 * Select record(s) via find command and return json format result.<p>
	 * @param sql find command. 
	 * @return Json format result.
	 */
	public String selectJson(String sql);
	
	/**
	 * Modify database records with update, insert or delete command.
	 * @param sql find command. 
	 * @return	the number of affected successfully records.
	 */
	public int modify(String sql);
	
	/**
	 * Select record(s) via find command and return list structure data whose element is Map<String, Object>.
	 * @param sql find command. 
	 * @return the multi-line record of List<Map<String, Object>> structure.
	 */
	public List<Map<String, Object>> selectMapList(String sql);
	
//	public String selectFun(String sql);
	
}
