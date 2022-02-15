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

import org.teasoft.bee.osql.SuidType;

/**
 * 自动填充AutoSetValue标识的字段.
 * 填充的值由handler指定的类提供.
 * 字段的类型,需要是java.lang.String.
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoSetString {
	boolean override() default false;

	SuidType suidType();

	Class<? extends AnnotationHandler> handler();
}
