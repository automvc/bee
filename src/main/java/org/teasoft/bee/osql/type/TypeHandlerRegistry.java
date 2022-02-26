/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.type;

import java.util.HashMap;
import java.util.Map;

/**
 * Field Type Handler Registry.
 * @author Kingstar
 * @since  1.11
 */
public final class TypeHandlerRegistry {

	private static final String PRIORITY = "1";
	private static final Map<Class<?>, TypeHandler<?>> handlersMap = new HashMap<>();
	private static final Map<Class<?>, String> priorityMap = new HashMap<>();

	/**
	 * register TypeHandler,it will effect if can not process by default.
	 * @param fieldType Javabean field type.
	 * @param handler handler for Javabean field type.
	 */
	public static <T> void register(Class<T> fieldType, TypeHandler<? extends T> handler) {
		handlersMap.put(fieldType, handler);
	}

	/**
	 * register TypeHandler
	 * @param fieldType Javabean field type.
	 * @param handler handler for Javabean field type.
	 * @param isPriority whether use custom handler before default one.
	 */
	public static <T> void register(Class<T> fieldType, TypeHandler<? extends T> handler, boolean isPriority) {
		handlersMap.put(fieldType, handler);
		if (isPriority) priorityMap.put(fieldType, PRIORITY);
	}

	/**
	 * return the priority of the fieldType.
	 * @param fieldType Javabean field type.
	 * @return boolean value of priority
	 */
	public static <T> boolean isPriorityType(Class<T> fieldType) {
		return priorityMap.get(fieldType) == null ? false : true;
	}

	/**
	 * return the register Handler of fieldType.
	 * @param fieldType Javabean field type.
	 * @return the register Handler of fieldType.
	 */
	@SuppressWarnings("unchecked")
	public static <T> TypeHandler<T> getHandler(Class<T> fieldType) {
		return (TypeHandler<T>) handlersMap.get(fieldType);
	}

	/**
	 * process the result get from ResultSet with TypeHandler,and return new processed result.
	 * @param fieldType Javabean field type.
	 * @param result  result get from ResultSet.
	 * @return the result processed by TypeHandler.
	 */
	public static <T> T handlerProcess(Class<T> fieldType, Object result) {
		return getHandler(fieldType).process(fieldType, result);
	}
}
