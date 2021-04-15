/*
 * Copyright 2016-2020 the original author.All rights reserved.
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
 * 将多表查询的实体转成SQL语句.Select of More Objects to SQL.
 * @author Kingstar
 * @since  1.7
 */
public interface MoreObjToSQL {

	public <T> String toSelectSQL(T entity);

	public <T> String toSelectSQL(T entity, int start, int size);

	/**
	 * 根据entity和Condition转换成sql语句
	 * @param entity 实体类对象,且不能为空. table's entity(do not allow null).
	 * @param condition 默认有值的字段会转成field=value的形式,其它形式可通过condition指定.
	 * if the field is not null or empty, it will be translate to field=value.Other can define with condition. 
	 * @return Return the sql String.
	 */
	public <T> String toSelectSQL(T entity, Condition condition);

}
