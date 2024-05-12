
Bee
=========
**Easy for Stronger.**   
**Bee** is an ORM framework.   
**Bee** is an easy and high efficiency ORM framework.  


## Feature & Function: 

**Support many Database**(MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL and so on) and easy extend。 

**V1.0**  
Single entity(table) Suid (select,update,insert,delete) object-oriented operation.  
Automatically generate the Javabean via DB table or view.  
Convention-over-configuration:Javabean no annotation,no xml.  
Automatically mapping the table column and the Javabean field.  
Javabean support the raw type:int,double,and so on.  
PreparedStatement support.  
Procedure support.  
Native SQL support.  
Batch operate support.  
Transaction support.  
Automatic filter the null and empty field for default.  
MAX,MIN,SUM,AVG,COUNT support.  
Order by,Paging.  
Select some field.  
Dynamic & random combination of query conditions,no need to prepare the interface in advance; new query requirements, no need to change the query interface.  
All Suid(select,update,insert,delete) operation use the same Bee interface,no longer need any new dao interface.  
Users/Developer only need to pay attention to the Bee interface.  

**V1.1**  
Json format Result support.  
Procedure(Query type) support.  

**V1.2**  
Customer sql support #{para} placeholder,eg:name=#{name}; like keyword support:#{%para%},#{%para},#{para%}  

**V1.3**  
Add: chain programming(select&update)

**V1.4**  
Add: selectById,deleteById  
Add: public &lt;T> List&lt;T> select(T entity,String selectFields,int start,int size)  
Enhance: selectJson add config:ignoreNull;date,time,timestamp Wit hMillisecond format  
Enhance: List<String[]> select(String sql), add config:nullToEmptyString  
Enhance ResultSet Cache mechanism  
Cache support: never,forever,forever and modify Syn,resultSet's size control.  
Add: SysValue annotation  

**V1.5**  
1.add NameTranslate interface and default implement class,support customize translation rule of DB and Java naming.  
2.support jdbcTypeToFieldType-{DbName}.properties,define DB's column type map java type.  
3.enhance Oracle's type translation；other DB can define the column type and java type.  
mapping in file: jdbcTypeToFieldType-{DbName}.properties.  
4.add special entity and table name mapping support.  
  Optimize table name to entity name.  
5.add BeeIllegalEntityException for check illegal Entity.  
6.add create file util.  
7.enhance paging function,and support customize extend interface.  
8.fix ORA-00911 bug,it will cause when operate oracle DB with JDBC.  
9.override the op method for default equal(in UpdateImpl and SelectImpl).  
10.add override OperationType in enum Op.  

**V1.6**  
1.Suid add complicate select oriented object. 
  Suid add method:public &lt;T> List&lt;T> select(T entity,Condition condition);  
  support complicate select;support to use between、like、in、>、>=、<、<=、group by、having、order by、paging  at same time.  
2.SuidRich add complicate select oriented object.  
SuidRich add new method:  
select(T entity, IncludeType includeType, Condition condition)  
selectJson(T entity, IncludeType includeType, Condition condition)  
3.SuidRich add new method:  
updateBy(T entity,String whereFields)  
updateBy(T entity,String whereFields,IncludeType includeType)  
4.add SqlNullException in PreparedSqlLib.  
V1.6.1  
1.PreparedSql add start & size paging parameters in relative methods.  
2.add Deprecated to modify method in PreparedSql.  
3.update getFieldSet method's return type with Java generics.  
4.fix bug.ConditionImpl's fieldSet need record the field in between method.  

