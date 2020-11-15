常见问题收集:

1.

Q: Bee支持几种数据库?  

A: MySQL,MariaDB,Oracle,SQL Server,H2,SQLite,PostgreSQL等等都是支持的,只要该DB支持JDBC,Bee就可以轻松支持它!

2.

Q:&nbsp;表与实体Javabean可以自动映射吗?

A: Bee采用约定优于配置的方式,默认实现有三种方式, 且支持自定义映射规则扩展.  
在bee.properties作相关配置即可切换默认实现方式.

```properties
#since 1.7.2
#default implement translate type. 1 : order_no<-->orderNo(DB<-->Java), 2: ORDER_NO<-->orderNo(DB<-->Java), 3: original
#if want to use other naming rule, you can define a new class implements NameTranslate
#default value is :1
bee.osql.naming.translate.type=1
```

3.

Q:&nbsp;Bee支持读写分离,支持多数据源吗?

A: V1.8支持读写分离一主多从, 仅分库等多数据源模式。  
分布式环境下生成连续单调递增(在一个workerid内),全局唯一数字id。

4.    
    

Q: 在一个DB中，随着数据量不断增长，需要将老的数据移到历史表中. 如，订单表orders,将5月，6月数据移到 orders\_202005,orders\_202006,结构与表orders一样。 如何用同一javabean，同时映射多个数据表？

A:&nbsp;V1.8支持同库分表,动态表名映射.&nbsp;

