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

package org.teasoft.bee.spi;

import java.lang.reflect.Field;

/**
 * annotation adapter interface.
 * @author Kingstar
 * @since  1.17
 */
public interface AnnoAdapter {

	public boolean isPrimaryKey(Field field);

	public boolean isTable(Class<?> clazz);

	public boolean isColumn(Field field);
	// Index
	// Unique

	public String getValue(Field field);

	public String getValue(Class<?> clazz);

}
