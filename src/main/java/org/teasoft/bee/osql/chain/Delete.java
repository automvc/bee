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
public interface Delete extends Where<Delete>, ToSql {

	public Delete delete(String table);

	public Delete truncate(String table);

	public Delete drop(String table);

	public Delete drop();

	public Delete IfExists();

	public Delete table(String table);
}