/*
 * Copyright 2016-2022 the original author.All rights reserved.
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

package org.teasoft.bee.osql.interccept;

import java.util.List;

/**
 * @author Kingstar
 * @since  1.11
 */
public interface Interceptor {

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public Object beforePasreEntity(Object entity); 

	//在有多个数据源时,指定某个数据源的名称才有效.
	public void setDataSourceOneTime(String ds);

	/**
	 * 
	 * @return
	 */
	public String getOneTimeDataSource();

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public String afterCompleteSql(String sql);

	/**
	 * 
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public void afterAccessDB(List list);
	
	/**
	 * 
	 */
	public void afterAccessDB();

}
