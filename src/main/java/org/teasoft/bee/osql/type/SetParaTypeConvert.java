/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.type;

/**
 * Convert the set parameter type.
 * The SetParaTypeConvert work for setting parameter to PreparedStatement.
 * @author Kingstar
 * @since  1.11
 */
public interface SetParaTypeConvert<T> {
	
	public Object convert(T value);

}
