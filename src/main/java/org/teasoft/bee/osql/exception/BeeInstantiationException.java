/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.exception;

import org.teasoft.bee.osql.BeeException;

/**
 * @author Kingstar
 * @since  1.4
 */
public class BeeInstantiationException extends BeeException {
	
	static final long serialVersionUID = -875516993124222231L;


	public BeeInstantiationException() {
		super();
	}

	public BeeInstantiationException(String message) {
		super(message);
	}

	public BeeInstantiationException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeeInstantiationException(Throwable cause) {
		super(cause);
	}
}