**V1.7**  
more tables select oriented object support.  
1.support one to one,one to many,many to one,many to many.  
2.support join(inner join), left join,right join, no join.  
3.The select operations of single table and more tables do not affect each other.  
**V1.7.1**  
gen javabean support create comment.  
support getColumnNames,getFieldNames method in GenBean.  
fix the bug for the define sql no placeholder.  
fix the bug for page in PreparedSqlLib.  
enhance the exception when the sql string is null(CustomSql).  
fix bug about cache.  
fix bug in SelectImpl.  
fix bug for inner join condition style.  
add FileCreator interface.  
**V1.7.2**  
support set the default naming translate type by config.  
enhance function of BeeFactory.  
adjust the format of SQL log.  
support set the date format by config.  
[move test/example to new project bee-exam](../../../bee-exam).  
add class FileLogger for write the log in file.  
support control print log level or not by config.  
enhance test case/example.  
support generate the file according to template.  
add method delete(T entity, Condition condition) in Suid.  
support setting not allowed delete whole records in one table while Object Oriented way.  
SuidRich add 2 methods:  
updateBy(T entity,String whereFields,Condition condition)  
update(T entity,String updateFields,Condition condition)  
add nocache config support.  
add method setAdd,setMultiply in Condition for set value in SQL update.  

**V1.8**   
**Add Distributed Feature:**   
1.Add multi-DataSource support(Write/Read, only Split Database).  
add multi-DataSource no need change the Java code.  
add the route interface of multi-Datasource.  
add multi-DataSource route.  
add multi-DataSource config.  
support refresh multi-DataSource config information.  
2.Generate global unique id number in distributed environment.  
3.Generate Serial Unique id number in one workid of distributed environment.  
Independent clock,workerid can config and easily expand.  
Implement algorithms:SerialUniqueId,OneTimeSnowflakeId,PearFlowerId.  
Support GenId Factory,and can config the id generator.  
4.Gen Serial Unique Id for all Table's Long Id field as primary key.  
**Enhance Function:**   
5.The same database sub table support, dynamic table name mapping support.  
Entity and any table name mapping support.  
Suid add one method:	
public Suid setDynamicParameter(String para,String value);  
add 2 annotation:@Table,@Entity.  
6.Use 'for update' lock some select record(s).   
public Condition forUpdate()  
7.Added support for advanced update set,   
Complex query and multi table query support only project some fields.   
Add 5 methods in Condition:  
public Condition setAdd(String field, String fieldName)  
public Condition setMultiply(String field, String fieldName)  
public Condition set(String fieldNmae, Number num)  
public Condition set(String fieldNmae, String value)  
public Condition selectField(String fieldList)  
8.Support show type of data in sql and show ExecutableSql:  
bee.osql.showSQL.showType=false  
bee.osql.showSQL.showExecutableSql=false  
9.Add one method in SuidRich:  
public &lt;T> int update(T entity,Condition condition);  
Add three methods in PreparedSql:  
public String selectJson(String sqlStr);  
public List<String[]> select(String sql);  
public String selectFun(String sql);  
10.Oracle DATE column mapping to Timestamp,fix the problem:miss the hour,minute,second in Oracle DATE column.  
11.GenFiles support upper case first letter,eg: #{entityName?up1}.  
**Fix bug:**   
12.fixed cache bug:genkey;clear cache for batch insert.  
fixed bug:parse the json has extra comma.	
fixed null bug about:PreparedSql's method select(String sql,Object preValues[]).  
fixed bug about Oracle more table paing.  

**v1.8.15**(2020-10-01 3Festivals)  
1.Enhance support for H2,SQLite,PostgreSQL.  
2.Enhance page funtion,paging para also use placeholder.  
3.Can be used in zero configuration.  
4.Enhance PearFlowerId algorithm that it will produce even number with continuous mantissa of 0 when is often not used (there are no such defect in SerialUniqueId and OneTimeSnowflakeId).  
5.Enhance Log function.  
6.Fixed json transform bug.  

**v1.8.99**(2020-10-25 Double Ninth Festival)  
1.Support lower and upper case option for SQL KeyWord.  
2.Cache sql key support MD5 string.  
3.Optimize the way of setting DB information with Honeyconfig.  
4.Fix bug about checkSelectField.  

**v1.8.15**(2020-10-01 3Festivals)  
1.Enhance support for H2,SQLite,PostgreSQL.  
2.Enhance page funtion,paging para also use placeholder.  
3.Can be used in zero configuration.  
4.Enhance PearFlowerId algorithm that it will produce even number with continuous mantissa of 0 when is often not used (there are no such defect in SerialUniqueId and OneTimeSnowflakeId).  
5.Enhance Log function.  
6.Fixed json transform bug.  

