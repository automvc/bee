/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Kingstar
 * @since 1.17
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tran {

	/**
	 * value is "true" or "false"
	 * @return
	 */
	String readOnly() default "";

	TransactionIsolationLevel isolation() default TransactionIsolationLevel.DEFAULT;
	
}
