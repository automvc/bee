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
 * 为了过滤查询记录的结构体.Struct for search the record.
 * <p>
 * eg:
 * new Search("id",Operator.between,"100030","100035","or");
 * --> or id between 100030 and 100035

 * @author Kingstar
 * @since  1.9.8
 */
public class Search {

	private String field;
	private Operator op;
	private String value1;

	// when like,notLike, value2 is:Left,Right,LeftRight
	// when function, value2 is: alias name
	//between, notBetween value2 is:second para
	// other Operator,value2 is null
	private String value2;

	private String op2; //or ,   and is default

	public Search() {}

	public Search(String field, Operator operator, String value1, String value2) {
		super();
		this.field = field;
		this.op = operator;
		this.value1 = value1;
		this.value2 = value2;
	}

	public Search(String field, Operator operator, String value1, String value2, String op2) {
		super();
		this.field = field;
		this.op = operator;
		this.value1 = value1;
		this.value2 = value2;
		this.op2 = op2;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Operator getOp() {
		return op;
	}

	public void setOp(Operator operator) {
		this.op = operator;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	/**
	 * when like,notLike, value2 is:Left,Right,LeftRight
	 * when function, value2 is: alias name
	 * between, notBetween value2 is:second para
	 * other Operator,value2 is null
	 * @return value2
	 */
	public String getValue2() {
		return value2;
	}

	/**
	 * when like,notLike, value2 is:Left,Right,LeftRight
	 * when function, value2 is: alias name
	 * between, notBetween value2 is:second para
	 * other Operator,value2 is null
	 * @param value2
	 */
	public void setValue2(String value2) {
		this.value2 = value2;
	}

	/**
	 * it will be : "or", "and" , "(" , ")" ,   "or (",   ") or",  "and (",  ") and"
	 * @return operator2
	 */
	public String getOp2() {
		return op2;
	}

	/**
	 * it will be : "or", "and" , "(" , ")" ,   "or (",   ") or",  "and (",  ") and"
	 * @param operator2
	 */
	public void setOp2(String operator2) {
		this.op2 = operator2;
	}

}
