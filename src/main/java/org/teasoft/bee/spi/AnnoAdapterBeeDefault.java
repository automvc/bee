/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.spi;

import java.lang.reflect.Field;

import org.teasoft.bee.osql.annotation.Column;
import org.teasoft.bee.osql.annotation.PrimaryKey;
import org.teasoft.bee.osql.annotation.Table;

/**
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
	public String getValue(Field field) {

		if (field.isAnnotationPresent(Column.class)) {
			Column column = field.getAnnotation(Column.class);
			String defineColumn = column.value();
			return defineColumn;
		}

		return "";
	}

	@Override
	public String getValue(Class<?> clazz) {

		if (clazz.isAnnotationPresent(Table.class)) {
			Table tab = (Table) clazz.getAnnotation(Table.class);
			return tab.value();
		}

		return "";
	}

}
