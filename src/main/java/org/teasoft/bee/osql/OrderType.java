package org.teasoft.bee.osql;

/**
 * SQL's Order type(asc,desc).
 * @author Kingstar
 * @since  1.0
 */
public enum OrderType {

	/**
	 * Corresponding to ASC of SQL
	 */
	ASC("asc"),

	/**
	 * Corresponding to desc of SQL
	 */
	DESC("desc");

	String name;

	OrderType(String name) {
		this.name = name;
	}

	/**
	 * return type of order.
	 * @return type of order.
	 */
	public String getName() {
		return name;
	}

}