**v1.8.99**(2020-10-25 Double Ninth Festival)  
1.Support lower and upper case option for SQL KeyWord.  
2.Cache sql key support MD5 string.  
3.Optimize the way of setting DB information with Honeyconfig.  
4.Fix bug about checkSelectField.  

**V1.9**  
SuidRich add new methods support list parameter in batch insert.  
enhance SuidRich function, SuidRich add method:  
	public <T> List<String[]> selectString(T entity,Condition condition);  
	public <T> int updateById(T entity,Condition condition);  
	public <T> String selectWithFun(T entity, FunctionType functionType, String fieldForFun, Condition condition);  
	public <T> int count(T entity);  
	public <T> int count(T entity, Condition condition);  
	public <T> boolean exist(T entity); //check the record whether exist in table  
SuidRich adjust methods selectById for unique entity and intelligently judge the Javabean id type of string id parameter.  
Suid add method insertAndReturnId.  
enhance aggregate function cont,sum,avg,min,max,Condition add method:  
	public Condition selectFun(FunctionType functionType,String fieldForFun);  
	public Condition selectFun(FunctionType functionType,String fieldForFun,String alias);  
Condition add method:opWithField,setWithField support like :field1=field2  
Condition add method:selectDistinctField,support distinct as select distinct(userid) from table_name  
MapSuid,no need Javabean, use map to set the entity information that needs to be transformed and operate the database(select/insert/delete record).  
support read Excel(*.xls,*.xlsx), converting data into List<String[]> and importing them into database(bee-ext).  
more table join select support more join condition.  
same Connection for some ORM operation.  
support different type muli-Ds at same time.  
IncludeType support exclude "  ".  
add Ignore Annotation, ignore the field which do not want to transfer.  
support define start and end token when generate file by template.  
enhance DB conn management.  
enhance code quality.  
enhance chain coding:Select,Update.  
adjust config information of bee.properties,HoneyConfig.  
Bee integration with Spring Boot,provide bee-spring-boot-starter.  
support use Javabean create the DB table.  
fix the problem that the fields with the same name will be confused in some databases(oracle) when multi table paging query.  
fixed: update is default by id,but no id field or id is null,will have exception.  
fixed: cache bug.  
fixed: about getRangeId(int sizeOfIds) of GenId.  
fixed: in jdk 11,LoggerFactory use log4j2,have exception.  
when entity is view(not table), recommend put in bee.osql.cache.never(bee.properties).

**V1.9.8**(2021 Mid-Autumn Day)  
SuidRich add 4 method:  
public <T> int save(T entity);  
public <T> int update(T oldEntity,T newEntity);  
public <T> String selectJson(T entity, String selectField);  
public <T> String selectJson(T entity, String selectField, int start, int size);  

MoreTable(more table select):  
support List type field for more tables join;  
support two sub tables join(inner join,right join, left join);  
support one sub table have another join sub table;  
if all fields is null, the sub table field will set null;  
annotation JoinTable add method:subClass() for List type field   
Condition add method:  
public Condition opOn(String field, Op Op, Object value);  

MapSuid(the Javabean corresponding to the table is not required):  
add method update,count,paging select, add and adjust insert and insertAndReturnId.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSql.  
add method count(MapSql mapSql),update(MapSql mapSql),insertAndReturnId(MapSql mapSql),support page in MapSuid.  
add method putNew(String fieldName, Object newValue),putNew(Map map),put(Map map),support page in MapSqlImpl.  
add method toUpdateSqlByMap ,toCountSqlByMap ,support page in MapSqlProcessor.  
add method count(MapSql mapSql),update(MapSql mapSql),support page in MapSuidImpl.  
MapSuidImpl change two different method:insert(MapSql mapSql) & insertAndReturnId(MapSql mapSql)  

PreparedSqlLib support selectMapList method.  
Read/Write multi-DataSource support different type DataSource.  
Logger: two method support have parameter Throwable.  
sql log support config the log level.  
add class StreamUtil  
ObjectUtils add one method: isTrue(Boolean b)  
enhance check field  
use LinkedHashMap in List&lt;Map> result for selectMapList(String sql).  
Condition support condition.set("fieldName", null).  
selectJson support config long to string  
enhance autoGenBean ,support to generate SQL Json Script.  
Add general search function support (simplify back-end complex query programming).  
enhance multi-thread support.  
custom the path of bee.properties.  
Generate Javabean(GenBean) support type:JSON,TEXT.  

