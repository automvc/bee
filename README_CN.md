
Bee
=========
## 好消息:  
**Bee 2.1 完善的Sharding分片功能, 完善的MongoDB ORM功能。**  
当前**最新**版本为:**V2.1.7 LTS版**  

Sharding分片目标:对业务开发透明,编码透明,只加少量分片配置即可实现分片功能.  
#### [快速开始:Shardign最佳实践参考实例](guide/Quick-start-Sharding_CN.md) 

#### 工欲善其事必先利其器！——《论语》  
#### 为适应互联网时代软件需求量大,需求变更频繁,性能要求高等要求,ORM Bee应运而生!  

**Bee**，一个简单，易用，功能强大(编码少、开发速度快，运行快）的 JAVA ORM 框架。  
**Bee**，互联网新时代的Java ORM框架，更快、更简单、更自动，开发速度快，运行快，更智能!  
**Bee简单易用**：**概念简单**,10分钟即可入门。  
**Bee功能强大**：运行速度比其它流行ORM工具更快。  
**Bee功能丰富**：支持JDBC/关系型数据库; 支持手机环境ORM:Android和Harmony；支持NoSQL的Cassandra,Mongodb等;支持Sharding分片。  

**如果说Mybatis在Hibernate之后不是重复造轮子,那Bee在Hibernate和Mybatis之后也不会是重复造轮子!**  
择其优点，避其缺点，此外，还加有自己的优点！  

#### 磨刀不误砍柴工！    Bee连磨刀的时间都帮你省了。  
[IT->AiTea](What-is-AiTea.md) 

## 环境要求  
#### Bee jdk1.8+   
Bee2.1.7 + Spring boot3.0.8对应版本**2.1.7.boot3.0.8 需要JDK17**   

## Bee主要功能特点介绍：  
#### 简单易用
* 1.**接口简单，使用方便**。Suid接口中对应SQL语言的select,update,insert,delete操作提供**4个同名方法**。  
* 2.使用了Bee,你可以不用再另外编写dao代码，直接调用Bee的api即可完成对DB的操作。  
* 3.**约定优于配置**:Javabean没有注解,也不需要xml映射文件,只是纯的Javabean即可,甚至get,set方法不用也可以。  
* 4.**智能化自动过滤**实体的null和空字符串属性，不再需要写判断非空的代码。  
* 5.可轻松实现**只查询一部分字段**，轻松实现**原生语句分页**。   
* 6.支持**直接返回Json**格式查询结果; 链式编程。  
* 7.**Sharding分片**,分库分表;只分库;只分表;读写分离;(对以前的代码无需修改,该功能对代码是透明的,即无需额外编码)。 
* 8.**多种DB**支持轻松扩展(MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL,SQL Server,Access,金仓,达梦等,NoSQL:**Cassandra,Mongodb**等直接可用),理论上支持JDBC的DB都可以支持,此外还支持**Android和Harmony**; 
* 9.更多数据库分页默认支持:MsAccess,Cubrid,HSQL,Derby,Firebird等  
* 10.**多种数据库可同时使用(如同时使用Mysql,Oracle,MongoDB)**。  

#### 自动,功强强大
* 11.**动态/任意组合**查询条件,不需要提前准备dao接口,有新的查询需求也不用修改或添加接口。  
* 12.支持**事务**、多个ORM操作使用同一连接、**for update**，支持**批处理**操作，支持原生SQL(**自定义sql**语句)，支持**存储过程**。
* 13.支持面向对象方式复杂查询、**多表查询**(无n+1问题; 支持：一对一,一对多,多对一,多对多;返回结果根据子表是否使用List有两种呈现结构)。 
* 14.Mongodb ORM,Mongodb分库分表。  
* 15.**注册器、拦截器、多租户,支持自定义TypeHandler,处理查询的ResultSet结果**;  
                 转换器SetParaTypeConvert转换PreparedStatement参数的类型。    
* 16.自定义动态SQL标签,@in,@toIsNULL1,@toIsNULL2,&lt;if isNotNull>,&lt;if isNotBlank>;  
     动态sql,将list转为像in (1,2,3)的语句,不需要foreach,批量插入也不需要foreach。      
* 17.复杂查询前后端可自动解析。  
* 18.**一级缓存**，概念简单，功能强大；一级缓存也可以**像JVM一样进行细粒度调优**；**支持可更新的长久缓存列表**，更新配置表，**不需要重启**。天生抵御缓存穿透 。 
    **二级缓存扩展支持;内置Redis二级缓存支持**。  
* 19.**无**第三方插件依赖；可零配置使用。  
* 20.**性能好:接近JDBC的速度；文件小：Bee V1.17 仅502k**, **V2.1 仅827k**。  

**辅助功能**:  
* 21.提供自然简单的分布式主键生成方案:**分布式**环境下生成**连续单调递增**(在一个workerid内),**全局唯一**数字**id**。  
* 22.支持自动生成表对应的Javabean，根据Javabean创建表，Javaweb**后端代码**根据**模板自动生成**；能打印非占位符的**可执行sql(支持sql格式化)**,方便调试;支持生成Json格式的SQL脚本。  
* 23.支持**读取Excel**,从Excel导入数据到DB，操作简单;支持从Excel获取配置生成数据库表。  
* 24.流的工具类StreamUtil。  
* 25.丰富的注解支持:PrimaryKey,Column,Datetime,Createtime,Updatetime;JustFetch,ReplaceInto(MySQL),Dict,DictI18n等。  
* 26.使用实体名_F(自动生成)引用实体字段名Users_F.name或在SuidRichExt接口中使用格式如Users::getName。  


## 最新功能简介: 

### **V2.1.8(2023.08·LTS版)**  
1.DateUtil增加判断日期格式,计算年龄  
2.兼容spring boot命令行active选择环境,兼容spring boot数据源配置  
3.多表关联插入,更新,删除  
4.CurrencyArithmetic变量bug  
5.CacheSuidStruct表名不区分大小写  
6.MongodbObjSQLRichExt完善拦截器及上下文信息管理  
7.通过Excel创建表，支持更多数据库  
8.Mongodb打印日志，查询所有字段时，默认不显示要查询的字段；可以通过bee.osql.showMongoSelectAllFields配置控制是否显示  
9.提供默认的BeeSimpleDataSource，支持在bee.properties里配置多数据源  
10.Javabean支持生成Swagger注解

### **V2.1.7(2023.07.01·LTS版)**  
1.增加可运行sql格式化(需要配置:bee.osql.showSql.sqlFormat=true)  
2.二级缓存支持过期时间随机设置, 解决缓存雪崩问题  
3.DdlViaExcel.createTable通过excel里的信息创建数据库表,可只创建部分  
4.支持Spring boot 3.0,动态配置  
5.完善Sharding ThreadPool,可以自定义配置Sharding操作执行线程数的大小  
6.完善Android多线程操作获取SQLiteDatabase的问题  

### **V2.1.6(2023.06.18·父亲节版)**  
1.添加开关closeDefaultParaResultRegistry,控制是否需要默认加载参数类型转换器和查询结果类型转换器  
2.支持JAP新的API包jakarta.persistence.*  
3.批量插入支持配置是否由框架捕获主键等异常catchModifyDuplicateException,默认不捕获  
4.关闭UtilDotDateTypeConvert因少了 HH:mm:ss  
5.fixed bug 更新配置的默认值  
  fixed bug NullPointerException for PreparedSql preparedValue  
  fixed bug for StringUtils  

### **V2.1(2023.05.20·LTS版)主要功能**  
1.Suid,SuidRich,MoreTable,PreparedSql,MapSuid等主要的常用的接口移到org.teasoft.bee.osql.api包  
2.更好支持MVC编程和Spring RestFul编程  
3.bee.properties支持配置多数据源(此方式,无需xml或java代码配置)  
4.GenBean支持Lombok注解:@Setter,@Getter,@Data  
5.内置Json工具fastjson实现支持,支持自定义配置使用的Json工具  
6支持更多数据库一行代码生成整个库所有表对应的Javabean  
new GenBean().genAllBeanFile();  
7.广播表批量插入    
8.完善分片Sharding功能  
9.Mongodb ORM功能全面支持  
9.1.支持Mongodb地理信息插入,查询(可分片查询)等  
9.2.GridFs文件各种操作,支持注解    
9.3.可直接执行原生语句(MongodbRawSql)  
9.4.Mongodb面向对象操作打印原生语句日志     
9.5.支持Mongodb事务  
9.6.支持Mongodb创建索引,删除索引    
9.7.mongodb bean定义为插拔组件  
10.更多数据库分页默认支持:MsAccess,Cubrid,HSQL,Derby,Firebird等  

#### [Mongodb ORM(Bee)详细功能列表](MongodbORM-Function-List.md) 

### **V2.0(2023.02·母爱)**  
**使用分库分表像使用单库一样方便;使用MongoDB像使用MySQL一样容易.**  
1.新增分库分表支持:面向对象分片,JDBC分片  
1.1.面向对象分片  
1.2.Suid,SuidRich,查询,更新分片  
1.3.MoreTable多表查询分片  
1.4.批量插入分片  
1.5.MAX,MIN,COUNT,SUM,AVG分片查询分片  
1.6.分页/排序分片  
1.7.分片种类支持:分库分表,仅分库,仅分表  
1.8.分片路由种类支持:一库一表,一库多表,多库多表,全库全表,只指定表,只指定库  
1.9.通过Hint强制指定当次操作的分片路由(指定ds和table)  
1.10.分片的广播表  
1.11.Sharding分片配置支持  
1.12.流式查询,降低查询内存使用(JDBC)  
1.13.分片支持:=,in,between;其中in支持Number,List,Set  
        不参与分片:not in, not between,>=,<=。 
2.新增Mongodb ORM功能支持(使用类似JDBC用法)  
3.新增Mongodb分片功能  
4.新增MS Access支持  

### **V1.17.21(2023.06.18  1.17.x LTS版)**  
同步V2.0，V2.1发现的bug,完善相关问题.  

### **V1.17(2022·中秋)**  
1)完善SqlServer分页  
2)增加Android(安卓)ORM功能  
3)增加HarmonyOS(鸿蒙)ORM功能  
4)命名转换增加种类4(DbUpperAndJavaLower)  

