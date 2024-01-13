/*
 * Copyright 2020-2024 the original author.All rights reserved.
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

package org.teasoft.bee.osql.chain;

import org.teasoft.bee.osql.Op;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public interface Where<T> {
	
		/**
		 * add "("
		 * @return T
		 */
		public T lParentheses();
		
		/**
		 * add ")"
		 * @return T
		 */
		public T rParentheses();
		
		public T op(String field, String value);

		public T op(String field, Number value);
		
		/**
		 * add a expression formatter as : field operator value, 
		 * eg:op("field1",Op.ge,11) -->  field1 >= 11
		 * @param field
		 * @param op Op
		 * @param value support String,Number, and if the Op is In/NotIn, can use Number Array,String,Set,List.
		 * @return T
		 */
		public T op(String field, Op op, Object value);
		
		public T opWithField(String field1, Op op, String field2);

		/**
		 * Default will automatically add and.  
		 * @return T
		 */
		public T and();

		public T or();
		
		public T not();
		
		public T where();

		public T where(String expression) ;
		
		public T between(String field, Number low, Number high);
		public T notBetween(String field, Number low, Number high);

		public T isNull(String field);
		public T isNotNull(String field);

		public T in(String field, Number... valueList);
		public T notIn(String field, Number... valueList);
		
		public T in(String field, String valueList);
		public T notIn(String field, String valueList);
		
}
