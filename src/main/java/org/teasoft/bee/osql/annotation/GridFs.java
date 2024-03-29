/*
 * Copyright 2020-2023 the original author.All rights reserved.
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
 * Store the file for Mongodb and register the file id to the field which define in fileIdName.
 * The filename from the field which define in fileName.
 * The file type is InputStream;
 * Just support INSERT type, SELECT(since 2.1.8) type.
 * @author Kingstar
 * @since  2.1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GridFs {

	/**
	 * Used for Mongodb declaration. After saving the file to the database, 
	 * the file ID will be saved to the field of the fileIdName declaration (default: fileid)
	 * @return fileId name
	 */
	String fileIdName() default "fileid";

    /**
     * The field name corresponding to the file name
     * @return file name
     */
	String fileName() default "filename";
}
