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

import java.util.List;
import java.util.Map;

/**
 * 支持带占位符(?)的sql操作.sql语句是DB能识别的SQL,非面向对象的sql.
 * 若是简单的操作,建议用面向对象的操作方式,ObjSQL和ObjSQLRich.
 * @author Kingstar
 * @since  1.0
 * 支持如name=#{name}的map参数形式
 * @since  1.2
 */
public interface PreparedSql {

	public <T> List<T> select(String sql,T returnType,Object preValues[]);
	
	/**
	 * 
	 * @param sqlStr
	 * @param returnType
	 * @param map
	 * @return
	 */
	public <T> List<T> select(String sqlStr,T returnType,Map<String,Object> map);
	
	public <T> List<T> selectSomeField(String sql,T returnType,Object preValues[]);
	public <T> List<T> selectSomeField(String sqlStr,T returnType,Map<String,Object> map);
	
	public String selectFun(String sql,Object preValues[]) throws ObjSQLException;
	public String selectFun(String sqlStr,Map<String,Object> map) throws ObjSQLException;

	/**
	 * @param sql
	 * @param preValues 占位符对应的参数
	 * @return
	 * eg:
	 * select property1,property2 from beanName;
	 * return list element as: property1[#Bee#]property2 
	 */
	public List<String[]> select(String sql,Object preValues[]);
	public List<String[]> select(String sqlStr,Map<String,Object> map);
	
	public String selectJson(String sql,Object preValues[]);
	public String selectJson(String sqlStr,Map<String,Object> map);
	/**
	 * 操作update,insert,delete
	 * @param sql
	 * @param preValues 占位符对应的参数
	 * @return the number of successful records 返回成功操作的记录行数
	 */
	public int modify(String sql,Object preValues[]);
	public int modify(String sqlStr,Map<String,Object> map);
}
