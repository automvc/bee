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

package org.teasoft.bee.osql.annotation.customizable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 从指定位置开始,将指定数量的字符改为掩码字符
 * eg:
 * 	\@Desensitize(start=5, size=2, mask="*")
 * 	private String sequence;
 * 	sequence in the database is: 0123456789
 * 	after process:
 * 	sequence=01234**789
 * 
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Desensitize {
	/**
	 * 开始位置(从0开始)
	 * Start position (starting from 0)
	 * @return start position
	 */
	int start();
	
	/**
	 * 需要替换的字符数量
	 * the number of characters need to replace
	 * @return the number of characters need to replace
	 */
	int size();
	
	/**
	 * 使用的掩码
	 * Mask used
	 * @return mask code
	 */
	String mask(); 
}
