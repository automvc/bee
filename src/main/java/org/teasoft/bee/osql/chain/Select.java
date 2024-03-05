/*
 * Copyright 2013-2024 the original author.All rights reserved.
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

import org.teasoft.bee.osql.OrderType;

/**
 * Select interface for SQL with chain programming.
 * @author Kingstar
 * @since  1.3
 * @since  2.4.0
 */
public interface Select extends Where<Select>, ToSql {
	
	public Select select() ;

	public Select select(String column);

	public Select distinct(String field) ;
	public Select distinct(String fieldName, String alias); //2.x

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
	
	public Select forUpdate();
	
//	public Condition selectFun(FunctionType functionType, String fieldForFun);
//	public Condition selectFun(FunctionType functionType, String fieldForFun, String alias);
	
	
//	public Select selectFun(FunctionType functionType, String fieldForFun);
//	public Select selectFun(FunctionType functionType, String fieldForFun, String alias);
//	public Select forUpdate();
}
