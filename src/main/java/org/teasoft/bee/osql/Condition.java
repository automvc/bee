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

package org.teasoft.bee.osql;

/**
 * 为面向对象方式操作数据库提供封装的条件.Condition for operate DB with Object Oriented Programming way.
 * <br>用户需要保证SQL的书写顺序,如order by应在group by的后面.
 * <br>setMultiply,setAdd,set等方法仅用于SQL Update语句的set部分.
 * <br>Users need to ensure the order of SQL writing, such as order by should be behind group by.
 * <br>The methods setMultiply,setAdd,set just use in SQL Update 'set' part.
 * @author Kingstar
 * @since  1.6
 */
public interface Condition extends ConditionAssistant {

	/**
	 * 添加用于分页时设置开始的页数(仅用于SQL的select).For setting the start of the page(only for select of SQL).
	 * <br>无书写顺序限制.There is no restriction on writing order.
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @return Condition
	 */
	public Condition start(Integer start);

	 /**
	  * 添加用于分页时设置每页返回的记录数量(仅用于SQL的select).For setting the size of the page(only for select of SQL).
	  * <br>无书写顺序限制.There is no restriction on writing order.
	  * @param size 结果集大小 大于等于1. fetch result size (>0).
	  * @return Condition
	  */
	public Condition size(Integer size);
	
	/**
	 * 设置IncludeType过滤参数.op,between,notBetween方法设置的字段,不受includeType的值影响.Set IncludeType.
	 * <br>如果Condition没有使用该方法设置,则按默认过滤方式处理.
	 * <br>无书写顺序限制.There is no restriction on writing order.
	 * @param includeType
	 * @return Condition
	 * @since  1.7
	 */
	public Condition setIncludeType(IncludeType includeType);

	/**
	 * 添加一个表达式条件.Add a expression condition.
	 * <br>此方法不能用于SQL的update set.
	 * @param field 字段名.field name
	 * @param op 操作符.operator.
	 * @param value 字段对应的值.value of the field.
	 * @return Condition
	 */
	public Condition op(String field, Op op, Object value);
	

	/**
	 * 表达式将对应  table1 JoinType table2 on field Op value
	 * eg: opOn("table2.valid",Op.eq,"1")    table1 left join table2 on table1.id=table2.id and table2.valid='1'
	 * it is different from where part: table1 left join table2  on table1.id=table2.id where valid='1'
	 * @param field
	 * @param op 操作符.operator.
	 * @param value 字段对应的值.value of the field.
	 * @return Condition
	 */
	public Condition opOn(String field, Op op, Object value);
	
	/**
	 * 添加一个表达式条件.Add a expression condition.
	 * <br>此方法不能用于SQL的update set.
	 * eg: opWithField(field1,Op.gt,field2)-->where field1>field2
	 * @param field1 first field
	 * @param op 操作符.operator.
	 * @param field2 second field
	 * @return Condition
	 * @since 1.9
	 */
	public Condition opWithField(String field1, Op op, String field2);

	/**
	 * 默认自动加 'and'.Default will automatically add 'and'.
	 * 
	 * @return Condition
	 */
	public Condition and();

	/**
	 * 添加 'or'.Add 'or'.
	 * 
	 * @return Condition
	 */
	public Condition or();

	/**
	 * 添加左括号.Add left parentheses.
	 * @return Condition
	 */
	public Condition lParentheses();

	/**
	 * 添加右括号.Add right parentheses.
	 * @return Condition
	 */
	public Condition rParentheses();

	/**
	 * 
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
	 * between
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
	 * eg: having(FunctionType.MIN, "field", Op.ge, 60)-->having min(field)>=60
	 * @param functionType SQL函数类型
	 * @param field 实体字段,会被命名转换(如果需要).
	 * @param op 操作类型
	 * @param value 值
	 * @return Condition
	 */
	public Condition having(FunctionType functionType, String field, Op op, Number value);

	/**
	 * order by
	 * eg: orderBy("price")-->order by price
	 * @param field 用于排序的字段名.field name.
	 * @return Condition
	 */
	public Condition orderBy(String field);

	/**
	 * order by
	 * eg: orderBy("price", OrderType.DESC)-->order by price desc
	 * @param field 用于排序的字段名.field name.
	 * @param orderType 排序类型(asc或desc). order type(asc or desc)
	 * @return Condition
	 */
	public Condition orderBy(String field, OrderType orderType);

