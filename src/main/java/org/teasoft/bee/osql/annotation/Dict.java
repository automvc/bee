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
 * 字典转化注解,用于按规则过滤处理查询返回数据.
 * 有没映射则不替换
 * data in Databsee:
 * flag=null
 * flag=1
 * flag=0
 * flag=
 * //@Dict(map = "0=No,1=Yes",nullValue="?")
 * @Dict(map = "0=No,1=Yes,=empty,",nullValue="?")
	private String flag;
 * after process:
 * flag=?
 * flag=Yes
 * flag=No
 * flag=empty
 * 
 * 1.11版本,暂未提供通用处理实现.
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dict {

	String map();

	/**
	 * 字段值是null是,替换的目标值
	 * @return
	 */
	String nullValue() default "@#placeholderStr(default do not process)";

}
