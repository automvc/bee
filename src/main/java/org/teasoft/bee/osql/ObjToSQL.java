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

package org.teasoft.bee.osql;

import org.teasoft.bee.osql.api.Condition;

/**
 * Object to SQL string for Suid. <br>
 * Object to SQL string for Suid (select,update,insert,delete),
 * entity must not be null.
 * @author Kingstar
 * @since  1.0
 */
public interface ObjToSQL {

	/**
	 * Convert to select SQL statement according to entity.
	 * @param entity table's entity(do not allow null).
	 * @return the sql string.
	 */
	public <T> String toSelectSQL(T entity);

	/**
	 * Convert to update SQL statement according to entity.
	 * @param entity table's entity(do not allow null).
	 * @return the sql string.
	 */
	public <T> String toUpdateSQL(T entity);

	/**
	 * Convert to insert SQL statement according to entity.
	 * @param entity table's entity(do not allow null).
	 * @return the sql string.
	 */
	public <T> String toInsertSQL(T entity);

	/**
	 * Convert to delete SQL statement according to entity.
	 * @param entity table's entity(do not allow null).
	 * @return the sql string.
	 */
	public <T> String toDeleteSQL(T entity);

	/**
	 * Convert to select SQL statement according to entity and condition.
	 * @param entity table's entity(do not allow null).
	 * @param condition instance of Condition.
	 * @return the sql string.
	 * @since  1.6
	 */
	public <T> String toSelectSQL(T entity, Condition condition);

	/**
	 * Convert to delete SQL statement according to entity and condition
	 * @param entity table's entity(do not allow null).
	 * @param condition instance of Condition.
	 * @return the sql string.
	 * @since  1.7.2
	 */
	public <T> String toDeleteSQL(T entity, Condition condition);
}
