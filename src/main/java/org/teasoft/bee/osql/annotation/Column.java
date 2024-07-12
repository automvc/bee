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
 * Table column names and Javabean field names mapping annotation.
 * 
 * Before 2.0, to use @column, open the openDefineColumn configuration and realize the mapping function.
 * Since 2.1, it will be open by default. If not used, in order to improve efficiency, it can be manually configured to be closed.
 * <p><br>
 * <p>Where will detect this annotation:
 * <p>Object oriented way: Suid,SuidRich,MoreTable will detect.
 * <p>The create SQL command (Ddl.java) generated according to the Javabean will detect.
 * <p>Where will not detect this annotation:
 * <p>Entities in PreparedSql are used as return types, and column annotations are not detected for entities.
 * <p>Mapsuid will not detect
 * <p>JustFetch annotated fields should not be annotated with Column.
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	String value();
}
