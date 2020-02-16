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

/**
 * Bee的SQL异常父类.Bee's SQL super exception class.
 * @author Kingstar
 * @since  1.4
 */
public class BeeSQLException extends BeeException {
	static final long serialVersionUID = -875516993124222222L;

	private String SQLState;
	private int vendorCode;

	public BeeSQLException() {
		super();
	}

	public BeeSQLException(String message) {
		super(message);
	}

	public BeeSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeeSQLException(Throwable cause) {
		super(cause);
	}

	protected BeeSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
    public BeeSQLException(String reason,String sqlState, int vendorCode, Throwable cause) {
        super(reason,cause);
        this.SQLState = sqlState;
        this.vendorCode = vendorCode;
    }
    
    /**
     * Retrieves the SQLState for this <code>BeeSQLException</code> object.
     *
     * @return the SQLState value
     */
    public String getSQLState() {
        return (SQLState);
    }

    /**
     * Retrieves the vendor-specific exception code
     * for this <code>BeeSQLException</code> object.
     *
     * @return the vendor's error code
     */
    public int getErrorCode() {
        return (vendorCode);
    }
}
