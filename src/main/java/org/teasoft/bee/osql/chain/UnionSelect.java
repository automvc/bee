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
 * UnionSelect interface for standard SQL with chain programming.
 * union or union all for Select or String/String[] type parameters.
 * @author Kingstar
 * @since  1.3
 */
public interface UnionSelect extends ToSql {

	/**
	 * union two Select type subSelect.
	 * @param subSelect1 the first Select type parameter
	 * @param subSelect2 the second Select type parameter
	 * @return
	 */
	public UnionSelect union(Select subSelect1, Select subSelect2);

	/**
	 * union two subSelect string.
	 * @param subSelect1 the first sub select string
	 * @param subSelect2 the second sub select string
	 * @return
	 */
	public UnionSelect union(String subSelect1, String subSelect2);

	/**
	 * union all two Select type subSelect.
	 * @param subSelect1 the first Select type parameter
	 * @param subSelect2 the second Select type parameter
	 * @return
	 */
	public UnionSelect unionAll(Select subSelect1, Select subSelect2);

	/**
	 * union all two subSelect string.
	 * @param subSelect1 the first sub select string
	 * @param subSelect2 the second sub select string
	 * @return
	 */
	public UnionSelect unionAll(String subSelect1, String subSelect2);

	/**
	 * create UnionSelect via sql string array.
	 * The Bee framework do not transfer parameter value to placeholder.
	 * @param subSelects  sql string array
	 * @return UnionSelect
	 * @since 2.4.0
	 */
	public UnionSelect union(String[] subSelects);

	/**
	 * create UnionSelect via sql string array.
	 * The Bee framework do not transfer parameter value to placeholder.
	 * @param subSelects  sql string array
	 * @return UnionSelect
	 */
	public UnionSelect unionAll(String[] subSelects);

}