fix bug for ExecutableSql.  
transfer the the field of 'order by'.  
fix null bug in create() of ObjectCreatorFactory.  
fix bug for max column number(excel in bee-ext). 
fix bug about HoneyContext  
fix bug about checkPackageByClass  
fix bug about multi-thread safe in ConditionHelper.   

**V1.11**  
V1.11.0.1.1(**2022 New Year**)  
SuidRich add method:  
  public <T> long insertAndReturnId(T entity,IncludeType includeType);  
PreparedSql add method:  
  public <T> List<T> select(String sql,T returnType);  
add annotation PrimaryKey  
MapSqlKey support PrimaryKey  
BF is shortcut for BeeFactoryHelper  
Enhance:config info add trim() about multi-DataSource Write/Read  
fix a bug for naming transfer  

V1.11.0.2.1(**2022 Spring Festival**)  
add function: Interceptor、multi-tenant  
add Interceptor,InterceptorChain  
add DefaultInterceptor,CommInterceptorChain,DefaultInterceptorChain  

V1.11.0.2.4(**2022 Beijing Winter Olympics**)  
level tow ext cache support  
Redis cache support  
add BeeExtCache,DefaultBeeExtCache  
add BeeExtRedisCache  

V1.11.0.2.15(**2022 the Lantern Festival**)  
add annotation:Datetime,Createtime,Updatetime;JustFetch  
add support Jndi DataSource  
check MapSqlKey value 
 
V1.11.0.2.20(**Honor**)  
Optimize use different Database Type at same time(multi-Ds)  
Support use differnt type Database at the same time(eg:use Mysql,Oracle,SQL Server at same time)  
PreparedSql,MapSuid support Interceptor  
Suid,PreparedSql,MapSuid support get DataSource,get InterceptorChain  
Suid,PreparedSql,MapSuid,MoreTable add method:setDataSourceName,getDataSourceName,getInterceptorChain  
add Annotation:  
AnnotationHandler,AutoSetString  
Desensitize    
ReplaceInto,MySQL replace into  
MultiTenancy  
BeforeReturnAnnotationHandler,AbstractDictI18nDefaultHandler  
Dict  
DictI18n  

V1.11.0.2.28  (**Special Day**)  
add ShardingStruct prepare for sharding.  
add Column annotation support to extend mapping column and Javabean field name.  
support custom TypeHandler,and process the ResultSet.  
PreparedSql custom sql support more table select,and return more table struct Javabean.  
fixed bug:  
More table self association query of the same entity forbid multi-self-cycles  

V1.11.0.3.8  (**Lady First**)  
add SetParaTypeConvert for convert PreparedStatement parameter.  
Javabean use java.util.Date type for SUID compatibility processing.  
SQLite get the timestamp result for conversion.  
The Json field of DB is automatically converted to the attribute marked with Json annotation of Javabean(Javabean structure corresponding to Json). 

V1.11.0.3.12  (**Tree Planting Day**)  
Ddl.java uses Javabean to create tables, supports the mapping between Java and DB field types, and supports the setting java_dbtype mapping.  
Ddl.java is compatible with raw char type and java.util.Date.  
PreparedSql support batch insert.  
Support Suid instance set NameTranslate.  
Add DbFeature Registry,it is easy for setting custom database dialect.  
Support Cassandra.  

V1.11.0.3.20  (**Spring Equinox**)  
add Custom dynamic SQL token,@in,@toIsNULL1,@toIsNULL2,&lt;if isNotNull>,&lt;if isNotBlank>.  
dynamic SQL list transfer list to SQL in eg:in (1,2,3),no need foreach;batch insert also no need foreach.  
Separate CN and EN API.  

