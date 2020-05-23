/*
 * Copyright 2013-2019 the original author.All rights reserved.
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
 * 表名与实体名,列名与字段名互转.table name<-->entity name, coloumn name<-->field name.
 * @author Kingstar
 * @since  1.5
 */
public interface NameTranslate {

	/**
	 * 将Java实体名转成DB表名.Entity name to table name.
	 * @param entityName
	 * @return table name.
	 */
	public String toTableName(String entityName);
	
	
	/**
	 * 将Java实体类的字段名转成DB表的列名.Field name to column name.
	 * @param fieldName field name in Java entity. Java里实体类的字段名
	 * @return column name.
	 */
	public String toColumnName(String fieldName);
	

	/**
	 * 将DB表名转成Java实体名.Table name to entity name.
	 * @param tableName
	 * @return entity name(Javabean name).
	 */
	public String toEntityName(String tableName);
	
	
	/**
	 * 将DB表的列名转成Java里实体类的字段名.Column name to field name.
	 * @param columnName DB table's column name. DB表的列名
	 * @return Javabean's field name.
	 */
	public String toFieldName(String columnName);
}
