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

package org.teasoft.bee.osql.dialect;

/**
 * 为特定DB转换成对应的sql.Translate the sql for really DB.
 * @author Kingstar
 * @since  1.0
 */
public interface DbFeature {
	/**
	 * 为SQL添加分页部分的语句.add the page part for sql.
	 * @param sql sql语句
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return
	 */
	public String toPageSql(String sql,int start,int size);
	/**
	 * 为SQL添加分页部分的语句,默认从第0或1条记录开始返回.add the page part for sql,default start index,min value is 0 or 1
	 * @param sql sql语句
	 * @param size 结果集大小 大于等于1. fetch result size (>0).
	 * @return
	 */
	public String toPageSql(String sql, int size);
}
