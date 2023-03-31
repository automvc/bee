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

package org.teasoft.bee.spi.defaultimpl;

import java.lang.reflect.Field;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.Ignore;
import org.teasoft.bee.osql.annotation.PrimaryKey;
import org.teasoft.bee.osql.annotation.Table;
import org.teasoft.bee.spi.AnnoAdapter;

/**
 * Annotation Adapter Bee Default.
 * @author Kingstar
 * @since  1.17
 */
public class AnnoAdapterBeeDefault implements AnnoAdapter {

	@Override
	public boolean isPrimaryKey(Field field) {
		return field.isAnnotationPresent(PrimaryKey.class);
	}

	@Override
	public boolean isTable(Class<?> clazz) {
		return clazz.isAnnotationPresent(Table.class);
	}

	@Override
	public boolean isColumn(Field field) {
		return field.isAnnotationPresent(Column.class);
	}
	
	@Override
	public boolean isIgnore(Field field) {
		return field.isAnnotationPresent(Ignore.class);
	}

	@Override
	@SuppressWarnings("deprecation")
	public String getValue(Field field) {

		if (field.isAnnotationPresent(Column.class)) {
//			Column column = field.getAnnotation(Column.class);
//			String defineColumn = column.value();
//			return defineColumn;
			return field.getAnnotation(Column.class).value();
		}

		return "";
	}

	@Override
	public String getValue(Class<?> clazz) {

		if (clazz.isAnnotationPresent(Table.class)) {
			return clazz.getAnnotation(Table.class).value();
		}

		return "";
	}

}
