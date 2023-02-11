/*
 * Copyright 2016-2022 the original author.All rights reserved.
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

package org.teasoft.bee.sharding;

import org.teasoft.bee.osql.OrderType;

/**
 * 
 * the array element 's order corresponds to orderFields[] except index[]. 
 * 
 * select id,name,age from student order by age desc,name asc; struct: orderFields[]{age,name} new OrderType[]
 * {OrderType.DESC,OrderType.ASC} struct.setType(new String[] { "Integer", "String"}); struct.setIndex(new int[] { 2,1});
 * 
 * result: c0 c1 c2 id,name,age
 * 
 * @author AiTeaSoft
 * @since 2.0
 */
public class ShardingSortStruct {

	private String orderSql;  //need when rewrite to union all.
	private String orderFields[];
	private OrderType orderTypes[];

//	the following 5 field for:
//	public List<String[]> select(String sql)

	//The element order corresponds to orderFields []
	private String type[]; //Number,String...
	private boolean nullFirst[];
	private boolean caseSensitive[];
	// the field value in the select column index
	private int index[];
	private volatile boolean regFlag = false;

	public ShardingSortStruct() {}

	public ShardingSortStruct(String orderSql, String[] orderFields, OrderType[] orderTypes) {
		super();
		this.orderSql = orderSql;
		this.orderFields = orderFields;
		this.orderTypes = orderTypes;
	}

	public String getOrderSql() {
		return orderSql;
	}

	public void setOrderSql(String orderSql) {
		this.orderSql = orderSql;
	}

	public String[] getOrderFields() {
		return orderFields;
	}

	public void setOrderFields(String[] orderFields) {
		this.orderFields = orderFields;
	}

	public OrderType[] getOrderTypes() {
		return orderTypes;
	}

	public void setOrderTypes(OrderType[] orderTypes) {
		this.orderTypes = orderTypes;
	}

	/**
	 * the field value in the select column index
	 * @return index array
	 */
	public int[] getIndex() {
		return index;
	}

	/**
	 * the field value in the select column index
	 * 
	 * @param index
	 */
	public void setIndex(int[] index) {
		this.index = index;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public boolean[] getNullFirst() {
		return nullFirst;
	}

	public void setNullFirst(boolean[] nullFirst) {
		this.nullFirst = nullFirst;
	}

	public boolean[] getCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(boolean[] caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	public boolean isRegFlag() {
		return regFlag;
	}

	public void setRegFlag(boolean regFlag) {
		this.regFlag = regFlag;
	}
	
}
