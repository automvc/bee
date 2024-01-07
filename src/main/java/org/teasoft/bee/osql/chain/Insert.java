/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.chain;

/**
 * @author Kingstar
 * @since  2.4.0
 */
//public interface Insert extends Where<Insert>, ToSql {
public interface Insert extends ToSql {

	public Insert insert(String table);
	
	public Insert column(String column);
}

