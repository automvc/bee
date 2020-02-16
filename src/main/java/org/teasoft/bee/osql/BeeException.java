/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

/**
 * Bee的异常父类.Bee's super exception class.
 * @author Kingstar
 * @since  1.4
 */
public class BeeException extends RuntimeException{
	
	static final long serialVersionUID = -875516993124222221L;
	
	public BeeException() {
		super();
	}

	public BeeException(String message) {
		super(message);
	}

	public BeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeeException(Throwable cause) {
		super(cause);
	}

	protected BeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
