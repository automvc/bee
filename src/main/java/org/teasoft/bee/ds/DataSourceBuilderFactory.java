/*
 * Copyright 2016-2023 the original author.All rights reserved.
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

package org.teasoft.bee.ds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.teasoft.bee.osql.Registry;

/**
 * DataSource Builder Factory.
 * @author Kingstar
 * @since  2.1
 */
public class DataSourceBuilderFactory implements Registry {
	
//	private static volatile Map<String, DataSourceBuilder> map = null; //sonar
	private static Map<String, DataSourceBuilder> map = null;
//	private static byte[] lock=new byte[0];

	private DataSourceBuilderFactory() {}

	public static void register(String dataSourceToolType, DataSourceBuilder builder) {
		if (map == null) initMap();
		map.put(dataSourceToolType.toLowerCase(), builder);
	}
	
	private synchronized static void initMap() {
		map = new ConcurrentHashMap<>();
	}
	
//	public static void register(String dataSourceToolType, DataSourceBuilder builder) {
//		if (map == null) {  //find Bugs
//			synchronized (lock) {
//				map = new ConcurrentHashMap<>();
//			}
//		}
//		map.put(dataSourceToolType.toLowerCase(), builder);
//	}

	public static DataSourceBuilder getDataSourceBuilder(String dataSourceToolType) {
		return map == null ? null : map.get(dataSourceToolType.toLowerCase());
	}

}

//find Bugs
//Bug: Incorrect lazy initialization of static field org.teasoft.bee.ds.DataSourceBuilderFactory.map in org.teasoft.bee.ds.DataSourceBuilderFactory.register(String, DataSourceBuilder)
//This method contains an unsynchronized lazy initialization of a non-volatile static field. Because the compiler or processor may reorder instructions, threads are not guaranteed to see a completely initialized object, if the method can be called by multiple threads. You can make the field volatile to correct the problem. For more information, see the Java Memory Model web site. 

//sonar
//This can be salvaged with arrays by using the relevant AtomicArray class, such as AtomicIntegerArray, instead. For mutable objects, the volatile should be removed, and some other method should be used to ensure thread-safety, such as synchronization, or ThreadLocal storage.