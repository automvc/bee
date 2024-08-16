/*
 * Copyright 2020-2022 the original author.All rights reserved.
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

import java.util.Map;

import org.teasoft.bee.sharding.algorithm.Calculate;

/**
 * Bean for Sharding.
 * @author AiTeaSoft
 * @since 2.0
 */
public class ShardingBean extends ShardingSimpleStruct {

	private String dsField;
	private String tabField;

	private Class<? extends Calculate> dsAlgorithmClass = Calculate.class;
	private Class<? extends Calculate> tabAlgorithmClass = Calculate.class;
	private String fullNodes;

	private int tabAssignType; // 0: order; 1: polling

	public ShardingBean() {}

	/**
	 * create ShardingBean instance by fullNodes.
	 * @param fullNodes
	 */
	public ShardingBean(String fullNodes) {
		super();
		this.fullNodes = fullNodes;
	}

	/**
	 * create ShardingBean instance by fullNodes and tabField.
	 * @param fullNodes
	 * @param tabField
	 */
	public ShardingBean(String fullNodes, String tabField) {
		super();
		this.fullNodes = fullNodes;
		this.tabField = tabField;
	}

	/**
	 * create ShardingBean instance by fullNodes, tabField and dsField.
	 * @param fullNodes
	 * @param tabField
	 * @param dsField
	 */
	public ShardingBean(String fullNodes, String tabField, String dsField) {
		super();
		this.fullNodes = fullNodes;
		this.tabField = tabField;
		this.dsField = dsField;
	}

	public ShardingBean(ShardingSimpleStruct shardingSimpleStruct) {
		super.setDsAlgorithm(shardingSimpleStruct.getDsAlgorithm());
		super.setDsName(shardingSimpleStruct.getDsName());
		super.setDsRule(shardingSimpleStruct.getDsRule());
		super.setDsShardingValue(shardingSimpleStruct.getDsShardingValue());
		super.setTabAlgorithm(shardingSimpleStruct.getTabAlgorithm());
		super.setTabName(shardingSimpleStruct.getTabName());
		super.setTabRule(shardingSimpleStruct.getTabRule());
		super.setTabShardingValue(shardingSimpleStruct.getTabShardingValue());
	}

	/**
	 * get dataSource field.
	 * @return dataSource field.
	 */
	public String getDsField() {
		return dsField;
	}

	/**
	 * set dataSource field.
	 * @param dsField
	 */
	public void setDsField(String dsField) {
		this.dsField = dsField;
	}

	/**
	 * get table field.
	 * @return table field.
	 */
	public String getTabField() {
		return tabField;
	}

	/**
	 * set table field.
	 * @param tabField
	 */
	public void setTabField(String tabField) {
		this.tabField = tabField;
	}

	public Class<? extends Calculate> getDsAlgorithmClass() {
		return dsAlgorithmClass;
	}

	/**
	 * 
	 * @param dsAlgorithmClass
	 */
	public void setDsAlgorithmClass(Class<? extends Calculate> dsAlgorithmClass) {
		this.dsAlgorithmClass = dsAlgorithmClass;
	}

	public Class<? extends Calculate> getTabAlgorithmClass() {
		return tabAlgorithmClass;
	}

	/**
	 * 
	 * @param tabAlgorithmClass
	 */
	public void setTabAlgorithmClass(Class<? extends Calculate> tabAlgorithmClass) {
		this.tabAlgorithmClass = tabAlgorithmClass;
	}

	/**
	 * get full nodes string.
	 * @return full nodes string.
	 */
	public String getFullNodes() {
		return fullNodes;
	}

	/**
	 * set full nodes string.
	 * @param fullNodes
	 */
	public void setFullNodes(String fullNodes) {
		this.fullNodes = fullNodes;
	}

	/**
	 * 0: order; 1: polling
	 * @return tabAssignType
	 */
	public int getTabAssignType() {
		return tabAssignType;
	}

	/**
	 * 0: order; 1: polling
	 * @param tabAssignType
	 */
	public void setTabAssignType(int tabAssignType) {
		this.tabAssignType = tabAssignType;
	}

	/**
	 * create ShardingBean by map
	 * @param map include ShardingBean field value
	 * @since 2.4.0
	 */
	public ShardingBean(Map<String, String> map) {
		super();
		if (map == null || map.size() == 0) return;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if ("fullNodes".equals(entry.getKey()))
				setFullNodes(entry.getValue());
			else if ("dsField".equals(entry.getKey()))
				setDsField(entry.getValue());
			else if ("tabField".equals(entry.getKey()))
				setTabField(entry.getValue());
			else if ("tabAssignType".equals(entry.getKey()))
				setTabAssignType(Integer.parseInt(entry.getValue()));
			else if ("dsAlgorithm".equals(entry.getKey()))
				setDsAlgorithm(Integer.parseInt(entry.getValue()));
			else if ("tabAlgorithm".equals(entry.getKey()))
				setTabAlgorithm(Integer.parseInt(entry.getValue()));
			else if ("dsRule".equals(entry.getKey()))
				setDsRule(entry.getValue());
			else if ("dsName".equals(entry.getKey()))
				setDsName(entry.getValue());
			else if ("tabRule".equals(entry.getKey()))
				setTabRule(entry.getValue());
			else if ("dsShardingValue".equals(entry.getKey()))
				setDsShardingValue(entry.getValue());
			else if ("tabShardingValue".equals(entry.getKey()))
				setTabShardingValue(entry.getValue());

//			dsAlgorithmClass or tabAlgorithmClass,pls use Java style
		}

	}
}
