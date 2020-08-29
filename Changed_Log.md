
Bee
=========
**Easy for Stronger.**   
**Bee** is an ORM framework.   
**Bee** is an easy and high efficiency ORM framework.  


## Feature & Function: 

**V1.0**  
Single entity(table) Suid (select,update,insert,delete) object-oriented operation.  
Automatically generate the Javabean via DB table or view(MySQL,MariaDB).  
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

	