
Bee
=========
#### 工欲善其事必先利其器！——《论语·卫灵公》    
#### 磨刀不误砍柴工！    
**Bee** 是一个 Java ORM框架利器,它的开发速度快, 编码少, 还很简单！       
**Bee** 是一个具有人工智能(AI)特性，省时/优雅、简易、自动( **AiTea:** Timesaving/Tasteful, Easy, Automatic) 的ORM软件框架(AiTeaSoft)(IT-->AiTea 的思维转变!)。  
你还在为不断重复写ORM操作数据库的代码而烦恼吗?每写一个service业务层，就要写一个dao层(即使我们知道dao就是简单的查改增删suid操作)。  
让**Bee**帮助你从烦琐的编码工作中解脱出来。  
Bee是一种更接近SQL语言思维的ORM框架，  
一种开发速度和开发成本都不比php差的Java ORM框架，  
而且它的编码复杂度是O(1)，即用了Bee，**无论多少个表**,你都可以不用另外再写dao代码。  

**Bee** 网址:  
https://github.com/automvc/bee  
**Bee在gitee** 的网址:  
https://gitee.com/automvc/bee

## 环境要求  
jdk1.7+

## Bee主要功能特点介绍：  
* 1.接口简单，使用方便。Suid接口中对应SQL语言的select,update,insert,delete操作提供**4个同名方法**。  
* 2.使用了Bee,你可以不用再另外编写dao代码，直接调用Bee的api即可完成对DB的操作。  
* 3.**约定优于配置**:Javabean没有注解,也不需要xml映射文件,只是纯的Javabean即可,甚至get,set方法不用也可以。  
* 4.**智能化自动过滤**null和空字符串，不用再写判断非空的代码。  
* 5.**动态/任意组合**查询条件,不需要提前准备dao接口,有新的查询需求也不用修改或添加接口。  
* 6.支持原生SQL排序,**原生语句分页**(不需要将全部数据查出来)。  
* 7.支持直接返回**Json**格式查询结果;链式编程。  
* 8.支持**存储过程**，支持原生SQL(**自定义sql**语句)，支持**事务**、**for update**，支持**批处理**操作。
* 9.支持**只查询一部分字段**。    
* 10.支持面向对象方式复杂查询、**多表查询**(无n+1问题;支持：一对一,一对多,多对一,多对多)。 
* 11.**一级缓存**，概念简单，功能强大；一级缓存也可以**像JVM一样进行细粒度调优**；**智能缓存**，支持更新配置表，**不用重启**。  
* 12.表名与实体名、字段名与属性名映射默认提供多种实现，且支持**自定义映射规则扩展**。  
* 13.**多种DB**支持轻松扩展。 
* 14.**无**第三方插件依赖。  
* 15.提供表对应的javabean**自动生成工具**，Javaweb**后端代码**根据模板自动生成;能打印非占位符的**可执行sql**,方便调试。  
* 16.支持**读写分离**一主多从, 仅**分库**等**多数据源**模式。  
* 17.**分布式**环境下生成**连续单调递增**(在一个workerid内),**全局唯一**数字**id**。  
* 18.**支持同库分表,动态表名映射**。  

## [详细功能介绍](../../../bee/blob/master/Changed_Log.md) : 

**V1.0**  

单表Suid(select,update,insert,delete)面向对象方式的操作,方法名与数据库Suid操作对应.  
自动通过DB的表或视图生成Javabean(V1.0支持MySQL,MariaDB,其它数据库有部分类型未做映射处理,客户可通过在配置文件添加配置信息实现).  
约定优于配置:Javabean没有注解,没有xml,只是纯的Javabean即可(为什么要给Javabean那么重的负担呢??!!!).  
自动映射表的列与的字段.  
Javabean支持原生类型:int,double等.  
使用PreparedStatement防止SQL注入攻击.  
Procedure存储过程支持.  
原生SQL支持.  
批处理操作支持.  
Transaction事务支持.  
自动过滤null和空字符串(作为默认实现).  
SQL中函数:MAX,MIN,SUM,AVG,COUNT支持.  
SQL中排序,分页支持.  
支持只查询一部分字段.  
动态/任意组合查询条件,不需要提前准备dao接口,有新的查询需求也不用修改或添加接口.  
所有的suid操作都是用同一个bee接口,不用再定义任何新的dao接口,更不用实现dao接口.  
用户/开发者仅需要关注bee接口如何调用即可.  

**V1.1**  
**直接返回Json**格式查询结果支持.  
Procedure存储过程支持(CallableStatement.executeQuery).  

**V1.2**  
用户自定义sql支持#{para}占位参数设置，如：eg:name=#{name}; like查询 支持:#{%para%},#{%para},#{para%} 

**V1.3**  
增加:select/update链式编程

