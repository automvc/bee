/*
 * Copyright 2016-2020 the original author.All rights reserved.
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

package org.teasoft.bee.osql;

import java.util.Set;

/**
 * Assistant of Condition.
 * @author Kingstar
 * @since  1.6
 */
public interface ConditionAssistant {
	
	/**
	 * If the field use in Condition,it would not be processed again in default.
	 * @return Returns fields collection for where condition expression.
	 */
	public Set<String> getWhereFields();
	
	void setSuidType(SuidType suidType);
	 
	 /**
	  * 
	  * @return  return IncludeType
	  * @since  1.7
	  */
	 public IncludeType getIncludeType();
	 
	 /**
	  * return the fields use in method of setAdd and setMultiply.
	  * @return set of fields
	  * @since 1.7.2
	  */
	 public Set<String> getUpdatefields();
	 
	 public String getSelectField();
	 
	 public Boolean getForUpdate();
}
