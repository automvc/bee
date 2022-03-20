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

	/**
	 * get dataSource algorithm
	 * @return dataSource algorithm
	 */
	public int getDsAlgorithm() {
		return dsAlgorithm;
	}

	/**
	 * set dataSource algorithm
	 * @param dsAlgorithm dataSource algorithm
	 */
	public void setDsAlgorithm(int dsAlgorithm) {
		this.dsAlgorithm = dsAlgorithm;
	}

	/**
	 * get dataSource rule
	 * @return dataSource rule
	 */
	public String getDsRule() {
		return dsRule;
	}

	/**
	 * set dataSource rule
	 * @param dsRule dataSource rule
	 */
	public void setDsRule(String dsRule) {
		this.dsRule = dsRule;
	}

	/**
	 * get dataSource name
	 * @return dataSource name
	 */
	public String getDsName() {
		return dsName;
	}

	/**
	 * set dataSource name
	 * @param dsName
	 */
	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	/**
	 * get table algorithm
	 * @return table algorithm
	 */
	public int getTabAlgorithm() {
		return tabAlgorithm;
	}

	/**
	 * set table algorithm
	 * @param tabAlgorithm table algorithm
	 */
	public void setTabAlgorithm(int tabAlgorithm) {
		this.tabAlgorithm = tabAlgorithm;
	}

	/**
	 * get table rule
	 * @return table rule
	 */
	public String getTabRule() {
		return tabRule;
	}

	/**
	 * set table rule
	 * @param tabRule table rule
	 */
	public void setTabRule(String tabRule) {
		this.tabRule = tabRule;
	}

	/**
	 * get table name
	 * @return table name
	 */
	public String getTabName() {
		return tabName;
	}

	/**
	 * set table name
	 * @param tabName
	 */
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	/**
	 * get sharding value
	 * @return sharding value
	 */
	public Object getShardingValue() {
		return shardingValue;
	}

	/**
	 * set sharding value
	 * @param shardingValue sharding value
	 */
	public void setShardingValue(Object shardingValue) {
		this.shardingValue = shardingValue;
	}

}