### **V1.11** (**2022·劳动节**)  
1)新增拦截器、多租户,注册器功能  
2)二级缓存扩展支持  
Redis缓存支持  
3)支持自定义TypeHandler,处理查询的ResultSet结果  
  添加转换器SetParaTypeConvert转换PreparedStatement参数的类型  
4)支持Cassandra.  
5)添加Jndi数据源支持  
6)自定义动态SQL标签,@in,@toIsNULL1,@toIsNULL2,<if isNotNull>,<if isNotBlank>.  
动态sql,将list转为像in (1,2,3)的语句,不需要foreach,批量插入也不需要foreach.  
7)配置文件支持多环境差异化配置;  
8)丰富的注解支持.  
  
...

## [详细完整功能介绍](../../../bee/blob/master/Changed_Log_CN.md)  
[点击链接可查看  详细完整功能介绍](../../../bee/blob/master/Changed_Log_CN.md)  

## ORM比较	
### 应用于JDBC方面的比较	

[ORM-Compare (More Detail)](../../../orm-compare)  

测试环境: Windows.  
数据库: MySQL (Version 5.6.24).  
测试点: 批量插入;分页查询;事务(update and select).  

<img src="illustration/batch-insert-compare.png">  

<table cellspacing="0" cellpadding="0">
  <col width="62" />
  <col width="69" />
  <col width="64" />
  <col width="69" span="2" />
  <col width="96" />
  <tr height="19">
    <td colspan="6" height="19" width="429"><div align="center">批量插入(单位: ms)</div></td>
  </tr>
  <tr height="19">
    <td height="19">　</td>
    <td>5k</td>
    <td>1w</td>
    <td>2w</td>
    <td>5w</td>
    <td>10w</td>
  </tr>
  <tr height="19">
    <td height="19">Bee</td>
    <td align="right">529.00 </td>
    <td align="right">458.33 </td>
    <td align="right">550.00 </td>
    <td align="right">1315.67 </td>
    <td align="right">4056.67 </td>
  </tr>
  <tr height="19">
    <td height="19">MyBatis</td>
    <td align="right">1193</td>
    <td align="right">713</td>
    <td align="right">1292.67 </td>
    <td align="right">1824.33 </td>
    <td>Exception</td>
  </tr>
