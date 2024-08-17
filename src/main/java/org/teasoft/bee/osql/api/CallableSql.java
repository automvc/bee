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

package org.teasoft.bee.osql.api;

import java.sql.CallableStatement;
import java.util.List;

/**
 * Procedure sql operate the DB.
 * CallableSql do not support DB Sharding.
 * CallableSql have not BeeSql router system.
 * @author Kingstar
 * @since  1.0
 * some methods support Interceptor.
 * @since  2.4.0
 */
public interface CallableSql {

	/**
	 * Use Procedure to query data.
	 * @param callSql procedure sql
	 * @param returnType entity Type,just for return type.
	 * @param preValues parameter,just support In type.
	 * @return list which contains more than one entity.
	 */
	public <T> List<T> select(String callSql, T returnType, Object preValues[]);

	/**
	 * Use Procedure to query data.
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @param preValues parameter,just support In type.
	 * @return list can contain more than one record with String array struct.
	 */
	public List<String[]> select(String callSql, Object preValues[]);

	/**
	 * Use Procedure to query data and return Json string.
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @param preValues parameter,just support In type.
	 * @return Json string, it transform from list which can contain more than one entity.
	 * @since  1.1
	 */
	public String selectJson(String callSql, Object preValues[]);

	/**
	 * Use Procedure to query data.
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @param preValues parameter,just support In type.
	 * @return the number of affected successfully records.
	 */
	public int modify(String callSql, Object preValues[]);

	/**
	 * Returns the instance of CallableStatement so that the in, out, inout parameters can be set.
	 * <br>It is convenient to call the underlying methods of JDBC
	 * @param callSql procedure sql,eg: procedure_name(?)
	 * @return CallableStatement.
	 */
	public CallableStatement getCallableStatement(String callSql);

	/**
	 * For parameters with out or inout type, the method can be called after setting the parameters.
	 * @param cstmt instance of CallableStatement 
	 * @return the number of affected successfully records.
	 */
	public int modify(CallableStatement cstmt);

}
