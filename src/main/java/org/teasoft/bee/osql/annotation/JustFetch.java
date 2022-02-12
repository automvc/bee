/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于查询并获取记录信息,但不作为过滤条件.
 * eg:
 * @JustFetch("CONCAT(fisrt_name,last_name)") //多表查询时,若字段会混淆,需要带表名
 * private String fullname;
 * -->select CONCAT(fisrt_name,last_name) as fullname
 *  
 *  map field name and column name,but can not transform to where part
 *  eg:
 * 	@JustFetch("name")
 * 	private String name2;
 * -->select name as name2	
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JustFetch {
	String value();
}
