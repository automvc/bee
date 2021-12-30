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

/**
 * 对象到SQL的转换(对应Suid).Object to SQL string for Suid. <br>
 * 根据entity对象转换成DB能识别的sql语句(包括:select,update,insert,delete),
 * entity 参数不能为null.<br>
 * Object to SQL string for Suid (select,update,insert,delete),
 * entity must not be null.
 * @author Kingstar
 * @since  1.0
 */
public interface ObjToSQL {
	
	public  <T> String toSelectSQL(T entity) ;
	public  <T> String toUpdateSQL(T entity) ;
	public  <T> String toInsertSQL(T entity) ;
	public  <T> String toDeleteSQL(T entity) ;
	
    /**
     * 根据entity和Condition转换成sql语句
     * @param entity
     * @param condition
     * @return the sql string.
     * @since  1.6
     */
	public  <T> String toSelectSQL(T entity,Condition condition) ;

    /**
     * 根据entity和Condition转换成sql语句
     * @param entity
     * @param condition
     * @return the sql string.
     * @since  1.7.2
     */
	public  <T> String toDeleteSQL(T entity,Condition condition) ;
}
