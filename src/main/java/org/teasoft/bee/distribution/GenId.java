/*
 * Copyright 2013-2020 the original author.All rights reserved.
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

package org.teasoft.bee.distribution;

/**
 * 
 * Generate global unique id number in distributed environment.
 * GUID : Global Unique ID.
 * 
<p> ---------------------------------------------
<p> org.teasoft.honey.distribution.PearFlowerId

<p> ---------------------------------------------
<p> org.teasoft.honey.distribution.SerialUniqueId
 * Serial Unique Id in one workerid.
 * Advantages:continuous and unique;less clock dependent.Implemented in dB, it can achieve auto increment 
 * of distributed global unique ID in dB. The ID number get in the same workerid can satisfy continuous
 * monotonic increasing uniqueness.
 * Shortcoming:worker1's ID<worker2's ID...<worker1023's ID.
 
<p> ---------------------------------------------
<p> org.teasoft.honey.distribution.OneTimeSnowflakeId

 * @author Kingstar
 * @since  1.7.2
 */
public interface GenId {
	
	/**
	 * return the id number.
	 * @return long id number.
	 */
	public long get();
	
	/**
	 * Get a segment of numbers at a time and return the minimum and maximum available numbers of a batch.
	 * <br>eg: [100000,101000],array[0]=100000,array[1]=101000.
	 * <br>In some algorithms, such as:PearFlowerId,OneTimeSnowflakeId,
	 * <br> 1) The parameter sizeOfIds should not be greater than 8192.
	 * <br> 2) In order to make array[0]=min,array[1]=max in the range of series, it is possible to waste id number;
	 * <br>    if you don't want to, you can loop call the get() method or use SerialUniqueId algorithm.
	 * <br> The SerialUniqueId algorithm does not have the above two problems.
	 * @param sizeOfIds the size Of ids in one batch.
	 * @return return the array of long. array[0]=min,array[1]=max.
	 */
	public long[] getRangeId(int sizeOfIds);

}