	/**
	 * order by
	 * eg: orderBy(FunctionType.MAX, "total", OrderType.DESC)-->order by max(total) desc
	 * @param functionType SQL函数类型.Function type of SQL.
	 * @param field 用于排序的字段名.field name.
	 * @param orderType 排序类型(asc或desc). order type(asc or desc)
	 * @return Condition
	 */
	public Condition orderBy(FunctionType functionType, String field, OrderType orderType);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update set),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
	 * <br>eg: setAdd("price",2.0)--> price=price+2.0
	 * @param field
	 * @param num
	 * @return Condition
	 * @since 1.7.2
	 */
	public Condition setAdd(String field,Number num);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update set),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
	 * <br>eg: setMultiply("price",1.05)--> price=price*1.05
	 * @param field
	 * @param num
	 * @return Condition
	 * @since 1.7.2
	 */
	public Condition setMultiply(String field,Number num);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update set),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
     * <br>eg:setAdd("price","delta")--> price=price+delta
	 * @param field
	 * @param otherFieldName
	 * @return Condition
	 * @since 1.8
	 */
	public Condition setAdd(String field, String otherFieldName);

	/**
	 * 设置需要更新的字段(仅用于SQL的update set),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
     * <br>eg: setMultiply("price","delta")--> price=price*delta
	 * @param field
	 * @param otherFieldName other fieldName
	 * @return Condition
	 * @since 1.8
	 */
	public Condition setMultiply(String field, String otherFieldName);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update set);当要更新的字段也需要用于where条件时,可用该方法 
     * <br>Set the fields that need to be updated (only for update of SQL ); this method can be used when the set fields also need to be used for the where expression.
     * <br>eg: set("maxid", 1000)-->maxid=1000
	 * @param fieldName field name
	 * @param num
	 * @return Condition
	 * @since 1.8
	 */
	public Condition set(String fieldName, Number num);

	/**
	 * 设置需要更新的字段(仅用于SQL的update set);当要更新的字段也需要用于where条件时,可用该方法 
     * <br>Set the fields that need to be updated (only for update of SQL); this method can be used when the set fields also need to be used for the where expression.
     * <br>eg: set("name", 'bee')-->name='bee'
	 * @param fieldName
	 * @param value
	 * @return Condition
	 * @since 1.8
	 */
	public Condition set(String fieldName, String value);
	
	
	/**
	 * set one field with other field value
	 * eg: setWithField(field1,field2)--> set field1=field2
	 * @param field1 first field
	 * @param field2 second field
	 * @return Condition
	 * @since 1.9
	 */
	public Condition setWithField(String field1, String field2);
	
	/**
	 * 指定需要查询的部分字段(仅用于SQL的select).Specify the partial fields to be queried (only for select of SQL).
	 * @param fieldList 需要查询的字段,多个用逗号隔开. select fields,if more than one,separate with comma.
	 * @return Condition
	 * @since 1.8
	 */
	public Condition selectField(String fieldList);
	
	/**
	 * 设置字段fieldName为distinct(fieldName)
	 * eg: selectDistinctField(fieldName) --> distinct(fieldName)
	 * @param fieldName 要设置为distinct的字段
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectDistinctField(String fieldName);

	/**
	 * 设置字段fieldName为distinct(fieldName)
	 * eg: selectDistinctField(fieldName,alias) --> distinct(fieldName) as alias
	 * @param fieldName 要设置为distinct的字段
	 * @param alias 别名
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectDistinctField(String fieldName, String alias);
	
	/**
	 * 设置使用函数查询结果.set select result with function.
	 * <br>eg: condition.selectFun(FunctionType.COUNT, "*");-->count(*)
	 * @param functionType SQL函数类型.Function type of SQL.
	 * @param fieldForFun 用于函数统计的字段名.field name for function.
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectFun(FunctionType functionType, String fieldForFun);
	
	/**
	 * 设置使用函数查询结果.set select result with function.
	 * <br>eg:selectFun(FunctionType.MAX, "score","maxScore")-->max(score) as maxScore
	 * @param functionType SQL函数类型.Function type of SQL.
	 * @param fieldForFun 用于函数统计的字段名.field name for function.
	 * @param alias 统计结果的别名.alias name for the function result.
	 * @return Condition
	 * @since 1.9
	 */
	public Condition selectFun(FunctionType functionType, String fieldForFun, String alias);
	
	/**
	 * 锁定查询的部分记录(仅用于SQL的单个表select).lock the select record with 'for update'.
	 * <br>无书写顺序限制.There is no restriction on writing order.
	 * @return Condition
     * @since 1.8
	 */
	public Condition forUpdate();

}
