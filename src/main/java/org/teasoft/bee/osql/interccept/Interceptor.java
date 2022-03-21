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

package org.teasoft.bee.osql.interccept;

import java.util.List;

import org.teasoft.bee.osql.SuidType;

/**
 * 拦截器.Interceptor
 * order:1.beforePasreEntity->2.afterCompleteSql->3.beforeReturn
 * @author Kingstar
 * @since  1.11
 */
public interface Interceptor {

	/**
	 * 在解析Entity成sql前触发
	 * @param entity
	 * @param suidType
	 * @return 处理后的Entity
	 */
	public Object beforePasreEntity(Object entity,SuidType suidType); 
	
	/**
	 * 在解析Entity数组成sql前触发
	 * @param entityArray 实体数组
	 * @param suidType
	 * @return entityArray
	 */
	public Object[] beforePasreEntity(Object entityArray[],SuidType suidType); 

	/**
	 * 设置一次性临时数据源名称
	 * 在有多个数据源时,指定某个数据源的名称才有效.
	 * @param ds 一次性临时数据源名称
	 */
	public void setDataSourceOneTime(String ds);

	/**
	 * 获取一次性临时数据源名称
	 * @return 一次性临时数据源名称
	 */
	public String getOneTimeDataSource();
	
	
	public void setTabNameOneTime(String tabName);
	public void setTabSuffixOneTime(String tabSuffix);
	
	public String getOneTimeTabName();
	public String getOneTimeTabSuffix();
	

	/**
	 * 在完成sql解析后触发
	 * @param sql
	 * @return 处理后的sql语句
	 */
	public String afterCompleteSql(String sql);

	/**
	 * 在访问DB并得到结构化数据后触发,用于有返回Javabean结构的查询
	 * @param list 处理后的结果集List
	 */
	@SuppressWarnings("rawtypes")
	public void beforeReturn(List list);
	
	/**
	 * 在访问DB并得到处理结果后触发,用于update,insert,delete及没有返回Javabean结构的查询方法
	 */
	public void beforeReturn();

}
