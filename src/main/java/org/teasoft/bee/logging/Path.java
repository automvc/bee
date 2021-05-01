/*
 * Copyright 2013-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.teasoft.bee.logging;

/**
 * 设置日志文件的路径与文件名.set the log file path(include file name).
 * @author Kingstar
 * @since  1.7.2
 */
public class Path {
	
	private static String fullPath="";
	
	private Path() {}
	
	public static String getFullPath(){
		return fullPath;
	}
	
	public static void setFullPath(String fullPath) {
		Path.fullPath = fullPath;
	}

}