</table>

<p>&nbsp;</p>
<table cellspacing="0" cellpadding="0">
  <col width="62" />
  <col width="69" />
  <col width="64" />
  <col width="69" span="2" />
  <col width="96" />
  <tr height="19">
    <td colspan="6" height="19" width="429"><div align="center">分页查询(单位: ms)</div></td>
  </tr>
  <tr height="19">
    <td height="19">　</td>
    <td align="right">20次</td>
    <td align="right">50次</td>
    <td align="right">100次</td>
    <td align="right">200次</td>
    <td align="right">500次</td>
  </tr>
  <tr height="19">
    <td height="19">Bee</td>
    <td align="right">17.33 </td>
    <td align="right">58.67 </td>
    <td align="right">52.33 </td>
    <td align="right">38.33 </td>
    <td align="right">57.33 </td>
  </tr>
  <tr height="19">
    <td height="19">MyBatis</td>
    <td align="right">314.33 </td>
    <td align="right">446.00 </td>
    <td align="right">1546.00 </td>
    <td align="right">2294.33 </td>
    <td align="right">6216.67 </td>
  </tr>
</table>

<p>&nbsp;</p>
<table cellspacing="0" cellpadding="0">
  <col width="62" />
  <col width="69" />
  <col width="64" />
  <col width="69" span="2" />
  <col width="96" />
  <tr height="19">
    <td colspan="6" height="19" width="429"><div align="center">事务(update and select) (单位: ms)</div></td>
  </tr>
  <tr height="19">
    <td height="19">　</td>
    <td align="right">20次</td>
    <td align="right">50次</td>
    <td align="right">100次</td>
    <td align="right">200次</td>
    <td align="right">500次</td>
  </tr>
  <tr height="19">
    <td height="19">Bee</td>
    <td align="right">1089.00 </td>
    <td align="right">70.00 </td>
    <td align="right">84.00 </td>
    <td align="right">161.33 </td>
    <td align="right">31509.33 </td>
  </tr>
  <tr height="19">
    <td height="19">MyBatis</td>
    <td align="right">1144</td>
    <td align="right">35</td>
    <td>79.67 </td>
    <td align="right">146.00 </td>
    <td align="right">32155.33 </td>
  </tr>
