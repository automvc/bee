
Bee
=========
#### 工欲善其事必先利其器！——《论语·卫灵公》    
**Bee** 是一个 Java ORM框架利器, 它的开发速度快, 编码少, 还很简单！       
**Bee** 编码复杂度是O(1)，即用了Bee，**无论多少个表**,你都可以不用另外再写dao代码。  


## 详细功能介绍: 

**多种DB**支持轻松扩展(MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL等直接可用)。 

**V1.0**  
单表Suid(select,update,insert,delete)面向对象方式的操作,方法名与数据库Suid操作对应.  
自动通过DB的表或视图生成Javabean.  
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
增加: public &lt;T> List&lt;T> select(T entity,String selectFields,int start,int size)  
增加: selectJson add config:ignoreNull;date,time,timestamp Wit hMillisecond format  
增加: List<String[]> select(String sql), add config:nullToEmptyString  
完善查询结果缓存机制(一级缓存可**对用户编程透明**,也可进行细粒度配置调优控制)  
**一级缓存**即可支持: **不缓存列表,永久缓存列表,可更新的长久缓存列表**,结果集超过一定大小可不放缓存 等细粒度配置调优控制.  
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
  Suid接口增加方法:public &lt;T> List&lt;T> select(T entity,Condition condition);  
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
public &lt;T> int update(T entity,Condition condition);  
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
修复关于oracle多表查询分页bug.  
	

**v1.8.15**(2020-10-01 3节日)  
1.增强对数据库H2,SQLite,PostgreSQL的支持.  
2.优化分页功能,分页参数也用占位符.  
3.可零配置使用.  
4.完善梨花算法经常不使用时,产生连续尾数为0的偶数的问题(SerialUniqueId和OneTimeSnowflakeId这两种ID生成算法不会有这些缺陷).  
5.完善日志Log功能.  
6.修复json转换bug.  

**v1.8.99**(2020-10-25 重阳节)  
1.SQL关键字支持可配置大写或小写输出.  
2.SQL缓存key可用MD5字符.  
3.优化利用HoneyConfig设置DB信息的方式.  
4.修复关于checkSelectField的bug.  

**V1.9**  
SuidRich新增支持List参数的批量插入方法.  
增强SuidRich功能, SuidRich增加方法:  
	public <T> List<String[]> selectString(T entity,Condition condition);  
	public <T> int updateById(T entity,Condition condition);  
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun, Condition condition);  
	public <T> int count(T entity);  
	public <T> int count(T entity, Condition condition);  
	public <T> boolean exist(T entity); //判断记录是否存在  
SuidRich调整selectById方法且String类型参数的id智能识别Javabean的id类型.  
Suid新增insertAndReturnId方法.  
加强聚合函数cont,sum,avg,min,max功能,Condition增加方法:  
	public Condition selectFun(FunctionType functionType,String fieldForFun);  
	public Condition selectFun(FunctionType functionType,String fieldForFun,String alias);  
Condition 添加方法:opWithField,setWithField 支持像:field1=field2的表达式  
Condition 添加方法:selectDistinctField,支持distinct像 select distinct(userid) from table_name  
MapSuid,无需Javabean，用map承载需要转换的实体信息，操作数据库(查询,插入,删除数据).  
支持读取Excel(*.xls,*.xlsx),并将数据转成List<String[]>,且导入到数据库(bee-ext).  
多表关联查询支持多个关联条件.  
多个ORM操作使用同一个Connection.  
支持同时使用不同数据库(多个数据源).  
支持长度大于0空字符串忽略处理,如"     ".  
增加Ignore注解，忽略Javabean字段，不进行转换.  
用模板生成文件支持自定义起止标签.  
完善DB连接管理.  
加强代码质量.  
增强链式编程:Select,Update.  
调整bee.properties,HoneyConfig配置信息.  
整合Spring boot,提供bee-spring-boot-starter.  
支持利用Javabean生成表.  
修复多表分页查询时,同名字段在部分数据库会混淆的缺陷(oracle).  
修复缺陷:update默认主键为id时,无id字段或id为null时,异常处理.  
修复缺陷:cache bug.  
修复缺陷:有关GenId的 getRangeId(int sizeOfIds)方法.  
修复缺陷:jdk 11下,LoggerFactory在配置log4j2时,报错.  
强烈建议:使用视图时,声明视图不放缓存(因会产生脏数据).    

