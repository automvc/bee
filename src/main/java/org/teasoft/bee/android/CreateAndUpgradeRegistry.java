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

package org.teasoft.bee.android;

/**
 * CreateAndUpgrade Registry
 * @author Kingstar
 * @since  1.17
 */
public class CreateAndUpgradeRegistry {

	private static Class<? extends CreateAndUpgrade> clazz;

	public static void register(Class<? extends CreateAndUpgrade> c) {
		clazz = c;
	}

	public static Class<? extends CreateAndUpgrade> getCreateAndUpgrade() {
		return clazz;
	}

}
