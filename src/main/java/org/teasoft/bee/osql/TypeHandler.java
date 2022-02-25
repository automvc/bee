/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

/**
 * 根据实体的字段类型,选用处理器处理查询返回结果.
 * @author Kingstar
 * @since  1.11
 */
public interface TypeHandler<T> {

	/**
	 * 使用默认处理不能解决时,才会用自定义字段类型处理器.
	 * @param fieldType Javabean field type.
	 * @param result get from ResultSet.
	 * @return processed result.
	 */
	public T process(Class<T> fieldType, Object result);


}