**V1.4**  
增加: selectById,deleteById  
增加: public <T> List<T> select(T entity,String selectFields,int start,int size)  
增加: selectJson add config:ignoreNull;date,time,timestamp Wit hMillisecond format  
增加: List<String[]> select(String sql), add config:nullToEmptyString  
完善查询结果缓存机制(一级缓存可**对用户编程透明**,也可进行细粒度配置调优控制)  
**一级缓存**即可支持: **不缓存列表,永久缓存列表,永久缓存且可更新列表**,结果集超过一定大小可不放缓存 等细粒度配置调优控制.  
增加: SysValue注解  

**V1.5**  
1.增加NameTranslate接口和默认转换实现类，支持Java与DB命名转换规则自定义。  
2.支持jdbcTypeToFieldType-{DbName}.properties,自定义DB列转Java的类型。  
3.完善Oracle类型转换；**多种DB支持轻松扩展**:可将某种DB特有的类型映射关系放在文件:  
  jdbcTypeToFieldType-{DbName}.properties，即可完成自动转换。  
4.增加entity实体名与表名的特殊映射关系支持,优化表名转实体名的情况。  
5.过滤非法实体类型。  
6.增加**文件生成工具**。  
7.完善分页功能,并支持自定义扩展接口。  
8.修复Oracle JDBC操作数据库ORA-00911 bug。  
9.增加op方法重载，默认为等号(in UpdateImpl and SelectImpl)。  
10.增加OperationType重载(in enum Op)。  

**V1.6**  
1.Suid增加**面向对象方式复杂查询**支持.  
  Suid接口增加方法:public <T> List<T> select(T entity,Condition condition);  
   支持范围查询;支持同时使用范围查询、模糊查询、in、>、>=、<、<=、分组、having过滤、排序、分页等复杂查询。  
2.SuidRich增加面向对象方式复杂查询支持.  
SuidRich接口增加方法:  
select(T entity, IncludeType includeType, Condition condition)  
selectJson(T entity, IncludeType includeType, Condition condition)  
3.SuidRich增加更新方法:  
updateBy(T entity,String whereFieldList)  
updateBy(T entity,String whereFieldList,IncludeType includeType)  
4.add SqlNullException in PreparedSqlLib.  
V1.6.1  
1.PreparedSql相关方法添加start,size分页参数，使自定义sql查询的分页更方便，  
    自定义的sql语句中不用带分页部分,移植性更高。  
2.PreparedSql的modify加注解:@Deprecated  
3.Condition的方法getFieldSet返回值由Set改为Set<String>。  
4.fix bug.ConditionImpl的fieldSet需要记录在between方法使用的记录。  

**V1.7**  
增加面向对象方式**多表查询**支持.  
1.**支持一对一,一对多,多对一,多对多**。  
2.支持join(inner join), left join,right join, no join。  
3.单表、多表的查询操作互不干扰。  
**V1.7.1**  
创建javabean支持添加注释.  
创建javabean的类新增getColumnNames,getFieldNames方法.  
修复自定义sql没有占位符时出现的bug.  
修复在PreparedSqlLib分页的bug.  
完善在CustomSql中sql字符串为null的异常.  
修复关于缓存的bug.  
修复SelectImpl的bug. 
修复内连接条件风格转换的bug.  
添加FileCreator接口.  
**V1.7.2**   
可以通过配置选择已实现的命名转换规则.  
完善BeeFactory类的功能.  
调整SQL输出日志格式.  
日期格式可以通过配置定义.  
[将测试/使用实例迁移到bee-exam项目](../../../bee-exam).  
添加类FileLogger,用于将日志记录到文件中.  
可以通过配置控制是否输出日志级别.  
完善测试用例/使用样例.  
支持使用模板快速生成文件.  
在Suid接口增加方法 delete(T entity, Condition condition).  
支持配置是否允许删除一个表的所有数据(在面向对象方式下有效).  
SuidRich 新增两个方法:  
  updateBy(T entity,String whereFields,Condition condition)  
  update(T entity,String updateFields,Condition condition)  
新增不使用缓存配置支持.  
Condition接口新增方法setAdd,setMultiply用于设置SQL中update操作的set设置.  

