package org.bee.osql;

/**
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
