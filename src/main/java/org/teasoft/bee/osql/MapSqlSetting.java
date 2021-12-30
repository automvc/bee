/*
 * Copyright 2016-2021 the original author.All rights reserved.
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
 * 用于MapSuid的MapSql配置信息.MapSql configuration information for MapSuid.
 * @author Kingstar
 * @since  1.9
 */
public enum MapSqlSetting {
	
    /**
     * 是否命名转换.Is naming transfer. value is 'true' or 'false',default is 'false'
     * 真时,会根据配置的规则(可在bee.properties配置)进行转换;假时不转换.
     * if true, will transfer by the rule (eg: bee.properties). if false,do not transfer.
     */
    IsNamingTransfer("IsNamingTransfer") ,
    
    /**
     * include Null.value is 'true' or 'false',default is 'false'
     */
    IsIncludeNull("IsIncludeNull"),
    
    /**
     * include empty string.value is 'true' or 'false',default is 'false'
     */
    IsIncludeEmptyString("IsIncludeEmptyString")
    ;
	
    String name;
    
    MapSqlSetting(String name){
    	this.name = name;  
    }
    
    public String getName(){
    	return name;
    }

}
