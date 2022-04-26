/*
 * Copyright 2020-2022 the original author.All rights reserved.
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

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Table column names and Javabean field names mapping annotation,
 * To use @column, open the openDefineColumn configuration and realize the mapping function.
<p><br>
<p>Where will detect this annotation:
<p>Object oriented way: Suid,SuidRich,MoreTable will detect.
<p>The create SQL command (Ddl.java) generated according to the Javabean will detect.
<p>Where will not detect this annotation:
<p>Entities in PreparedSql are used as return types, and column annotations are not detected for entities.
<p>Mapsuid will not detect
<p>JustFetch annotated fields should not be annotated with Column.
<p><br>
<p>Notice: the mapping implementation needs to be developed by the user(implement the ColumnHandler interface,
<p>and use NameTranslateHandle.setColumnHandler(columnHandler) to set).
<p>The use of Column annotation is not officially recommended base the bellow reason.
<p><br>
<p><b>Benefits of not using Column annotation:</b>
<p>Convention-over-configuration, automatic naming mapping can be used, and the rules are simple.
<p>You can use the Bee framework to automatically generate the Javabean corresponding to the table.
<p>The table structure is changed and easy to maintain. It can be automatically generated again.
<p>Keep appropriate redundancy. Fields such as creation time and creator do not need to be moved to the parent class, <br>
<p>the table can correspond to the Javabean without too much manual intervention. It can save more time to focus on business logic.
<p>The processing speed is faster.
<p> <br>
<p> <b>Solution:</b>
<p> 1)Suid,SuidRich,MoreTable will parse entity to sql automatically;
<p> 2)Moretable can also handle the situation that different tables have duplicate name fields and different DB paging syntax.
<p> 3)Custom SQL, alias with "as"(select column_name as java_field_name),<br>
<p> The query results can be automatically parsed to the given Javabean structure.
<p> 4)Ignore field can use @Ignore 
<p> 5)Using JustFetch annotation
<p> @&nbsp;JustFetch("CONCAT(fisrt_name,last_name)") 
<p> private String fullname;
<p> -->select CONCAT(fisrt_name,last_name) as fullname
<p>  @&nbsp;JustFetch("name")
<p> 	private String name2;
<p> -->select name as name2	

 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	@Deprecated
	String value();
}
