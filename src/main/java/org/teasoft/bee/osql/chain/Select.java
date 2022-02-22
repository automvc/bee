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
package org.teasoft.bee.osql.chain;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;

/**
 * Select接口,用于链式风格写SQL语句.Select interface for SQL with chain programming.
 * @author Kingstar
 * @since  1.3
 */
public interface Select extends ToSql{
	
	//<==============condition start
	
	/**
	 * 添加左括号.add "("
	 * @return Update
	 */
	public Select lParentheses();
	
	/**
	 * 添加右括号.add ")"
	 * @return Update
	 */
	public Select rParentheses();
	
	public Select op(String field, Op op, String value);

	public Select op(String field, Op op, Number value);
	
	public Select op(String field, String value);

	public Select op(String field, Number value);

	/**
	 * 默认自动加and. Default will automatically add and.
	 * @return Select
	 */
	public Select and();

	public Select or();
	
	
	public Select where();

	public Select where(String expression) ;
	
	public Select between(String field, Number low, Number high);
	public Select notBetween(String field, Number low, Number high);

	public Select isNull(String field);
	public Select isNotNull(String field);

	public Select in(String field, Number... valueList);
	public Select notIn(String field, Number... valueList);
	
	public Select in(String field, String valueList);
	public Select notIn(String field, String valueList);
	
	//==============condition end>
	
	public Select select() ;

	public Select select(String column);

	public Select distinct(String field) ;

	public Select from(String table);

	public Select join(String anotherTable) ;

	public Select innerJoin(String anotherTable);

	public Select leftJoin(String anotherTable);

	public Select rightJoin(String anotherTable);

	public Select on();

	public Select on(String expression);

	public Select groupBy(String field);

	public Select having(String expression);

	public Select orderBy(String field);

	public Select orderBy(String field, OrderType orderType);

	public Select start(int start) ;

	public Select size(int size) ;

	public Select exists(Select subSelect) ;
	public Select notExists(Select subSelect);
	
	public Select in(String field, Select subSelect);
	public Select notIn(String field, Select subSelect);
}
