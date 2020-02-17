/*
 * Copyright 2013-2018 the original author.All rights reserved.
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

package org.teasoft.bee.osql.transaction;

/**
 * 事务隔离级别.Transaction isolation level.
 * @author Kingstar
 * @since  1.0
 */
public enum TransactionIsolationLevel
{
    TRANSACTION_NONE(0), 
    TRANSACTION_READ_UNCOMMITTED(1), 
    TRANSACTION_READ_COMMITTED(2), 

    TRANSACTION_REPEATABLE_READ(4), 
    TRANSACTION_SERIALIZABLE(8);

	private final int level;

	private TransactionIsolationLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}

