/*
 * Copyright 2013-2019 the original author.All rights reserved.
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
 * @author Kingstar
 * @since  1.8.99
 */
public class LowerKey implements SqlKeyWord{
	
	public static String SPACE=" ",
	        select="select",
			from="from", 
			where="where",
			insert="insert",
			into="into",
			values="values",
			and="and",
			or="or",
			Null="null",
			isNull="is null",
			isNotNull="is not null",
			update="update",
			set="set",
			delete="delete",
			orderBy="order by",
			count="count",
			asc="asc",
			on="on",
			limit="limit",
			offset="offset",
			top="top",
			
			groupBy="group by",
			having="having",
			between="between",
			notBetween="not between",
			
			forUpdate="for update";

	@Override
	public String select() {
		return select;
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

}
