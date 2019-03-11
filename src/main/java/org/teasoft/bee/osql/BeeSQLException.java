/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

/**
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
