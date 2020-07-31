/*
 * Copyright 2016-2020 the original author.All rights reserved.
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
 * 用户需要保证SQL的书写顺序,如order by应在group by的后面.
 * @author Kingstar
 * @since  1.6
 */
public interface Condition extends ConditionAssistant {

	/**
	 * 添加用于分页时设置开始的页数(仅用于SQL的select).For setting the start of the page(only for select of SQL).
	 * @param start 开始下标(从0或1开始,eg:MySQL是0,Oracle是1).  start index,min value is 0 or 1(eg:MySQL is 0,Oracle is 1).
	 * @return Condition
	 */
	public Condition start(Integer start);

	 /**
	  * 添加用于分页时设置每页返回的记录数量(仅用于SQL的select).For setting the size of the page(only for select of SQL).
	  * @param size 结果集大小 大于等于1. fetch result size (>0).
	  * @return Condition
	  */
	public Condition size(Integer size);
	
	/**
	 * 设置IncludeType过滤参数.op,between,notBetween方法设置的字段,不受includeType的值影响.Set IncludeType.
	 * 如果Condition没有使用该方法设置,则按默认过滤方式处理.
	 * @param includeType
	 * @return Condition
	 * @since  1.7
	 */
	public Condition setIncludeType(IncludeType includeType);

	/**
	 * 添加一个表达式条件.Add a expression condition.
	 * @param field 字段名.field name
	 * @param Op 操作符.operator.
	 * @param value 字段对应的值.value of the field.
	 * @return Condition
	 */
	public Condition op(String field, Op Op, Object value);

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
	 * 
	 * @param field
	 * @param low
	 * @param high
	 * @return Condition
	 */
	public Condition notBetween(String field, Number low, Number high);
	
	/**
	 * 
	 * @param field
	 * @param low
	 * @param high
	 * @return Condition
	 */
	public Condition between(String field, String low, String high);
	
	/**
	 * 
	 * @param field
	 * @param low
	 * @param high
	 * @return Condition
	 */
	public Condition notBetween(String field, String low, String high);

	/**
	 * 
	 * @param field
	 * @return Condition
	 */
	public Condition groupBy(String field);

	/**
	 * eg:having("count(*)>5")  --> having count(*)>5
	 * @param expressionStr 表达式字符串,field不会被转化.
	 * expression string,if contain field,it will not be translated.
	 * @return Condition
	 */
	public Condition having(String expressionStr);

	/**
	 * eg: having(FunctionType.MIN, "field", Op.ge, 60)-->having min(field)>=60
	 * @param functionType 函数类型
	 * @param field 实体字段,会被命名转换(如果需要).
	 * @param Op 操作类型
	 * @param value 值
	 * @return Condition
	 */
	public Condition having(FunctionType functionType, String field, Op Op, Number value);

	/**
	 * eg: orderBy("price")-->order by price
	 * @param field
	 * @return Condition
	 */
	public Condition orderBy(String field);

	/**
	 * eg: orderBy("price", OrderType.DESC)-->order by price desc
	 * @param field 字段名.field name.
	 * @param orderType 排序类型(asc或desc). order type(asc or desc)
	 * @return Condition
	 */
	public Condition orderBy(String field, OrderType orderType);

	/**
	 * eg: orderBy(FunctionType.MAX, "total", OrderType.DESC)-->order by max(total) desc
	 * @param functionType 函数类型.Function type of SQL.
	 * @param field 字段名.field name.
	 * @param orderType 排序类型(asc或desc). order type(asc or desc)
	 * @return Condition
	 */
	public Condition orderBy(FunctionType functionType, String field, OrderType orderType);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
	 * <br>eg: setAdd("price",2.0)--> price=price+2.0
	 * @param field
	 * @param num
	 * @return Condition
	 * @since 1.7.2
	 */
	public Condition setAdd(String field,Number num);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
	 * <br>eg: setMultiply("price",1.05)--> price=price*1.05
	 * @param field
	 * @param num
	 * @return Condition
	 * @since 1.7.2
	 */
	public Condition setMultiply(String field,Number num);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
     * <br>eg:setAdd("price","delta")--> price=price+delta
	 * @param field
	 * @param fieldName
	 * @return Condition
	 * @since 1.7.3
	 */
	public Condition setAdd(String field, String fieldName);

	/**
	 * 设置需要更新的字段(仅用于SQL的update),字段在自身基础上变化.Set the fields to be updated (for only update of SQL),and the field change on itself.
     * <br>eg: setMultiply("price","delta")--> price=price*delta
	 * @param field
	 * @param fieldName another fieldName
	 * @return Condition
	 * @since 1.7.3
	 */
	public Condition setMultiply(String field, String fieldName);
	
	/**
	 * 设置需要更新的字段(仅用于SQL的update);当要更新的字段也需要用于where条件时,可用该方法 
     * <br>Set the fields that need to be updated (only for update of SQL ); this method can be used when the set fields also need to be used for the where expression.
     * <br>eg: set("maxid", 1000)-->maxid=1000
	 * @param fieldNmae
	 * @param num
	 * @return Condition
	 * @since 1.7.3
	 */
	public Condition set(String fieldNmae, Number num);

	/**
	 * 设置需要更新的字段(仅用于SQL的update);当要更新的字段也需要用于where条件时,可用该方法 
     * <br>Set the fields that need to be updated (only for update of SQL); this method can be used when the set fields also need to be used for the where expression.
     * <br>eg: set("name", 'bee')-->name='bee'
	 * @param fieldNmae
	 * @param value
	 * @return Condition
	 * @since 1.7.3
	 */
	public Condition set(String fieldNmae, String value);
	
	
	/**
	 * 指定需要查询的部分字段(仅用于SQL的select).Specify the partial fields to be queried (only for select of SQL).
	 * @param fieldList 需要查询的字段,多个用逗号隔开. select fields,if more than one,separate with comma.
	 * @return Condition
	 * @since 1.7.3
	 */
	public Condition selectField(String fieldList);
	
	/**
	 * 锁定查询的部分记录(仅用于SQL的单个表select)
	 * @return Condition
	 */
	public Condition forUpdate();

}
