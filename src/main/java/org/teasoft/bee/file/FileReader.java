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

import java.io.BufferedReader;

/**
 * 用来读取字符文件的便捷类.Easy class of Read file by fullPathAndName.
 * @author Kingstar
 * @since  1.7.2
 */
public interface FileReader {
	/**
	 * 根据路径读取文件.read the file by fullPathAndName.
	 * @param fullPathAndName 全部路径,包括文件名
	 */
	public BufferedReader readFile(String fullPathAndName);
}
