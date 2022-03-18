/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.token;

/**
 * 自定义动态SQL标签
 * 不能用在批量插入操作.
 * @author Kingstar
 * @since  1.11
 */
public final class CustomAutoSqlToken {
	public static final String isNotNull = "<if isNotNull>";
	public static final String isNotBlank = "<if isNotBlank>";
	public static final String endIf = "</if>";
	
	/**
	 * support list and set, transfer to: in (1,2) or in ('a','b')
	 * userid in #{userid @in}
	 * userid in #{userid@in}
	 */
	public static final String atIn="@in";
	
	//when the value is null, name=#{name@toIsNULL1} -> name is null (delete one char '='
	public static final String toIsNULL1="@toIsNULL1";
	//when the value is null, num>=#{num@toIsNULL2} -> name is null (delete two char '>=')
	public static final String toIsNULL2="@toIsNULL2";
	
	//just use in like
	public static final String percent ="%";
}