**V1.9.8**(2021中秋节)  
SuidRich增加4个方法:  
public <T> int save(T entity);  
public <T> int update(T oldEntity,T newEntity);  
public <T> String selectJson(T entity, String selectField);  
public <T> String selectJson(T entity, String selectField, int start, int size);  

MoreTable(多表查询):  
支持子表实体字段为List类型的多表关联查询.   
支持两个子表的join关联查询(inner join,right join, left join);  
支持一个子表里还有一个子表的关联查询.   
修复问题:当一个子表的属性都为null时,子表字段直接设置为null.   
注解 JoinTable添加方法:subClass()用于List类型字段的多表关联查询.   
Condition新增方法,用于在关联查询时的on表达式达到提前过滤数据:  
public Condition opOn(String field, Op Op, Object value);  

MapSuid(不用Javabean实体结构操作数据库):  
新增update,count,查询分页,新增和调整insert and insertAndReturnId.  
至此，MapSuid的select,update,insert,delete及分页功能已完备.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSql.  
add method count(MapSql mapSql),update(MapSql mapSql),insertAndReturnId(MapSql mapSql),support page in MapSuid.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSqlImpl.  
add method toUpdateSqlByMap ,toCountSqlByMap ,support page in MapSqlProcessor.  
add method count(MapSql mapSql),update(MapSql mapSql),support page in MapSuidImpl.  
MapSuidImpl change two different method:insert(MapSql mapSql) & insertAndReturnId(MapSql mapSql)  

PreparedSqlLib新增selectMapList方法.  
多数据源读写模式,支持不同类型数据源,方便数据库间转移数据.  
Logger: 两个方法支持有Throwable参数.  
sql输出日志支持logger不同级别输出设置.  
增加流的工具类StreamUtil.  
ObjectUtils增加一个方法: isTrue(Boolean b)  
增强检测字段合法性,包括MapSuid使用的字段.  
use LinkedHashMap in List&lt;Map> result for selectMapList(String sql).  
Condition支持condition.set("fieldName", null).  
selectJson支持通过配置将long转为string  
增强autoGenBean ,支持生成Json格式的SQL脚本(SQL Json Script).  
添加通用查询功能支持(简化后端复杂查询编程).  
增强多线程支持.  
可指定bee.properties所在路径.  
自动生成Javabean(GenBean)支持类型:JSON,TEXT.  

fix bug for ExecutableSql.  
transfer the the field of 'order by'.  
fix null bug in create() of ObjectCreatorFactory.  
fix bug for max column number(excel in bee-ext).  
fix bug about HoneyContext.  
fix bug about checkPackageByClass.  
fix bug about multi-thread safe in ConditionHelper.  

**V1.11**  
V1.11(**劳动节版**) 五一前更新到Maven  
各细分版本添加功能如下:  
  
V1.11.0.1.1(**2022新年版**)  
SuidRich增加方法:  
  public <T> long insertAndReturnId(T entity,IncludeType includeType);  
PreparedSql增加方法:  
  public <T> List<T> select(String sql,T returnType);  
增加声明主键支持:  
  add annotation PrimaryKey  
  MapSqlKey support PrimaryKey  
可用BF代替BeeFactoryHelper加快输入  
增强:读写模式配置信息去除空格  
fix a bug for naming transfer  

V1.11.0.2.1(**2022春节版**)  
拦截器、多租户  
add Interceptor,InterceptorChain  
add DefaultInterceptor,CommInterceptorChain,DefaultInterceptorChain  

V1.11.0.2.4(**2022北京冬奥会版**)  
二级缓存扩展支持  
Redis缓存支持  
add BeeExtCache,DefaultBeeExtCache  
add BeeExtRedisCache  

V1.11.0.2.15(**2022元宵节版**)  
添加注解:Datetime,Createtime,Updatetime;JustFetch  
添加Jndi数据源支持  
检测MapSqlKey的值  

V1.11.0.2.20(**荣耀**)  
multi-DS同时使用不同类型DB优化  
支持同时使用多种数据库(如同时使用Mysql,Oracle,SQL Server)  
PreparedSql(自定义sql),MapSuid:拦截器，多数据源支持  
Suid,PreparedSql,MapSuid支持设置数据源名称,获取拦截器链  
Suid,PreparedSql,MapSuid,MoreTable增加方法:setDataSourceName,getDataSourceName,getInterceptorChain  
增加注解:  
AnnotationHandler,AutoSetString自动设置字符值  
Desensitize,敏感信息模糊处理  
ReplaceInto,MySQL replace into转换  
MultiTenancy多租户  
BeforeReturnAnnotationHandler,AbstractDictI18nDefaultHandler  
Dict字典转化  
DictI18n多语言国际化字典转化  

