/*
 * Copyright 2013-2020 the original author.All rights reserved.
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

package org.teasoft.bee.distribution.ds;

/**
 * 多数据源的路由接口.the route interface of multi-DataSource.
 * @author Kingstar
 * @since  1.8
 */
public interface Route {
	
	/**
	 * 返回数据源的名称.Return the name of DataSource.
	 * @return the name of DataSource.
	 */
	public String getDsName();

}
