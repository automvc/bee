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

package org.bee.osql;

import java.sql.CallableStatement;
import java.util.List;

/**
 * @author KingStar
 * @since  1.0
 */
public interface CallableSQL {
	
	public <T> List<T> select(String sql,T entity,Object preValues[]);
	
	public List<String> select(String sql,Object preValues[]);
	
	public String selectJson(String sql,Object preValues[]);
//	int executeUpdate()
	public int modify(String sql,Object preValues[]);

	/**
	 * 返回CallableStatement对象以便可以设置in,out,inout参数
	 * @param callSql procedure sql
	 * @return
	 */
	public CallableStatement getCallableStatement(String callSql);
	
	public int modify(CallableStatement cstmt);
	public <T> List<T> select(CallableStatement cstmt, T entity);
	public String selectJson(CallableStatement cstmt);

}
