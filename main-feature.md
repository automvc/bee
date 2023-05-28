## Bee主要功能特点介绍：  
**Bee概念简单**(10分钟即可入门)、功能强大。  
Bee **简化了与DB交互的编码**工作量。连接，事务都可以由Bee框架负责管理。  
简单易用,文件小,性能好;同时支持**JDBC(比如JavaWeb),Android和Harmony,NoSQL(Cassandra,MongoDB)**。  
### 省时,开发速度快
#### 简单易用
* 1.**接口简单，使用方便**。Suid接口中对应SQL语言的select,update,insert,delete操作提供**4个同名方法**。  
* 2.使用了Bee,你可以不用再另外编写dao代码，直接调用Bee的api即可完成对DB的操作。  
* 3.**约定优于配置**:Javabean没有注解,也不需要xml映射文件,只是纯的Javabean即可,甚至get,set方法不用也可以。  
* 4.**智能化自动过滤**实体的null和空字符串属性，不再需要写判断非空的代码。  
* 5.可轻松指定**只查询一部分字段**。   
**Bee可用于Android和Harmony环境访问SQLite数据库,专门对此作了优化(V1.17)**
#### 自动,功强强大
* 6.**动态/任意组合**查询条件,不需要提前准备dao接口,有新的查询需求也不用修改或添加接口。  
* 7.支持原生SQL排序, **原生语句分页**(不需要将全部数据查出来)。  
* 8.支持**直接返回Json**格式查询结果; 链式编程。  
* 9.支持**事务**、多个ORM操作使用同一连接、**for update**，支持**批处理**操作，支持原生SQL(**自定义sql**语句)，支持**存储过程**。
* 10.支持面向对象方式复杂查询、**多表查询**(无n+1问题; 支持：一对一,一对多,多对一,多对多;返回结果根据子表是否使用List有两种呈现结构)。 
* 11.**一级缓存**，概念简单，功能强大；一级缓存也可以**像JVM一样进行细粒度调优**；**支持可更新的长久缓存列表**，更新配置表，**不需要重启**。天生抵御缓存穿透 。 
    **二级缓存扩展支持;内置Redis二级缓存支持**。  
* 12.表名与实体名、字段名与属性名映射默认提供多种实现，且支持**自定义映射规则扩展**。  
* 13.**多种DB**支持轻松扩展(MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL,SQL Server,Access,**Cassandra,Mongodb**等直接可用),理论上支持JDBC的DB都可以支持,此外还支持Android和Harmony。 
* 14.支持**读写分离**一主多从, 仅**分库**等**多数据源**模式(对以前的代码无需修改,该功能对代码是透明的,即无需额外编码);Jndi数据源支持。  
* 15.**多种数据库可同时使用(如同时使用Mysql,Oracle,SQL Server)**。  
* 16.提供自然简单的分布式主键生成方案:**分布式**环境下生成**连续单调递增**(在一个workerid内),**全局唯一**数字**id**。  
* 17.**支持同库分表,动态表名映射**。  
* 18.**拦截器、多租户,支持自定义TypeHandler,处理查询的ResultSet结果**。    
* 19.**Suid,SuidRich,PreparedSql,MapSuid,MoreTable支持设置数据源名称**。  
* 20.可以不用表对应的Javabean也能操作DB。  
* 21.**无**第三方插件依赖；可零配置使用。  
* 22.**性能好:接近JDBC的速度；文件小：Bee V1.17 仅502k**, **V2.1 仅827k**。  
* 23.Sharding分库分表。  
* 24.Mongodb ORM,Mongodb分库分表。  
* 25.更多数据库分页默认支持:MsAccess,Cubrid,HSQL,Derby,Firebird等  
* 26.自定义动态SQL标签,@in,@toIsNULL1,@toIsNULL2,<if isNotNull>,<if isNotBlank>.  
动态sql,将list转为像in (1,2,3)的语句,不需要foreach,批量插入也不需要foreach.  
* 27.新增注册器功能.  
**辅助功能**:  
* 28.支持自动生成表对应的Javabean，根据Javabean创建表，Javaweb**后端代码**根据**模板自动生成**；能打印非占位符的**可执行sql**,方便调试;支持生成Json格式的SQL脚本。  
* 29.支持**读取Excel**,从Excel导入数据到DB，操作简单;支持从Excel获取配置生成数据库表。  
* 30.流的工具类StreamUtil。  
* 31.复杂查询前后端可自动解析。  
* 32.注解支持:PrimaryKey,Column,Datetime,Createtime,Updatetime;JustFetch,ReplaceInto(MySQL)。  
* 33.使用实体名_F(自动生成)引用实体字段名Users_F.name或在SuidRichExt接口中使用格式如Users::getName。    