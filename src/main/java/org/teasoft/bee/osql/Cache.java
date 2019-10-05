/*
 * Copyright 2013-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

/**
 * @author Kingstar
 * @since  1.4
 */
public interface Cache {
	
	/**
	 * 通过查询用的sql获取缓存结果记录
	 * @param sql 查询用的sql
	 * @return
	 */
	public Object get(String sql);
	
	/**
	 * 将结果集放入缓存
	 * @param sql 查询用的sql
	 * @param resultSet 结果记录
	 */
	public void add(String sql,Object resultSet);
	
	/**
	 * 清除某个表相关的缓存
	 * @param sql  会更新表数据的sql
	 */
	public void clear(String sql);
	
}
