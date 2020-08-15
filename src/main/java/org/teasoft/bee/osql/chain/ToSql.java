/*
 * Copyright 2013-2019 the original author.All rights reserved.
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
package org.teasoft.bee.osql.chain;

/**
 * ToSql接口,用于链式风格写SQL语句.ToSql interface for SQL with chain programming.
 * @author Kingstar
 * @since  1.3
 */
public interface ToSql {
	/**
	 * 转成SQL语句. to SQL statement.
	 * @return sql语句.sql statement.
	 */
	public String toSQL();
	
	/**
	 * 转成SQL语句. to SQL statement.
	 * @param noSemicolon 为true时,不包含分号.true means: no semicolon.
	 * @return sql语句.sql statement.
	 */
	public String toSQL(boolean noSemicolon);
}
