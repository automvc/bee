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

package org.teasoft.bee.spi.entity;

/**
 * Struct for sort bean.
 * @author AiTeaSoft
 * @since  2.0
 */
public class SortStruct {
	
	private String fieldName;
	private boolean isReverse; //In descending order, the default is false; That is, the default is ascending
	
	public SortStruct(String fieldName) {
		this.fieldName=fieldName;
	}
	
	public SortStruct(String fieldName, boolean isReverse) {
		this.fieldName = fieldName;
		this.isReverse = isReverse;
	}

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * In descending order, the default is false; That is, the default is ascending.
	 * @return boolean value
	 */
	public boolean isReverse() {
		return isReverse;
	}
	
	/**
	 * In descending order, the default is false; That is, the default is ascending.
	 * @param isReverse
	 */
	public void setReverse(boolean isReverse) {
		this.isReverse = isReverse;
	}

}
