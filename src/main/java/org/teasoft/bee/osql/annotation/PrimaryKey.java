/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注某个属性为主键<br>
 * 不允许定义一个字段名为id,但却不将它定义为主键.<br>
 * 当主键的字段名不是id时,可用PrimaryKey注解标注为主键.<br>
 * 当字段有Ignore注解时,PrimaryKey注解也会被忽略.<br>
 * 此注解是为兼容旧系统而存在,<br>
 * 强烈建议,新系统定义表时设置一个id列为主键
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {
	
}
