/*
 * Copyright 2013-2024 the original author.All rights reserved.
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
package org.teasoft.bee.osql.chain;

/**
 * Update interface for standard SQL with chain programming.
 * @author Kingstar
 * @since  1.3
 * @since  2.4.0
 */
public interface Update extends Where<Update>, ToSql {

	public Update update(String table);

	public Update set(String field, String value);

	public Update set(String field, Number value);

	public Update setAdd(String field, Number num);

	public Update setMultiply(String field, Number num);

	public Update setAdd(String field, String otherFieldName);

	public Update setMultiply(String field, String otherFieldName);

	public Update setWithField(String field1, String field2);

	public Update setNull(String fieldName);

}
