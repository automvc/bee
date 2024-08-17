/*
 * Copyright 2022-2024 the original author.All rights reserved.
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

package org.teasoft.bee.osql;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class ResultAssemblerRegistry implements Registry {

	private static final Map<Class<?>, ResultAssembler<?>> assemblerMap = new HashMap<>();

	public static <T> void register(Class<T> c, ResultAssembler<T> assembler) {
		assemblerMap.put(c, assembler);

	}

	@SuppressWarnings("unchecked")
	public static <T> ResultAssembler<T> getResultAssembler(Class<T> c) {
		return (ResultAssembler<T>) assemblerMap.get(c);
	}

}
