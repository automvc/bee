/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

/**
 * @author Kingstar
 * @since  1.6
 */
public interface Condition extends ConditionAssistant {

	public Condition start(Integer start);

	public Condition size(Integer size);

	public Condition op(String field, Op Op, Object value);

	/**
	 * 默认自动加 and. Default will automatically add and.
	 * 
	 * @return
	 */
	public Condition and();

	public Condition or();

	public Condition lParentheses();

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
