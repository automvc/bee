package org.teasoft.bee.osql;

/**
 * Include type about Null and empty string.
 * @author Kingstar
 * @since  1.0
 */
public enum IncludeType {

	/**
	 * include: NULL
	 */
	INCLUDE_NULL(0),
	/**
	 * include: ""
	 */
	INCLUDE_EMPTY(1),

	/**
	 * include: NULL and ""
	 */
	INCLUDE_BOTH(2),

	
	/**
	 * exclude: NULL and ""
	 */
	EXCLUDE_BOTH(-1), // v1.9
	
	/**
	 * exclude:  NULL , "" and "  "
	 */
	EXCLUDE_BLANK(-3),
	
	/**
	 * exclude:  NULL , "" and "  "
	 * replace with EXCLUDE_BLANK
	 */
	@Deprecated
	EXCLUDE_THREE(-3);

	private final int value;

	private IncludeType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
