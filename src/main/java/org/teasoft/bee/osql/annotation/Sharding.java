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

package org.teasoft.bee.osql.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.teasoft.bee.osql.annotation.customizable.DsTabHandler;

/**
 * Sharding.
 * <br>Specify different tables in the same database after calculation; Specify different databases after calculation.
 * <br>When there are multiple tables, cross table is not supported.
 * <br>The dataSource of the sub table is consistent with the main table.
 * <br>Order: 1->2
 * <br>1. Special (if special is configured, others will not be detected)
 * <br>2. Calculate by algorithm (default if there is no match)
 * @author AiTeaSoft
 * @since  2.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sharding {
	
	/**
	 * appoint dataSource
	 * @return  appointed dataSource 
	 */
	String appointDS() default "";
	
	/**
	 * appoint table name
	 * @return appointed table name
	 */
	String appointTab() default "";
	
	/**
	 * 0: operations that can be calculated directly such as remainder; 1: Take part of the string such as date; 2: Custom
	 * @return value of dsAlgorithm
	 */
    int dsAlgorithm() default 0; 
    
    /**
     * 0: operations that can be calculated directly such as remainder; 1: Take part of the string such as date; 2: Custom
     * @return value of tabAlgorithm
     */
    int tabAlgorithm() default 0; 
	
    /**
     * If dsRule is not set, that is, the default empty value is used, it means that is not to consider the database name.
	 * <br>eg: "id%dsSize
     * @return value of dsRule
     */
	String dsRule() default "";
	
	/**
	 * If dsRule is empty and the value of dsName is not set, the database name is not required.
	 * <br>By default, the value calculated by dsRule() will be automatically used as the suffix of dsName.
	 * @return dsName
	 */
	String dsName() default "";
	
	/**
	 * get tabRule
	 * @return tabRule
	 */
	String tabRule() default "";
	/**
	 * get tabName.
	 * <br>The default is the value calculated by tabRule() as the suffix of tabName.
	 * <br>eg:tab${tabRule}
	 * @return tabName
	 */
	String tabName() default "";
	
	/**
	 * use for define DsTabHandler.
	 * @return class of DsTabHandler type
	 */
	Class<? extends DsTabHandler> handler() default DsTabHandler.class;

}
