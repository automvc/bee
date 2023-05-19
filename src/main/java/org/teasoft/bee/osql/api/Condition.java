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

package org.teasoft.bee.osql.api;

import org.teasoft.bee.osql.ConditionAssistant;
import org.teasoft.bee.osql.FunctionType;
import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;

/**
 * Condition for operate DB with Object Oriented Programming way.
 * <br>Users need to ensure the order of SQL writing, such as order by should be behind group by.
 * <br>The methods setMultiply,setAdd,set just use in SQL Update 'set' part.
 * <br>Field name will be translated according the config.
 * @author Kingstar
 * @since  1.6
 */
public interface Condition extends ConditionAssistant {

	/**
	 * For setting the start of the page(only for select of SQL).
	 * <br>There is no restriction on writing order.
	 * @param start Start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @return Condition
	 */
	public Condition start(Integer start);

	 /**
	  * For setting the size of the page(only for select of SQL).
	  * There is no restriction on writing order.
	  * @param size Fetch result size (>0).
	  * @return Condition
	  */
	public Condition size(Integer size);
	
	/**
	 * Set the IncludeType filter parameter. The fields set by op, between and 
	 * <br>notbetween methods are not affected by the value of IncludeType.
	 * <br>If the condition is not set with this method, it will be processed 
	 * <br>according to the default filtering method.
	 * <br>There is no restriction on writing order.
	 * @param includeType
	 * @return Condition
	 * @since  1.7
	 */
	public Condition setIncludeType(IncludeType includeType);

	/**
	 * Add a expression condition.
	 * <br>This method cannot be used for SQL update set part.
	 * @param field Field name
	 * @param op operator
	 * @param value Value of the field.
	 * @return Condition
	 */
	public Condition op(String field, Op op, Object value);
////	- The type Number is not an interface; it cannot be specified as a bounded parameter
//	public <T extends String & List & Set & Number[] & Number> Condition op(String field, Op op, T value);
	

	/**
	 * The expression will correspond to: table1 JoinType table2 on field Op value
	 * <br>eg: opOn("table2.valid",Op.eq,"1")    table1 left join table2 on table1.id=table2.id and table2.valid='1'
	 * <br>it is different from where part: table1 left join table2  on table1.id=table2.id where valid='1'
	 * @param field Field name
	 * @param op operator
	 * @param value Value of the field. Since 1.17 the type change from Object to String,Number.
	 * @return Condition
	 */
	public Condition opOn(String field, Op op, String value);
//	public Condition opOn(String field, Op op, Object value);
	
	
	/**
	 * The expression will correspond to: table1 JoinType table2 on field Op value
	 * <br>eg: opOn("table2.valid",Op.eq,1)    table1 left join table2 on table1.id=table2.id and table2.valid=1
	 * <br>it is different from where part: table1 left join table2  on table1.id=table2.id where valid=1
	 * @param field Field name
	 * @param op operator
	 * @param value Value of the field. Since 1.17 the type change from Object to String,Number.
	 * @return Condition
	 */
	public Condition opOn(String field, Op op, Number value);
	
	/**
	 * Add a expression condition.
	 * <br>This method cannot be used for SQL update set part.
	 * <br>eg: opWithField(field1,Op.gt,field2)-->where field1>field2
	 * @param field1 first field name
	 * @param op operator
	 * @param field2 second field name
	 * @return Condition
	 * @since 1.9
	 */
	public Condition opWithField(String field1, Op op, String field2);

	/**
	 * Default will automatically add 'and'.
	 * 
	 * @return Condition
	 */
	public Condition and();

	/**
	 * Add 'or'.
	 * 
	 * @return Condition
	 */
	public Condition or();

	/**
	 * Add left parentheses '('.
	 * @return Condition
	 */
	public Condition lParentheses();

	/**
	 * Add right parentheses ')'.
	 * @return Condition
	 */
	public Condition rParentheses();

	/**
	 * transform to:  field between low and high;
	 * @param field
	 * @param low
	 * @param high
	 * @return Condition
	 */
	public Condition between(String field, Number low, Number high);
	
	/**
	 * not between
	 * @param field
	 * @param low
	 * @param high
	 * @return Condition
	 */
	public Condition notBetween(String field, Number low, Number high);
	
	/**
	 * field between 'low' and 'high';
	 * @param field
	 * @param low
	 * @param high
	 * @return Condition
	 */
	public Condition between(String field, String low, String high);
	
	/**
	 * not between
	 * @param field
	 * @param low
	 * @param high
	 * @return Condition
	 */
	public Condition notBetween(String field, String low, String high);

	/**
	 * group by
	 * @param field
	 * @return Condition
	 */
	public Condition groupBy(String field);

	/**
	 * having
	 * <br>eg: having(FunctionType.MIN, "field", Op.ge, 60)-->having min(field)>=60
	 * @param functionType FunctionType
	 * @param field Entity field,it will be translated according the config.
	 * @param op operator
	 * @param value Value of the field.
	 * @return Condition
	 */
	public Condition having(FunctionType functionType, String field, Op op, Number value);

