/*
 * Copyright 2016-2021 the original author.All rights reserved.
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

/**
 * 用于MapSuid的对应SQL功能的MapSql关键字.MapSql keyword for the corresponding SQL function of MapSuid.
 * @author Kingstar
 * @since  1.9
 */
public enum MapSqlKey {
	
    /**
     * 声明需要操作的表.Declare the table to be operated on.
     */
	Table("Table"),
	
	/**
	 * 在MapSuid的方法insertAndReturnId(MapSql mapSql),当主键名称不是id时使用.
	 * @since 1.11
	 */
	PrimaryKey("PrimaryKey"),
	
	/**
	 * 声明需要查询的字段,多个用逗号隔开.Declare the select fields,if more than one,separate with comma.
	 */
    SelectColumns("SelectColumns"),
    
    /**
     * 对应SQL的group by.It corresponds to the group by of SQL.
     */
    GroupBy("GroupBy"),
    
    /**
     * 对应SQL的having.It corresponds to the having of SQL.
     */
    Having("Having"),
    
    /**
     * 对应SQL的order by.It corresponds to the order by of SQL.
     */
    OrderBy("OrderBy")
    
//	,
//  Start("Start"),
//	Size("Size"),
    ;
	
    String name;
    
    MapSqlKey(String name){
    	this.name = name;  
    }
    
    public String getName(){
    	return name;
    }

}
