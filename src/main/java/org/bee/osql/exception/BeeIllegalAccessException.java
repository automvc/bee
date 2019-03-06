/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.bee.osql.exception;

import org.bee.osql.BeeException;

/**
 * @author Kingstar
 * @since  1.4
 */
public class BeeIllegalAccessException extends BeeException {
	
	static final long serialVersionUID = -875516993124222230L;


	public BeeIllegalAccessException() {
		super();
	}

	public BeeIllegalAccessException(String message) {
		super(message);
	}

	public BeeIllegalAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeeIllegalAccessException(Throwable cause) {
		super(cause);
	}

}
