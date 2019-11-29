/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

import java.util.Set;

/**
 * Condition的辅助接口.Assistant of Condition.
 * @author Kingstar
 * @since  1.6
 */
public interface ConditionAssistant {
	
	public Set<String> getFieldSet();
	
	 void setSuidType(SuidType SuidType);
}