</table>
	
**Bee需要的文件**   
orm\compare\bee\service\BeeOrdersService.java	

**Mybatis需要的文件**(对一个表的操作,就会比Bee多三个dao相关文件)   
orm\compare\mybatis\service\MybatisOrdersService.java	
orm\compare\mybatis\dao\OrdersDao.java	
orm\compare\mybatis\dao\OrdersMapper.java	
orm\compare\mybatis\dao\impl\OrdersDaoImpl.java	

公共都需要的有,Javabean和Service接口:  
Orders.java  
OrdersService.java  

**用Bee无需用户再写Dao代码，一个表少三个Dao文件，100个表就少300个Dao文件.**	

### Bee应用于APP方面的比较

**Bee应用于APP开发性能对比数据**  
操作1万条数据	,使用时间对比如下.  

<table cellpadding="0" cellspacing="0">
  <col width="50" />
  <col width="90" />
  <col width="74" />
  <col width="76" />
  <tr height="19">
    <td height="19" colspan="4" ><div align="center">操作1w条数据 (单位: ms)</div></td>
  </tr>
  <tr height="19">
    <td height="19" >　</td>
    <td align="right">insert</td>
    <td align="right">query</td>
    <td align="right">delete</td>
  </tr>
  <tr height="19">
    <td height="19">greenDao(Android)</td>
    <td align="right">104666</td>
    <td align="right">600 </td>
    <td align="right">47 </td>
  </tr>
  <tr height="19">
    <td height="19">Bee(Android 8.1)</td>
    <td align="right">747</td>
    <td align="right">184</td>
    <td align="right">25 </td>
  </tr>
  <tr height="19">
    <td height="19">Bee(HarmonyOS P40 Pro模拟器)</td>
    <td align="right">339</td>
    <td align="right">143</td>
    <td align="right">2 </td>
  </tr>
</table>

	
快速开始:
=========	
## 1. 引入Bee  
#### 1.1 maven工程,添加如下依赖  

```xml
       <dependency>
	      <groupId>org.teasoft</groupId>
	      <artifactId>bee-all</artifactId>
	      <version>2.1.7</version>
        </dependency>
		
	    <!-- Mysql config.You need change it to the real database config. -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.47</version>
			<scope>runtime</scope>
		</dependency>
```

#### 1.2  也可以直接下载jar文件  	
		
## 2. 创建数据库和表  

举例如下:  
创建一个数据库,默认名称为bee.  
可以用[init-data(user-orders)-mysql.sql](../../../bee-exam/blob/master/src/main/resources/init-data(user-orders)-mysql.sql)脚本创建表和插入初始化数据.  

