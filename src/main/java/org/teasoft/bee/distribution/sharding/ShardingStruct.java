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
 * ShardingStruct
 * @author Kingstar
 * @since  1.11
 */
public class ShardingStruct {

	private int dsAlgorithm;
	private String dsRule;
	private String dsName;
	private int tabAlgorithm;
	private String tabRule;
	private String tabName;

	private Object shardingValue;
	
	//还需设置所有库表的

	public int getDsAlgorithm() {
		return dsAlgorithm;
	}

	public void setDsAlgorithm(int dsAlgorithm) {
		this.dsAlgorithm = dsAlgorithm;
	}

	public String getDsRule() {
		return dsRule;
	}

	public void setDsRule(String dsRule) {
		this.dsRule = dsRule;
	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public int getTabAlgorithm() {
		return tabAlgorithm;
	}

	public void setTabAlgorithm(int tabAlgorithm) {
		this.tabAlgorithm = tabAlgorithm;
	}

	public String getTabRule() {
		return tabRule;
	}

	public void setTabRule(String tabRule) {
		this.tabRule = tabRule;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public Object getShardingValue() {
		return shardingValue;
	}

	public void setShardingValue(Object shardingValue) {
		this.shardingValue = shardingValue;
	}

}