V1.11.0.4.22 (**The World Earth Day**)  
Add registry interface; Add nameregistry.  
Change serializer throws exceptions type.  
Mapsuid and mapsql support parsing string to boolean type.  
Genbean, which does not support JDBC type, reminds you which file to set;  
Genbean support config where override the old file;  
Genbean support gen javabean's field file;  
SuidRich's method selectString support variable-length arguments:  
 public <T> List<String[]> selectString(T entity,String... selectFields);  
CommInterceptorChain check whether add same class.
SystemLogger supports setting log level to facilitate development and debugging.  
The logger add method: public static void debug (string MSG, throwable T) (convenient for development and debugging).  
Nocache add log prompt.  
Improve cache security.  
Add preload SPI interface Preload.  
Add InterceptorChainRegistry, an interceptor registrar for global use.  
Add configuration item:  
pagingWithLimitOffset    
notCatchModifyDuplicateException    
notShowModifyDuplicateException    
fixed bug for type converter.  
fixed bug about @PrimaryKey in Suid update(entity).  

V1.11.0.4.29  
The configuration file supports multi-environment differentiated configuration.  
SuidRich,public <T> int update(T oldEntity, T newEntity) Interceptors only handle newEntity.  


**V1.17(2022·Mid-Autumn Day)**  

**V1.17.0.10**  
fixed bug:
1)prototype InterceptorChain  
2)if Android SQLiteDatabase instance is not open,get a new one  

**V1.17.0.9(Good,Better·Seventh Evening)**  
1)Transaction annotation @tran, which can be used at the class level  
2)the ref field class {Entity}_F,add ALL_NAMES field,can get the field list of the Entity  
3)Ddl.java support create index(normal,unique),combine Primary key  
4)auto get JdbcToJavaType  
5)bee.osql.naming.translateType add type 4(DbUpperAndJavaLower):Db Upper And Java Lower,ignore case,the name is same.  
6)When multiple DB naming are used, the translatetype part is added to the cache  
7)@Ignore(@Transient) compatible with JPA(interface AnnoAdapter)  
8)condition.op(fieldName, Op.in, Value) add support List,Set,Number Array,one Number element  
9)condition.opOn(fieldName, Op.in, Value) Value can just use Number and String  
10)Enhance:like;Op add likeLeft,likeRight,likeLeftRight(the value of the parameter will be escaped by the framework)  
11)Enhance:dynamic calculation of the number of ExcelReader data columns  
12)Enhance: SQLite date type transfer support  
13)Enhance:GenBean generate Javabean,when id type is BigDecimal,will be set to Long  
14)fixed bug:level 2 cache;TypeHandlerRegistry return value  


**V1.17.0.8**  
1)Primary key support the field is not "id",except the Long, the type can be Integer or String    
2)Support the automatic generation of the primary key by annotation(GenId,GenUUID)  
3)@Column support default implement(Strongly recommend: do not use this Annotation in new system)  
4)@Table,@Column,@PrimaryKey(@Id) compatible with JPA(interface AnnoAdapter)  
5)Distributed id generator supports setting the starting year:bee.distribution.genid.startYear  
6)Chain programming SelectImpl,UpdateImpl adjust check rule for field  

**V1.17.0.7**  
1)**add support HarmonyOS ORM function**  
2)In **HarmonyOS and Android** environment can use the same ORM code with Bee  
3)support HarmonyOS Log:ohos.hiviewdfx.HiLog  

**V1.17.0.6**  
1)**add support Android ORM function,you can use Bee for SQLite DB in Android environment.**  
2)support android.util.Log  
3)Ddl: optimize process if the table is exist  
4)add log tip the dsName(dataSource name) when multi-dataSource  
5)when paging , the size is 0, return emptyList  

V1.17.0.5  
1)Sql Server support (start,size) paging  
2)@Tran transaction annotation  

### **V2.0 Sharding(Mother Love)** 
**The use of more dataSources is as convenient as the use of single database; Using MongoDB is as easy as using MySQL**  
1)add support object-oriented Sharding,JDBC Sharding  
2)add support Mongodb ORM(use like JDBC)  
3)add Mongodb Sharding  
4)add support MS Access  
5)add annotation default implementation(org.teasoft.bee.osql.annotation)  
6)enhance:entities of different packages cannot share the cache even if the same table is specified  
enhance:Json String type query result conversion enhance  
7)fixed bug:PreparedSql interface's method insertBatch null pointer and placeholder bug 

