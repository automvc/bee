/*
 * Copyright (c) 2017,2018, Kingstar Corporation.All rights reserved.
 * 版本所有  金星科技
 */
package org.bee.osql;

/**
 * Object to SQL string for Suid (select,update,insert,delete)
 * entity must not be null
 * 根据entity对象转换成DB能识别的sql语句(包括:select,update,insert,delete)
 * entity 参数不能为null.
 * @author KingStar
 * @since  1.0
 */
public interface ObjToSQL{
	
	public  <T> String toSelectSQL(T entity) ;
	public  <T> String toDeleteSQL(T entity) ;
	public  <T> String toInsertSQL(T entity) ;
	public  <T> String toUpdateSQL(T entity) throws ObjSQLException;

}
