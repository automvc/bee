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
