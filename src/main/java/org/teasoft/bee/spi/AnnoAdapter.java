/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
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
