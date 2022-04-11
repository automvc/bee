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
	 * Set the dataSource for current instance. If use the default settings that are not required.
	 * Set dataSource name (corresponding data source must be defined).
	 * @param dsName dataSource name
	 */
	public void setDataSourceName(String dsName);

	/**
	 * get DataSource name which set for current instance.
	 * @return DataSource name
	 */
	public String getDataSourceName();
	
	/**
	 * Get the Interceptor chain, which can be used for a generated object set a specific interceptor.
	 * @return InterceptorChain
	 */
	public InterceptorChain getInterceptorChain();
	
	/**
	 * Set the NameTranslate for current instance. 
	 * If use the default settings that are not required.
	 * @param nameTranslate nameTranslate
	 */
	public void setNameTranslate(NameTranslate nameTranslate);
}
