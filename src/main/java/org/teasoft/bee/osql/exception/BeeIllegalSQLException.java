/*
 * Copyright 2016-2021 the original author.All rights reserved.
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
 
package org.teasoft.bee.osql.exception;

import org.teasoft.bee.osql.BeeException;

/**
 * 非法的Bee SQL异常.Bee Illegal SQLException
 * @author Kingstar
 * @since  1.9.8
 */
public class BeeIllegalSQLException extends BeeException {

	static final long serialVersionUID = -875516993124222232L;

	public BeeIllegalSQLException() {
		super();
	}

	public BeeIllegalSQLException(String message) {
		super(message);
	}

	public BeeIllegalSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeeIllegalSQLException(Throwable cause) {
		super(cause);
	}

}
