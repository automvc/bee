/*
 * Copyright 2020-2022 the original author.All rights reserved.
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

package org.teasoft.bee.android;

import java.util.List;
import java.util.Map;

/**
 * 操作Android环境SQLite数据库的接口.
 * 通常不直接使用这个接口,而是通过Suid,SuidRich,MoreTable,MapSuid,PreparedSql间接使用.
 * @author Kingstar
 * @since 1.17
 */
public interface BeeSqlForAndroid {

	public <T> List<T> select(String sql, T entity, String[] selectionArgs);

	public String selectFun(String sql, String[] selectionArgs);

	public int modify(String sql, Object[] bindArgs);

	public List<String[]> select(String sql, String[] selectionArgs);

	/**
	 * Select and transform every record to Map<String,Object>.
	 * 
	 * @param sql SQL select statement
	 * @return List, every element is a Map<String,Object>(transform from record).
	 */
	public List<Map<String, Object>> selectMapList(String sql, String[] selectionArgs);
	
	//内部使用
	public List<Map<String, String>> selectMapListWithColumnName(String sql, String[] selectionArgs);
	/**
	 * Select and return json format result.
	 * 
	 * @param sql SQL select statement
	 * @return json format result .
	 */
	public String selectJson(String sql, String[] selectionArgs, Class entityClass);
	
	
//	public <T> List<T> moreTableSelect(String sql,T entity ,String[] selectionArgs);
	public long insertAndReturnId(String sql, Object[] bindArgs); //SQLite支持返回id,   查下android如何返回
	//Bee也提供生成id的      要加多一种短的int类型id生成.
	
	public int batchInsert(String sql0,List<Object[]> listBindArgs);    
//	public int batch(String sqls,List<Object[]> listBindArgs,int batchSize);

}
