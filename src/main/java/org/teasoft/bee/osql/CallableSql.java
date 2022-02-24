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
 * 存储过程方式Sql操作DB的接口.Procedure sql operate the DB.
 * @author Kingstar
 * @since  1.0
 */
public interface CallableSql {
	
	/**
	 * 使用存储过程查询数据.
	 * @param callSql procedure sql
	 * @param returnType
	 * @param preValues parameter,just support In type; 只支持in类型的参数
	 * @return 可包含多个实体(多条记录)的list. list which contains more than one entity.
	 */
	public <T> List<T> select(String callSql,T returnType,Object preValues[]);
	
	/**
	 * 使用存储过程查询数据.
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @param preValues parameter,just support In type; 只支持in类型的参数
	 * @return 可包含多个String数组结构的多条记录的list. list can contain more than one record with String array struct.
	 */
	public List<String[]> select(String callSql,Object preValues[]);
	
	/**
	 * 使用存储过程查询数据并返回Json.
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @param preValues parameter,just support In type; 只支持in类型的参数
	 * @return 可包含多个实体(多条记录)的list转换成的json格式的字符串. Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public String selectJson(String callSql,Object preValues[]);
	
	
	/**
	 * 使用存储过程修改数据.
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @param preValues parameter,just support In type; 只支持in类型的参数
	 * @return 成功操作的记录行数. the number of affected successfully records.
	 */
	public int modify(String callSql,Object preValues[]);

	/**
	 * 返回CallableStatement对象以便可以设置in,out,inout参数.可方便调用JDBC底层的方法
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @return CallableStatement.
	 */
	public CallableStatement getCallableStatement(String callSql);
	
	/**
	 * 对于有out或inout类型的参数,可设置参数后,再调用该方法.
	 * @param cstmt
	 * @return 成功操作的记录行数. the number of affected successfully records.
	 */
	public int modify(CallableStatement cstmt);
	
}
