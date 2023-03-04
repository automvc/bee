/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * store the file for Mongodb and register the file id to the field which define in fileIdName.
 * @author Kingstar
 * @since  2.1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GridFs {
	
	//用于Mongodb声明, 保存文件到数据库后,会将文件id保存到fileIdName声明的字段(默认是:fileid).
	String fileIdName() default "fileid";
}
