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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Struct for SQL group & function in Sharding.
 * @author Kingstar
 * @since  2.0
 */
public class GroupFunStruct {

	private List<String> groupFields;
//	private FunStruct funStructs[];
	private List<FunStruct> funStructs;

	private List<String> orginalSelectColumn = new ArrayList<>(); // V3.0.0.8 记录selectString[]原来查的列，以便删除自动加的列
	private Set<String> addedGroupByColumn = new LinkedHashSet<>(); // V3.0.0.8 记录分组的字段没在select而加的字段

//	private boolean needGroupWhenNoFun;

	// has avg or String[] type need following
	private boolean hasAvg;
	private String columnNames;

	private Map<String, Integer> columnIndexMap = new LinkedHashMap<>();

	private String mainTableForGroupField = "";

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

//	public boolean isNeedGroupWhenNoFun() {
//		return needGroupWhenNoFun;
//	}
//
//	public void setNeedGroupWhenNoFun(boolean needGroupWhenNoFun) {
//		this.needGroupWhenNoFun = needGroupWhenNoFun;
//	}

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
		String col;
		int index = -1;
		for (int i = 0; i < columns.length; i++) {
			col = columns[i].trim();
			if (col != null) {
				col = col.toLowerCase();
				index = col.indexOf(" as ");
				if (index > 0) {
					col = col.substring(index + 4);
				} else { // fixed bug V3.0.0.8, process use alias but no as.
					index = col.indexOf(" ");
					if (index > 0)
						col = col.substring(index + 1).trim();
				}

				columnIndexMap.put(col, i);
				// 不带表名的也存一份
				int dotIndex = col.indexOf('.');
				if (dotIndex > 0) {
					columnIndexMap.put(col.substring(dotIndex + 1), i);
				}
			}
		}
	}

	public Map<String, Integer> getColumnIndexMap() {
		return this.columnIndexMap;
	}

	public Integer getIndexByColumn(String column) {
		return getColumnIndexMap().get(column);
	}

//	public void setColumnIndexMap(Map<String, Integer> columnIndexMap) {
//		this.columnIndexMap = columnIndexMap;
//	}

	public List<String> getOrginalSelectColumn() {
		return orginalSelectColumn;
	}

	public void appendOrginalSelectColumn(List<String> orginalSelectColumnList) {
		if (orginalSelectColumnList != null)
			this.orginalSelectColumn.addAll(orginalSelectColumnList);
	}

	public void addFirstOrginalSelectColumn(String orginalSelectColumn) {
		if (orginalSelectColumn == null) return;

		String columns[] = orginalSelectColumn.split(",");
		String col;
		int index = -1;
//		for (int i = 0; i < columns.length; i++) {
		for (int i = columns.length - 1; i >= 0; i--) {
			col = columns[i].trim();
			if (col != null) {
				col = col.toLowerCase();
				index = col.indexOf(" as ");
				if (index > 0) {
					col = col.substring(index + 4);
				} else { // fixed bug V3.0.0.8, process use alias but no as.
					index = col.indexOf(" ");
					if (index > 0)
						col = col.substring(index + 1).trim();
				}
//				columnIndexMap.put(col, i);
//				this.orginalSelectColumn.add(col);
				this.orginalSelectColumn.addFirst(col);
			}
		}
	}
	
	public Set<String> getAddedGroupByColumn() {
		return addedGroupByColumn;
	}

	public void appendAddedGroupByColumn(String addedGroupByColumn) {
		this.addedGroupByColumn.add(addedGroupByColumn);
	}

	public String getMainTableForGroupField() {
		return mainTableForGroupField;
	}

	public void setMainTableForGroupField(String mainTableForGroupField) {
		this.mainTableForGroupField = mainTableForGroupField;
	}

}
