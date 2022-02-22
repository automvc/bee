/*
 * Copyright 2013-2020 the original author.All rights reserved.
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

package org.teasoft.bee.osql;

/**
 * SQL关键字的大写形式.SQL KeyWord's upper case.
 * @author Kingstar
 * @since  1.8.99
 */
public class UpperKey implements SqlKeyWord {

	private static final String SPACE = " ";
	private static final String SELECT = "SELECT";
	private static final String AS = "AS";
	private static final String FROM = "FROM";
	private static final String WHERE = "WHERE";
	private static final String INSERT = "INSERT";
	private static final String REPLACE = "REPLACE";
	private static final String INTO = "INTO";
	private static final String VALUES = "VALUES";
	private static final String AND = "AND";
	private static final String OR = "OR";
	private static final String NULL = "NULL";
	private static final String ISNULL = "IS NULL";
	private static final String isNotNull = "IS NOT NULL";
	private static final String UPDATE = "UPDATE";
	private static final String SET = "SET";
	private static final String DELETE = "DELETE";
	private static final String orderBy = "ORDER BY";
	private static final String COUNT = "COUNT";
	private static final String ASC = "ASC";
	private static final String ON = "ON";

	private static final String LIMIT = "LIMIT";
	private static final String OFFSET = "OFFSET";
	private static final String TOP = "TOP";

	private static final String groupBy = "GROUP BY";
	private static final String HAVING = "HAVING";
	private static final String BETWEEN = "BETWEEN";
	private static final String notBetween = "NOT BETWEEN";

	private static final String forUpdate = "FOR UPDATE";

	private static final String DISTINCT = "DISTINCT";
	private static final String JOIN = "JOIN";
	private static final String innerJoin = "INNER JOIN";
	private static final String leftJoin = "LEFT JOIN";
	private static final String rightJoin = "RIGHT JOIN";
	private static final String IN = "IN";
	private static final String notIn = "NOT IN";
	private static final String EXISTS = "EXISTS";
	private static final String notExists = "NOT EXISTS";

	@Override
	public String select() {
		return SELECT;
	}

	@Override
	public String as() {
		return AS;
	}

	@Override
	public String from() {
		return FROM;
	}

	@Override
	public String where() {
		return WHERE;
	}

	@Override
	public String insert() {
		return INSERT;
	}

	@Override
	public String replace() {
		return REPLACE;
	}

	@Override
	public String into() {
		return INTO;
	}

	@Override
	public String values() {
		return VALUES;
	}

	@Override
	public String and() {
		return AND;
	}

	@Override
	public String or() {
		return OR;
	}

	@Override
	public String Null() {
		return NULL;
	}

	@Override
	public String isNull() {
		return ISNULL;
	}

	@Override
	public String isNotNull() {
		return isNotNull;
	}

	@Override
	public String space() {
		return SPACE;
	}

	@Override
	public String update() {
		return UPDATE;
	}

	@Override
	public String set() {
		return SET;
	}

	@Override
	public String delete() {
		return DELETE;
	}

	@Override
	public String orderBy() {
		return orderBy;
	}

	@Override
	public String count() {
		return COUNT;
	}

	@Override
	public String asc() {
		return ASC;
	}

	@Override
	public String on() {
		return ON;
	}

	@Override
	public String forUpdate() {
		return forUpdate;
	}

	@Override
	public String limit() {
		return LIMIT;
	}

	@Override
	public String offset() {
		return OFFSET;
	}

	@Override
	public String top() {
		return TOP;
	}

	@Override
	public String groupBy() {
		return groupBy;
	}

	@Override
	public String having() {
		return HAVING;
	}

	@Override
	public String between() {
		return BETWEEN;
	}

	@Override
	public String notBetween() {
		return notBetween;
	}

	@Override
	public String distinct() {
		return DISTINCT;
	}

	@Override
	public String join() {
		return JOIN;
	}

	@Override
	public String innerJoin() {
		return innerJoin;
	}

	@Override
	public String leftJoin() {
		return leftJoin;
	}

	@Override
	public String rightJoin() {
		return rightJoin;
	}

	@Override
	public String in() {
		return IN;
	}

	@Override
	public String notIn() {
		return notIn;
	}

	@Override
	public String exists() {
		return EXISTS;
	}

	@Override
	public String notExists() {
		return notExists;
	}

}
