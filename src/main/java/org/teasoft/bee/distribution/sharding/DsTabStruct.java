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

package org.teasoft.bee.distribution.sharding;

/**
 * DataSource and Table Struct
 * @author Kingstar
 * @since  1.11
 */
public class DsTabStruct {

	private String dsName;
	private String tabName;
	
	/**
	 * table name Suffix
	 * tabName使用Entity名称转换时,可设置
	 */
	private String tabSuffix;
	
	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
	
	/**
	 * return table name Suffix
	 * @return table name Suffix
	 */
	public String getTabSuffix() {
		return tabSuffix;
	}

	/**
	 * table name Suffix
	 * tabName使用Entity名称转换时,可设置
	 */
	public void setTabSuffix(String tabSuffix) {
		this.tabSuffix = tabSuffix;
	}
	
}