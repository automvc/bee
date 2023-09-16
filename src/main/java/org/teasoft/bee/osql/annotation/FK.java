/*
 * Copyright 2020-2023 the original author.All rights reserved.
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
 * Foreign Key annotation,use for UPDATE,INSERT,DELETE.
 * @author Kingstar
 * @since  2.1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FK {

	/**
	 * foreign key
	 * @return foreign key.
	 */
	 String[] value();
	
	/**
	 * Field referenced by foreign key.
	 * @return Field referenced by foreign key.
	 */
	String[] refBy() default "id"; 
	
//	/**
//	 * whether override the old foreignKey value when it has not blank value.
//	 * @return the boolean value of whether override
//	 */
//	boolean override() default true;
	
}