## 3. 更新数据库的配置信息(在bee.properties)  
注:如果还没有bee.properties文件,可以自己新建一个.  
(默认的bee.properties位于Hoeny工程下,对应HoneyConfig.java,列举了Bee所有会用到的配置)   
也可以配置数据源(此处只是一个例子).  

\#bee.databaseName=MySQL  
bee.db.dbName=MySQL  
bee.db.driverName = com.mysql.jdbc.Driver  
\#bee.db.url =jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8  
bee.db.url =jdbc:mysql://127.0.0.1:3306/bee?characterEncoding=UTF-8&useSSL=false  
bee.db.username = root  
bee.db.password =  

\#输出日志  
bee.osql.showSQL=true  
bee.osql.showSql.showType=true  
bee.osql.showSql.showExecutableSql=true  
\# since 2.1.7 =true时,可格式化sql
bee.osql.showSql.sqlFormat=false

\#log4j>slf4j>log4j2>androidLog>harmonyLog>systemLogger>fileLogger>noLogging>jdkLog>commonsLog  
\#fileLogger 输出到文件; systemLogger 控制台输出  
bee.osql.loggerType=systemLogger  

## 4. 生成Javabean Orders可参考:  
[Orders(Javabean)](../../../bee-exam/blob/master/src/main/java/org/teasoft/exam/bee/osql/entity/Orders.java)  
[自动生成Javabean](../../../bee-exam/blob/master/src/main/java/org/teasoft/exam/bee/osql/autogen/GenBeanExam.java)  

## 5. 运行下面的 java代码    

```java
		
import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

/**
 * 查,改,增,删 Suid (select,update,insert,delete)实例
 * @author Kingstar
 * @since  2.1
 */
public class SuidExam {
	
	public static void main(String[] args) {

		Suid suid=BeeFactoryHelper.getSuid();
//	    Suid suid=BF.getSuid();//从1.9.8开始,可以加快输入
		
		//需要先生成相应的Javabean
		Orders orders1=new Orders();
		orders1.setId(100001L);
		orders1.setName("Bee(ORM Framework)");
		
		//1:select查询实例
		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
		List<Orders> list1 =suid.select(orders1);  //select
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).toString());
		}
		
		//2:update更新实例
		orders1.setName("Bee--ORM Framework");
		//默认只更新需要更新的字段. 过滤条件默认只用id字段,其它需求可用SuidRich中的方法.
		int updateNum=suid.update(orders1);   //update
		System.out.println("update record:"+updateNum);
		
		
		Orders orders2=new Orders();
		orders2.setUserid("bee");
		orders2.setName("Bee(ORM Framework)");
		orders2.setTotal(new BigDecimal(91.99));
		orders2.setRemark("");  //empty String test
		
		//3:insert 插入实例
		int insertNum=suid.insert(orders2); //insert  		
		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动插入数据库中. 
		//方便结合DB插值,如id自动增长,由DB插入;createtime由DB默认插入
		System.out.println("insert record:"+insertNum);
		
		//4:delete 删除实例
		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
		//int deleteNum=suid.delete(orders2);   //delete
		//System.out.println("delete record:"+deleteNum);
		
	}
}
//注意: 事务,分页,排序,范围查询,查询结果直接返回json等都支持,这里只是一个入门例子.
//更加应用参考,请查看: 更多例子   和    综合应用 .

```

## 6.操作视频:    
<img src="guide/bee-quick-start-2.0.gif"  width="840" height="420">  

------------------------------------------------------------------------

## [快速开始:Harmony环境使用Bee及性能对比](guide/Quick-start-for-Harmony_CN.md) 

## [快速开始:Android环境使用Bee及性能对比](guide/Quick-start-for-Android_CN.md) 

### [更多例子/测试用例](../../../bee-exam/)	

### [Bee+Spring-boot Demo](../../../bee-starter-demo/)	
**2.1.7.boot3.0.8需要JDK17**	

## Bee架构介绍
**V2.1**  
<img src="illustration/Bee-architecture-V2.0.png"  width="520" height="640">  

## Bee常用接口介绍  
<img src="illustration/common-interface.jpg">  

综合应用:
=========	
**Java快速编程, 让Java的开发速度超过php和Rails。**  

**更快的开发Java Web的新组合：**  
[Bee+Spring+SpringMVC](../../../../aiteasoft/bee-spring-springmvc)  
**包括仅分库多数据源实例**	

[Bee+Spring+SpringMVC开发学校教务管理与分数管理系统](../../../../aiteasoft/schoolsys)  