V1.11.0.2.28  (**Special Day**)  
增加ShardingStruct为分库分表作准备  
Column列名与属性名映射扩展支持  
支持自定义TypeHandler,处理查询的ResultSet结果  
PreparedSql自定义sql支持多表查询,返回多表关联Javabean结构数据  
fixed bug:  
多表查询同一个实体自我关联查询禁止自我多次循环  

V1.11.0.3.8  (**Lady First**)  
增加SetParaTypeConvert转化PreparedStatement参数.  
Javabean使用java.util.Date类型,进行SUID作兼容处理.  
SQLite获取Timestamp结果作转化处理.  
实体属性是Javabean与DB表Json类型字段在参数设置与查询结果时自动转换(使用Json注解自定义实现).  

V1.11.0.3.12  (**植树节版**)  
Ddl.java使用Javabean创建表,支持追加java与db字段类型映射,支持设置某个DB的java_dbtype类型映射.  
Ddl.java兼容原生char类型,兼容java.util.Date.  
PreparedSql自定义sql支持批量插入.  
支持在Suid等对象设置命名转换器.  
增加DbFeature方言注册器,自定义实现不同DB方言更加易用.  
支持Cassandra.  
showExecutableSql添加List,Set,Map,UUID支持.  

V1.11.0.3.20  (**春分**)  
自定义动态SQL标签,@in,@toIsNULL1,@toIsNULL2,&lt;if isNotNull>,&lt;if isNotBlank>.  
动态sql,将list转为像in (1,2,3)的语句,不需要foreach,批量插入也不需要foreach.  
分离中文API.  

V1.11.0.4.22 (**世界地球日**)  
增加Registry空接口；增加NameRegistry.  
更改Serializer接口抛出异常方式.  
MapSuid,MapSql支持解析字符串的Boolean类型.  
GenBean，还不支持的jdbc类型，提醒在哪个文件设置.  
GenBean增加支持是否覆盖原有文件设置.  
GenBean增加获取字段支持，使用字段名可以不直接使用字符串.  
SuidRich的selectString方法支持可变参数:  
 public <T> List<String[]> selectString(T entity,String... selectFields);  
CommInterceptorChain增加检测是否添加了相同类型拦截器.  
systemLogger支持设置日志级别，方便开发调试.  
Logger增加public static void debug(String msg,Throwable t)(方便开发调试).  
nocache增加日志提示.  
提高缓存安全.  
添加SPI预加载接口PreLoad.  
添加用于全局的拦截器注册器InterceptorChainRegistry.  
添加配置项:  
是否是limit offset语法分页 pagingWithLimitOffset  
是否捕获单条插入时的重复键异常 notCatchModifyDuplicateException  
是否显示单条插入时的重复键异常 notShowModifyDuplicateException  
fixed bug for type converter.  
fixed bug about @PrimaryKey in Suid update(entity).  

V1.11.0.4.29  
配置文件支持多环境差异化配置.  
SuidRich,public <T> int update(T oldEntity, T newEntity)拦截器只处理新实体newEntity.  

**V1.11** (**International Labour Day**)  
功能汇总列表:  
1)拦截器、多租户  
2)增加ShardingStruct为分库分表作准备  
3)二级缓存扩展支持  
Redis缓存支持  
4)支持自定义TypeHandler,处理查询的ResultSet结果  
     添加转换器SetParaTypeConvert转换PreparedStatement参数的类型  
5)支持在Suid等对象设置命名转换器.  
增加DbFeature方言注册器,自定义实现不同DB方言更加易用.  
6)支持Cassandra.  
7)添加Jndi数据源支持  
8)Ddl.java使用Javabean创建表,支持追加java与db字段类型映射,支持设置某个DB的java_dbtype类型映射.  
9)PreparedSql自定义sql支持批量插入.  
PreparedSql自定义sql支持多表查询,返回多表关联Javabean结构数据  
10)自定义动态SQL标签,@in,@toIsNULL1,@toIsNULL2,<if isNotNull>,<if isNotBlank>.  
动态sql,将list转为像in (1,2,3)的语句,不需要foreach,批量插入也不需要foreach.  
11)注册器:  
CalculateRegistry,计算分片算法注册器  
DbFeatureRegistry,DB方言特性注册器  
InterceptorChainRegistry,拦截器链注册器  
NameRegistry,命名转换注册器  
SetParaTypeConverterRegistry, PreparedStatement参数类型转换注册器  
TypeHandlerRegistry 查询结果转换处理注册器  
12)配置文件支持多环境差异化配置.  
  