参考:&nbsp;[https://gitee.com/automvc/bee/issues/I1P8YH](https://gitee.com/automvc/bee/issues/I1P8YH)&nbsp;

或:&nbsp;[https://github.com/automvc/bee/issues/18](https://github.com/automvc/bee/issues/18)

5.

Q: Bee有说明文档吗?有测试用例吗?这么好用的orm竟然没文档??!!!

A: 请参考Bee源码网站wiki,或: JavaWeb开发的利器 系统文章，请关注微信公众号: 软件设计活跃区. 测试用例,请查看:[https://gitee.com/automvc/bee-exam](https://gitee.com/automvc/bee-exam)

6.    
    

Q: 请教下bee的多对多映射是类似mybatis那种可以全部查出来然后映射，还是hibernate那种多次查询?

A: bee更接近原生SQL,可用原生语句分页，不需要全部查出来，也不需要查多次 wiki相关文档: (四): 分页、查询部分字段原来如此简单 (六): 多表查询(面向对象方式)

7.    
    

Q: Bee怎么具有AI特性?

A: 通过从手工写sql语句直接用JDBC操作数据库，到简单的DB工具类， 再到像Hibernate的旧版本通过操作对象将操作DB封闭到Dao； 再到后来写dao都觉得累赘，通用操作只写个空接口。 ORM工具的发展，就是一步一提炼，简化操作的历史。 假如用AI学习，演变，那写空接口都会觉得是多余的，&nbsp;每个数据库表不就是表名,以及包含一些列而矣吗??!!!&nbsp;为什么不能用同样的方式去处理呢??!!!&nbsp;而且dao层可以直接去掉放到ORM框架统一处理。 为了实现这些目标,就有了Bee框架。 原来编码复杂度是O(n)的，现在变成是O(1),无论多少个表,你都可以不用另外再写dao代码。 可以用时间复杂度和空间复杂度体会下编码复杂度这种变化。

8.    
    

Q:&nbsp;分布式ORM正在解决的问题之一: 能不能找到一种，既不依赖DB，也不依赖时间的ID生成算法呢？ DB表自增ID真的不能用在分布式场景吗？

A: 都是可以的.参考Bee的org.teasoft.bee.distribution.GenId接口的三种实现.

9.    
    

Q:&nbsp;与传统ORM工具的比较?

A: Hibernate的概念太复杂，学习成本高，更新会先查询再更新，n+1问题。Mybatis即使进行单表的Suid操作也需要人工写sql或生成sql文件，需要维护的sql太多。 更多比较,参考:&nbsp;[https://blog.csdn.net/abckingaa/article/details/84557336](https://blog.csdn.net/abckingaa/article/details/84557336)

10.    
    

Q:&nbsp;Bee如何提高Java web软件开发效率?

A: 除了可以不需要写dao代码外(编码复杂度为O(1)),还提供了表对应的实体Javabean自动生成工具, 根据模板自动生成Java web前后端代码;人性化的SQL日志,可输出直接运行的sql语句(有占位符的SQL不能直接运行,不方面调试).

11.    
    

Q:&nbsp;Bee支持缓存吗? 如何设置缓存?

A: 支持。还可以像调优JVM一样，对一级缓存进行调优。有暂时缓存，也有永久缓存，还有可以同步更新的永久缓存。

```properties
#cache=======================start
#缓存类型
#bee.osql.cache.type=FIFO
#缓存集数据量数目
bee.osql.cache.map.size=10
#resultset超过一定的值将不会放缓存
bee.osql.cache.work.resultSet.size=300
#缓存保存时间(毫秒 ms)
bee.osql.cache.timeout=10000
#检测到超时,超过这个使用比例则顺便起线程清除缓存
bee.osql.cache.startDeleteCache.rate=0.6
#缓存容量使用率;添加缓存,检测达到该使用率则清除一定比例缓存
bee.osql.cache.fullUsed.rate=0.8
#添加缓存,检测到缓存容量快满时,删除缓存数的比例
bee.osql.cache.fullClearCache.rate=0.2

#仅分库时(bee.dosql.multi-DS.type=2),可用格式:  dsName.tableName
#use table name, not entity name
#不缓存表的列表, 表名不区分大小写
#bee.osql.cache.never=user
#永久缓存表的列表, 表名不区分大小写
#bee.osql.cache.forever=constant
#永久缓存,但有更改时也会清除缓存,以便同步新的值到缓存. 表名不区分大小写
#bee.osql.cache.forever.modifySyn=para

# since v1.7.2. default value is: false (use cache)
#bee.osql.cache.nocache=true

#cache=======================end

```	

12.    
    

Q:&nbsp;Bee设计原理?

A: 参考wiki或公众号相关文章: (十一)：如何设计ORM架构及Bee源码分析 (十二)：为什么需要一个新的ORM框架

13.Q:&nbsp;Bee查询自己怎么写筛选条件呢？像筛选状态大于2的 

A: 写法类似： Condition condition=new ConditionImpl(); condition .op("status", Op.gt, 2) // 会转化到SQL中的where status&gt;2 详情参考wiki: (五): 复杂查询(面向对象方式) (十三)：update高级用法说明    
 **更新的字段是在原来的基础上变化** 
如某类商品提价2元，可以有如下写法。    
set price=price+2    
 **这样写的好处，可以不需要查询出原来的价格，减少IO开销。**     
Bee的面向对象写法：    
condition.setAdd("price", 2);     
suidRich.update(entity,condition);    

若字段p每次增加的值由字段step配置，则写为：    
condition.setAdd("p", "step");    
会转化为: set p=p+step	

14.Q:&nbsp;Bee与Honey是什么关系? 

A: ORM Bee框架是采用接口与实现分离的设计方式.Bee是接口,而Honey则是Bee的实现.	

15.

Q:&nbsp;Bee非常易用,编写代码少,但使用是一方面, 它的性能如何?

A: 性能绝对是过得去的．README给出了详细的表格比较数据．　　详细比较还开启了一个项目，欢迎ＰＫ。  
https://gitee.com/automvc/orm-compare  

16.

Q:&nbsp;Bee适合手机开发领域吗?

A: Bee文件小。bee V1.8 jar files 仅217k. 而且性能也接近JDBC的性能.还专门对H2,SQLite作了优化.

**其它相关资源:**

gitee issue:&nbsp;[https://gitee.com/automvc/bee/issues?assignee\_id=&amp;author\_id=&amp;branch=&amp;issue\_search=&amp;label\_name=&amp;milestone\_id=&amp;program\_id=&amp;scope=&amp;sort=&amp;state=closed](https://gitee.com/automvc/bee/issues?assignee_id=&amp;author_id=&amp;branch=&amp;issue_search=&amp;label_name=&amp;milestone_id=&amp;program_id=&amp;scope=&amp;sort=&amp;state=closed)&nbsp;

gitee wiki:&nbsp;[https://gitee.com/automvc/bee/wikis](https://gitee.com/automvc/bee/wikis)

github issue:&nbsp;[https://github.com/automvc/bee/issues?q=is%3Aissue+is%3Aclosed](https://github.com/automvc/bee/issues?q=is%3Aissue+is%3Aclosed)&nbsp;

github wiki:&nbsp;[https://github.com/automvc/bee/wiki](https://github.com/automvc/bee/wiki)