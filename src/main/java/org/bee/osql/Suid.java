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

package org.bee.osql;

import java.util.List;

/**
 * 数据库操作接口,包括查,改,增,删 Suid (select,update,insert,delete)
 * 默认不处理null和空字符串
 * Database operation: Suid (select,update,insert,delete)
 * the null and empty string are not handled by default
 * @author Kingstar
 * Create on 2013-6-30 下午10:03:15
 * @since  1.0
 *
 */
public interface Suid {
	
	/**
	 * 根据实体对象entity查询数据
	 * According to entity object select records from database.
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * entity corresponding to table and can not be null.
	 * If the field value is not null and not empty string as filter condition, 
	 * the operator is equal sign.eg:field=value
	 * @return 返回的list可包含多个实体(多条记录) return list can contain more than one entity
	 */
	public <T> List<T> select(T entity);
	
	/**
	 * 根据实体对象entity更新数据   According to entity object update database.
	 * @param entity 与表对应的实体对象,且不能为空;entity中id属性不能为空,作为过虑条件
	 * entity中非null与非空字符串将更新到数据库(id除外) 
	 * @see  SuidRich#update(T entity,String updateFieldList)
	 * The entity corresponding to table and can not be null. 
	 * The ID field of entity must be not null and as filter condition. 
	 * The not null and not empty string will update to database except ID.
	 * @see  SuidRich#update(T entity,String updateFieldList)
	 * @return 成功更新的记录数  the numbers of update records successfully.
	 */
	public <T> int update(T entity);
	
	
	/**
	 * 根据实体对象entity插入数据 According to entity object insert record. 
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串将插入到数据库
	 * The entity corresponding to table and can not be null. 
	 * The not null and not empty string will insert to database.
	 * @return 成功插入的记录数   the numbers of insert records successfully.
	 */
	public <T> int insert(T entity);
	
	/**
	 * 根据实体对象entity删除数据 According to entity object delete record. 
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * The entity corresponding to table and can not be null.
	 * If the field value is not null and not empty string as filter condition, 
	 * the operator is equal sign.eg:field=value
	 * @return 成功删除的记录数   the numbers of delete records successfully.
	 */
	public <T> int delete(T entity);
	
}
