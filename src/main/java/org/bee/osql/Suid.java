/*
 * Copyright (c) 2017,2018, Kingstar Corporation.All rights reserved.
 * 版本所有  金星科技
 */
package org.bee.osql;

import java.util.List;

/**
 * Database operation: Suid (select,update,insert,delete)
 * Don't process the null and empty string by default.
 * 数据库操作接口,包括查,改,增,删 Suid (select,update,insert,delete)
 * 默认不处理null和空字符串
 * @author KingStar
 * Create on 2013-6-30 下午10:03:15
 * @since  1.0
 *
 */
public interface Suid {
	
	/**
	 * 根据实体对象entity查询数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * @return 返回的list可包含多个实体(多条记录)
	 */
	public <T> List<T> select(T entity);
	
	/**
	 * 根据实体对象entity更新数据
	 * @param entity 与表对应的实体对象,且不能为空;entity中id属性不能为空,作为过虑条件
	 * entity中非null与非空字符串将更新到数据库(id除外)
	 * 另查看 SuidRich.update(T entity,String updateFieldList)
	 * @return 更新的记录数
	 */
	public <T> int update(T entity);
	
	
	/**
	 * 根据实体对象entity插入数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串将插入到数据库
	 * @return 成功插入的记录数
	 */
	public <T> int insert(T entity);
	
	/**
	 * 根据实体对象entity删除数据
	 * @param entity 与表对应的实体对象,且不能为空
	 * entity中非null与非空字符串作为过虑条件,操作符是等号.eg:field=value
	 * @return 成功删除的记录数
	 */
	public <T> int delete(T entity);
	
}
