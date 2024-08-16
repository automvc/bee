/*
 * Copyright 2020-2024 the original author.All rights reserved.
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

/**
 * can use TO_DATE in : 
 * <br>Condition op(String field, Op op, Object value) 
 * <br>for Oracle.
 * <br>eg:condition.op("mydatetime", Op.ge, new TO_DATE("2024-07-08", "YYYY-MM-DD"));
 * <br>->  
 * <br>where mydatetime>=TO_DATE('2024-07-08', 'YYYY-MM-DD') ;
 * <br>In general, this interface is only used for Oracle.
 * @author Kingstar
 * @since  2.4.0
 */
public class TO_DATE {

	private String datetimeValue;
	private String formatter;

	public TO_DATE() {}

	public TO_DATE(String datetimeValue, String formatter) {
		this.datetimeValue = datetimeValue;
		this.formatter = formatter;
	}

	public String getDatetimeValue() {
		return datetimeValue;
	}

	public void setDatetimeValue(String datetimeValue) {
		this.datetimeValue = datetimeValue;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

}