**V2.0.0.1001(2022·National Day) **  
Add Sharding Function  
1)object-oriented Sharding  
2)Suid,SuidRich,select,modify Sharding  
3)MoreTable select Sharding  
4)batch insert Sharding  
5)MAX,MIN,COUNT,SUM,AVG select Sharding  
6)paging/sort select Sharding  
7)support Sharding type:Separate databases and tables,separate databases only,separate tables only  
8)support route Sharding type:One database and one table, one database and multiple tables, multiple databases and multiple tables, all databases and all tables, only specifying tables, only specifying databases  
9)Forcibly specify the partition route for the current operation through Hint(appoint ds and table)  
10)Sharding broadcast table support  
11)easy Sharding config support   
12)stream select,reduce query memory usage  

**V2.0.1.1(2023·New Year)**  
13)**mongodb ORM function**  
14)**mongodb Sharding function**  
15)SuidRich,adjust the parameter position of the specified query field in some methods and change it to a variable-length parameter  
16)SuidRich add method select first record:selectFirst(T entity, Condition condition)  

**V2.0.1.22(2023·Spring Festival)**  
17)add support sharding for groupBy(including JDBC,Mongodb)  
18)add support MS Access  
19)support Mongodb generate Javabean,including multi-layer embedded document structure  
20)add SuidRichExt,support non-hardcode point out the entity field  
21)broadcast table query (randomly selected one dataSource), broadcast table modify (executed in all nodes)  
22)DDL:createTable for sharding  

**V2.0.2.5(2023·the Lantern Festival)**  
23)update(T,T) change internal implementation  
24)Desensitize support does not need to know the end position @Desensitize(start=0, size=-1, mask="*")  
   0123456789 -> *********  
25)Partitioning support:=, in, between; Where in supports Number, List and Set  
Do not participate in fragmentation: not in, not between,>=,<=.  
26)To improve HintManager, only dataSourceName or tableName can be specified  
It is recommended to specify both or at least tableName  
27)HintManager can use the shortcut HM  

**V2.0.2.14(2023·Valentine's Day)**  
enhance Mongodb ORM log  
enhance Json String result transfer  
fixed bug about insertBatch in PreparedSql  


### **V2.1**  
**V2.1.2.21(Dragon Fly)**  
1)Bee+SpringBoot support application file config multi-dataSource  
2)when do not use Mongodb,no need the dependency  
3)fixed bug:ObjSQLRichService+Spring generate more one error instance  
4)suppress the check Log implement msg  
5)Search expression redundant bracket compatibility

**V2.1.2.28(Eleven)**  
6)bee.properties support config multi-dataSource(this type no need xml,java code config)  
7)fixed bug:Batch insert cannot set data source name  
8)Mongodb query result date type conversion  
9)multi dataSource is only Mongodb,can set bee.dosql.multiDS.justMongodb=true  
then BF.getSuid() can return Mongodb type Suid instance  
10)Support spring generation of Mongodb corresponding implementation class objects  
//  Mongodb  
//	@Resource(name = "mongodbObjSQLRichService")  
//	ObjSQLRichService objSQLRichService;  
//  use mongodb  type1  
//	@Autowired  
//	@Qualifier(value = "mongoSuidRich")  
//	SuidRich suidRich; // ok  
//	use mongodb  type2  
//	@Resource(name = "mongoSuidRich")  
//	SuidRich suidRich; // ok  
11)Mongodb GridFS file store  

**V2.1.3.6(Awakening & Growing)**  
12)GridFs annotation for MongoDB register the file id.  
13)fixed bug: OneTimeSnowflakeId.getRangeId boundary value jumping;  
   sequence & segment is max, need reset segment to 0  
14)fixed bug: PearFlowerId.getRangeId boundary value jumping  

