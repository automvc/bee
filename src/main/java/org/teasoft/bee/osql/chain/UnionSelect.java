/*
 * Copyright 2013-2019 the original author.All rights reserved.
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
 * UnionSelect接口,用于链式风格写SQL语句.UnionSelect interface for SQL with chain programming.
 * @author Kingstar
 * @since  1.3
 */
public interface UnionSelect extends ToSql{
	
	public UnionSelect union(Select subSelect1,Select subSelect2);
	
	public UnionSelect union(String subSelect1,String subSelect2);
	
	public UnionSelect unionAll(Select subSelect1,Select subSelect2);
	
	public UnionSelect unionAll(String subSelect1,String subSelect2);
}
