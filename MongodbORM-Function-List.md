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
分片支持:  
DDL创建表
sharding分片查询:  
  查询聚合函数的分片  
  查询操作返回结果是List<T>类型的分片(分片的select操作)  
  查询操作返回结果是List<String[]>类型的分片  
  查询操作返回结果是Json字符串类型的分片(selectJson的分片)  
批量插入  
分片键分片支持的运算符  
=,in,between;其中in支持Number,List,Set  
    注意不参与分片:not in, not between,>=,<=  
直接使用Mongodb shell命令操作DB. (V2.1开发中)  


#### Mongodb ORM(Bee)(V2.0,V2.1)未支持功能:  
多表查询MoreTable,PreparedSql.  
广播表的更改;(可以自行多次设置库名并调用更改方法)  
sharding分组  
sharding分片更改操作中:单条插入,更新,删除的分片操作(可以自行多次设置库名并调用更改方法) 
创建索引  
事务  