**更快的开发Spring Cloud微服务的新组合：**  
[Bee + Spring Boot](../../../bee-springboot)  

**HarmonyOS使用Bee开发App实例：**  
[Bee + HarmonyOS](../../../../aiteasoft/HarmonyOS-ORM-Bee-Demo)  

### 快码加编
[快码加编——代码生成神器](http://www.kmcoding.com)  
* 1.一键生成整个工程(无需再搭建系统框架)  
* 2.自动生成增删改查等常用功能  
* 3.生成的工程可以直接运行,不再是只能看不能跑的demo  
* 4.快速响应变化,与客户边聊边改，立即可以看到更改后的效果  
* 5.基础功能无需人工测试、接口联调，简化整个开发流程  
* 6.设计的软件易维护、易扩展，利于二次开发、增加新功能！  
* 7.既可以**节约开发成本**，也可以**提高开发效率**！  
......  

## [FAQ常见问题](../../../bee/blob/master/FAQ_CN.md)  
[点击链接可查看(资料)  FAQ常见问题](../../../bee/blob/master/FAQ_CN.md)  

其它学习资料:
=========	
### API-DOC  
API-V1.17      下载代码含有 bee-1.17中文和英文版API,bee-1.17中文版源码  
API-V2.1(最新版) 下载代码含有 bee-2.1英文版API  

### 使用文档
[wiki 文档](../../../bee/wikis)  

[Bee常用大全](/guide/Frequently-Used-Guide.md)  

[CSDN: ORM Bee资料大全](https://blog.csdn.net/abckingaa/article/details/121664398)
  
企业版:
=========	
为了给大家提供更多更强大的功能,Bee团队与企业合作,推出企业版本.  
注：免费版本不会故意少加ORM的功能而让你去购买企业版；企业版本只会推出更加专业，安全，节约成本的企业级功能.  
### 新增特性  
**我们希望提供更多简单易用的Bee功能!进一步提高开发效率!&nbsp;**  
* 1.降低金融计算型项目开发难度,简化金融数字计算等	
* 2.@AutoSetString注解易用性改进,轻松处理像CreateBy,UpdateBy等自动填充功能	
*   自动插入租户的值	
* 3.@Desensitize,敏感信息模糊处理  
* 4.@Dict具体字段字典数值转化	
* 5.@DictI18n多语言国际化字典转化,全局统一设置,无需逐个设置,省时省力	
* 6.@MultiTenancy多租户  
* 7.@Column实现Javabean属性与表列名不一致时,定义映射关系(新系统不建议使用,主要是为了兼容旧系统)  
* 8.@Json实体属性是Javabean与DB表Json类型字段在参数设置与查询结果时自动转换  
    支持List结构实体Json解析(V1.11.0.5.6)  
* 9.支持EDI XML电子报文自动生成	
* 10.Sql Server支持start,size两个参数分页(V1.11.0.5.8)  
注: 除1、5、9外,其它已添加到V2.1 LTS版  

### 价格(企业版)
**企业**用户:  
￥999  
**个人**用户:  
￥198  

### 使用期限(企业版)
**购买后永久使用,免费获取升级**  

### 技术支持
**企业版使用，专业技术支持，解决方案咨询，由以下单位提供:**  
**[深圳彩凤软件](http://www.aiteasoft.com)**  
(有意愿加入的企业,请联系我们!)  


**Bee** 网址:  
https://github.com/automvc/bee  
**Bee在gitee** 的网址:  
https://gitee.com/automvc/bee  
bee-ext:  
https://github.com/automvc/bee-ext  

  
联系与欢迎:
=========	
#### 作者的电子邮箱email:    honeysoft@126.com  
#### 如有任何相关建议,欢迎给作者发邮件,不胜感激!  
#### 更多设计思想,请关注微信公众号: 软件设计活跃区  
<img src="weixin.jpg" width="200" heigh="200">

为了我们能够相互了解,更好的为你服务,你可以到以下地址登录使用情况.
https://github.com/automvc/bee/issues/43  
https://gitee.com/automvc/bee/issues/I3PIUJ  
完成**登记的伙伴**,请加QQ群(**992650213**),可找群主领企业级生产环境建议相关资料! 

#### 为了能及时解答大家的疑问，可以加入Bee的技术QQ群：992650213

#### 同时,也欢迎你加入到Bee框架的开发之中,相信有你的加入,Bee会更加美好! 
