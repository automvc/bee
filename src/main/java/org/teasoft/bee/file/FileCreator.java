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
 * 文件创建接口.File creator interface.
 * @author Kingstar
 * @since  1.7.1
 */
public interface FileCreator extends FileReader{
	/**
	 * 将内容写到生成的文件中
	 * @param fullPathAndName 全部路径,包括文件名
	 * @param content 文件内容.content
	 */
	public  void genFile(String fullPathAndName, String content);
	
	/**
	 * 将内容写到生成的文件中
	 * @param fullPath 全部路径.full path
	 * @param fileName 文件名.file name
	 * @param content  文件内容.content
	 */
	public  void genFile(String fullPath, String fileName, String content);
	
	/**
	 * 将内容写到生成的文件中
	 * @param basePath 基础路径. base path
	 * @param packagePath 包路径.package path
	 * @param fileName 文件名.file name
	 * @param content  文件内容.content
	 */
	public  void genFile(String basePath,String packagePath, String fileName, String content);
	
	
	/**
	 * 将内容追加到文件尾部
	 * @param fullPathAndName 全部路径,包括文件名
	 * @param content 文件内容.content of file.
	 * @since  1.7.2
	 */
	public void genAppendFile(String fullPathAndName, String content);
	
	/**
	 * set charsetName
	 * @param charsetName
	 * @since 1.8.9
	 */
	public void setCharsetName(String charsetName);
	
}
