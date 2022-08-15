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

import java.io.Serializable;
import java.util.List;

import org.teasoft.bee.osql.SuidType;

/**
 * Interceptor.
 * order:1.beforePasreEntity->2.afterCompleteSql->3.beforeReturn
 * @author Kingstar
 * @since  1.11
 */
public interface Interceptor extends Serializable{

	/**
	 * call before parsing entity into SQL
	 * @param entity
	 * @param suidType
	 * @return Processed entity
	 */
	public Object beforePasreEntity(Object entity,SuidType suidType); 
	
	/**
	 * call before parsing entity array into SQL
	 * @param entityArray entity array
	 * @param suidType SuidType
	 * @return entityArray Processed entity array
	 */
	public Object[] beforePasreEntity(Object entityArray[],SuidType suidType); 

	/**
	 * set OneTime temporary dataSource name.
	 * When there are multiple dataSource, specifying the name of a dataSource is effective.
	 * @param ds OneTime temporary dataSource name
	 */
	public void setDataSourceOneTime(String ds);

	/**
	 * Get OneTime temporary dataSource name
	 * @return OneTime temporary dataSource name
	 */
	public String getOneTimeDataSource();
	
	
	public void setTabNameOneTime(String tabName);
	public void setTabSuffixOneTime(String tabSuffix);
	
	public String getOneTimeTabName();
	public String getOneTimeTabSuffix();
	

	/**
	 * call after finished to SQL 
	 * @param sql
	 * @return Processed sql string
	 */
	public String afterCompleteSql(String sql);

	/**
	 * call after accessing the DB and getting the structured data.
	 * <br>it is used for the query that returns the Javabean structure.
	 * @param list query result with List type
	 */
	@SuppressWarnings("rawtypes")
	public void beforeReturn(List list);
	
	/**
	 * call after accessing the DB and getting the processing results. 
	 * <br>it is used for update, insert, delete and query methods that do not return the Javabean structure.
	 */
	public void beforeReturn();

}
