
Bee
=========
## 好消息:  
**ORM Bee除了ORM功能, 还有完善的分库分表(Sharding分片), 完善的MongoDB ORM功能。**  
当前**最新**版本为:**V2.5.2 LTS版**(只有935k)  
旧版1.17.x LTS版为:**1.17.25**  

Sharding分片:对业务开发透明,编码透明,只加少量分片配置即可实现分片功能.  
#### [快速开始:Shardign最佳实践参考实例](guide/Quick-start-Sharding_CN.md) 

#### 工欲善其事必先利其器！——《论语》  
#### 为适应互联网时代软件需求量大,需求变更频繁,性能要求高等要求,ORM Bee应运而生!  

**Bee**，一个简单，易用，功能强大(编码少、开发速度快，运行快）的 JAVA ORM 框架。  
**Bee**，互联网新时代的Java ORM框架，更快、更简单、更自动，开发速度快，运行快，更智能!  
**Bee简单易用**：**概念简单**,10分钟即可入门。  
**Bee功能强大**：运行速度比其它流行ORM工具更快。  
**Bee功能丰富**：支持JDBC/关系型数据库; 支持手机环境ORM:Android和Harmony；支持NoSQL的Cassandra,Mongodb等;支持Sharding分片;支持ElasticSearch查询。  

**如果说Mybatis在Hibernate之后不是重复造轮子,那Bee在Hibernate和Mybatis之后也不会是重复造轮子!**  
择其优点，避其缺点，此外，还加有自己的优点！  

#### 磨刀不误砍柴工！    Bee连磨刀的时间都帮你省了。  
[IT->AiTea](What-is-AiTea.md) 

## 环境要求  
#### Bee jdk1.8+   
Bee2.1.8 + Spring boot3.0.8对应版本**2.1.8.boot3.0.8 需要JDK17**   
Bee2.2 + Spring boot3.0.13对应版本**2.2.boot3.0.13 需要JDK17**  

## Bee主要功能特点介绍：  
<img src="illustration/ORM Bee Outline.png">  

[主要功能介绍](../../../bee/blob/master/main-feature.md)  

## 最新功能简介: 
### **V2.5.2(2025·LTS版)**  
**2.5.2.1 新年**
1. MongoDB update,delete,deleteById支持分片  
2. MongoDB modify 分片cache增强  
3. MongoDB index support for sharding  
4. add ShardingFullOpTemplate  
5. SuidRich的实现类ObjSQLRich增加selectByTemplate  
**2.5.2.2**
6. fixed bug for MongodbShardingDdlEngine  
7. SQL性能分析,记录并打印SQL执行时间  
bee.osql.showSqlExecuteTime=true  
bee.osql.minSqlExecuteTime=0  
8. 使用CQRS命令查询责任分离模式操作数据库  
**2.5.2.6**
9. 默认打开常用配置,防止有人不知道功能  
openEntityCanExtend = true  
showSQL = true  
showShardingSQL = true  
showSqlExecuteTime = true  
minSqlExecuteTime = 5;   //ms  
10. 字段名支持允许使用SQL关键字  
可以使用开关控制是否使用,默认是开启  
bee.osql.naming.allowKeyWordInColumn=true  
若Bee还未包括某些关键字,还可以通过以下项追加  
bee.osql.naming.sqlKeyWordInColumn  
11. 分离logger; config先独立初始化  
12. BeeSimpleDataSourceBuilder兼容不同风格配置  


### **V2.4.2(2024.冬至·LTS版)**  
1. GenFiles增加genFileViaStream,支持读取jar里的配置文件  
2. Genbean:更新方法genFieldFile,toString, 添加方法setUpperFieldNameInFieldFile用于指定变量大小写风格 
3. 更新DoNotSetTabShadngValue提示信息(分片插入需要设置分片键的值)  
4. SuidRich selectById,deleteById支持sharding  
5. Condition支持clone  
6. fixed bug:  
sharding select all(no paging)  
sharding modify cache  

## [详细完整功能介绍](../../../bee/blob/master/Changed_Log_CN.md)  
[点击链接可查看  详细完整功能介绍](../../../bee/blob/master/Changed_Log_CN.md)  

## Bee支持的数据库	
1.MySQL  
2.Oracle  
3.SQL Server  
4.MariaDB  
5.H2  
6.SQLite  
7.PostgreSQL  
8.MS Access  
9.金仓  
10.达梦  
11.OceanBase  
12.Cubrid,HSQL,Derby,Firebird  
13.其它支持JDBC的DB  

NOSQL:  
14.Mongodb  
15.ElasticSearch  
16.Cassandra  

手机环境(的数据库):  
17.Android  
18.Harmony  


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
	      <version>2.5.2</version>
        </dependency>
		
	    <!-- Mysql config.You need change it to the real database config. -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.47</version>
			<scope>runtime</scope>
		</dependency>
```

Gradle

```xml
implementation group: 'org.teasoft', name: 'bee-all', version: '2.5.2'
//Gradle(Short)
implementation 'org.teasoft:bee-all:2.5.2'
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
关键代码    

```java
List<Orders> list1 =suid.select(orders1);  //select
int updateNum=suid.update(orders1);   //update
int insertNum=suid.insert(orders2); //insert 
int deleteNum=suid.delete(orders2);   //delete
```

详细实例    

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
		
		//在实体里,默认的运行符是等号,除了等号,Bee是用比较符合书写习惯的方法, 可以任意写不同的条件.
          //Condition condition=BF.getCondition();   //SuidRich接口有很多带Condition参数的方法
          //condition.op(Orders_F.userid, Op.ge, 0);   //userid>=0
          //Op支持除了"="外的,>,<,>=,<=,!=, like, in, not in 等
		
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
**2.2.boot3.0.13需要JDK17**	

## Bee架构介绍
**V2.1**  
<img src="illustration/Bee-architecture-V2.0.png"  width="520" height="640">  

## Bee常用接口介绍  
<img src="illustration/common-interface-2.5.2.png">  

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

**自动生成代码GenCode**  
[Generate code automatically](../../../gencode)  

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
API-V2.5.2(最新版) 下载代码含有 bee-2.5.2英文版API  

### 使用文档
[wiki 文档](../../../bee/wikis)  

[Bee常用大全](/guide/Frequently-Used-Guide.md)  

[CSDN: ORM Bee资料大全](https://blog.csdn.net/abckingaa/article/details/121664398)

**Bee** 网址:  
https://github.com/automvc/bee  
**Bee在gitee** 的网址:  
https://gitee.com/automvc/bee  
bee-ext:  
https://github.com/automvc/bee-ext  
Python版Bee:
https://github.com/automvc/BeePy  

  
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
