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
 * Transaction isolation level.
 * @author Kingstar
 * @since  1.0
 */
public enum TransactionIsolationLevel
{
    /**
     * A constant indicating that transactions are not supported.
     */
	TRANSACTION_NONE(0), 
	/**
	 * 指示可以发生:脏读 (dirty read)、不可重复读和虚读 (phantom read) 的常量<br>
	 * A constant indicating that dirty reads, non-repeatable reads and phantom reads can occur.
     * This level allows a row changed by one transaction to be read
     * by another transaction before any changes in that row have been
     * committed (a "dirty read").  If any of the changes are rolled back,
     * the second transaction will have retrieved an invalid row.
	 */
    TRANSACTION_READ_UNCOMMITTED(1), 
    
    /**
     * A constant indicating that dirty reads are prevented; 
     * <br>non-repeatable reads and phantom reads can occur.
     * <br>This level only prohibits a transaction
     * <br>from reading a row with uncommitted changes in it.
     */
    TRANSACTION_READ_COMMITTED(2), 

    /**
     * A constant indicating that dirty reads and non-repeatable reads are prevented; phantom reads can occur.  
     * This level prohibits a transaction from
     * reading a row with uncommitted changes in it, and it also
     * prohibits the situation where one transaction reads a row,
     * a second transaction alters the row, and the first transaction
     * rereads the row, getting different values the second time
     * (a "non-repeatable read").
     */
    TRANSACTION_REPEATABLE_READ(4), 
    
    /**
     * A constant indicating that dirty reads, non-repeatable reads and phantom reads are prevented.
     * This level includes the prohibitions in
     * <code>TRANSACTION_REPEATABLE_READ</code> and further prohibits the
     * situation where one transaction reads all rows that satisfy
     * a <code>WHERE</code> condition, a second transaction inserts a row that
     * satisfies that <code>WHERE</code> condition, and the first transaction
     * rereads for the same condition, retrieving the additional
     * "phantom" row in the second read.
     */
    TRANSACTION_SERIALIZABLE(8);

	private final int level;

	private TransactionIsolationLevel(int level) {
		this.level = level;
	}

	/**
	 * get the value of TransactionIsolationLevel.
	 * @return value of TransactionIsolationLevel.
	 */
	public int getLevel() {
		return this.level;
	}
}

