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

/**
 * 链式风格写SQL语句的Update接口.Update interface for SQL with chain programming.
 * @author Kingstar
 * @since  1.3
 */
public interface Update extends ToSql{

	public Update update(String table) ;
	public Update set(String field, String value);
	public Update set(String field, Number value);
	
	//<==============condition
	public Update op(String field, Op opType, String value);

	public Update op(String field, Op opType, Number value);
	
	public Update op(String field, String value);

	public Update op(String field, Number value);

	/**
	 * 默认自动加 and. Default will automatically add and.
	 * 
	 * @return
	 */
	public Update and();

	public Update or();
	
	
	public Update where();

	public Update where(String expression) ;
	//=============>
}
