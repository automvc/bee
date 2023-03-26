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

import org.teasoft.bee.osql.exception.BeeIllegalBusinessException;

/**
 * @author Kingstar
 * @since  2.1
 */
public class NearPara {

	private String geoFieldName;
	private double x;
	private double y;
	private Double maxDistance;
	private Double minDistance;

	public NearPara() {}

	public NearPara(String geoFieldName, double x, double y, Double maxDistance,
			Double minDistance){
		
		this.geoFieldName = geoFieldName;
		this.x = x;
		this.y = y;
		this.maxDistance = maxDistance;
		this.minDistance = minDistance;
		
		if (maxDistance < minDistance) throw new BeeIllegalBusinessException("The maximum value must not be less than the minimum value!");
	}

	public String getGeoFieldName() {
		return geoFieldName;
	}

	public void setGeoFieldName(String geoFieldName) {
		this.geoFieldName = geoFieldName;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Double getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(Double maxDistance) {
		this.maxDistance = maxDistance;
	}

	public Double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(Double minDistance) {
		this.minDistance = minDistance;
	}

}
