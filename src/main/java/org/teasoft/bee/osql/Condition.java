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
public interface Condition extends ConditionAssistant{
	
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
	
	public Condition groupBy(String field);

	public Condition having(String expression);

	public Condition orderBy(String field);

	public Condition orderBy(String field, OrderType orderType);

}
