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

/**
 * @author Kingstar
 * @since  2.1
 */
public class BoxPara {

	private String geoFieldName;
	private double lowerLeftX;
	private double lowerLeftY;
	private double upperRightX;
	private double upperRightY;

	public BoxPara() {}
	
	public BoxPara(String geoFieldName, double lowerLeftX, double lowerLeftY,
			double upperRightX, double upperRightY) {
		
		this.geoFieldName = geoFieldName;
		this.lowerLeftX = lowerLeftX;
		this.lowerLeftY = lowerLeftY;
		this.upperRightX = upperRightX;
		this.upperRightY = upperRightY;
	}

	public String getGeoFieldName() {
		return geoFieldName;
	}

	public void setGeoFieldName(String geoFieldName) {
		this.geoFieldName = geoFieldName;
	}

	public double getLowerLeftX() {
		return lowerLeftX;
	}

	public void setLowerLeftX(double lowerLeftX) {
		this.lowerLeftX = lowerLeftX;
	}

	public double getLowerLeftY() {
		return lowerLeftY;
	}

	public void setLowerLeftY(double lowerLeftY) {
		this.lowerLeftY = lowerLeftY;
	}

	public double getUpperRightX() {
		return upperRightX;
	}

	public void setUpperRightX(double upperRightX) {
		this.upperRightX = upperRightX;
	}

	public double getUpperRightY() {
		return upperRightY;
	}

	public void setUpperRightY(double upperRightY) {
		this.upperRightY = upperRightY;
	}

}
