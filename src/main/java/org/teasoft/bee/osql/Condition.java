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
 * 为面向对象方式操作数据库提供封装的条件.
 * @author Kingstar
 * @since  1.6
 */
public interface Condition extends ConditionAssistant {

	public Condition start(Integer start);

	public Condition size(Integer size);
	
	/**
	 * 设置IncludeType过滤参数.op,between,notBetween方法设置的字段,不受includeType的值影响.
	 * 如果Condition没有使用该方法设置,则按默认过滤方式处理.
	 * @param includeType
	 * @return
	 * @since  1.7
	 */
	public Condition setIncludeType(IncludeType includeType);

	public Condition op(String field, Op Op, Object value);

	/**
	 * 默认自动加 'and'. Default will automatically add 'and'.
	 * 
	 * @return
	 */
	public Condition and();

	/**
	 * 添加 'or'. add 'or'.
	 * 
	 * @return
	 */
	public Condition or();

	/**
	 * 添加左括号.add left parentheses.
	 * @return
	 */
	public Condition lParentheses();

	/**
	 * 添加右括号.add right parentheses.
	 * @return
	 */
	public Condition rParentheses();

	public Condition between(String field, Number low, Number high);
	public Condition notBetween(String field, Number low, Number high);
	public Condition between(String field, String low, String high);
	public Condition notBetween(String field, String low, String high);

	public Condition groupBy(String field);

	/**
	 * eg:having("count(*)>5")  --> having count(*)>5
	 * @param expressionStr 表达式字符串,field不会被转化.
	 * expression string,if contain field,it will not be translated.
	 * @return
	 */
	public Condition having(String expressionStr);

	/**
	 * eg: having(FunctionType.MIN, "field", Op.ge, 60)-->having min(field)>=60
	 * @param functionType 函数类型
	 * @param field 实体字段,会被命名转换(如果需要).
	 * @param Op 操作类型
	 * @param value 值
	 * @return
	 */
	public Condition having(FunctionType functionType, String field, Op Op, Number value);

	public Condition orderBy(String field);

	public Condition orderBy(String field, OrderType orderType);

	/**
	 * eg: orderBy(FunctionType.MAX, "total", OrderType.DESC)-->order by max(total) desc
	 * @param functionType
	 * @param field
	 * @param orderType
	 * @return
	 */
	public Condition orderBy(FunctionType functionType, String field, OrderType orderType);

}
