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

package org.teasoft.bee.file;

/**
 * File creator interface.
 * @author Kingstar
 * @since  1.7.1
 */
public interface FileCreator extends FileReader{
	/**
	 * Write content to generated file.
	 * @param fullPathAndName All paths, including file names
	 * @param content file of content
	 */
	public  void genFile(String fullPathAndName, String content);
	
	/**
	 * Write content to generated file.
	 * @param fullPath full path
	 * @param fileName file name
	 * @param content  file of content
	 */
	public  void genFile(String fullPath, String fileName, String content);
	
	/**
	 * Write content to generated file.
	 * @param basePath base path
	 * @param packagePath package path
	 * @param fileName file name
	 * @param content  file of content
	 */
	public  void genFile(String basePath,String packagePath, String fileName, String content);
	
	
	/**
	 * Append content to the end of the file.
	 * @param fullPathAndName All paths, including file names
	 * @param content file of content
	 * @since  1.7.2
	 */
	public void genAppendFile(String fullPathAndName, String content);
	
	/**
	 * set charsetName
	 * @param charsetName charset name
	 * @since 1.8.9
	 */
	public void setCharsetName(String charsetName);
	
}
