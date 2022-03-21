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

package org.teasoft.bee.osql;

import org.teasoft.bee.osql.interccept.InterceptorChain;

/**
 * Common operate about Suid.
 * @author Kingstar
 * @since  1.11
 */
public interface CommOperate {
	
	/**
	 * 用于设置当前对象使用的数据源名称,使用默认的不需要设置.
	 * 设置数据源名称(对应数据源必须已定义)
	 * Set the dataSource for current instance. If use the default settings that are not required.
	 * @param dsName dataSource name
	 */
	public void setDataSourceName(String dsName);

	/**
	 * 获取当前对象设置的数据源名称.
	 * get DataSource name which set for current instance.
	 * @return DataSource name
	 */
	public String getDataSourceName();
	
	/**
	 * 获取拦截器栈,可用于某个生成对象,需要设置特定拦截器.
	 * @return InterceptorChain
	 */
	public InterceptorChain getInterceptorChain();
	
	/**
	 * 用于设置当前对象使用的命名转换器.使用默认的不需要设置
	 * set nameTranslat
	 * Set the NameTranslate for current instance. If use the default settings that are not required.
	 * @param nameTranslate nameTranslate
	 */
	public void setNameTranslate(NameTranslate nameTranslate);
}
