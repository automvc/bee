Sharing Sharing better example


1.Sharing better example

```java

//1. Sharding config

ShardingConfig.addShardingBean(Orders.class,new ShardingBean("ds[0..1].orders[0..5]", "userid"));

//2. query

Suid suid=BF.getSuid(); // get select,update,insert,delete instance

Orders orders1=new Orders();

orders1.setUserid(3L); // Sharding value

List<Orders> list=suid.select(orders1,condition); // query Orders entity list

```

eg："ds [0..1].orders [0..5]", "userid"     mean there are two dataSources:ds0, ds1;  ds0 has：orders0，orders1，orders2；   
ds1 has：orders3，orders4，orders5； table sharding field：userid；  
默认是根据表分片键（字段）的值，来路由到相应的表，如 条件 where userid =3, 则  3%6=3, 就会路由到表 orders3。Bee 默认还支持分片值是 String 的类型。  

示例中，“//2. 查询” 注释的部分代码，是原来数据库没有分片时，ORM 用来查询的代码。在分片的情况下，只需要添加 “//1. 分片配置” 部分的代码即可；  
该部分是 Java 风格的配置，也可以使用 properties 风格的方式进行添加配置信息。    


2.  Bee relative config  

```properties

#Bee Sharding enable
bee.dosql.multiDS.enable=true
bee.dosql.multiDS.sharding=true
# since v2.0   enable  Sharding log
bee.osql.showSQL=true
bee.osql.showShardingSQL=true

```
