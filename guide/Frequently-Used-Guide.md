Bee常用大全  
Frequently Used Guide    

# 1、快速开始  
## 1.1 引入Bee    
#### maven工程,添加如下依赖    
  
```xml  
		<dependency>  
			<groupId>org.teasoft</groupId>  
			<artifactId>bee</artifactId>  
			<version>1.11</version>  
		</dependency>  
		<dependency>  
			<groupId>org.teasoft</groupId>  
			<artifactId>honey</artifactId>  
			<version>1.11</version>  
		</dependency>  
		<!--for log framework,Excel(poi) -->  
		<dependency>  
			<groupId>org.teasoft</groupId>  
			<artifactId>bee-ext</artifactId>  
			<version>1.11</version>  
		</dependency>  
```  
    
## 1.2 创建DB及表，自动生成Javabean    
参考源码官网,快速开始    
[https://gitee.com/automvc/bee](https://gitee.com/automvc/bee)  
或:    
[https://github.com/automvc/bee](https://github.com/automvc/bee)  
  
## 1.3. 添加必要的配置(在bee.properties)  
  
```properties  
  
bee.db.dbName=MySQL    
bee.db.driverName = com.mysql.jdbc.Driver    
#bee.db.url =jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8    
bee.db.url =jdbc:mysql://127.0.0.1:3306/bee?characterEncoding=UTF-8&useSSL=false    
bee.db.username = root    
bee.db.password =    
  
```  
  
## 1.4 运行下面的 java代码      
  
```java  
		  
import java.math.BigDecimal;  
import java.util.List;  
  
import org.teasoft.bee.osql.Suid;  
import org.teasoft.honey.osql.core.BeeFactoryHelper;  
  
/**  
 * 查,改,增,删 Suid (select,update,insert,delete)实例  
 * @author Kingstar  
 * @since  1.0  
 */  
public class SuidExam {  
	  
	public static void main(String[] args) {  
  
		Suid suid = BeeFactoryHelper.getSuid();
//	    Suid suid=BF.getSuid();//从1.9.8开始,BF可以加快输入  
		Orders orders1 = new Orders();
		List<Orders> list1 = suid.select(orders1);

		// 2:update更新实例
		orders1.setName("Bee--ORM Framework");
		orders1.setId(1000L);
		// 默认只更新需要更新的字段. 过滤条件默认只用id字段,其它需求可用SuidRich中的方法.
		int updateNum = suid.update(orders1); // update

		Orders orders2 = new Orders();
		orders2.setUserid("bee");
		orders2.setRemark(""); // 默认过滤空字符和null
		int insertNum = suid.insert(orders2); // 3. 插入 insert

		// 4:delete 删除实例
		// 默认不处理null和空字符串.其它有值的字段全部自动作为过滤条件
		// int deleteNum=suid.delete(orders2); //delete 
		  
	}  
}  
//注意: 事务,分页,排序,范围查询,查询结果直接返回json等都支持,这里只是一个入门例子.  
//更加应用参考,请查看: 更多例子   和    综合应用 .  
  
```  
  
  
## 1.5 常用配置  
  
```properties  
  
#常用配置:  
#开启查询结果字段类型转换,将支持更多类型  
bee.osql.openFieldTypeHandler=true  
  
#如果允许删除和更新整张表,需要去掉注释  
#默认不允许，是为了生产更安全  
#bee.osql.notDeleteWholeRecords=false  
#bee.osql.notUpdateWholeRecords=false  
  
#命名转换配置, 1 : order_no<-->orderNo(DB<-->Java),   
#2: ORDER_NO<-->orderNo(DB<-->Java), 3: original 原样保留  
bee.osql.naming.translateType=1  
  
#日志打印配置  
#打印日志  
bee.osql.showSQL=true  
#显示参数的类型  
bee.osql.showSql.showType=true  
#生成可执行的sql(不使用占位符，可直接运行,方便开发阶段调试)  
bee.osql.showSql.showExecutableSql=true  
  
#日志类型配置， fileLogger 输出到文件; systemLogger 控制台输出  
#log4j>slf4j>log4j2>androidLog>systemLogger>fileLogger>noLogging>jdkLog>commonsLog  
bee.osql.loggerType=systemLogger  
  
#主键id生成器  #V1.17开始，可以使用注解@GenId,@GenUUID  
#bee.distribution.genid开头的配置  
  
#缓存配置 1.11之前，是单例模式；从V1.11开始，使用原型模式，相对会更加安全。但要求  
#实体类实现序列化接口。若想兼容1.11之前的情况，使用bee.osql.cache.prototype=0；  
#详情如下：  
#since V1.11  
#prototype: 0 not prototype, but faster; 1:prototype,if have NotSerializableException, do not put in cache, slower, but safer; 2 : prototype, but have NotSerializableException,return original    
#high safe cache,the javabean(entity) need implements Serializable interface.  
bee.osql.cache.prototype=1  
  
  
#多数据源时配置 #V1.11 多数据源时，可以在生成Suid等对象时指定数据源  
bee.dosql.multiDS.enable=true  
#是否同时使用多种不同的数据库，比如同时用mysql,oracle  
#bee.dosql.multiDS.differentDbType=true  
#默认数据源  
#bee.dosql.multiDS.defalutDS=ds1  
# 1:only r/w, one main and more sub-database;  2:only more database (table name is same)  
#bee.dosql.multiDS.type=1  
  
#java代码配置方式:  
#HoneyConfig.getHoneyConfig().multiDS_enable = true;  
#HoneyConfig.getHoneyConfig().multiDS_type = 1;  
#HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;  
#HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds1";  
  
```  
  
  
## 1.6 其它实例  
[HarmonyOS 鸿蒙使用 ORM Bee 访问数据库实例](https://my.oschina.net/u/4111850/blog/5542608)    
  
[Android环境使用Bee实例](https://my.oschina.net/u/4111850/blog/5538992)    
  
  
# 2、约定与自定义  
  
## 2.1 我们的约定(约定优于配置)    
### 2.1.1 字段值的约定   
在select,update,insert,delete操作中，    
我们约定默认不处理null和空字符串；其它有值的字段全部会解析；      
在select和delete两个操作中，会自动作为过滤条件(对应SQL语句的where部分).     
默认操作符是"=".     
   
### 2.1.2 命名转换的约定   
#命名转换配置, 1 : order_no<-->orderNo(DB<-->Java) 最常用，可用于mysql等多种DB,     
#2: ORDER_NO<-->orderNo(DB<-->Java) Oracle命名风格, 3: original 原样保留    
bee.osql.naming.translateType=1    
  
### 2.1.3 主键的约定  
主键名称默认是"id"(小写)    
采用约定，可以更省事，系统运行效率也更高。   
  
### 2.1.3 Suid.update(T entity)    
默认主键作为过虑条件，其它非空且非null的作为要更新的新值。    
默认操作符是"=".     
  
### 2.1.4 缓存的约定  
从V1.11开始，缓存使用相对安全的原型模式；默认是实体没有实现序列化，则不放缓存(值为1)。  
有0，1，2三种模式可选  
bee.osql.cache.prototype=1  
  
一级缓存，概念简单，功能强大；一级缓存也可以像JVM一样进行细粒度调优；支持可更新的长久缓存列表，更新配置表，不需要重启。天生抵御缓存穿透 。   
  
### 2.1.5 SQL关键字大小写  
默认是小写  
#value is:lower,upper  
bee.osql.sqlKeyWordCase=lower  
  
### 2.1.6 与众不同的  
#### Bee不需要xml映射文件  
#### Bee不需要mapping接口  
#### 动态/任意组合查询条件,不需要提前准备dao接口,有新的查询需求也不用修改或添加接口。  
#### 无第三方插件依赖；可零配置使用。    
部分数据库至少要配置:    
bee.db.url =    
bee.db.username =    
#### 性能好:接近JDBC的速度；文件小：Bee V1.8 仅217k, V1.9.5 仅315k，V1.9.8 仅310k。    
#### 同时支持 JDBC (比如 JavaWeb),Android 和 Harmony    
#### 提供辅助功能，提高开发效率    
自动生成表对应的Javabean，根据Javabean创建表，Javaweb后端代码    
读取Excel；支持中文金额大小写转换;    
复杂查询前后端可自动解析等.    
  
  
### 2.1.7 其它   
默认不开启二级缓存  
bee.osql.cache.useLevelTwo=false  
默认不开启多数据源  
bee.dosql.multiDS.enable  
#默认@Column转换功能是关闭，若要使用，需要设置
bee.osql.openDefineColumn=true
  
## 2.2 约定情况不满足需求时    
### 2.2.1 想要处理null和空字符      
SuidRich里的方法，有IncludeType参数的，可以进行相关设置.        
或者通过Condition设置IncludeType. Suid,SuidRich有不少方法有Condition参数。        
public Condition setIncludeType(IncludeType includeType);        
IncludeType中:INCLUDE_NULL包括null值，INCLUDE_EMPTY包括空字符，        
INCLUDE_BOTH包括以上两者。      
  
### 2.2.2 默认命名转换不满足需求    
可自定义转换方法。 配置，可参考: FAQ_CN.md  第41点.    
表名与实体名不一致，使用@Table。    
字段不一致使用@column(V1.17提供转换实现支持)       
官方不推荐使用@column注解,在API文档里记录有好几种可以替代该注解的方案. 
#默认@Column转换功能是关闭，若要使用，需要设置
bee.osql.openDefineColumn=true     
V1.17 兼容JPA的@Table,@column(只需要设置name="xxx").    
Bee支持在@Table注解里使用变量。如:@Table("Orders${month}"),通过设置month的值，可以映射到不同的历史订单表。    
某些名山规范，建议boolean型变量在entity改字段名，不是一个好主意，只会自找麻烦。  

@Ignore
忽略不想转换的字段.
 * <br>建议尽可能少用该注解,因为很多时候你可以用默认忽略null/空字符的特性达到同样的效果.
 
@JustFetch
用于查询并获取记录信息,但不作为过滤条件.
eg:
@ JustFetch("CONCAT(fisrt_name,last_name)") //多表查询时,若字段会混淆,需要带表名
private String fullname;
--> select CONCAT(fisrt_name,last_name) as fullname
map field name and column name,but can not transform to where part
eg:
@ JustFetch("name")
private String name2;
-->select name as name2
  
### 2.2.3 主键名称不是id    
主键不是Id,使用@PrimaryKey    
Suid.update(T entity) 会相应选取主键作为过滤条件。其它相关方法也有类似处理。    
V1.17 兼容JPA的@Id字段，与@PrimaryKey有同等效果。     
  
### 2.2.4 主键字段类型不是Long;主键生成策略    
在Suid,SuidRich的insertAndReturnId方法，返回值是Long值。  
V1.17   支持主键字段是Integer/int时，也可使用insertAndReturnId,返回的long型值是在int型范围内的。    
主键字段是String类型,若是Long型数值的字符串,也可以使用insertAndReturnId(V1.17使用@GenId注解可以).    
当使用非数字的字符串作为主键，如@GenUUID生成的字段，则不能使用insertAndReturnId.  
  
主键自动生成      
Bee框架，主键策略是一种松耦合的设计。实体里有可设置值，也可以自动生成。    
有一个是否覆盖的开关，当实体有值时，即可配置了自动生成，也可以不覆盖原有的值(此时，自动生成被忽略)    
统一配置:    
使用bee.properties里bee.distribution.genid开头的相关配置。    
在bee.properties配置的好处是:可以统一配置，不会侵入代码。      
V1.17可以使用@GenId,@GenUUID注解生成主键值。    
  
  
## 2.3 只查部分字段  
使用SuidRich接口,      
public <T> List<T> select(T entity,String selectFields);    
public <T> List<T> select(T entity,String selectFields,int start,int size);    
public <T> List<String[]> selectString(T entity,String... selectFields);       
public <T> String selectJson(T entity, String selectFields);    
public <T> String selectJson(T entity, String selectFields, int start, int size);    
  
selectFields变量为要查询的字段，多个时，使用逗号隔开。    
另外，String... selectFields是支持变参方式。    
Condition接口也有指定查询字段的方法。    
public Condition selectField(String... fieldList);    
SuidRich或Suid接口中，有很多方法有Condition参数.    
  
## 2.4 只更新部分字段或更新时只选用部分字段作为条件      
首先需要清楚，更新需要分清新值和旧值。      
新值就是我们想更新的值，对应SQL UPDATE语句中的SET部分。    
旧值一般作为过滤条件(新旧值一样，相当于没更新，无意义),对应SQL中的where部分，用于过滤，选出要的记录。    
 使用SuidRich中，update或updateBy相关方法。    
 一个实体，我们指定了要更新的部分，另外部分的字段则作为旧值用于where;    
剩下的问题就是是否要处理null和空字符(参考2.2.1).     
  
//		int updateBy(T entity,String whereFields);  
		suidRich.updateBy(noid, "uuid,name"); //updateBy, 通过"uuid,name"字段修改记录,"uuid,name"会作为where的过滤条件  
		  
//		int update(T entity,String updateFields);  
		suidRich.update(noid, "num"); //只更新num字段, 则其它字段作为where过滤条件  
  
(十三)：Bee面向对象update高级用法说明  
https://blog.csdn.net/abckingaa/article/details/120932780  
  
  
## 2.5 分页(SQL原生分页,性能好)  
原生语句分页(不需要将全部数据查出来)  
SuidRich中有带有int start,int size参数的查询方法都可以分页,如:  
public <T> List<T> select(T entity,String selectFields,int start,int size);  
public <T> String selectJson(T entity, String selectFields, int start, int size);  
Condition接口也有指定分页的方法。  
	public Condition start(Integer start);  
	public Condition size(Integer size);  
SuidRich或Suid接口中，有很多方法有Condition参数.  
  
start是记录开始的下标；Bee智能识别不同数据库是从0还是1作为首条记录。  
size是一页的记录数量；  
支持的数据库包括:MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL,SQL Server  
  
## 2.6 范围查询,排序  
https://blog.csdn.net/abckingaa/article/details/120897275  
  
Suid suid = BeeFactory.getHoneyFactory().getSuid();  
    Orders orders = new Orders();  
   
    orders.setName("Bee(ORM Framework)"); //等于的条件,会默认转换  
    orders.setTotal(new BigDecimal("100"));  //不会再处理.因为between已有用  
   
     Condition condition=new ConditionImpl();  
     condition  
     .op("userid", Op.like, "bee%") //模糊查询  
     .between("total", 90, 100)     //total字段的范围查询  
     .between("createtime","2020-03-01","2020-03-03")  
     .orderBy("userid",OrderType.ASC) //排序  
     .start(0).size(10)              //分页  
     ;  
       
    List<Orders> list2 = suid.select(orders, condition);  
    for (int i = 0; i < list2.size(); i++) {  
      Logger.info(list2.get(i).toString());  
    }  
  
## 2.7 事务  
(九)：Bee如何使用事务Transaction  
https://blog.csdn.net/abckingaa/article/details/120897426  
  
V1.17可使用@Tran注解。该注解的实现，依赖于aop框架。测试使用的是spring aop.  
  
## 2.8 查询结果直接返回json等  
使用SuidRich接口,    
public <T> String selectJson(T entity, String selectFields);  
public <T> String selectJson(T entity, String selectFields, int start, int size);  
(八): 查询结果直接返回Json格式数据  
https://blog.csdn.net/abckingaa/article/details/120897417  
  
## 2.9 多表查询  
无n+1问题  
(六): ORM Bee多表查询(面向对象方式)  
https://blog.csdn.net/abckingaa/article/details/120897283  
(十七)ORM Bee多表关联查询实例,及用List和不用List的区别  
https://blog.csdn.net/abckingaa/article/details/120933357  
  
## 2.10 多数据源  
多数据源时，核心问题是:需要告诉框架，在操作数据时，如何路由到某一个数据源。  
可以在bee.properties配置，通过包的名称或表名称与具体的数据源名称关联。  
给出实例。  
https://blog.csdn.net/abckingaa/article/details/121664398   
(十四)：读写分离一主多从, 仅分库等多数据源使用指南  
(十五)：Bee多数据源:同库分表使用指南  
(十七)ORM Bee多表关联查询实例,及用List和不用List的区别  
(二十一)ORM框架Bee,多数据源Java编码设置实例  
(二十二)ORM框架Bee,Spring配置多数据源实例  
  
也可以在代码中，创建Suid等对象时，指定数据源。这种方式，可参考以下实例。  
(三十七)Bee如何同时使用不同数据源实例  
https://blog.csdn.net/abckingaa/article/details/125241550  
  
  
## 2.11 其它资料  
### 2.11.1 ORM Bee资料大全  
https://blog.csdn.net/abckingaa/article/details/121664398   
### 2.11.2 FAQ:  
https://github.com/automvc/bee/blob/master/FAQ_CN.md  
或:  
https://gitee.com/automvc/bee/blob/master/FAQ_CN.md  
  
### 2.11.3 综合应用实例  
https://github.com/automvc/bee/blob/master/README_CN.md  
或  
https://gitee.com/automvc/bee  
搜索:  
综合应用  
### 2.11.4 API DOC  
API-V1.11(最新版) 下载代码含有 bee-1.11中文和英文版API,bee-1.11中文版源码  