/*
 * Copyright 2016-2023 the original author.All rights reserved.
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

package org.teasoft.bee.ds;

import java.util.HashMap;
import java.util.Map;

import org.teasoft.bee.osql.Registry;

/**
 * @author Kingstar
 * @since  2.1
 */
public class DataSourceBuilderFactory implements Registry {
	private static Map<String, DataSourceBuilder> map = null;

	private DataSourceBuilderFactory() {}

	public static void register(String dataSourceToolType, DataSourceBuilder builder) {
		System.out.println("==============register=================");
		if (map == null) map = new HashMap<>();
		map.put(dataSourceToolType.toLowerCase(), builder);
	}

	public static DataSourceBuilder getDataSourceBuilder(String dataSourceToolType) {
		System.out.println("==============getDataSourceBuilder=================");
		return map == null ? null : map.get(dataSourceToolType.toLowerCase());
	}

}
