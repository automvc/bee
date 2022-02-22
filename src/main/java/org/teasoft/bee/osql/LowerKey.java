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
 * SQL关键字的小写形式.SQL KeyWord's lower case.
 * @author Kingstar
 * @since  1.8.99
 */
public class LowerKey implements SqlKeyWord {

	private static final String SPACE = " ";
	private static final String select = "select";
	private static final String as = "as";
	private static final String from = "from";
	private static final String where = "where";
	private static final String insert = "insert";
	private static final String replace = "replace";
	private static final String into = "into";
	private static final String values = "values";
	private static final String and = "and";
	private static final String or = "or";
	private static final String Null = "null";
	private static final String isNull = "is null";
	private static final String isNotNull = "is not null";
	private static final String update = "update";
	private static final String set = "set";
	private static final String delete = "delete";
	private static final String orderBy = "order by";
	private static final String count = "count";
	private static final String asc = "asc";
	private static final String on = "on";
	private static final String limit = "limit";
	private static final String offset = "offset";
	private static final String top = "top";

	private static final String groupBy = "group by";
	private static final String having = "having";
	private static final String between = "between";
	private static final String notBetween = "not between";

	private static final String forUpdate = "for update";

	private static final String distinct = "distinct";
	private static final String join = "join";
	private static final String innerJoin = "inner join";
	private static final String leftJoin = "left join";
	private static final String rightJoin = "right join";
	private static final String in = "in";
	private static final String notIn = "not in";
	private static final String exists = "exists";
	private static final String notExists = "not exists";

	@Override
	public String select() {
		return select;
	}

	@Override
	public String as() {
		return as;
	}

	@Override
	public String from() {
		return from;
	}

	@Override
	public String where() {
		return where;
	}

	@Override
	public String insert() {
		return insert;
	}

	@Override
	public String replace() {
		return replace;
	}

	@Override
	public String into() {
		return into;
	}

	@Override
	public String values() {
		return values;
	}

	@Override
	public String and() {
		return and;
	}

	@Override
	public String or() {
		return or;
	}

	@Override
	public String Null() {
		return Null;
	}

	@Override
	public String isNull() {
		return isNull;
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
		return update;
	}

	@Override
	public String set() {
		return set;
	}

	@Override
	public String delete() {
		return delete;
	}

	@Override
	public String orderBy() {
		return orderBy;
	}

	@Override
	public String count() {
		return count;
	}

	@Override
	public String asc() {
		return asc;
	}

	@Override
	public String on() {
		return on;
	}

	@Override
	public String forUpdate() {
		return forUpdate;
	}

	@Override
	public String limit() {
		return limit;
	}

	@Override
	public String offset() {
		return offset;
	}

	@Override
	public String top() {
		return top;
	}

	@Override
	public String groupBy() {
		return groupBy;
	}

	@Override
	public String having() {
		return having;
	}

	@Override
	public String between() {
		return between;
	}

	@Override
	public String notBetween() {
		return notBetween;
	}

	@Override
	public String distinct() {
		return distinct;
	}

	@Override
	public String join() {
		return join;
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
		return in;
	}

	@Override
	public String notIn() {
		return notIn;
	}

	@Override
	public String exists() {
		return exists;
	}

	@Override
	public String notExists() {
		return notExists;
	}

}
