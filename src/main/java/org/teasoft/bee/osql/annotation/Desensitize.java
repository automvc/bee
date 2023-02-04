/*
 * Copyright 2016-2022 the original author.All rights reserved.
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
 * Starting from the specified position, change the specified size of characters to mask characters.
 *<br> eg:
 *<br> 	\@Desensitize(start=5, size=2, mask="*")
 *<br> 	private String sequence;
 *<br> 	sequence in the database is: 0123456789
 *<br> 	after process:
 *<br> 	sequence=01234**789
 *<br> 	V2.0
 *<br> 	\@Desensitize(start=0, size=-1, mask="*")  //replace all
 *<br> 	\@Desensitize(start=2, size=-1, mask="*")  //replace from 2 to end
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitize {
	/**
	 * Start position (starting from 0)
	 * @return start position
	 */
	int start();
	
	/**
	 * the number of characters need to replace;
	 * if it is - 1, replace it until the end(V2.0).
	 * @return the number of characters need to replace
	 */
	int size();
	
	/**
	 * Mask used
	 * @return mask code
	 */
	String mask(); 
}
