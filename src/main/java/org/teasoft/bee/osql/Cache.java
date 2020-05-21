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

package org.teasoft.bee.osql;

/**
 * 缓存接口.Cache interface.
 * @author Kingstar
 * @since  1.4
 */
public interface Cache {
	
	/**
	 * 通过查询用的sql获取缓存结果记录
	 * get the cache result by sql 
	 * @param sql 查询用的sql
	 * @return 返回缓存的结果集.return the cache resultset.
	 */
	public Object get(String sql);
	
	/**
	 * 将结果集放入缓存
	 * put the result in the cache identify with sql
	 * @param sql 查询用的sql
	 * @param resultSet 结果记录
	 */
	public void add(String sql,Object resultSet);
	
	/**
	 * 清除某个表相关的缓存
	 * clear the cache result by sql
	 * @param sql  会更新表数据的sql
	 */
	public void clear(String sql);
	
}
