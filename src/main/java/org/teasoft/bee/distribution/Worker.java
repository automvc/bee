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

package org.teasoft.bee.distribution;

/**
 * 用于唯一标识在一个运行的ID生成程序.uniquely identify the ID generator running in an application.
 * @author Kingstar
 * @since  1.7.2
 */
public interface Worker {
	
	/**
	 * 获取唯一标识ID生成程序的ID编号.get long number of unique worker ID.
	 * @return long number of unique worker ID.
	 */
	long getWorkerId();

}
