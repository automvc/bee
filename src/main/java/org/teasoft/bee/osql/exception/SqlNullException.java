/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.exception;

import org.teasoft.bee.osql.BeeException;

/**
 * @author Kingstar
 * @since  1.6
 */
public class SqlNullException extends BeeException {
	
	static final long serialVersionUID = -875516993124221124L;


	public SqlNullException() {
		super();
	}

	public SqlNullException(String message) {
		super(message);
	}

	public SqlNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public SqlNullException(Throwable cause) {
		super(cause);
	}
}

