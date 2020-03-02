/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.logging;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class Path {
	
	private static String fullPath="";
	
	public static String getFullPath(){
		return fullPath;
	}
	
	public static void setFullPath(String fullPath) {
		Path.fullPath = fullPath;
	}

}