	/**
	 * order by
	 * <br>eg: orderBy("price")-->order by price
	 * @param field field name.
	 * @return Condition
	 */
	public Condition orderBy(String field);

	/**
	 * order by
	 * <br>eg: orderBy("price", OrderType.DESC)-->order by price desc
	 * @param field Field name.
	 * @param orderType order type(asc or desc)
	 * @return Condition
	 */
	public Condition orderBy(String field, OrderType orderType);

	/**
	 * order by
	 * <br>eg: orderBy(FunctionType.MAX, "total", OrderType.DESC)-->order by max(total) desc
	 * @param functionType Function type of SQL.
	 * @param field Field name.
	 * @param orderType order type(asc or desc)
	 * @return Condition
	 */
	public Condition orderBy(FunctionType functionType, String field, OrderType orderType);
	

	/**
	 * Specify the partial fields to be queried (only for select of SQL).
	 * @param fields select fields,if more than one,separate with comma or use variable-length arguments.
	 * @return Condition
	 * @since 1.8
	 * @since 1.11 support variable-length arguments
	 */
	public Condition selectField(String... fields);
	
	/**
	 * set fieldName for distinct(fieldName)
	 * <br>eg: selectDistinctField(fieldName) --> distinct(fieldName)
	 * @param fieldName Field name
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectDistinctField(String fieldName);

	/**
	 * set fieldName for distinct(fieldName)
	 * eg: selectDistinctField(fieldName,alias) --> distinct(fieldName) as alias
	 * @param fieldName Field name
	 * @param alias Name of alias
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectDistinctField(String fieldName, String alias);
	
	/**
	 * set for select result with function.
	 * <br>eg: condition.selectFun(FunctionType.COUNT, "*");-->count(*)
	 * @param functionType Function type of SQL.
	 * @param fieldForFun Field name for function.
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectFun(FunctionType functionType, String fieldForFun);
	
	/**
	 * set for select result with function.
	 * <br>eg:selectFun(FunctionType.MAX, "score","maxScore")-->max(score) as maxScore
	 * @param functionType Function type of SQL.
	 * @param fieldForFun field name for function.
	 * @param alias Name of alias for the function result.
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectFun(FunctionType functionType, String fieldForFun, String alias);
	
	/**
	 * lock the select record with 'for update'.
	 * <br>There is no restriction on writing order.
	 * @return Condition
     * @since 1.8
	 */
	public Condition forUpdate();
	
	
	
	////////////////////////////////-------just use in update-------------start-
	
	/**
	 * Set the fields to be updated (for only update of SQL),and the field change on itself.
	 * <br>eg: setAdd("price",2.0)--> price=price+2.0
	 * @param field Field name.
	 * @param num number
	 * @return Condition
	 * @since 1.7.2
	 */
	public Condition setAdd(String field,Number num);
	
	/**
	 * Set the fields to be updated (for only update of SQL),and the field change on itself.
	 * <br>eg: setMultiply("price",1.05)--> price=price*1.05
	 * @param field Field name.
	 * @param num number
	 * @return Condition
	 * @since 1.7.2
	 */
	public Condition setMultiply(String field,Number num);
	
	/**
	 * Set the fields to be updated (for only update of SQL),and the field change on itself.
     * <br>eg:setAdd("price","delta")--> price=price+delta
	 * @param field Field name.
	 * @param otherFieldName
	 * @return Condition
	 * @since 1.8
	 */
	public Condition setAdd(String field, String otherFieldName);

	/**
	 * Set the fields to be updated (for only update of SQL),and the field change on itself.
     * <br>eg: setMultiply("price","delta")--> price=price*delta
	 * @param field Field name.
	 * @param otherFieldName other fieldName
	 * @return Condition
	 * @since 1.8
	 */
	public Condition setMultiply(String field, String otherFieldName);
	
	/**
	 * Set the fields that need to be updated (only for update of SQL ); 
     * <br>this method can be used when the set fields also need to be used for the where expression.
     * <br>eg: set("maxid", 1000)-->update table_name set maxid=1000
	 * @param fieldName field name
	 * @param num number
	 * @return Condition
	 * @since 1.8
	 */
	public Condition set(String fieldName, Number num);

	/**
	 * Set the fields that need to be updated (only for update of SQL); 
	 * <br>this method can be used when the set fields also need to be used for the where expression.
     * <br>eg: set("name", 'bee')-->name='bee'
	 * @param fieldName Field name
	 * @param value
	 * @return Condition
	 * @since 1.8
	 */
	public Condition set(String fieldName, String value);
	
	
	/**
	 * Set the fields with null value (only for update of SQL); 
	 * @param fieldName
	 * @return Condition
	 * @since 2.0
	 */
	public Condition setNull(String fieldName);
	
	/**
	 * set one field with other field value
	 * <br>eg: setWithField(field1,field2)--> set field1=field2
	 * @param field1 first field name
	 * @param field2 second field name
	 * @return Condition
	 * @since 1.9
	 */
	public Condition setWithField(String field1, String field2);
	
	////////////////////////////////-------just use in update-------------end-
	


}
