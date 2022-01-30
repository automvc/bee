/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.interccept;

import java.util.List;

/**
 * @author Kingstar
 * @since  1.11
 */
public interface Interceptor {

	public Object beforePasreEntity(Object entity); 

	//在有多个数据源时,指定某个数据源的名称才有效.
	public void setDataSourceOneTime(String ds);

	public String getOneTimeDataSource();

	public String afterCompleteSql(String sql);

	public void afterAccessDB(List list);
	
	public void afterAccessDB();

}
