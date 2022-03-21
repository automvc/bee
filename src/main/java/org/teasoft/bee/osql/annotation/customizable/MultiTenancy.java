/*
 * Copyright 2016-2022 the original author.All rights reserved.
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

package org.teasoft.bee.osql.annotation.customizable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 多租户.
 * 计算后指定同一库不同表;计算后指定不同库
 * 多表时,不支持跨表.从表的DS与主表一致.
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiTenancy {
	
//Order: 1->2
//	1.特指 (配置了特指的,其它不再检测)
//	2.通过算法计算(若没有匹配的则用默认)
	
	String appointDS() default "";
	
	String appointTab() default "";
	
	/**
	 * 0:求余等能直接计算的运算, 1:自定义,  2:范围???  3:日期等取部分字符串??
	 * @return dsAlgorithm
	 */
    int dsAlgorithm() default 0; 
    int tabAlgorithm() default 0; 
    
	
	/**
	 * dsRule不设置,即使用默认的空值,则表示,不用管库名
	 * eg: "id%dsSize
	 */
	String dsRule() default "";
	
	/**
	 * dsRule为空,也没设置dsName的值,则不需要带库名
	 * 默认是dsRule()计算得的值自动作为dsName的后缀.
	 * @return dsName
	 */
	String dsName() default "";
	
	/**
	 * get tabRule
	 * @return tabRule
	 */
	String tabRule() default "";
	/**
	 * 默认是tabRule()计算得的值作为tabName的后缀.
	 * eg:tab${tabRule}
	 * @return tabName
	 */
	String tabName() default "";
	
	/**
	 * 要以定义处理器
	 * @return class of DsTabHandler type
	 */
	Class<? extends DsTabHandler> handler() default DsTabHandler.class;

}
