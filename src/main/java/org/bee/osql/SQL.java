/*
 * Copyright (c) 2017,2018, Kingstar Corporation.All rights reserved.
 * 版本所有  金星科技
 */
package org.bee.osql;

import java.util.List;

/**
 * 直接用sql语句操作数据库的接口
 * 在该接口中的sql字符串要是DB能识别的SQL语句
 * @author KingStar
 * Create on 2013-6-30 下午10:05:36
 * @since  1.0
 */
public interface SQL {
	
	public <T> List<T> select(String sql,T entity );
	
	public <T> List<T> selectSomeField(String sql,T entity );  //调用者:public <T> List<T> select(T entity, String selectField)
	
	public String selectFun(String sql) throws ObjSQLException;

	/**
	 * @param sql
	 * @return
	 * eg:
	 * select property1,property2 from beanName;
	 * return list element as: property1[#Bee#]property2 
	 */
	public List<String[]> select(String sql);    //PreparedSqlLib 有调用
	
	public String selectJson(String sql);
	
	/**
	 * 操作update,insert,delete.对应jdbc的executeUpdate方法
	 * @param sql
	 * @return the number of successful records 返回成功操作的记录行数
	 */
	public int modify(String sql);
	
	public int[] batch(String sql[]);
	public int[] batch(String []insertSql,int batchSize);
}
