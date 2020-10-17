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
public class UpperKey implements SqlKeyWord{
	
	public static String SPACE=" ",
			select="SELECT",
			from="FROM", 
			where="WHERE",
			insert="INSERT",
			into="INTO",
			values="VALUES",
			and="AND",
			or="OR",
			Null="NULL",
			isNull="IS NULL",
			isNotNull="IS NOT NULL",
			update="UPDATE",
			set="SET",
			delete="DELETE",
			orderBy="ORDER BY",
			count="COUNT",
			asc="ASC",
			on="ON",
			forUpdate="FORUPDATE",
			limit="LIMIT",
			offset="OFFSET",
			top="TOP"	
			;

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
	
}
