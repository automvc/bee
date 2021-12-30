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
 * 分布式环境下生成全局唯一数字id.Generate global unique id number in distributed environment.
 * GUID : Global Unique ID.
 * 
 * 分段模式与雪花到底有什么区别？
 * 一个是依赖DB,一个是依赖时间的.
 * 一个是取的号码可以一直连续递增的；一个是趋势递增，会因workerid的原因产生的ID号是会跳很大一段的.
 * 依赖于DB的号段模式，当多个节点一起拿号时，最终落库的ID还是不能连续的。
 * 雪花ID适合做分布式数据库表主键吗？它只保证递增，没保证连续。
 * 
 * 改进目标:
 * 能不能找到一种，既不依赖DB，也不依赖时间的ID生成算法呢？答案是，肯定有的，这是我们努力的方向!
 * 
<p> ---------------------------------------------
<p> org.teasoft.honey.distribution.PearFlowerId
<p>改进的雪花算法——姑且称为梨花算法(PearFlowerId)吧  （忽如一夜春风来，千树万树梨花开）。
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
 * 在一个workerid内连续唯一的ID生成方法(绝对连续单调递增，全局唯一).Serial Unique Id in one workerid.
 * 优点:连续唯一;不依赖时钟. 在DB内实现,可达到分布式全局唯一ID在DB内自增长;在同一个workerid内,获取的ID号,可以满足连续单调递增唯一.
 * Advantages:continuous and unique;less clock dependent.Implemented in dB, it can achieve auto increment 
 * of distributed global unique ID in dB. The ID number get in the same workerid can satisfy continuous
 * monotonic increasing uniqueness.
 * 缺点/Shortcoming:worker1's ID<worker2's ID...<worker1023's ID.
 * 
 * SerialUniqueId:绝对连续单调递增，全局唯一.
 * 分布式环境下生成连续单调递增(在一个workerid内),且全局唯一数字id.
 * 连续单调递增ID生成算法SerialUniqueId：不依赖于时间，也不依赖于任何第三方组件，只是启动时，用一个时间作为第一个ID设置的种子，
 * 设置了初值ID后，就可获取并递增ID。在一台DB内与传统的一样，连续单调递增（而不只是趋势递增），而代表DB的workerid作为DB的区别放在高位，
 * 从所有DB节点看，则满足分布式DB生成全局唯一ID。本地（C8 I7 16g）1981ms可生成1亿个ID号,利用上批获取，分隔业务，每秒生成过亿ID号
 * 不成问题。可用作分布式DB内置生成64位long型ID自增主键。只要按本算法设置了记录的ID初值，然后默认让数据库表id主键自增就可以（如MYSQL）。
 * 绝对连续单调递增，全局唯一的方案(可用于DB表主键)，如下：
 * 只能是在新增一个库时，就分配一个库的workerid. 然后在初始化表时，设置初始ID开始用的值，以后由DB自动增长。Workerid的分配可统一放在一个
 * 配置文件，由工具检测到某个表是空表，且使用的主键对应的是Java的long型时，设置初始ID开始用的值。
 * 
 * 考虑到2019年双11的峰值不超过55万笔/秒, 因此419w/s这个值已可以满足此苛刻要求;采用testSpeedLimit()检测平均值不超过419w/s这个
 * 值即可,而且在空闲时段省下的ID号,还可以在高峰期时使用。
 
 * 这个都被大家忽略了:
 * DB表自增ID，也是可以改为具有分布式特性的，SerialUniqueId就是！


<p> ---------------------------------------------
<p> org.teasoft.honey.distribution.OneTimeSnowflakeId
 * OneTimeSnowflakeId，进一步改进了梨花算法。
 * 不依赖时间的梨花算法，Workerid应放在序号sequence的上一段，且应用SerialUniqueId算法，使ID不依赖于时间自动递增。
 * 使用不依赖时间的梨花算法OneTimeSnowflakeId，应保证各节点大概均衡轮流出号，这样入库的ID会比较有序，因此每个段号内的序列号不能太多。
 * 支持批获取ID号。可以一次取一批ID（即一个范围内的ID一次就可以获取了）。可以代替依赖DB的号段模式。
 * 应用订单号等有安全要求的场景,可随机不定时获取一些批的号码不用即可。
 * 考虑到2019年双11的峰值不超过55万笔/秒, 因此419w/s这个值已可以满足此苛刻要求;采用testSpeedLimit()检测平均值不超过419w/s这个值即可,而且在空闲时
 * 段省下的ID号,还可以在高峰时使用。
 * 
 * @author Kingstar
 * @since  1.7.2
 */
public interface GenId {
	
	/**
	 * 返回id号码.return the id number.
	 * @return long id号码.long id number.
	 */
	public long get();
	
	/**
	 * 一次获取一段号码,返回一个批次可用号码的最小值和最大值,eg: [100000,101000].return the min and max long in this batch.eg: [100000,101000]
	 * <br>在一些算法中,如:PearFlowerId,OneTimeSnowflakeId,
	 * <br> 1) 参数sizeOfIds不应该大于8192.
	 * <br> 2) 为了使array[0]=min,array[1]=max在连续的范围,会存在浪费id号的可能;
	 * <br>    如果不想出现这种情况,可以循环调用get()方法,或使用SerialUniqueId算法.
	 * <br> SerialUniqueId算法不会出现以上两种问题.
	 * <br>In some algorithms, such as:PearFlowerId,OneTimeSnowflakeId,
	 * <br> 1) The parameter sizeOfIds should not be greater than 8192.
	 * <br> 2) In order to make array[0]=min,array[1]=max in the range of series, it is possible to waste id number;
	 * <br>    if you don't want to, you can loop call the get() method or use SerialUniqueId algorithm.
	 * <br> The SerialUniqueId algorithm does not have the above two problems.
	 * @param sizeOfIds 返回的一批id的数量.the size Of ids in one batch.
	 * @return return the array of long. array[0]=min,array[1]=max.
	 */
	public long[] getRangeId(int sizeOfIds);

}
