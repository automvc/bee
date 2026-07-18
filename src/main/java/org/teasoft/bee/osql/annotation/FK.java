/*
 * Copyright 2020-2026 the original author.All rights reserved.
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
 * Foreign Key annotation,use for UPDATE, INSERT, DELETE.
 * if do not use FK, will use JoinTable by default;
 * if define mainField/subField in FK, it will override mainField/subField in JoinTable when use update/insert/delete.
 * @author Kingstar
 * @since  3.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FK {

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
	 * Subtable entity Class type.
	 * @return subClass Class type.
	 */
	@SuppressWarnings("rawtypes")
	Class subClass() default Object.class;

}
