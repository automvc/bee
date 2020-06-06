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
 * 分布式环境下生成数字id.Generate id number in distributed environment.
 * 
<p>改进的雪花算法——姑且称为梨花算法吧  （忽如一夜春风来，千树万树梨花开）。
<p>改进目标：解决雪花算法的时钟回拨问题；部分避免机器id重复时，号码冲突问题。

<p>long型的64位分成以下几个部分组成：
<p>符号位：1位
<p>时间：31位   （精确到秒）够用68年
<p>段号(批次号)：3位    每秒可分为8个段
<p>机器号：10位   最多支持1024台机器
<p>序列号：19位    可表示:0--524287

<p>注：根据情况，机器号可以调整到最后部分。
<p>每个机器,每秒可生成4.19w个id(4194304).

<p>   经过调整，时间只对秒灵敏，成功回避了服务器间几百毫秒的时间误差引起的时间回拨问题；若第59秒的8个段号没有用完，
<p>则当润秒来临时，还可继续使用。另外具体实现上，可设置一定的秒数（如3秒）内提前消费。比如第10秒的号码，在800毫
<p>秒用完了，可以继续使用第11秒的号码。这样，下1秒用的号码不是很多时，就可以借给上1秒使用。
<p>   以上的方案是与时间强相关的。若某一段时间内的号码没用使用，也会浪费掉。当在分布式DB的表主键这种应用场景时，
<p>   只需要全局id不重复，且是递增的。类似这种场景，可以设计成时间不相关的。
<p>   供分布式DB表主键等类似场景使用,不浪费号码的方案。long型的64位分配还是一样。只不过，取号时，是取上一个号码加1，
<p>而不用管现在的时间是什么时候。当突然down机时，重启又获取当前的时间，重新开始分派号码；这时之前节省下的号码就被浪
<p>费掉了。为解决这个问题，可以在一段时间或分派一定数量的号（如10000），就将当前分派的号码记录到日志，或同步到DB表，
<p>等重启时，可以设置初始值。实现上，还是要控制分派的速度，若每秒几百万的号不够用，可用表名分隔命名空间，每个表单独取
<p>自己的号；即使号码够用，也可以这样做，因为这样得到的号在同一张表里就比较连续，而不只是递增而矣。当各个机器分派的id
<p>速度相差太大时，各机器得到的id大小就比较乱；这种问题，可以设置负载均衡，让每台机器轮流出号。

<p>   机器id重复的问题。当两台机器的id一样时，分派的号就会重复。若0-7八个段号（段号3位），每次都是从0-3随机获取一个
<p>开始的段号，比方说获取到2，那重复机器id的服务要是获取到0或1的段号就可以避免号码重复的冲突。当然了，这都是基于每秒用
<p>不完号码的情况下的。可以循环使用段号，如获取到3，那就从3-7,0,1,2这样使用段号，后面0，1，2这几个段号要是分派出去，
<p>号码就不递增了。具体怎么用，还是要根据自己的情况做取舍。


<p> ---------------------------------------------
<p> org.teasoft.honey.distribution.SerialUniqueId
<p> 在一个workid内连续唯一的ID.Serial Unique Id in one workid.
<p> 优点:连续唯一;不强依赖时钟. 在DB内实现,可达到分布式全局唯一ID在DB内自增长.
<p> Advantages:continuous and unique;less clock dependent.Implemented in dB, it can achieve auto increment of distributed global unique ID in dB.
<p> 缺点/Shortcoming:worker1's ID<worker2's ID...<worker1023's ID.

 * 
 * @author Kingstar
 * @since  1.7.2
 */
public interface GenId {
	
	/**
	 * @return 返回id号码
	 */
	public long get();
	
	/**
	 * 一次获取一段号码,返回一个批次可用号码的最大值和最小值,eg: [100000,101000].return the min and max long in this batch.eg: [100000,101000]
	 * @param sizeOfIds 返回的一批id的数量.the size Of ids in one batch.
	 * @return return the array of long. array[0]=min,array[1]=max.
	 */
	public long[] getRangeId(int sizeOfIds);

}