添加注解:  
PrimaryKey,Datetime,Createtime,Updatetime;JustFetch  
AnnotationHandler,AutoSetString自动设置字符值  
Desensitize,敏感信息模糊处理  
ReplaceInto,MySQL replace into转换  
MultiTenancy多租户  
BeforeReturnAnnotationHandler,AbstractDictI18nDefaultHandler  
Dict字典转化  
DictI18n多语言国际化字典转化  
Column列名与属性名映射扩展支持  
  
增强:  
multi-DS同时使用不同类型DB优化  
 (比如,同时使用Mysql,Oracle,SQL Server)  
可用BF代替BeeFactoryHelper加快输入  
Javabean使用java.util.Date类型,进行SUID作兼容处理.  
Ddl.java兼容原生char类型,兼容java.util.Date.
SQLite获取Timestamp结果作转化处理.  
实体属性是Javabean与DB表Json类型字段在参数设置与查询结果时自动转换(使用Json注解自定义实现).
读写模式配置信息去除空格  
检测MapSqlKey的值  
增加Registry空接口；增加NameRegistry.  
更改Serializer接口抛出异常方式.  
MapSuid,MapSql支持解析字符串的Boolean类型.  
GenBean，还不支持的jdbc类型，提醒在哪个文件设置.  
GenBean增加支持是否覆盖原有文件设置.  
GenBean增加获取字段支持，使用字段名可以不直接使用字符串.  
SuidRich的selectString方法支持可变参数:  
public List<String[]> selectString(T entity,String... selectFields);  
CommInterceptorChain增加检测是否添加了相同类型拦截器.  
提高缓存安全.  
添加SPI预加载接口PreLoad.  
添加用于全局的拦截器注册器InterceptorChainRegistry.  
SuidRich,public <T> int update(T oldEntity, T newEntity)拦截器只处理新实体newEntity.  

fixed bug:  
naming transfer  
多表查询同一个实体自我关联查询禁止自我多次循环  

**V1.17(2022·中秋)**  
**新增功能**:  
1)SqlServer支持start,size两个参数分页  
2)事务注解Tran及提供与AOP协调的默认实现;支持在类级别使用  
3)**支持Android(安卓)直接使用Bee访问SQLite数据库;Bee增加Android ORM功能.**  
4)**支持HarmonyOS(鸿蒙)直接使用Bee访问SQLite数据库;Bee增加HarmonyOS ORM功能.** 
在**Harmony和Android两个环境**,可以用**同一套Bee代码访问DB**,提高代码重用,节省人力物力!  
5)支持Android日志:android.util.Log  
6)支持HarmonyOS日志:ohos.hiviewdfx.HiLog  

7)主键支持名称不叫"id",类型除了Long,可以是Integer或String  
8)支持用注解定义主键自动生成,主键值生成注解:GenId,GenUUID  
9)@Column添加默认实现(强烈建议:在新系统中不要使用该注解)  
10)@Table,@Column,@PrimaryKey(@Id),@Ignore(@Transient)可以兼容JPA相应注解(在AnnoAdapter接口定义)  
11)字段名称引用类(默认格式:实体名_F(自动生成))增加ALL_NAMES属性,可一次获取实体的所有字段值  
12)Ddl.java支持创建索引(normal,unique),联合主键  
13)动态获取JdbcToJavaType  
14)命名转换增加种类4(DbUpperAndJavaLower):数据库使用大写字母，Java使用小写字母;忽略大小写,使用的字符是一样的  
15)多种命名时,缓存添加TranslateType部分  
16)分布式id生成器,支持设置起始年份:bee.distribution.genid.startYear  

