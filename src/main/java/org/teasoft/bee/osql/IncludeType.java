package org.teasoft.bee.osql;

/**
 * 包含类型:关于Null和空字符的.Include type about Null and empty string.
 * @author Kingstar
 * @since  1.0
 */
public enum IncludeType {

	// -1  for both exclude 留用
	/**
	 * exclude: NULL and ""
	 */
	EXCLUDE_BOTH(-1),  //v1.9
	
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
	 * exclude:  NULL , "" and "  "
	 */
	EXCLUDE_THREE(-3); 

	private final int value;

	private IncludeType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
