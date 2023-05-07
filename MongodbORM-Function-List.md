Mongodb ORM(Bee)
=========
Mongodb ORM 是Bee提供众多ORM功能的一部分;  
Bee，互联网新时代的Java ORM框架,  
同时支持JDBC(比如JavaWeb),Android和Harmony;  
支持Sharding分片;  
支持多种关系型数据库(MySQL,MariaDB,Oracle,H2,SQLite,PostgreSQL,SQL Server,Access,金仓,达梦等),  
还支持NoSQL的Cassandra,Mongodb等.  


## Mongodb ORM-Function-List
**Bee 2.0 起,开始支持MongoDB和分片.**  
#### Mongodb ORM(Bee)支持功能  
Bee使用ORM面向对象方式操作Mongodb支持接口:  
Suid  
SuidRich  
SuidRichExt/MongodbSuidRichExt  
支持打印可执行的原生语句日志  

非分片情况下,以上四个接口的方法都适合在Mongodb使用.  
兼容支持JDBC数据源(Mongodb JDBC)  
支持数字ID(Long,Int),支持全局唯一的数字ID  
分片支持:  
DDL创建集合Collection(表)  
生成集合(表)对应的Javabean(可一行代码生成整个库的表)  
sharding分片查询:  
  查询聚合函数的分片  
  查询操作返回结果是List<T>类型的分片(分片的select操作)  
  查询操作返回结果是List<String[]>类型的分片  
  查询操作返回结果是Json字符串类型的分片(selectJson的分片)  
批量插入分片  
广播表批量插入所有库  
分片键分片支持的运算符  
=,in,between;其中in支持Number,List,Set  
    注意不参与分片:not in, not between,>=,<=  
原生语句(Mongodb shell命令)可直接执行(MongodbRawSql)  
事务  
创建索引  
支持查询嵌入式文档  
地理信息插入、查询  

#### Mongodb ORM(Bee)(V2.0,V2.1)未支持功能:  
多表查询MoreTable(使用单表查询嵌入式文档即可).  
广播表的更改;(可以自行多次设置库名并调用更改方法)  
sharding分组汇总查询  
sharding分片更改操作中:单条插入,更新,删除的分片操作(可以自行多次设置库名并调用更改方法) 


#### 常识:  
**Mongodb与RDB的概念对应关系**  
<table width="399" border="0">
  <tr>
    <td width="145" height="43"><strong>Mongodb</strong></td>
    <td width="42">&nbsp;</td>
    <td width="198"><strong>关系型数据库 </strong></td>
  </tr>
  <tr>
    <td height="43">集合(Collectioin)</td>
    <td>&nbsp;</td>
    <td>表(Table)</td>
  </tr>
  <tr>
    <td height="50">文档(Documnet) </td>
    <td>&nbsp;</td>
    <td>记录/一行记录(Record)</td>
  </tr>
</table>


