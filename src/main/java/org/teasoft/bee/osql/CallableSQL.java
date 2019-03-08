/*
 * Copyright 2013-2018 the original author.All rights reserved.
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

import java.sql.CallableStatement;
import java.util.List;

/**
 * @author Kingstar
 * @since  1.0
 */
public interface CallableSQL {
	
	/**
	 * 
	 * @param callSql procedure sql
	 * @param entity
	 * @param preValues 只支持in类型的参数
	 * @return
	 */
	public <T> List<T> select(String callSql,T entity,Object preValues[]);
	
	/**
	 * 
	 * @param callSql procedure sql
	 * @param preValues 只支持in类型的参数
	 * @return
	 */
	public List<String[]> select(String callSql,Object preValues[]);
	
	/**
	 * 
	 * @param callSql procedure sql
	 * @param preValues 只支持in类型的参数
	 * @return
	 * @since  1.1
	 */
	public String selectJson(String callSql,Object preValues[]);
	
	
//	int executeUpdate()
	/**
	 * 
	 * @param callSql procedure sql
	 * @param preValues 只支持in类型的参数
	 * @return
	 */
	public int modify(String callSql,Object preValues[]);

	/**
	 * 返回CallableStatement对象以便可以设置in,out,inout参数.可方便调用JDBC底层的方法
	 * @param callSql procedure sql
	 * @return
	 */
	public CallableStatement getCallableStatement(String callSql);
	
	/**
	 * 对于有out或inout类型的参数,可设计参数后,再调用该方法.
	 * @param cstmt
	 * @return
	 */
	public int modify(CallableStatement cstmt);
	
}