**优化与增强:**  
1)增强:GenBean生成Javabean,当id是BigDecimal时,重置为Long型  
2)优化GenBean,支持都使用默认配置  
3)Ddl: 优化创建表流程  
4)多数据源环境下,增加日志提示当前使用的是哪个数据源名称  
5)分页查询,当获取一页的数据量size为0时,直接返回emptyList  
6)增强:SQLite日期类型 (date) 匹配转换支持  
7)优化缓存  
8)condition.op(fieldName, Op.in, Value)增加支持List,Set,Number Array,单个Number元素  
9)condition.opOn(fieldName, Op.in, Value) Value限定只支持Number和String  
10)增强:like;Op添加likeLeft,likeRight,likeLeftRight(参数值由框架负责转义);打印SQL日志作相应转义  
11)增强:ExcelReader数据列数目动态计算  
12)增强:SQLite日期类型 (date) 匹配转换支持  
13)链式编程SelectImpl,UpdateImpl调整字段检测.  

fixed bug:
1)level 2缓存判断;TypeHandlerRegistry返回值类型转换   
2)拦截器对象不使用原型模式产生脏数据,改为原型模式   

**V1.17.0.10(查漏补缺)**  
fixed bug:
1)拦截器对象不使用原型模式产生脏数据,改为原型模式  
2)Android获取连接对象是已关闭的,要重新获取  

**V1.17.0.9(精益求精·七夕)**  
1)事务注解@Tran,支持在类级别使用  
2)字段名称引用类(默认格式:实体名_F(自动生成))增加ALL_NAMES属性,可一次获取实体的所有字段值  
3)Ddl.java支持创建索引(normal,unique),联合主键  
4)动态获取JdbcToJavaType  
5)命名转换增加种类4(DbUpperAndJavaLower):数据库使用大写字母，Java使用小写字母;忽略大小写,使用的字符是一样的  
6)多种命名时,缓存添加TranslateType部分  
7)@Ignore(@Transient)可以兼容JPA相应注解(在AnnoAdapter接口定义)  
8)condition.op(fieldName, Op.in, Value)增加支持List,Set,Number Array,单个Number元素  
9)condition.opOn(fieldName, Op.in, Value) Value限定只支持Number和String  
10)增强:like;Op添加likeLeft,likeRight,likeLeftRight(参数值由框架负责转义);打印SQL日志作相应转义  
11)增强:ExcelReader数据列数目动态计算  
12)增强:SQLite日期类型 (date) 匹配转换支持  
13)增强:GenBean生成Javabean,当id是BigDecimal时,重置为Long型  	
14)fixed bug:level 2缓存判断;TypeHandlerRegistry返回值类型转换   

**V1.17.0.8(海纳百川)**  
1)主键支持名称不叫"id",类型除了Long,可以是Integer或String  
2)支持用注解定义主键自动生成,主键值生成注解:GenId,GenUUID  
3)@Column添加默认实现(强烈建议:在新系统中不要使用该注解)  
4)@Table,@Column,@PrimaryKey(@Id)可以兼容JPA相应注解(在AnnoAdapter接口定义)  
5)分布式id生成器,支持设置起始年份:bee.distribution.genid.startYear  
6)链式编程SelectImpl,UpdateImpl调整字段检测.  

**V1.17.0.7(有为)**  
1)**支持HarmonyOS(鸿蒙)直接使用Bee访问SQLite数据库;**  
2)在**Harmony和Android两个环境**,可以用**同一套Bee代码访问DB**,提高代码重用,节省人力物力!  
3)支持HarmonyOS日志:ohos.hiviewdfx.HiLog  

**V1.17.0.6(奋斗)**  
1)**支持Android(安卓)系统直接使用Bee访问SQLite数据库;Bee增加Android ORM功能.**  
2)支持Android日志:android.util.Log  
3)Ddl: 优化创建表流程  
4)多数据源环境下,增加日志提示当前使用的是哪个数据源名称  
5)分页查询,当获取一页的数据量size为0时,直接返回emptyList  
6)优化GenBean,支持都使用默认配置  
7)优化缓存  

**V1.17.0.5(日臻完善)**  
1)SqlServer支持start,size两个参数分页  
2)事务注解Tran  


### **V2.0**  
**V2.0(母爱)**  
**使用分库分表像使用单库一样方便;使用MongoDB像使用MySQL一样容易.**  
1.新增分库分表支持:面向对象分片,JDBC分片  
1.1面向对象分片  
1.2Suid,SuidRich,查询,更新分片  
1.3MoreTable多表查询分片  
1.4批量插入分片  
1.5MAX,MIN,COUNT,SUM,AVG分片查询分片  
1.6分页/排序分片  
1.7分片种类支持:分库分表,仅分库,仅分表  
1.8分片路由种类支持:一库一表,一库多表,多库多表,全库全表,只指定表,只指定库  
1.9通过Hint强制指定当次操作的分片路由(指定ds和table)  
1.10分片的广播表  
1.11Sharding分片配置支持  
1.12流式查询,降低查询内存使用(JDBC)  
1.13分片支持:=,in,between;其中in支持Number,List,Set  
        不参与分片:not in, not between,>=,<=。 
