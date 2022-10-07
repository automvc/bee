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

import org.teasoft.bee.sharding.algorithm.Calculate;

/**
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

	public ShardingBean(String fullNodes, String tabField) {
		super();
		this.tabField = tabField;
		this.fullNodes = fullNodes;
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

	public String getDsField() {
		return dsField;
	}

	public void setDsField(String dsField) {
		this.dsField = dsField;
	}

	public String getTabField() {
		return tabField;
	}

	public void setTabField(String tabField) {
		this.tabField = tabField;
	}

	public Class<? extends Calculate> getDsAlgorithmClass() {
		return dsAlgorithmClass;
	}

	public void setDsAlgorithmClass(Class<? extends Calculate> dsAlgorithmClass) {
		this.dsAlgorithmClass = dsAlgorithmClass;
	}

	public Class<? extends Calculate> getTabAlgorithmClass() {
		return tabAlgorithmClass;
	}

	public void setTabAlgorithmClass(Class<? extends Calculate> tabAlgorithmClass) {
		this.tabAlgorithmClass = tabAlgorithmClass;
	}

	public String getFullNodes() {
		return fullNodes;
	}

	public void setFullNodes(String fullNodes) {
		this.fullNodes = fullNodes;
	}

	public int getTabAssignType() {
		return tabAssignType;
	}

	public void setTabAssignType(int tabAssignType) {
		this.tabAssignType = tabAssignType;
	}
}
