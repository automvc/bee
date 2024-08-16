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

package org.teasoft.bee.sharding;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Struct for SQL group & function in Sharding.
 * @author Kingstar
 * @since  2.0
 */
public class GroupFunStruct {

	private List<String> groupFields;
//	private FunStruct funStructs[];
	private List<FunStruct> funStructs;

	private boolean needGroupWhenNoFun;

	// has avg or String[] type need following
	private boolean hasAvg;
	private String columnNames;

	private Map<String, Integer> columnIndexMap = new LinkedHashMap<>();

	public GroupFunStruct() {}

//	public GroupFunStruct(List<String> groupFields, FunStruct[] funStructs) {
//		super();
//		this.groupFields = groupFields;
//		this.funStructs = funStructs;
//	}

	public List<String> getGroupFields() {
		return groupFields;
	}

	public void setGroupFields(List<String> groupFields) {
		this.groupFields = groupFields;
	}

//	public FunStruct[] getFunStructs() {
//		return funStructs;
//	}
//
//	public void setFunStructs(FunStruct[] funStructs) {
//		this.funStructs = funStructs;
//	}

	public List<FunStruct> getFunStructs() {
		return funStructs;
	}

	public void setFunStructs(List<FunStruct> funStructs) {
		this.funStructs = funStructs;
	}

	public boolean isNeedGroupWhenNoFun() {
		return needGroupWhenNoFun;
	}

	public void setNeedGroupWhenNoFun(boolean needGroupWhenNoFun) {
		this.needGroupWhenNoFun = needGroupWhenNoFun;
	}

	public boolean isHasAvg() {
		return hasAvg;
	}

	public void setHasAvg(boolean hasAvg) {
		this.hasAvg = hasAvg;
	}

	public String getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String columnNames) {
		this.columnNames = columnNames;

		String columns[] = columnNames.split(",");
		String t;
		int index = -1;
		for (int i = 0; i < columns.length; i++) {
			t = columns[i].trim();
			if (t != null) {
				t = t.toLowerCase();
				index = t.indexOf(" as ");
				if (index > 0) t = t.substring(index + 4);
				columnIndexMap.put(t, i);
			}
		}
	}

	public Map<String, Integer> getColumnIndexMap() {
		return this.columnIndexMap;
	}

	public Integer getIndexByColumn(String column) {
		return getColumnIndexMap().get(column);
	}

}
