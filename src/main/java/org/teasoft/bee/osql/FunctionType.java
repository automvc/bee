package org.teasoft.bee.osql;

/**
 * Function type of SQL.
 * @author Kingstar
 * @since  1.0
 */
public enum FunctionType {

	MAX("max"), MIN("min"), SUM("sum"), AVG("avg"), COUNT("count");

	String name;

	FunctionType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
