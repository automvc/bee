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

package org.teasoft.bee.osql.transaction;

/**
 * 事务接口.Transaction interface.
 * @author Kingstar
 * @since  1.0
 */
public interface Transaction {
	
	public void begin();
	public void commit();
	public void rollback();
	
	public void setReadOnly(boolean readOnly);
	public void setTransactionIsolation(TransactionIsolationLevel transactionIsolationLevel);

	public boolean isReadOnly();
	public int getTransactionIsolation();
	
	public void setTimeout(int seconds);
}
