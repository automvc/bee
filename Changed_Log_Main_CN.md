
Bee
=========
#### 工欲善其事必先利其器！——《论语·卫灵公》    
**Bee** 是一个 Java ORM框架利器, 它的开发速度快, 编码少, 还很简单！       
**Bee** 编码复杂度是O(1)，即用了Bee，**无论多少个表**,你都可以不用另外再写dao代码。  


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


**V2.1.10(2023.10)**  
1.支持SQL取反运算NOT("!")  
2.支持OceanBase数据库  
3.doBeforeReturn使用finally  
4.多数据源配置,dbs支持多环境覆盖配置  
5.支持在main方法中直接运行可以读取springboot的application.properties连接数据库的bee.db.url等信息  
6.更新dataSource时,清空缓存  
7.fixed bug:有两个配置项(notSupportUnionQuery,executorSize)没有加前缀sharding_  

**V2.1.8(2023·中秋国庆)**  
1.  
1.1 兼容spring boot命令行active选择环境,  
如:java -jar springbootDemo.jar --spring.profiles.active=dev,会觖发bee-dev.properties  
1.2 兼容spring boot数据源配置,如spring.datasource.url  
1.3 不启动应用,直接运行main方法,bee.properties没有配置数据源时,也可以使用application.properties的spring boot单数据源配置  
2.多表关联插入,更新,删除  
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


**V2.1.7(2023.07.01)**  
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

### **V2.1(2023.05.20版)主要功能**  
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

