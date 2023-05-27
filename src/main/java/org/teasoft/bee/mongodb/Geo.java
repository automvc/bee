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

package org.teasoft.bee.mongodb;

import java.util.List;

import org.teasoft.bee.osql.api.Condition;

/**
 * Interface for Mongodb Geo.
 * @author Kingstar
 * @since  2.1
 */
public interface Geo {

	public <T> List<T> geoWithinPolygon(T entity,String fieldName, final List<List<Double>> points,Condition condition);
	
	public <T> List<T> near(T entity,NearPara nearPara,Condition condition);
	public <T> List<T> nearSphere(T entity,NearPara nearPara,Condition condition);
	public <T> List<T> geoWithinCenter(T entity,CenterPara centerPara,Condition condition);
	public <T> List<T> geoWithinCenterSphere(T entity,CenterPara centerPara,Condition condition);
	public <T> List<T> geoWithinBox(T entity,BoxPara boxPara,Condition condition);
	
}
