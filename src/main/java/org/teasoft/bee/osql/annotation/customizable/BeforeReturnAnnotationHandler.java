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

import java.lang.reflect.Field;
import java.util.List;

/**
 * BeforeReturn类型注解处理器接口
 * Annotation Handler Interface.
 * @author Kingstar
 * @since  1.11
 */
public interface BeforeReturnAnnotationHandler {

	/**
	 * 
	 * @param field 带有相应注解的Field
	 * @param list 需要处理注解的List
	 */
	@SuppressWarnings("rawtypes")
	public void process(Field field,List list);

}
