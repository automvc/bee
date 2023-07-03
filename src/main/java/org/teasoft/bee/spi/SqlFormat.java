/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.spi;

import java.io.Serializable;

/**
 * Sql Format interface.
 * @author Kingstar
 * @since  2.1.7
 */
public interface SqlFormat extends Serializable{

	/**
	 * format the sql
	 * @param sql SQL statement
	 * @return formatted sql
	 */
	public String format(String sql);

}