**V2.1.3.12(2023·Tree Planting Day)**  
15)Support more database one-line code generation of Javabean corresponding to all tables of the entire database  
new GenBean().genAllBeanFile();  
16)DataSource connection pool，multi-dataSource config，increased support  Dbcp2，Tomcat, C3P0  
17)Improve GridFs annotation to save files, file names, metadata, etc  
18)change Cache tableNameList struct to Vector  
19)GenBean support Lombok annotation:@Setter,@Getter,@Data  

**V2.1.3.21(2023·Spring Equinox)**  
20)Provide two extension interfaces: SuidRichExt, MongoSuidRichExt, and shortcut input class BFX  
21)Improve Mongodb file metadata GridFsFile query  
22)fixed bug: DDL create table(Sharding); Sort field conversion during stream sharding select  

**V2.1.4.5(2023·Honor)**  
23)Mongodb support Geo insert,query (including Sharding)  
24)Mongodb support create index  
25)Mongodb support transaction  

**V2.1.4.20(2023·Grain Rain)**  
26)mongodb bean define plugin  

### **V2.1.5.1(2023·International Labour Day)**  
27)Mongodb ORM support print raw command shell  log  
28)MongodbRawSql can run raw command shell  
29)broadcast table(sharding model) batch insert  
30)support more database default paging implements, including Cubrid,HSQL,Derby,Firebird and so on  
31)BeeMongodbSimpleDataSource support define more item property  
32)support fastjson Json tool  
33)fixed bug:batch insert can not generate ID  

### **V2.1.5.20(2023·千言万语)**  

V1.17.21(2023.06.18  1.17.x LTS版)  


**V2.1.6** 
1.add switch closeDefaultParaResultRegistry  
2.support JAP new API package jakarta.persistence.*  
3.catchModifyDuplicateException for batch insert  
4.close UtilDotDateTypeConvert because it miss HH:mm:ss  
5.fixed bug update the defalut value for cofig item  
  fixed bug NullPointerException for PreparedSql preparedValue  
  fixed bug for StringUtils  
  
**V2.1.7** 
1.support showExecutableSql sql format(requires configuration: bee.osql.showSql.sqlFormat=true)  
2. Support random expiration time for second-level cache to solve cache avalanche issue.  
3. DdlViaExcel.createTable allows creating database tables using information from an Excel file, with the option to create only specific tables.  
4. Support for Spring Boot 3.0.8  
5. Enhance Sharding ThreadPool to allow custom configuration of the size of threads for Sharding operations.  
6. Improve handling of multi-threaded operations for obtaining SQLiteDatabase in Android.  


**V2.1.8(2023.Mid-Autumn Festival & National Day)**  
1.  
1.1 Make the spring boot command line compatible with active profile selection, for example: java -jar springbootDemo.jar --spring.profiles.active=dev, which will trigger bee-dev.properties.  
1.2 Make the spring boot data source configuration compatible, such as spring.datasource.url.  
1.3 When not starting the application directly running the main method, if bee.properties does not have a data source configuration, it should be able to use the single data source configuration in application.properties of spring boot.  
2. Perform insert, update, and delete operations on multiple table associations.  
3. Add date format validation and calculate age in DateUtil.  
4. Fix the bug in the CurrencyArithmetic variable.  
5. Make the table name in CacheSuidStruct case-insensitive.  
6. Improve the interceptor and context information management in MongodbObjSQLRichExt.  
7. Support creating tables through Excel for more Database.  
8. In Mongodb logging, when querying all fields, by default, the fields to be queried are not displayed. This can be controlled by the bee.osql.showMongoSelectAllFields configuration.  
9. Provide a default BeeSimpleDataSource that supports configuring multiple data sources in bee.properties (even without using spring boot). When using Bee alone, the DataSourceBuilderFactory can also start automatically.  
10. Support generating Swagger annotations for Javabean.  
11. GridFs annotation support select type for MongoDB, GridFs file type support byte[] 

**V2.1.10(2023.10)**  
1.support SQL not ("!")  
2.support OceanBase  
3.doBeforeReturn with finally  
4.clear cache when change dataSource map  
5.multiple data source configurations, dbs supports multiple environment coverage configurations  
6.support read bee.db.url and other information from application.properties of springboot when use in main method  
7.fixed bug:two properties item(notSupportUnionQuery,executorSize)have not prefix "sharding_"  
