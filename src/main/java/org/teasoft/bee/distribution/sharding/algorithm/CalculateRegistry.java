/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.distribution.sharding.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.teasoft.bee.osql.Registry;

/**
 * Calculate Registry
 * @author Kingstar
 * @since  1.11
 */
public class CalculateRegistry implements Registry {

	private static final Map<String, Calculate> calculateMap = new HashMap<>();
	
	private CalculateRegistry() {}

	/**
	 * register Calculate.
	 * @param type number type
	 * @param calculate instance of Calculate type
	 */
	public static void register(int type, Calculate calculate) {
		calculateMap.put(type + "", calculate);
	}

	/**
	 * get Calculate.
	 * @param type number type
	 * @return instance of Calculate type
	 */
	public static Calculate getCalculate(int type) {
		return calculateMap.get(type + "");
	}

}
