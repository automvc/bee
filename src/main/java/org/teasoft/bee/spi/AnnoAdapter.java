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

package org.teasoft.bee.spi;

import java.lang.reflect.Field;

/**
 * Annotation adapter interface.
 * @author Kingstar
 * @since  1.17
 */
public interface AnnoAdapter {

	/**
	 * Check the property or field whether is Primary Key annotation.
	 * The annotation is used to annotate a property or field of an entity class.
	 * @param field annotated field
	 * @return boolean value
	 */
	public boolean isPrimaryKey(Field field);

	/**
	 * Check the class whether is Table annotation.
	 * The annotation is used to annotate an entity class.
	 * @param clazz
	 * @return boolean value
	 */
	public boolean isTable(Class<?> clazz);

	/**
	 * Check the property or field whether is Column annotation.
	 * The annotation is used to annotate a property or field of an entity class.
	 * @param field annotated field
	 * @return boolean value
	 */
	public boolean isColumn(Field field);

	/**
	 * Check the property or field whether is Ignore or Transient annotation.
	 * The annotation is used to annotate a property or field of an entity class.
	 * @param field annotated field
	 * @return boolean value
	 */
	public boolean isIgnore(Field field);

	/**
	 * get the value of annotation which use on the field.
	 * @param field annotated field
	 * @return the value of annotation which use on the field.
	 */
	public String getValue(Field field);

	/**
	 * get the value of annotation which use on the class.
	 * @param clazz  annotated class
	 * @return the value of annotation which use on the class.
	 */
	public String getValue(Class<?> clazz);

}
