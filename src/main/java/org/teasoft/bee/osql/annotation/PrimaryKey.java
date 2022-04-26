/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark an property as the Primary Key.<br>
 * It is not allowed to define a field named ID, but it is not defined as a primary key.<br>
 * When the field name of the primary key is not "id", it can be marked as the primary <br>
 * key with the PrimaryKey annotation.<br>
 * When the field has Ignore annotation, the PrimaryKey annotation will also be ignored.<br>
 * This annotation exists for compatibility with old systems, <br>
 * It is strongly recommended to set an "id" column as the primary key when defining table in the new system.
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {
	
}
