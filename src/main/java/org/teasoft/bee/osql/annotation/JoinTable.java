/*
 * Copyright 2016-2020 the original author.All rights reserved.
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
 * 用于表连接的注解.Annotation for tables join.
 * @author Kingstar
 * @since  1.7
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinTable {

	/**
	 * JoinType: left join,right join,join, (full join need DB support)
	 * @return JoinType
	 */
	JoinType joinType() default JoinType.JOIN;

	/**
	 * 主表关联的字段.The join on field of main table.
	 * @return main table's join field name.
	 */
	String mainField() default ""; 

	/**
	 * 从表关联的字段.The join on field of subtable.
	 * @return subtable's join field name.
	 */
	String subField() default ""; 

	/**
	 * 从表别名.Subtable alias.
	 * @return subtable alias.
	 */
	String subAlias() default ""; 
	
	/**
	 * 从表的class类型;与主表实体在同一包下,可以只写类名.(在使用List类型的从表时才有效)
	 * Subtable class type, if it has same package with main table,the package name can be omitted.
	 * (effect when using a list type Subtable)
	 * replace by subClazz() since 1.11
	 * @return sub Class name.
	 * @since 1.9.8
	 * @deprecated (since="1.11",can use subClazz() replace it.)
	 */
	@Deprecated()
	String subClass() default ""; 
	
	/**
	 * 从表实体的Class类型.(在使用List类型的从表时才有效)
	 * Subtable entity Class type.
	 * (effect when using a list type Subtable)
	 * @return subClass Class type.
	 * @since 1.11
	 */
	@SuppressWarnings("rawtypes")
	Class subClazz() default Object.class; 

}
