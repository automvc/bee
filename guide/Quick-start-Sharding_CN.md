分库分表 Sharding: 6. Sharing 最佳实践参考实例



1.Sharing 最佳实践参考实例

```java

//1. 分片配置

ShardingConfig.addShardingBean(Orders.class,new ShardingBean("ds[0..1].orders[0..5]", "userid"));

//2. 查询

Suid suid=BF.getSuid(); // 获取 select,update,insert,delete 操作对象

Orders orders1=new Orders();

orders1.setUserid(3L); // 分片值

List<Orders> list=suid.select(orders1,condition); // 查询 Orders 实体列表

```

其中："ds [0..1].orders [0..5]", "userid"     表示，数据源有:ds0, ds1;  ds0 里有：orders0，orders1，orders2； ds1 里有表：orders3，orders4，orders5； 表的分片键是：userid；  默认是根据表分片键（字段）的值，来路由到相应的表，如 条件 where userid =3, 则  3%6=3, 就会路由到表 orders3。Bee 默认还支持分片值是 String 的类型。

示例中，“//2. 查询” 注释的部分代码，是原来数据库没有分片时，ORM 用来查询的代码。在分片的情况下，只需要添加 “//1. 分片配置” 部分的代码即可；该部分是 Java 风格的配置，也可以使用 properties 风格的方式进行添加配置信息。


2.  Bee 使用分片的相关配置

```properties
#Bee 使用分片的相关配置：
#开启 Bee Sharding 分片功能进行分库分表
bee.dosql.multiDS.enable=true
bee.dosql.multiDS.sharding=true
# since v2.0   开启 Sharding 日志
bee.osql.showSQL=true
bee.osql.showShardingSQL=true

```
