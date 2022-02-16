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

package org.teasoft.bee.osql;

/**
 * SQL关键字.SQL KeyWord.
 * @author Kingstar
 * @since  1.8.99
 */
public interface SqlKeyWord {
	
	String select();
	String as();
	String from();
	String where();
	
	String insert();
	String replace();
	String into();
	String values();
	String and();
	String or();
	String Null();
	String isNull();
	String isNotNull();
	
	String update();
	String set();
	String delete();
	
	String orderBy();
	String count();
	String asc();
	
	String on();
	String forUpdate();
	String limit();
	String offset();
	String top();
	
	String groupBy();
	String having();
	String between();
	String notBetween();
	
	String space(); 

	String distinct();
	String join();
	String innerJoin();
	String leftJoin();
	String rightJoin();
	String in();
	String notIn();
	String exists();
	String notExists();
}
