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

package org.teasoft.bee.sharding;

/**
 * Page struct for Sharding.
 * @author AiTeaSoft
 * @since 2.0
 */
public class ShardingPageStruct {

	private String beforeSql;
	private String pagingSql;
	private int pagingType; // MoreTablesInSameDsUseUnionAll:1, MoreDs:2, FullSelectPage:3
	private Integer start = -1; // -1 do not use
	private Integer size;

	public String getBeforeSql() {
		return beforeSql;
	}

	public void setBeforeSql(String beforeSql) {
		this.beforeSql = beforeSql;
	}

	public String getPagingSql() {
		return pagingSql;
	}

	public void setPagingSql(String pagingSql) {
		this.pagingSql = pagingSql;
	}

	public int getPagingType() {
		return pagingType;
	}

	// MoreTablesInSameDsUseUnionAll:1, MoreDs:2, FullSelectPage:3
	public void setPagingType(int pagingType) {
		this.pagingType = pagingType;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
