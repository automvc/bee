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

package org.teasoft.bee.osql;

/**
 * 扩展的缓存接口.Ext Cache interface.
 * @author Kingstar
 * @since  1.11
 */
public interface BeeExtCache extends Cache{

	/**
	 * 通过key获取缓存结果记录,key一般是查询用的sql
	 * Get the cache result by key(sql). 
	 * @param key cache key,normally it is sql.
	 * @return 结果记录
	 */
	public Object getInExtCache(String key);

	/**
	 * 将结果集放入缓存
	 * Put the result in the cache identify with key(sql).
	 * @param key  cache key,normally it is sql.
	 * @param result 结果记录
	 */
	public void addInExtCache(String key, Object result);

	/**
	 * 清除某个表相关的缓存
	 * Clear the cache result of related table by key(sql).
	 * @param key cache key,normally it is sql.
	 */
	public void clearInExtCache(String key);

}
