/*
 * Copyright 2013-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql;

/**
 * @author Kingstar
 * @since  1.4
 */
public enum SuidType {
	
	SELECT("SELECT"),UPDATE("UPDATE"),INSERT("INSERT"),DELETE("DELETE"),
	MODIFY("MODIFY"); //UPDATE,INSERT,DELETE
	
	private String type;
	
	SuidType(String type){
		this.type=type;
	}

	public String getType() {
		return type;
	}

}
