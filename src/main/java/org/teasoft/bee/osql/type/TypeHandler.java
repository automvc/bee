/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.type;

/**
 * 自定义ResultSet结果处理器.
 * 根据实体的字段类型,选用处理器处理查询返回结果.
 * @author Kingstar
 * @since  1.11
 */
public interface TypeHandler<T> {

	/**
	 * 使用自定义字段类型处理器处理查询返回结果.
	 * @param fieldType Javabean field type.
	 * @param result get from ResultSet.
	 * @return processed result.
	 */
	public T process(Class<T> fieldType, Object result);


}