**V1.8**   
**增加分布式特性:**   
1.添加多数据源支持(读写分离一主多从, 仅分库).  
增加多数据源无需改动Java代码(对编码透明)，只需添加配置信息即可. 
添加多数据源路由接口. 
添加多数据源路由实现算法.  
添加多数据源配置.  
支持配置信息刷新.  
2.分布式环境下生成全局唯一数字递增id.	  
分布式环境下生成连续单调递增(在一个workerid内),全局唯一数字id.  
3.Bee分布式唯一id算法特性:不依赖时钟,workerid可配置,易扩展.	  
具体算法实现:SerialUniqueId,OneTimeSnowflakeId,PearFlowerId.		  
提供id生成工厂:GenIdFactory,且可配置id生成器具体实现类.	  
4.可为所有表的Long型id字段自动生成全局唯一id主键.  
**增强功能:**   
5.同库分表支持,动态表名映射支持.  
实体与任意表名映射支持. 
Suid add one method:	
public Suid setDynamicParameter(String para,String value);  
add 2 annotation:@Table,@Entity.  
6.添加for update功能,用于锁住某个表的一些记录.  
public Condition forUpdate()  
7.增加高级更新设置值支持,复杂查询、多表查询支持只查部分字段:	
在Condition添加5个新方法:  
public Condition setAdd(String field, String fieldName)  
public Condition setMultiply(String field, String fieldName)  
public Condition set(String fieldNmae, Number num)  
public Condition set(String fieldNmae, String value)  
public Condition selectField(String fieldList)  
8.支持SQL输出日志配置,占位参数可显示参数,可输出直接可执行的sql:  
bee.osql.showSQL.showType=true  
bee.osql.showSQL.showExecutableSql=true  
9.SuidRich添加一个新方法:  
public <T> int update(T entity,Condition condition);  
PreparedSql添加三个新方法:  
public String selectJson(String sqlStr);  
public List<String[]> select(String sql);  
public String selectFun(String sql);  
10.Oracle DATE字段在Javabean里转成java.sql.Date存入数据库时会丢失时分秒，
转成Timestamp可以解决这个问题。  
11.GenFiles根据模板自动生成文件代码添加支持首字母大写,如: #{entityName?up1}.  
**修复原有问题:**   
12.bug修复:缓存key生成;批插入后清缓存.  
修复缺陷:解析json时多余的逗号错误.  
修复null bug,关于方法:PreparedSql's method select(String sql,Object preValues[]).  	

快速开始:
=========	
## 1. 引入Bee  
#### 1.1 maven工程,添加如下依赖  

```xml
		<dependency>
			<groupId>org.teasoft</groupId>
			<artifactId>bee</artifactId>
			<version>1.7.2</version>
		</dependency>

		<dependency>
			<groupId>org.teasoft</groupId>
			<artifactId>honey</artifactId>
			<version>1.7.2</version>
		</dependency>
```

#### 1.2  也可以直接下载jar文件  	
		
## 2. 创建数据库和表  

举例如下:  
创建一个数据库,默认名称为bee.  
可以用[init-data(user-orders)-mysql.sql](../../../bee-exam/blob/master/src/main/resources/init-data(user-orders)-mysql.sql)脚本创建两个表和插入初始化数据.  

## 3. 更新数据库的配置信息(在bee.properties)  
注:如果还没有bee.properties文件,可以自己新建一个.  
也可以配置数据源(此处只是一个例子).  

bee.databaseName=mysql  
bee.db.driverName = com.mysql.jdbc.Driver  
bee.db.url =jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8  
bee.db.username = root  
bee.db.password =  

## 4. 运行下面的 java代码    

```java
		
import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.Suid;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.example.entity.Orders;

/**
 * @author Kingstar
 * @since  1.0
 */
public class SuidExam {
	
	public static void main(String[] args) {

		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		
		//需要先生成相应的Javabean
		Orders orders1=new Orders();
		orders1.setId(100001L);
		orders1.setName("Bee(ORM Framework)");
		
		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
		List<Orders> list1 =suid.select(orders1);  //select
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).toString());
		}
		
		orders1.setName("Bee--ORM Framework");
		//默认只更新需要更新的字段. 过滤条件默认只用id字段,其它需求可用SuidRich中的方法.
		int updateNum=suid.update(orders1);   //update
		System.out.println("update record:"+updateNum);
		
		Orders orders2=new Orders();
		orders2.setUserid("bee");
		orders2.setName("Bee(ORM Framework)");
		orders2.setTotal(new BigDecimal(91.99));
		orders2.setRemark("");  //empty String test
		
		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动插入数据库中. 
		//方便结合DB插值,如id自动增长,由DB插入;createtime由DB默认插入
		int insertNum=suid.insert(orders2); //insert
		System.out.println("insert record:"+insertNum);
		
		//默认不处理null和空字符串.不用再写一堆的判断;其它有值的字段全部自动作为过滤条件
//		int deleteNum=suid.delete(orders2);   //delete
//		System.out.println("delete record:"+deleteNum);
		
		List<Orders> list2 =suid.select(orders1); //select  confirm the data
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).toString());
		}
	}

}
//注意: 事务,分页,排序,范围查询,查询结果直接返回json等都支持,这里只是一个入门例子.

```

综合应用:
=========	
**Java快速编程, 让Java的开发速度超过php和Rails。**  

**更快的开发Java Web的新组合：**  
[Bee+Spring+SpringMVC](../../../../aiteasoft/bee-spring-springmvc)  

**更快的开发Spring Cloud微服务的新组合：**  
[Bee + Spring Boot](../../../bee-springboot)  

......  
  
联系与欢迎:
=========	
#### 作者的电子邮箱email:    honeysoft@126.com  
#### 如有任何相关建议,欢迎给作者发邮件,不胜感激!  
#### 更多设计思想,请关注微信公众号: 软件设计活跃区  
<img src="weixin.jpg" width="200" heigh="200">

#### 为了能及时解答大家的疑问，可以加入Bee的QQ技术群(ORM框架Bee交流群)：992650213

#### 同时,也欢迎你加入到Bee框架的开发之中,相信有你的加入,Bee会更加美好! 
