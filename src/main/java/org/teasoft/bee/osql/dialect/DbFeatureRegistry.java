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

package org.teasoft.bee.osql.dialect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DbFeatureRegistry {
	private static final Map<String, DbFeature> dbFeatureMap = new HashMap<>();

	/**
	 * 注册某种DB的DbFeature实现类.
	 * register DbFeature for database.
	 * can ref databaseName DatabaseConst.
	 * @param databaseName database name
	 * @param dbFeature DbFeature的实现类.Implementation class of dbfeature.
	 */
	public static void register(String databaseName, DbFeature dbFeature) {
		dbFeatureMap.put(databaseName, dbFeature);
	}

	/**
	 * 通过databaseName获取注册的DbFeature实现类.
	 * @param databaseName
	 * @return instance of DbFeature.
	 */
	public static DbFeature getDbFeature(String databaseName) {
		return dbFeatureMap.get(databaseName);
	}
}
