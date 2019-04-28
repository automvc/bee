/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.exception;

import org.teasoft.bee.osql.ObjSQLException;

/**
 * @author Kingstar
 * @since  1.4
 */
public class BeeErrorFieldException extends ObjSQLException {
	static final long serialVersionUID = -875516993124222235L;


	public BeeErrorFieldException() {
		super();
	}

	public BeeErrorFieldException(String message) {
		super(message);
	}

	public BeeErrorFieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeeErrorFieldException(Throwable cause) {
		super(cause);
	}
}
