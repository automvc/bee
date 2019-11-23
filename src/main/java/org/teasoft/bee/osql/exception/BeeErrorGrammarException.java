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
public class BeeErrorGrammarException extends BeeException {
	
	static final long serialVersionUID = -875516993124221123L;


	public BeeErrorGrammarException() {
		super();
	}

	public BeeErrorGrammarException(String message) {
		super(message);
	}

	public BeeErrorGrammarException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeeErrorGrammarException(Throwable cause) {
		super(cause);
	}

}
