/*
 * Copyright 2013-2021 the original author.All rights reserved.
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

package org.teasoft.bee.osql.search;

/**
 * 较全的操作符
 * More complete operators
 * @author Kingstar
 * @since  1.9.8
 */
public enum Operator {
	
	/**
	 * eq is : =
	 */
	eq("="),
	
	/**
	 * gt is : >
	 */
	gt(">"),
	
	/**
	 * lt is : <
	 */
	lt("<"),
	
	/**
	 * nq is : !=
	 */
	nq("!="),   // <> 
	
	/**
	 * ge is : >=
	 */
	ge(">="),
	
	/**
	 * le is : <=
	 */
	le("<="),
	
	like("like"),
	notLike("not like"),
	
	in("in"),
	notIn("not in"),
	
	between("between"),
	notBetween("notBetween"),
	
	
	//select specific
	groupBy("groupBy"),
	having("having"),
	orderBy("orderBy"),
	
	//select specific
	distinct("distinct"),
	max("max"),
	min("min"),
	sum("sum"),
	avg("avg"),
	count("count"),
	
	
	or("or"),
	and("and")
	;
	
	private String operator;
	
	Operator(String operator){
		this.operator=operator;
	}

	public String getOperator() {
		return operator;
	}

}
