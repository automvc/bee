package org.teasoft.bee.osql;

/**
 * Bee的面向对象SQL异常父类.Bee's Object SQL super exception class.
 * @author Kingstar
 * @since  1.0
 */
public class ObjSQLException extends BeeException {
	static final long serialVersionUID = -875516993124211111L;

	public ObjSQLException() {
		super();
	}

	public ObjSQLException(String message) {
		super(message);
	}

	public ObjSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjSQLException(Throwable cause) {
		super(cause);
	}

	protected ObjSQLException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
