/*
 * Copyright 2013-2018 the original author.All rights reserved.
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

package org.teasoft.bee.osql.dialect;

/**
 * Translate the sql for really DB.
 * @author Kingstar
 * @since  1.0
 */
public interface DbFeature {
	
	/**
	 * add the page part for sql.
	 * @param sql sql statement
	 * @param start start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size fetch result size (>0).
	 * @return paging sql.
	 */
	public String toPageSql(String sql,int start,int size);
	
	/**
	 * add the page part for sql,default start index,min value is 0 or 1
	 * it is equal: toPageSql(sql,0,size) or toPageSql(sql,1,size)
	 * @param sql sql statement
	 * @param size fetch result size (>0).
	 * @return paging sql.
	 */
	public String toPageSql(String sql, int size);
}