2新增Mongodb ORM功能支持(使用类似JDBC用法)  
3新增Mongodb分片功能  
4新增MS Access支持  

**各V2.0.x.x版本更新详细请看以下列表.**  

**V2.0 Sharding分片功能**  
**V2.0.0.1001(2022·国庆节)**  
1)面向对象分片  
2)Suid,SuidRich,查询,更新分片  
3)MoreTable多表查询分片  
4)批量插入分片  
5)MAX,MIN,COUNT,SUM,AVG分片查询分片  
6)分页/排序分片  
7)分片种类支持:分库分表,仅分库,仅分表  
8)分片路由种类支持:一库一表,一库多表,多库多表,全库全表,只指定表,只指定库  
9)通过Hint强制指定当次操作的分片路由(指定ds和table)  
10)分片的广播表  
11)Sharding分片配置支持  
12)流式查询,降低查询内存使用(JDBC)  

**V2.0.1.1(2023·元旦)**  
13)**mongodb ORM功能**  
14)**mongodb Sharding分片功能**  
15)SuidRich接口中,调整部分方法中指定查询字段的参数位置,并更改为变长参数  
16)SuidRich接口添加查询首条记录的方法:selectFirst(T entity, Condition condition)  

**V2.0.1.22(2023·春节)**  
17)增加聚合(非分组)的分片(JDBC,Mongodb);增加分组聚合的分片(JDBC)  
   Mongodb分组聚合,可添加条件限制在一个组内使用非分组聚合  
18)增加支持MS Access  
19)支持Mongodb生成Javabean,也支持多层嵌入式文档结构生成Javabean  
20)增加SuidRichExt,支持非硬编码指定实体字段  
21)广播表查询(随机选定数据源),广播表更新(全部节点都执行)  
22)DDL:sharding分库分表创建表;创建表传递Class类型参数  

**V2.0.2.5(2023·元宵节)**  
23)update(T,T)更新内部实现  
24)Desensitize 支持不用知道结束位置 @Desensitize(start=0, size=-1, mask="*")  
   0123456789 -> *********  
25)分片支持:=,in,between;其中in支持Number,List,Set  
        不参与分片:not in, not between,>=,<=。  
26)完善HintManager,可只指定dataSourceName,或可只指定tableName  
建议两者都指定,或至少指定tableName  
27)HintManager可使用简称HM  

**V2.0.2.14(2023·情人节)**  
完善:Mongodb ORM日志功能  
完善:不同包的实体即使指定同一个表也不能共享缓存  
完善:Json String类型查询结果转换增强  
fixed bug:PreparedSql接口的批量插入insertBatch空指针和占位符  

### **V2.1(LTS版)主要功能**  
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
9.1支持Mongodb地理信息插入,查询(可分片查询)等  
9.2GridFs文件各种操作,支持注解    
9.3可直接执行原生语句(MongodbRawSql)  
9.4Mongodb面向对象操作打印原生语句日志     
9.5支持Mongodb事务  
9.6支持Mongodb创建索引,删除索引    
9.7mongodb bean定义为插拔组件  
10.更多数据库分页默认支持:MsAccess,Cubrid,HSQL,Derby,Firebird等  

### **V2.1各版本详细功能**  
**V2.1.2.21(Dragon Fly)**  
1)配置文件方式,支持多数据源简易配置(spring boot配置)  
2)屏蔽不使用mongodb时,提示没有添加mongodb相关依赖的信息  
3)修复ObjSQLRichService与Spring整合的多产生一个实例的bug  
4)屏蔽检查日志框架的异常  
5)Search表达式多余括号兼容  

