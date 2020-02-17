/*
 * Copyright 2016-2020 the original author.All rights reserved.
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

/**
 * SQL连接类型.SQL join type.
 * @author Kingstar
 * @since  1.7
 */
public enum JoinType {
	JOIN(" join "),  //inner join
	LEFT_JOIN(" left join "),RIGHT_JOIN(" right join "),FULL_JOIN(" full join ");
	
    String type;
    
    JoinType(String type){
    	this.type = type;  
    }
    
    public String getType(){
    	return type;
    }
}
