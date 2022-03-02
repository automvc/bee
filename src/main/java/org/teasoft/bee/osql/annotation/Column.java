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
 * 面向对象方式Suid,SuidRich,MoreTable会检测.
 * 根据Javabean生成创建sql命令(Ddl)会检测.
 * PreparedSql中实体作为返回类型(returnType),不对实体检测Column注解.
 * MapSuid不会检测.
 * JustFetch注解的字段，不应该再用Column注解。
 * 
 * 注意: 具体实现,需要用户自动开发(实现ColumnHandler接口,
 * 并使用NameTranslateHandle.setColumnHandler(columnHandler)设置).
 * 官方不推荐使用Column注解.
 * 
 * 不使用Column注解的好处:
 * 约定优于配置,可使用自动命名转换,规则简单.
 * 可以用Bee框架自动生成表对应的Javabean.
 * 表结构有更改,维护方便,再自动生成一次即可.
 * 保留适当冗余,像创建时间,创建人等字段无需移到父类,<br>
 * 表与Javabean对应即可,无需过多人工干预.可以节省更多时间关注商业逻辑.
 * 处理速度更加快.
 * 方案:
 * 1)Suid,SuidRich,MoreTable会自动解析sql;
 * 2)MoreTable还可以处理不同表有重名字段,不同DB分页语法不同等情况.
 * 3)自定义sql, 使用as取别名(select column_name as java_field_name),<br>
 * 可以将查询结果自动解析到给出的Javabean结构.
 * 4)忽略字段可使用@Ignore
 * 5)使用JustFetch注解
 * @JustFetch("CONCAT(fisrt_name,last_name)") 
 * private String fullname;
 * -->select CONCAT(fisrt_name,last_name) as fullname
 * 
 *  @JustFetch("name")
 * 	private String name2;
 * -->select name as name2	
 * 
 * 若要使用@Column,可开启openDefineColumn配置,并实现相关功能.
 * 
 * @author Kingstar
 * @since  1.11
 */
@Deprecated
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	String value();
}