**V2.1.2.28(Eleven)**  
6)bee.properties支持配置多数据源(此方式,无需xml或java代码配置)  
数据源连接池，多数据源配置，内置支持Hikari,Druid  
7)fixed bug:批量插入不能设置数据源名称  
8)Mongodb查询结果日期类型转换  
9)多数据源但都是Mongodb,可以设置bee.dosql.multiDS.justMongodb=true  
则BF.getSuid()会返回Mongodb类型的Suid实现类  
10)支持spring方式生成Mongodb对应的实现类对象  
//  Mongodb使用  
//	@Resource(name = "mongodbObjSQLRichService")  
//	ObjSQLRichService objSQLRichService;  
//  使用mongodb  type1  
//	@Autowired  
//	@Qualifier(value = "mongoSuidRich")  
//	SuidRich suidRich; // 可以  
//	//使用mongodb  type2  
//	@Resource(name = "mongoSuidRich")  
//	SuidRich suidRich; // 可以  
11)Mongodb GridFS文件存储  

**V2.1.3.6(惊蛰)**  
12)GridFs annotation为存储文件到MongoDB后,将文件id存入指定字段  
13)fixed bug: OneTimeSnowflakeId.getRangeId批量取号,遇边界值跳号问题;  
   sequence & segment达到最大值,要重置segment为0  
14)fixed bug: PearFlowerId.getRangeId批量取号,遇边界值跳号问题  

**V2.1.3.12(2023·植树节)**  
15)支持更多数据库一行代码生成整个库所有表对应的Javabean  
new GenBean().genAllBeanFile();  
16)数据源连接池，多数据源配置，内置支持 增加 Dbcp2，Tomcat, C3P0  
17)完善GridFs注解保存文件，保存文件名，元数据等  
18)修改Cache tableNameList的结构为Vector  
19)GenBean支持Lombok注解:@Setter,@Getter,@Data  

**V2.1.3.21(2023·春分)**  
20)提供两个扩展接口SuidRichExt,MongoSuidRichExt及快捷输入类BFX  
21)完善Mongodb文件元数据GridFsFile查询  
22)fixed bug: DDL创建表(Sharding); 流式分片查询时,排序字段转换  

**V2.1.4.5(2023·荣耀)**  
23)支持Mongodb地理信息插入、查询,包括分片  
24)支持Mongodb创建索引  
25)支持Mongodb事务  

**V2.1.4.20(2023·谷雨)**  
26)mongodb bean定义为插拔组件  

**V2.1.5.1(2023·劳动节)**  
27)Mongodb面向对象操作打印原生语句日志  
28)可直接执行原生语句(MongodbRawSql)  
29)广播表批量插入  
30)更多数据库分页默认支持:MsAccess,Cubrid,HSQL,Derby,Firebird等  
31)BeeMongodbSimpleDataSource支持配置文件使用更多属性设置  
32)内置Json工具fastjson实现支持  
33)fixed bug:批量插入不能自动生成主键值,已修复  

**V2.1.5.20(2023·千言万语)**  
34)Suid,SuidRich,MoreTable,PreparedSql,MapSuid等主要的常用的接口移到org.teasoft.bee.osql.api包  
35)增加org.teasoft.bee.mvc,org.teasoft.bee.mvc.service包,更好支持MVC编程和Spring RestFul编程  
36)增强转化成表名时,类型判断提示  
37)PreparedSql将Class转化成表名时的bug  
38)兼容形如orders_1带下划线的表命名,推荐使用如orders1格式的命名  
39)修复关于批量分片插入时一次性参数的bug  
40)当前对象设置命名转化器NameTranslate,只一次即失效,以便更好兼容spring bean  
41)更新dropIndex方法  
42)新增地理信息方法查询(使用mongodb驱动包的类型参数)  

### V1.17.21(2023.06.18  1.17.x LTS版)  
从V2.0，V2.1同步来的:  
增强转化成表名时,类型判断提示  
批量插入不能自动生成主键值  
修改Cache tableNameList的结构为Vector  
fixed bug: OneTimeSnowflakeId.getRangeId批量取号,遇边界值跳号问题;  
sequence & segment达到最大值,要重置segment为0  
fixed bug: PearFlowerId.getRangeId批量取号,遇边界值跳号问题  
修复ObjSQLRichService与Spring整合的多产生一个实例的bug  
完善:Json String类型查询结果转换增强  
fixed bug:PreparedSql接口的批量插入insertBatch空指针和占位符  
同步GenBean到V2.1(但不包括MongoDB功能)  
完善:不同包的实体即使指定同一个表也不能共享缓存  
屏蔽检查日志框架的异常  
//#从1.17.21开始，默认抛出异常；防止在事务时，不正确  
public boolean notCatchModifyDuplicateException=true;   
默认打开处理Column注解:  
openDefineColumn=true;  
默认打开查询结果的字段类型转换:  
openFieldTypeHandler=true;  
setNameTranslate改为:  
setNameTranslateOneTime  
设置中在一次操作数据库中有效。  
用于临时使用不同的命名规则；通过的命名规则应该写在配置文件中.  
SuidRich查询/更新有指定字段的，若改为动态参数，需要将字段字符串放在最后。  

