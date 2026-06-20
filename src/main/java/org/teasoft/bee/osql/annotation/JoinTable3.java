/*
 * Copyright 2016-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for tables join.
 * @author Kingstar
 * @since  3.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinTable3 {

	/**
	 * JoinType: left join,right join,join, (full join need DB support)
	 * @return JoinType
	 */
	JoinType joinType() default JoinType.JOIN;

	/**
	 * The join on field of main table.
	 * @return join field name of main table.
	 */
	String[] mainField() default {};

	/**
	 * The join on field of subtable.
	 * @return join field name of subtable .
	 */
	String[] subField() default {};

	/**
	 * Subtable alias.
	 * @return subtable alias.
	 */
	String subAlias() default "";

	String mainAlias() default "";

	/**
	 * Subtable entity Class type.
	 * @return subClass Class type.
	 */
	@SuppressWarnings("rawtypes")
	Class subClass() default Object.class;

}
