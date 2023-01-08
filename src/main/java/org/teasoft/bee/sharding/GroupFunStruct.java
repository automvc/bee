/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.sharding;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kingstar
 * @since  2.0
 */
public class GroupFunStruct {
	
	private List<String> groupFields;
//	private FunStruct funStructs[];
	private List<FunStruct> funStructs;
	
	private boolean needGroupWhenNoFun;
	
	//有avg的才需要以下属性  　或 String[]
	private boolean hasAvg;
	private String columnNames;
	
	private Map<String,Integer> columnIndexMap=new LinkedHashMap<>();
	

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
		
		String columns[]=columnNames.split(",");
		String t;
		int index;
		for (int i = 0; i < columns.length; i++) {
			t=columns[i].trim();
			t=t.toLowerCase();
			index=t.indexOf(" as ");
			if(index>0) t=t.substring(index+4);
			System.out.println(t);
			columnIndexMap.put(t, i);
		}
	}
	
	public Map<String, Integer> getColumnIndexMap() {
//		System.out.println(this.columnIndexMap);
		return this.columnIndexMap;
	}

	public Integer getIndexByColumn(String column) {
//		System.out.println(column);
		return getColumnIndexMap().get(column);
	}

}
