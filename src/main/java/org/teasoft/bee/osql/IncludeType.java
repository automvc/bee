package org.teasoft.bee.osql;

/**
 * 包含类型:关于Null和空字符的.Include type about Null and empty string.
 * @author Kingstar
 * @since  1.0
 */
public enum IncludeType {

	// -1  for exclude 留用
	INCLUDE_NULL(0), 
	INCLUDE_EMPTY(1), // ""
	INCLUDE_BOTH(2); // NULL and ""

	private final int value;

	private IncludeType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
