package org.teasoft.bee.osql;

/**
 * 面向对象SQL非法SQL字段串异常.Object SQL illegal SQL string exception.
 * @author Kingstar
 * @since  1.0
 */
public class ObjSQLIllegalSQLStringException extends BeeException {
	static final long serialVersionUID = -875516993124211122L;
	public ObjSQLIllegalSQLStringException() {
		super();
	}

	public ObjSQLIllegalSQLStringException(String message) {
		super(message);
	}

	public ObjSQLIllegalSQLStringException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjSQLIllegalSQLStringException(Throwable cause) {
		super(cause);
	}

	protected ObjSQLIllegalSQLStringException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
