/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.sharding;

/**
 * Struct for SQL function in Sharding.
 * @author Kingstar
 * @since  2.0
 */
public class FunStruct {

	private String fieldName;
	private String functionType;
	
	public FunStruct() {}
	
	public FunStruct(String fieldName, String functionType) {
		super();
		this.fieldName = fieldName;
		this.functionType = functionType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFunctionType() {
		return functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

}
