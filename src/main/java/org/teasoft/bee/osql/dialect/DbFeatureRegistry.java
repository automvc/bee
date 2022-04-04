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

import org.teasoft.bee.osql.Registry;

/**
 * DbFeature Registry
 * @author Kingstar
 * @since  1.11
 */
public class DbFeatureRegistry implements Registry{
	private static final Map<String, DbFeature> dbFeatureMap = new HashMap<>();

	/**
	 * register DbFeature for database.
	 * databaseName can use DatabaseConst.
	 * @param databaseName database name
	 * @param dbFeature Implementation class of dbfeature.
	 */
	public static void register(String databaseName, DbFeature dbFeature) {
		dbFeatureMap.put(databaseName, dbFeature);
	}

	/**
	 * get register DbFeature by database name.
	 * @param databaseName database name
	 * @return instance of DbFeature.
	 */
	public static DbFeature getDbFeature(String databaseName) {
		return dbFeatureMap.get(databaseName);
	}
}