与V2.1.6类似:  
//V1.17.21 若设置了关闭,则不再进行SetParaTypeConverterRegistry，TypeHandlerRegistry默认设置  
closeDefaultParaResultRegistry;  
JPA处理新的包:  
jakarta.persistence.*;  


### **V2.1.6(2023.06.18·父亲节版)**  
1.添加开关closeDefaultParaResultRegistry,控制是否需要默认加载参数类型转换器和查询结果类型转换器  
2.支持JAP新的API包jakarta.persistence.*  
3.批量插入支持配置是否由框架捕获主键等异常catchModifyDuplicateException,默认不捕获  
4.关闭UtilDotDateTypeConvert因少了 HH:mm:ss  
5.fixed bug 更新配置的默认值  
  fixed bug NullPointerException for PreparedSql preparedValue  
  fixed bug for StringUtils  
  
**V2.1.7(2023.07.01)**  
1.增加可运行sql格式化(需要配置:bee.osql.showSql.sqlFormat=true)  
2.二级缓存支持过期时间随机设置, 解决缓存雪崩问题  
3.DdlViaExcel.createTable通过excel里的信息创建数据库表,可只创建部分  
4.支持Spring boot 3.0,动态配置  
5.完善Sharding ThreadPool,可以自定义配置Sharding操作执行线程数的大小  
6.完善Android多线程操作获取SQLiteDatabase的问题  

**V2.1.8(2023·中秋国庆)**  
1.  
1.1 兼容spring boot命令行active选择环境,  
如:java -jar springbootDemo.jar --spring.profiles.active=dev,会觖发bee-dev.properties  
1.2 兼容spring boot数据源配置,如spring.datasource.url  
1.3 不启动应用,直接运行main方法,bee.properties没有配置数据源时,也可以使用application.properties的spring boot单数据源配置  
2.MoreTable多表关联插入,更新,删除  
3.DateUtil增加判断日期格式,计算年龄  
4.通过Excel创建表，支持更多数据库  
5.提供默认的BeeSimpleDataSource，支持在bee.properties里配置多数据源(不使用spring boot时,也可以),  
不使用Spring boot,单独使用Bee时,DataSourceBuilderFactory 也能自启动。  
6.Javabean支持生成Swagger注解  
7.MongodbObjSQLRichExt完善拦截器及上下文信息管理  
8.Mongodb打印日志，查询所有字段时，默认不显示要查询的字段；可以通过bee.osql.showMongoSelectAllFields配置控制是否显示  
9.GridFs注解支持SELECT查询类型,当查询实体时,可以自动关联查出相应的文件(MongoDB),GridFs文件类型支持byte[]  
10.修复 bug: 
CurrencyArithmetic变量bug,  
CacheSuidStruct表名不区分大小写,  
SQLite AS 语法少了空格,  
多表查询使用函数时，不能填充到对应字段,  

**V2.1.10(2023.10)**  
1.支持SQL取反运算NOT("!")  
2.支持OceanBase数据库  
3.doBeforeReturn使用finally  
4.多数据源配置,dbs支持多环境覆盖配置  
5.支持在main方法中直接运行可以读取springboot的application.properties连接数据库的bee.db.url等信息  
6.更新dataSource时,清空缓存  
7.fixed bug:有两个配置项(notSupportUnionQuery,executorSize)没有加前缀sharding_  


**V2.2(2024.1.1·LTS版)**  
1.Javabean实体支持继承(配置bee.osql.openEntityCanExtend=true)  
2.增强批量插入与事务的关联  
  2.2之前,调用批量插入在每个批都会提交commit,但在2.2改为只调用一次且在事务中,在批量插入的方法内容不再提交,而由事务控制.  
3.fixed bug:  
  1)Condition使用Op.in时,参数为null时会报异常  
  2)分片批量插入上下文相关的bug  
  3)仅分库时,解决上下文问题  
  4)分片时,主线程的上下文要清除  
  5).InheritableThreadLocal与parallelStream()不兼容的bug,当不是分片模式时,可以用parallelStream(),而分片时则不建议使用parallelStream()  

